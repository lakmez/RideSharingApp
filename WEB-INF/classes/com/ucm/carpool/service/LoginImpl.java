package com.ucm.carpool.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ucm.carpool.dao.DbConnection;
import com.ucm.carpool.model.Offer;
import com.ucm.carpool.model.PoolUser;
import com.ucm.carpool.model.Request;
import com.ucm.carpool.util.HtmlUtility;
import com.ucm.carpool.util.SendMail;

public class LoginImpl implements ILoginService{
	private boolean userLoggedIn = false;
	DbConnection db;
	PoolUser user;

	@Override
	public boolean checkPassword(String userName, String password) throws SQLException{
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		userLoggedIn = db.loginUser(userName, password);
		System.out.println(" in impl "+userLoggedIn);
		return userLoggedIn;
	}

	@Override
	public PoolUser getUserDetails(String userName)throws SQLException {
		//if(userLoggedIn){
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		user = db.getUser(userName);
		//}
		return user;
	}

	@Override
	public PoolUser registerUser(PoolUser pooler, String password2) throws SQLException {
		// TODO Auto-generated method stub
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		int n = db.addToUserDb(pooler);
		int m=0;
		if(n==1){	
			m = db.addUserToLoginTable(pooler.getUserName(), password2);			
		}if(n!=1||m!=1){
			pooler = null;
		}
		return pooler;
	}

	@Override
	public int addOffer(Offer offer) throws SQLException {
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		int val = db.addOffer(offer);
		return val;
	}

	@Override
	public int addRequest(Request req) throws SQLException {
		// TODO Auto-generated method stub
		//System.out.println(req.getOrigin()+req.getDestination()+req.getDate());
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		int val = db.addRequest(req);
		return val;
	}

	@Override
	public ArrayList<Offer> searchRides(String origin, String destination, String date,
			String time) throws SQLException {
		ArrayList <Offer> offerList= new ArrayList<>();
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		String condition="where origin='"+origin+"' and destination = '"+destination+"'";
		if(null!=date && !date.isEmpty()){
			condition=condition+" and date='"+date+"'";
		}
		if(null!=time && !time.isEmpty()){
			condition = condition+" and time='"+time+"'";
		}
		offerList = db.searchRides(condition);
		return offerList;
	}
	@Override
	public Map getSDList() throws SQLException{
		ArrayList <Offer> offerList= new ArrayList<>();
		HashMap<String, String> SDMap= new HashMap<>();
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		offerList = db.searchRides("");
		SDMap = getSDMApFromList(offerList);
		return SDMap;
	}

	private HashMap<String, String> getSDMApFromList(ArrayList<Offer> offerList) {
		// TODO Auto-generated method stub
		HashMap<String, String> SDMap= new HashMap<>();
		for(Offer ofr : offerList){
			SDMap.put(ofr.getOrigin(), ofr.getDestination());
		}
		return SDMap;
	}

	@Override
	public Offer selectRide(String id) throws SQLException {
		Offer offer = null;
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		int i = db.selectThisRide(id);//update in offer table
		//db.addRideReceivedEntry();//add value into a separate table username, rides
		if(i==1){
			offer = db.searchRides("where offerid="+id).get(0);
		}
		return offer;
	}

	@Override
	public ArrayList<Request> populateRequests() throws SQLException {
		ArrayList<Request> reqL = new ArrayList<>();
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		reqL = db.searchRequests("");
		return reqL;
	}

	@Override
	public ArrayList<Offer> populateOffers() throws SQLException {
		ArrayList<Offer> offrs = new ArrayList<>();
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		offrs = db.searchRides("");
		return offrs;
	}

	@Override
	public ArrayList<Offer> getMyOffers(String userName) throws SQLException {
		ArrayList<Offer> offrs = new ArrayList<>();
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		offrs = db.searchRides("where username='"+userName+"'");
		return offrs;

	}

	@Override
	public ArrayList<Request> getMyRequests(String userName)
			throws SQLException {
		ArrayList<Request> offrs = new ArrayList<>();
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		offrs = db.searchRequests("where username='"+userName+"'");
		return offrs;
	}

	@Override
	public int deleteOffer(String idSela) throws SQLException {
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		int r=1;
		r=db.deleteOffer(idSela);
		return r;
	}

	@Override
	public int deleteRequest(String idSela) throws SQLException {
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		int r = 1;
		r=db.deleteRequest(idSela);
		return r;
	}

	@Override
	public void getmatchingRequest(Offer offer) throws SQLException {
		ArrayList<Request> reqL = new ArrayList<>();
		if(null==db){
			db = new DbConnection();
			db.openConnection();
		}
		reqL = db.searchRequests("where origin='"+offer.getOrigin()+"' and destination='"+offer.getDestination()+"'");
		//return reqL;
		if(null!=reqL && !reqL.isEmpty()){
			notifyRequestors(reqL, offer);
		}
	}

	private void notifyRequestors(ArrayList<Request> reqL, Offer offer) throws SQLException {
		// TODO Auto-generated method stub
		for(Request request : reqL){
			PoolUser rider = db.getUser(request.getUserName());
			PoolUser driver = db.getUser(offer.getUserName());
			String content = HtmlUtility.getMsgBody("Hello", rider, offer, request, 3, driver);	
			SendMail send = new SendMail(rider.getEmail(),"NeedARide-A Matching Ride offer found", content);
			send.sender();
		}
		
	}
}
