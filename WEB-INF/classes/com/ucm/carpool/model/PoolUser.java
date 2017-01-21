package com.ucm.carpool.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PoolUser {

	private String userName;
	private String fstName;
	private String LstName;
	private String email;
	private String rollNo;
	private String PhNo;
	public PoolUser() {
		// TODO Auto-generated constructor stub
	}
	public PoolUser(ResultSet rs) throws SQLException {
		setUserName(rs.getString("username"));
		setFstName(rs.getString("firstName"));
		setLstName(rs.getString("lastName"));
		setEmail(rs.getString("email"));
		setRollNo(rs.getString("rollno"));
		setPhNo(rs.getString("phNo"));
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFstName() {
		return fstName;
	}
	public void setFstName(String fstName) {
		this.fstName = fstName;
	}
	public String getLstName() {
		return LstName;
	}
	public void setLstName(String lstName) {
		LstName = lstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getPhNo() {
		return PhNo;
	}
	public void setPhNo(String phNo) {
		PhNo = phNo;
	}
}
