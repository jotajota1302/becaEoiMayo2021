<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>

	<form method="get" action="http://localhost:8090/FlixnetController/login">

		<table border="1">
			<tr>
				<td><label>Usuario </label> <input type="text" name="user"></td>
			</tr>
			<tr>
				<td><label>Password </label> <input type="text" name="password"></td>
			</tr>				
		</table>
		<span></span>
		<button type="submit">ENVIAR</button>
	</form>
	
</body>
</html>