package com.ucm.carpool.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Request {

    private String origin;
    private String destination;
    private String date;
    private String time;
    private String userName;
    private boolean isActive;
    private int requestId;
	public Request(ResultSet rs) throws SQLException {
		this.origin = rs.getString("origin");
		this.destination = rs.getString("destination");
		this.date = rs.getString("ofrdate");
		this.time = rs.getString("ofrtime");		
		this.userName = rs.getString("username");
		this.requestId = rs.getInt("requestId");
	}
	public Request() {
		// TODO Auto-generated constructor stub
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
