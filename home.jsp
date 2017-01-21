<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Need A Ride</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
	<header>
		<div class="page">
			<div class="header1">
				<img src="img/Hitch_ride.jpg" class="filler" id="logo"
					alt="NEED A RIDE" />
			</div>
			<div class="leftnav"></div>
			<div class="rightnav"></div>
			<div class="header2">
				<nav>
					<a href="home.jsp" class="current">Home</a>&nbsp;&nbsp; <a
						href="hitch.jsp">Hitch a Ride</a>&nbsp;&nbsp; <a href="offer.jsp">Offer
						A Ride</a>&nbsp;&nbsp; <a href="request.jsp">Request A Ride</a>&nbsp;&nbsp;
					 <a href="<s:url action="edit-ride"/>">Edit My Ride</a>&nbsp;&nbsp;

				</nav>
			</div>
		</div>
	</header>
	<div class="body1">

<form>

		<fieldset ><h3>Hello Riders..........</h3>
		<p>Need A Ride makes ride-sharing easy, safe, and accessible for
			students in UCM. It connects drivers who already have a mid- to
			long-distance journey planned, with people who need a ride in the
			same direction. In just a few seconds, you can offer empty seats in
			your car, and passengers can book to ride along. Also use the
			UCMRides App to have access to fast and convenient mobility - and can
			share traveling costs.</p>
		<p>Select an option to Continue...</p>
</fieldset>
</form>		
	</div>

</body>
</html>