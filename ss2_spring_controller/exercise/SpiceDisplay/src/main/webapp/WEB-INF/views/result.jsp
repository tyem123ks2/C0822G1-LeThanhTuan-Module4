<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2/1/2023
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body><div class="col-lg-3">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Condiment</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${condiment}" var="condiment" varStatus="stt">
            <tr>
                <th scope="row">${stt.count}</th>
                <td>${condiment}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
