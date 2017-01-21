package com.ucm.carpool.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Offer {
	private String origin;
	private String destination;
	private String date;
	private String time;
	private int seat;
	private String registration;
	private String userName;
	private int id;

	public Offer(ResultSet rs) throws SQLException {

		this.origin = rs.getString("origin");
		this.destination = rs.getString("destination");
		this.date = rs.getString("ofrdate");
		this.time = rs.getString("ofrtime");
		this.seat = rs.getInt("seat");
		this.registration = rs.getString("registration");
		this.userName = rs.getString("username");
		this.id = rs.getInt("offerid");
	}
	public Offer() {
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
}
