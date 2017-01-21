<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
						a Ride</a>&nbsp;&nbsp; <a href="offer.jsp" class="current">Offer A
						Ride</a>&nbsp;&nbsp; <a href="request.jsp">Request A Ride</a>&nbsp;&nbsp;
					  <a href="<s:url action="edit-ride"/>">Edit My Ride</a>&nbsp;&nbsp;
				</nav>
			</div>
		</div>
	</header>
	<div class="body1">
		<div class="body-center">
			<form action="offer-ride">
				<fieldset>
					<legend>Offer Ride</legend>


					<table style="width: 75%">
						<tr>
							<td><label>Origin</label></td>
							<td>:</td>
							<td><input type="text" name="originx" size="30"
								maxlength="100"></td>
						</tr>
						<tr>
							<td><label>Destination</label></td>
							<td>:</td>
							<td><input type="text" name="destinationx" size="30"
								maxlength="100"></td>
						</tr>
						<tr>
							<td><label>Date</label></td>
							<td>:</td>
							<td><input type="date" name="datex"></td>
							<td>Enter date in mm/dd/yyyy format</td>
						</tr>
						<tr>
							<td><label>Time</label></td>
							<td>:</td>
							<td><input type="time" name="timex"></td>
							<td>Enter time in hh:mm format</td>
						</tr>
						<tr>
							<td><label>Seats Available</label></td>
							<td>:</td>
							<td><select name="seat">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
							</select></td>
						</tr>
						<tr>
							<td><label>Car Registration</label></td>
							<td>:</td>
							<td><input type="text" name="regn" size="30" maxlength="100"></td>

						</tr>
						<tr>
							<td><input type="submit" value="Register"><a
								href=""></a></td>
						</tr>
					</table>


				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>