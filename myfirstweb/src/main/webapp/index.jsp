<html>
<head><title>Mi primera JSP</title></head>
<body>
  <%
    double num = Math.random();
    if (num > 0.95) {
  %>
      <h2>Ostia vaya churro!!</h2><p>(<%= num %>)</p>
  <%
    } else {
  %>
      <h2>Palmas como un campeon</h2><p>(<%= num %>)</p>
  <%
    }
  %>
  <a href="<%= request.getRequestURI() %>"><h3>Probar otra vez</h3></a>
</body>
</html>