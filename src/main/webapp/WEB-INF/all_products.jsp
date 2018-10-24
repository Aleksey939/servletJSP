<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 22.10.2018
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" contentType="text/html;charset=utf-8"%>

<html>
<head>
    <title>All Product</title>
</head>
<body>
<ul>
<% ResultSet resultSet= (ResultSet) request.getAttribute("resultSet");
    while (resultSet.next()) {%>
       <li>
           <% resultSet.getString("Name");
            resultSet.getString("Description");
            resultSet.getInt("Price");}%>
           </li>
</ul>
</body>
</html>
