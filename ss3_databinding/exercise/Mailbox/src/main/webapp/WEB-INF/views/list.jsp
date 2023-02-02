<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2/2/2023
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h2 class="text-center">Email list</h2>

<h4 style="color: cadetblue" class="text-center">${mess}</h4>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Languages</th>
        <th>Page size</th>
        <th>Spams filter</th>
        <th>Signature</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${emailList}" var="email">
        <tr>
            <td>${email.id}</td>
            <td>${email.language}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamFilter}</td>
            <td>${email.signature}</td>
            <td><a href="/update?id=${email.id}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
