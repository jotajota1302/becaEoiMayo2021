<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mi primera pagina</title>
</head>
<body>
	<%
		String hour = Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE);
		out.println(hour);
		out.println("<br/><b> Esto es una prueba </b>");
	%>
	

	
</body>
</html>