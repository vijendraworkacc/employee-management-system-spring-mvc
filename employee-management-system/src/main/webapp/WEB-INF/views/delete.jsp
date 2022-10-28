<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
	<fieldset>
		<form action="delete" method="post">
			<table border="10">
				<tr>
					<td>Enter employee id:</td>
					<td><input type="text" placeholder="example TY001"
						name="empId"></td>
				</tr>
				<tr>
					<td><button type="submit">DELETE</button></td>
					<td></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>