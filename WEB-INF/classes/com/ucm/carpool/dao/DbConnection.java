package com.ucm.carpool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ucm.carpool.model.Offer;
import com.ucm.carpool.model.PoolUser;
import com.ucm.carpool.model.Request;

public class DbConnection {
	Connection con;
	Statement stmt;
	ResultSet rs;
	private static final String ID_VAL="id_sqnce.nextVal";
	private static final String REQUEST_ID="request_id.nextVal";
	public DbConnection() {

	}
	
	public void openConnection() throws SQLException
	{
		try
		{
			// Load the JDBC-ODBC bridge driver
			/*Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
			
			con = DriverManager.getConnection("jdbc:odbc:datasource", "lepy", "password");*/
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "lepy", "password");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","lepy","password");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		//return con;
	}
	public void closeConnection(Connection con) throws SQLException
	{
		// close all open database objects
		try
		{
			if (rs != null)
			{
				rs.close();
				rs = null;
			}
			if (stmt != null)
			{
				stmt.close();
				stmt = null;
			}
			if (con != null)
			{
				con.close();
				con = null;
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}

	public boolean loginUser(String uName, String password)throws SQLException{
		String pwd=null;
		boolean retVal = false;
		String query = "Select password from user_login where userName = '"+uName+"'" ;
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		System.out.println("RS"+rs);
		if(null!=rs){
			if(rs.next()){
				pwd = rs.getString("password");
				System.out.println("heloo password: "+pwd);
				System.out.println("entered val+"+password+pwd.equals(password));
			}
			if(pwd.equals(password)){
				retVal=true;
				System.out.println(" Worked");
			}
		}
		return retVal;
	}
	public PoolUser getUser(String uName)throws SQLException{
		String query = "Select * from user_details where userName ='"+uName+"'" ;
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		PoolUser user = null;
		if(rs.next()){
			user = new PoolUser();
			user.setUserName(rs.getString("username"));
			user.setFstName(rs.getString("firstname"));
			user.setLstName(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setRollNo(rs.getString("rollno"));
			user.setPhNo(rs.getString("phno"));
		}
		System.out.println(" USERNAME -"+user.getUserName()+user.getEmail());
		return user;
	}
	public int addToUserDb(PoolUser pooler) throws SQLException {
		// TODO Auto-generated method stub.
		String query = "INSERT INTO user_details values ('"+pooler.getUserName()+"','"+
		pooler.getFstName()+"','"+pooler.getLstName()+"','"+pooler.getEmail()+"','"+
				pooler.getRollNo()+"'";
		
		if(null!= pooler.getPhNo()){
			query=query+",'"+pooler.getPhNo()+"'";
		}
		query=query+")";
		stmt = con.createStatement();
		int r=  stmt.executeUpdate(query);
		return r;
	}
	public int addUserToLoginTable(String userName, String password2) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO user_login values ('"+userName+"','"+password2+"')";
		stmt = con.createStatement();
		int r = stmt.executeUpdate(query);
		return 1;
	}
	public int addOffer(Offer offer) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO offertable values ("+ID_VAL+",'"+offer.getOrigin()+"','"+offer.getDestination()
				+"','"+offer.getDate()+"','"+offer.getTime()+"','"+offer.getSeat()+"','"+offer.getRegistration()
				+"','"+offer.getUserName()
				+"')";
		stmt = con.createStatement();
		int s = stmt.executeUpdate(query);
		return s;
	}

	public int addRequest(Request req) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO request_table values ("+REQUEST_ID+",'"+req.getOrigin()+"','"+req.getDestination()
				+"','"+req.getDate()+"','"+req.getTime()
				+"','"+req.getUserName()
				+"')";
		stmt = con.createStatement();
		int s = stmt.executeUpdate(query);
		return s;
	}

	public ArrayList<Offer> searchRides(String condition) throws SQLException {
		ArrayList<Offer> offerList = new ArrayList<>();
		String query = "Select * from offertable "+condition;
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()){
			Offer ofr = new Offer(rs);
			offerList.add(ofr);
		}
		return offerList;
	}

	public int selectThisRide(String id) throws SQLException {
		String query = "Update offertable set seat = seat-1 where offerid="+id;
		stmt = con.createStatement();
		int s = stmt.executeUpdate(query);
		return s;	
	}

	public ArrayList<Request> searchRequests(String condition) throws SQLException {
		ArrayList<Request> requestList = new ArrayList<>();
		String query = "Select * from request_table "+condition;
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()){
			Request req = new Request(rs);
			requestList.add(req);
		}
		return requestList;
	}

	public int deleteOffer(String idSela) throws SQLException{
		String query = "delete from offertable where offerid='"+idSela+"'";
		stmt = con.createStatement();
		int s = stmt.executeUpdate(query);	
		return s;
	}

	public int deleteRequest(String idSela) throws SQLException {
		String query = "delete from request_table where requestid='"+idSela+"'";
		stmt = con.createStatement();
		int s = stmt.executeUpdate(query);
		return s;
	}
}