<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<html>
<head>
    <title>Today</title>
</head>
<body>
    <%
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String output = sdf.format(today);
    %>
    <h3><%= output%></h3>
</body>
</html>
