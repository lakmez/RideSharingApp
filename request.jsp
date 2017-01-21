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
					<a href="request.jsp" class="current">Request A Ride</a>&nbsp;&nbsp;
					<a href="<s:url action="edit-ride"/>">Edit My Ride</a>&nbsp;&nbsp;
				</nav>
			</div>
		</div>
	</header>
	<div class="body1">
		<div class="body-center">
			<form action="request-ride">
				<fieldset>
					<legend>Enter Requested Ride Details</legend>
					<table style="width: 75%">
						<tr>
							<td><label>Origin</label></td>
							<td>:</td>
							<td><input type="text" name="originy" size="30"
								maxlength="100"></td>
						</tr>
						<tr>
							<td><label>Destination</label></td>
							<td>:</td>
							<td><input type="text" name="destinationy" size="30"
								maxlength="100"></td>
						</tr>
						<tr>
							<td><label>Date</label></td>
							<td>:</td>
							<td><input type="date" name="datey"></td>
							<td>Enter date in mm/dd/yyyy format</td>
						</tr>
						<tr>
							<td><label>Time</label></td>
							<td>:</td>
							<td><input type="time" name="timey"></td>
							<td>Enter time in hh:mm format</td>
						</tr>
						<tr>
							<td><input type="submit" value="Request"><a href=""></a></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>