package com.ucm.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.ucm.carpool.model.Offer;
import com.ucm.carpool.model.PoolUser;
import com.ucm.carpool.model.Request;
import com.ucm.carpool.service.ILoginService;
import com.ucm.carpool.service.LoginImpl;


public class LoginAction implements SessionAware{

	ILoginService login = new LoginImpl(); ;	
	private String userName;
	private String password;
	private PoolUser user;
	private String name;
	private SessionMap<String,Object> session;

	private String fstName;
	private String LstName;
	private String userName2;
	private String email;
	private String rollNo;
	private String PhNo;
	private String password2;
	private String password3; 

	private ArrayList<Offer> offerList = new ArrayList<>();
	private ArrayList<Request> requestList = new ArrayList<>();
	
	
	public ArrayList<Offer> getOfferList() {
		return offerList;
	}
	public void setOfferList(ArrayList<Offer> offerList) {
		this.offerList = offerList;
	}
	public ArrayList<Request> getRequestList() {
		return requestList;
	}
	public void setRequestList(ArrayList<Request> requestList) {
		this.requestList = requestList;
	}
	public SessionMap<String,Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session = (SessionMap) map;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute(){
		System.out.println("name:"+userName+"/n password:"+password);
		try{
			
			boolean loggedIn = login.checkPassword(userName,password);
			if(loggedIn){
				user = login.getUserDetails(userName);				
			}
			if(loggedIn && null!=user){
				session.put("userinfo", user);
				session.put("uName", user.getFstName());
				populateBrowseRide();
				return "success";

			}
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "error";
	}
	private void populateBrowseRide() {
		try{
		offerList = login.populateOffers();
		requestList = login.populateRequests();
		if((null!=offerList && !offerList.isEmpty()) && (null!=offerList && !offerList.isEmpty())){
			session.put("offers", offerList);
			session.put("requests", requestList);
		}
		}catch(Exception e){
			
		}
	}
	public String logout(){
		if(null!=session){
			session.invalidate();
			return "success";
		}
		else{
			return "error";
		}
	}
	public String register(){
		String val = "error";
		if(null!= fstName && !fstName.isEmpty()&&
				null!=LstName && !LstName.isEmpty()&&
				null!= userName2 && !userName2.isEmpty()&&
				null!=email && !email.isEmpty()&&
				null!= password2 && !password2.isEmpty()&&
				null!=password3 && !password3.isEmpty() && 
				password2.equals(password3)){
			PoolUser pooler = new PoolUser();
			pooler.setFstName(fstName);
			pooler.setLstName(LstName);
			pooler.setUserName(userName2);
			pooler.setEmail(email);
			pooler.setRollNo(rollNo);
			pooler.setPhNo(PhNo);
			try{
				user = login.registerUser(pooler, password2);
				if(null!=user){
					session.put("userinfo", user);
					session.put("uName", user.getFstName());
					return "success";
				}
				return "invalid";
			}catch(Exception e){
				return val;
			}
		}
		else{
			return "invalid";	
		}
	}

	public void setFstName(String fstName) {
		this.fstName = fstName;
	}
	public void setLstName(String lstName) {
		LstName = lstName;
	}
	public void setUserName2(String userName2) {
		this.userName2 = userName2;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public void setPhNo(String phNo) {
		PhNo = phNo;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public void setPassword3(String password3) {
		this.password3 = password3;
	}
}
