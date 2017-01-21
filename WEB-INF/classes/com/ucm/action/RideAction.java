package com.ucm.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.ucm.carpool.model.Offer;
import com.ucm.carpool.model.PoolUser;
import com.ucm.carpool.model.Request;
import com.ucm.carpool.service.ILoginService;
import com.ucm.carpool.service.LoginImpl;
import com.ucm.carpool.util.HtmlUtility;
import com.ucm.carpool.util.SendMail;

public class RideAction implements SessionAware{
	private SessionMap<String,Object> session;
	private PoolUser user;
	private ILoginService rider;
	private String msg;

	private String originx;
	private String destinationx;
	private String datex;
	private String timex;
	private String seat;
	private String regn;

	private String originz;
	private String destinationz;
	private String datez;
	private String timez;

	private String idSel;
	private String idSeln;
	public String getidSeln() {
		return idSeln;
	}

	public void setidSeln(String idSeln) {
		this.idSeln = idSeln;
	}

	private String idSela;

	private ArrayList<Offer> myofferList = new ArrayList<>();
	private ArrayList<Request> myrequestList = new ArrayList<>();
	private ArrayList<Request> requestListmatch = new ArrayList<>();

	public ArrayList<Request> getRequestListmatch() {
		return requestListmatch;
	}

	public void setRequestListmatch(ArrayList<Request> requestListmatch) {
		this.requestListmatch = requestListmatch;
	}

	public ArrayList<Offer> getMyofferList() {
		return myofferList;
	}

	public void setMyofferList(ArrayList<Offer> myofferList) {
		this.myofferList = myofferList;
	}

	public ArrayList<Request> getMyrequestList() {
		return myrequestList;
	}

	public void setMyrequestList(ArrayList<Request> myrequestList) {
		this.myrequestList = myrequestList;
	}

	public String getIdSela() {
		return idSela;
	}

	public void setIdSela(String idSela) {
		this.idSela = idSela;
	}

	private ArrayList<Offer> offers;
	public String getOriginy() {
		return originy;
	}

	public void setOriginy(String originy) {
		this.originy = originy;
	}

	public String getDestinationy() {
		return destinationy;
	}

	public void setDestinationy(String destinationy) {
		this.destinationy = destinationy;
	}

	public String getDatey() {
		return datey;
	}

	public void setDatey(String datey) {
		this.datey = datey;
	}

	public String getTimey() {
		return timey;
	}

	public void setTimey(String timey) {
		this.timey = timey;
	}

	public String getIdSel() {
		return idSel;
	}

	public void setIdSel(String idSel) {
		this.idSel = idSel;
	}

	private String originy;
	private String destinationy;
	private String datey;
	private String timey;

