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
					<a href="request.jsp">Request A Ride</a>&nbsp;&nbsp; <a
						href="<s:url action="edit-ride"/>">Edit My Ride</a>&nbsp;&nbsp;
				</nav>
			</div>
		</div>
	</header>
	<div class="body1">
		<div class="body1">
			<div class="body-center">
				<form action="delete-offer">
					<fieldset>

						<table border="1" style="width: 80%">
							<tr>
								<th colspan="6">Available Offers</th>
							</tr>
							<tr>
								<th>Origin&nbsp;</th>
								<th>Dest&nbsp;</th>
								<th>Date&nbsp;</th>
								<th>Time &nbsp;</th>
								<th>Seats &nbsp;</th>
							</tr>
							<s:iterator value="myofferList" id="array" status="classStat">

								<tr>
									<td><s:property value="%{#array.origin}" /></td>
									<td><s:property value="%{#array.destination}" /></td>
									<td><s:property value="%{#array.date}" /></td>
									<td><s:property value="%{#array.time}" /></td>
									<td><s:property value="%{#array.seat}" /></td>
									<td><input type="checkbox" name="idSela"
										value="<s:property value="%{#array.id}"/>" /></td>
								</tr>

							</s:iterator>
						</table>
						<input type="submit" value="Delete">
					</fieldset>
				</form>
				<form action="delete-request">
					<fieldset>
						<table border="1" style="width: 80%">
							<tr>
								<th colspan="6">Requests</th>
							</tr>
							<tr>
								<th>Origin&nbsp;</th>
								<th>Dest&nbsp;</th>
								<th>Date&nbsp;</th>
								<th>Time &nbsp;</th>
								<th>Seats &nbsp;</th>

							</tr>

							<s:iterator value="myrequestList" id="array" status="classStat">
								<tr>
									<td><s:property value="%{#array.origin}" /></td>
									<td><s:property value="%{#array.destination}" /></td>
									<td><s:property value="%{#array.date}" /></td>
									<td><s:property value="%{#array.time}" /></td>
									<td><input type="checkbox" name="idSela"
										value="<s:property value="%{#array.id}"/>" /></td>
									</tr>
							</s:iterator>
						</table>
						<input type="submit" value="Delete">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>