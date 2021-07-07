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
	<%
		Map map = request.getParameterMap();
		Object[] keys = map.keySet().toArray();
		for (int k = 0; k < keys.length; k++) {
			String[] pars = request.getParameterValues((String) keys[k]);
			out.print("<tr><td>" + k + "</td><td>'" + keys[k] + "'</td><td>");
			for (int j = 0; j < pars.length; j++) {
				if (j > 0)
					out.print(", ");
				out.print("'" + pars[j] + "'");
			}
			out.println("</td></tr>");
		}
	%>
	
</body>
</html>