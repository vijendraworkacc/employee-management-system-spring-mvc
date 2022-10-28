<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<fieldset>
		<form action="changePassword" method="post">
			<table border="10">
				<tr>
					<td>Enter employee id:</td>
					<td><input type="text" placeholder="example TY001"
						name="empId"></td>
				</tr>
				<tr>
					<td>Enter old password:</td>
					<td><input type="password" placeholder="example yy2u3h2793ry"
						name="oldPassword"></td>
				</tr>
				<tr>
					<td>Enter new password:</td>
					<td><input type="password" placeholder="example ucnueiwhu4234"
						name="newPassword"></td>
				</tr>
				<tr>
					<td>Re-Enter new password:</td>
					<td><input type="password" placeholder="example ucnueiwhu4234"
						name="reEnterPassword"></td>
				</tr>
				<tr>
					<td><button type="submit">CHANGE PASSWORD</button></td>
					<td></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>