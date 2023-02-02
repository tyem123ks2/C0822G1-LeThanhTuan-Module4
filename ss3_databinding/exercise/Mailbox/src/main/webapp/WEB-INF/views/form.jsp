<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2/2/2023
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="email" method="post" action="/save">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>

        <tr>
            <td>Languages</td>
            <td><form:select path="language" items="${languageList}"/>
        </tr>

        <tr>
            <td>Page size</td>
            <td>
                show <form:select path="pageSize" items="${pageSizeList}" /> emails per page
            </td>
        </tr>

        <tr>
            <td>Spams filter</td>
            <td><form:checkbox path="spamFilter"/> Enable spams filter</td>
        </tr>

        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"/></td>
        </tr>

        <tr>
            <td></td>
            <td><form:button>Update</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
