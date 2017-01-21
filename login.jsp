<!DOCTYPE html>
<html>
<head>
<title>Need A Ride</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
	<header>
		<div class="page">
			<div class="filler">
				<img src="img/Hitch_ride.jpg" id="logo"
					class="filler" alt="NEED A RIDE" />
			</div>
		</div>
	</header>
	<div class="body-right">
		
			<fieldset>
			<form method="post" action=login>
				<legend>Login</legend>

				<table style="width: 75%">
					<tr>
						<td><label>Name</label></td>
						<td>:</td>
						<td><input type="text" name="userName" size="30" maxlength="100"></td>
					</tr>
					<tr>
						<td><label>Password</label></td>
						<td>:</td>
						<td><input type="password" name="password" size="30"
							maxlength="100"></td>

					</tr>
					<tr>
						<td><label><input type="checkbox" name="subscribe"
								checked="checked" />Remember me</label></td>
					</tr>
					<tr>
						<td><input type="submit" value="Sign In"><a href="login"></a></td>
					</tr>
				</table>
				
				</form>
			</fieldset>
			<br /> Are you a new user???
			<fieldset>
			<form action=register method = "post">
				<legend>Register</legend>


				<table style="width: 75%">
					<tr>
						<td><label>Name</label></td>
						<td>:</td>
						<td><input type="text" name="fstName" size="30" maxlength="100"></td>
					</tr>
						<tr>
						<td><label>Last Name</label></td>
						<td>:</td>
						<td><input type="text" name="LstName" size="30" maxlength="100"></td>
					</tr>
						<tr>
						<td><label>User Name</label></td>
						<td>:</td>
						<td><input type="text" name="userName2" size="30" maxlength="100"></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td>:</td>
						<td><input type="email" name="email" size="30"
							maxlength="100"></td>
					</tr>
					<tr>
						<td><label>700#</label></td>
						<td>:</td>
						<td><input type="text" name="rollNo" size="30"
							maxlength="100"></td>
					</tr>
					<tr>
						<td><label>Ph No.</label></td>
						<td>:</td>
						<td><input type="text" name="PhNo" size="30" maxlength="100"></td>

					</tr>
					<tr>
						<td><label>Password</label></td>
						<td>:</td>
						<td><input type="password" name="password2" size="30"
							maxlength="100"></td>
					</tr>
					<tr>
						<td><label>Re-enter Password</label></td>
						<td>:</td>
						<td><input type="password" name="password3" size="30"
							maxlength="100"></td>
					</tr>
					<tr>
						<td><input type="submit" value="Register"><a
							href="register"></a></td>
					</tr>
				</table>

				</form>
			</fieldset>
		

	</div>
	<div class="body-left">
		<img src="img/abc.jpg" class="align-center medium " id="logo" alt="NEED A RIDE" />
	</div>

</body>
</html>