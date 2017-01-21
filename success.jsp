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
					<a href="home.jsp">Home</a>&nbsp;&nbsp; <a href="hitch.jsp">Hitch
						a Ride</a>&nbsp;&nbsp; <a href="offer.jsp">Offer A Ride</a>&nbsp;&nbsp;
					<a href="request.jsp">Request A Ride</a>&nbsp;&nbsp; 
					 <a href="<s:url action="edit-ride"/>">Edit My Ride</a>&nbsp;&nbsp;

				</nav>
			</div>
		</div>
	</header>
	<div class="body1">
		<div class="body-center">
			<form>
				<fieldset>
					<p class="highlight">
						<s:property value="msg" />
					</p>
				</fieldset>
			</form>
			<p>
				<a class="bodylink" href="logout">Logout</a>
			</p>
		</div>

	</div>

</body>
</html>