	public RideAction() {
		// TODO Auto-generated constructor stub
		super();
		rider = new LoginImpl();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRegn() {
		return regn;
	}

	public String getOriginz() {
		return originz;
	}

	public void setOriginz(String originz) {
		this.originz = originz;
	}

	public String getDestinationz() {
		return destinationz;
	}

	public void setDestinationz(String destinationz) {
		this.destinationz = destinationz;
	}

	public String getDatez() {
		return datez;
	}

	public void setDatez(String datez) {
		this.datez = datez;
	}

	public String getTimez() {
		return timez;
	}

	public void setTimez(String timez) {
		this.timez = timez;
	}

	public void setRegn(String regn) {
		this.regn = regn;
	}

	public String getOriginx() {
		return originx;
	}

	public void setOriginx(String originx) {
		this.originx = originx;
	}

	public String getDestinationx() {
		return destinationx;
	}

	public void setDestinationx(String destinationx) {
		this.destinationx = destinationx;
	}

	public String getDatex() {
		return datex;
	}

	public void setDatex(String datex) {
		this.datex = datex;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getTimex() {
		return timex;
	}

	public void setTimex(String timex) {
		this.timex = timex;
	}


	public ArrayList<Offer> getOffers() {
		return offers;
	}

	public void setOffers(ArrayList<Offer> offers) {
		this.offers = offers;
	}



	@Override

	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session = (SessionMap) map;
	}

	public SessionMap<String,Object> getSession() {
		return session;
	}

	public boolean validateSession(){
		System.out.println("in validate");
		user = (PoolUser) getSession().get("userinfo");
		if(null!= user){
			return true;
		}
		return false;
	}
	public String offer(){
		msg = "";
		String val = "success";
		if(!validateSession()){
			return "login";
		}
		//System.out.println("@@"+originx+" "+destinationx+" "+datex+" "+timex+" "+seat+" "+PhNox);
		Offer ofr = new Offer();
		ofr.setUserName(user.getUserName());
		ofr.setOrigin(originx);
		ofr.setDestination(destinationx);
		ofr.setDate(datex);
		ofr.setTime(timex);
		ofr.setSeat(Integer.valueOf(seat));
		ofr.setRegistration(regn);


		try {
			rider.addOffer(ofr);

			System.out.println("@@"+originx+" "+destinationx+" "+datex+" "+timex+" "+ofr.getSeat()+" "+regn);
			setMsg("Your Offer has been added successfully. You will receive a confirmation Email with the details");
			String content = HtmlUtility.getMsgBody("Hello", user, ofr, null, 1, user);			
			SendMail send = new SendMail(user.getEmail(),"NeedARide-New Offer Registered", content);
			send.sender();			
			rider.getmatchingRequest(ofr);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}
		return val;
	}

	public String request(){
		msg = "";
		String val = "success";
		if(!validateSession()){
			return "login";
		}
		Request req = new Request();
		req.setOrigin(originy);
		req.setDestination(destinationy);
		req.setDate(datey);
		req.setTime(timey);
		req.setActive(true);
		req.setUserName(user.getUserName());
		try {
			int r = rider.addRequest(req);

			setMsg("Your Request has been added successfully."
					+ " You will receive a notification Email when a ride becomes available");
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}

		return val;
	}
	public String hitch(){
		msg = "";
		String val = "success";
		if(!validateSession()){
			return "login";
		}
		try {
			offers = new ArrayList<>(); 
			offers = rider.searchRides(originz, destinationz, datez, timez);
			val="success";	
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}
		return val;
	}
	public String select(){
		String val ="success";
		msg="";

		if(!validateSession()){
			return "login";
		}
		try{
			int v;
			Offer selOffer = rider.selectRide(idSela);
			PoolUser offerUser = rider.getUserDetails(selOffer.getUserName());
			if(null!=selOffer){
				val = "success";
				String content = HtmlUtility.getMsgBody("Hello", user, selOffer, null, 4, offerUser);			
				SendMail send = new SendMail(offerUser.getEmail(),"NeedARide-Rider Found", content);
				send.sender();
				setMsg("Success. Select a link to continue or Logout");						
			}
		}catch(Exception e){
			val = "error";
		}
		System.out.println("idValue$$----->"+idSela);
		return val;
	}
	public String edit(){
		msg="";
		String val="success";
		if(!validateSession()){
			return "login";
		}		
		try{
			myofferList= rider.getMyOffers(user.getUserName());
			myrequestList= rider.getMyRequests(user.getUserName());
		}catch(Exception e){
			val = "error";
		}
		return val;
	}
	public String deleteOffer(){
		msg="";
		String val="success";
		if(!validateSession()){
			return "login";
		}		
		try{
			System.out.println("idSel"+idSel);
			int s = rider.deleteOffer(idSel);
			if(s!=1){
				val = "error";
			}
		}catch(Exception e){
			val = "error";
		}
		return val;
	}
	public String deleteRequest(){
		msg="";
		String val="success";
		try{
			System.out.println("idSeln"+idSeln);
			int s = rider.deleteRequest(idSeln);
			if(s!=1){
				val = "error";
			}
		}catch(Exception e){
			val = "error";
		}
		return val;
	}
}
