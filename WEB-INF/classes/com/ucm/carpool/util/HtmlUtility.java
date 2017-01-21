package com.ucm.carpool.util;

import com.ucm.carpool.model.Offer;
import com.ucm.carpool.model.PoolUser;
import com.ucm.carpool.model.Request;
//1-offer registration, 2-request registration, 3-matching offer found, 4-accepted ur ride{userinfo of rider and offer of driver}
public class HtmlUtility {
	public static String getMsgBody(String title, PoolUser userRider, Offer offer, Request req, int i, PoolUser driveryou){
		String body="</p></body></html>";
		String header = "<!DOCTYPE html>\n"+
				"<html>\n"+
				"<head>\n"+
				"   <title>"+title+"</title>\n"+
				"</head>\n"+
				"<body style=\"background-color:#ffffff\">\n";	
				
		if(i== 1){
			body = //ur offer details
					"<p> Hello "+driveryou.getFstName()+",<br/><br><br>"
				+"Your Ride Offer Details" +" </p><br/><br><br>"+
					"<table bgcolor=\"#2E9AFE\" border=\"1\" style=\"width: 75%\" >"+
					"<tr>"+
					"<td><label>Origin</label></td>"+
					"<td>:</td>"+offer.getOrigin()+
					"</tr>"+
					"<tr>"+
					"<td><label>Destination</label></td>"+
					"<td>:</td>"+offer.getDestination()+
					"</tr>"+
					"<tr>"+
					"<td><label>Date</label></td>"+
					"<td>:</td>"+offer.getDate()+
					"</tr>"+
					"<tr>"+
					"<td><label>Time</label></td>"+
					"<td>:</td>"+offer.getTime()+
					"</tr>"+
					"<tr>"+
					"<td><label>Seats</label></td>"+
					"<td>:</td>"+offer.getSeat()+
					"</tr><br/><br/><br/>"+
					"</table>"+
					"</body></html>";

		}
		if(i==2){
			body = //ur req has been registered+
					"<p> Hello "+userRider.getFstName()+",<br/><br><br>"+
					"Your Ride Request has been registered with the following details" +" </p><br/><br><br>"+
					"<table bgcolor=\"#2E9AFE\" border=\"1\" style=\"width: 75%\" >"+
					"<tr>"+
					"<td><label>Origin</label></td>"+
					"<td>:</td>"+req.getOrigin()+
					"</tr>"+
					"<tr>"+
					"<td><label>Destination</label></td>"+
					"<td>:</td>"+req.getDestination()+
					"</tr>"+
					"<tr>"+
					"<td><label>Date</label></td>"+
					"<td>:</td>"+req.getDate()+
					"</tr>"+
					"<tr>"+
					"<td><label>Time</label></td>"+
					"<td>:</td>"+req.getTime()+
					"</tr>"+
					"</table>"+
					"</body></html>";

		}
		if(i==3){
			body = //matching offer has been found for your ride request
					"<p> Hello "+userRider.getFstName()+",<br/><br><br>"+
					"A Ride offer matching your Ride reqest has been found" +"  </p><br/><br><br>"+
					"<table bgcolor=\"#2E9AFE\" border=\"1\" style=\"width: 75%\" >"+
					"<tr>"+
					"<td><label>Origin</label></td>"+
					"<td>:</td>"+offer.getOrigin()+
					"</tr>"+
					"<tr>"+
					"<td><label>Destination</label></td>"+
					"<td>:</td>"+offer.getDestination()+
					"</tr>"+
					"<tr>"+
					"<td><label>Date</label></td>"+
					"<td>:</td>"+offer.getDate()+
					"</tr>"+
					"<tr>"+
					"<td><label>Time</label></td>"+
					"<td>:</td>"+offer.getTime()+
					"</tr>"+
					"<tr>"+
					"<td><label>Seats Remaining</label></td>"+
					"<td>:</td>"+offer.getSeat()+
					"</tr><br/><br/><br/>"+
					"</table>"+
					"</body></html>";

		}
		if(i==4){
			//the following user has accepted your ride offer.//username of rider and details of my pool-remainng seats
			body = "<p> Hello "+driveryou.getFstName()+",<br/><br><br>"+
					"The following user has accepted your Ride Offer" +"  </p><br/><br><br>"+
					"Rider Name-"+userRider.getFstName()+"<br/><br/>"+
					"<table bgcolor=\"#2E9AFE\" border=\"1\" style=\"width: 75%\" >"+
					"<tr>"+
					"<td><label>Origin</label></td>"+
					"<td>:</td>"+offer.getOrigin()+
					"</tr>"+
					"<tr>"+
					"<td><label>Destination</label></td>"+
					"<td>:</td>"+offer.getDestination()+
					"</tr>"+
					"<tr>"+
					"<td><label>Date</label></td>"+
					"<td>:</td>"+offer.getDate()+
					"</tr>"+
					"<tr>"+
					"<td><label>Time</label></td>"+
					"<td>:</td>"+offer.getTime()+
					"</tr>"+
					"<tr>"+
					"<td><label>Seats Remaining</label></td>"+
					"<td>:</td>"+offer.getSeat()+
					"</tr><br/><br/><br/>"+
					"</table>"+
					"</body></html>";

		}
		return header+body;
	}
}


