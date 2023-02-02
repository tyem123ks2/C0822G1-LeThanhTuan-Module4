<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2/2/2023
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<table>
    <tr>
        <td>Name:</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>ID</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>Contact Number:</td>
        <td>${contactNumber}</td>
    </tr>
</table>
</body>
</html>
