package com.ucm.carpool.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.ucm.carpool.model.Offer;
import com.ucm.carpool.model.PoolUser;
import com.ucm.carpool.model.Request;

public interface ILoginService {
	public boolean checkPassword(String userName, String password) throws SQLException;
	public PoolUser getUserDetails(String userName) throws SQLException;
	public PoolUser registerUser(PoolUser pooler, String password2) throws SQLException;
	public int addOffer(Offer ofr) throws SQLException;
	public int addRequest(Request req)throws SQLException;
	public ArrayList<Offer> searchRides(String originz, String destinationz, String datez,
			String timez)throws SQLException;
	public Map getSDList() throws SQLException;
	public Offer selectRide(String id) throws SQLException;
	public ArrayList<Request> populateRequests() throws SQLException;
	public ArrayList<Offer> populateOffers()throws SQLException;
	public ArrayList<Offer> getMyOffers(String userName)throws SQLException;
	public ArrayList<Request> getMyRequests(String userName)throws SQLException;
	public int deleteOffer(String idSela)throws SQLException;
	public int deleteRequest(String idSela)throws SQLException;
	public void getmatchingRequest(Offer ofr) throws SQLException;
	}
