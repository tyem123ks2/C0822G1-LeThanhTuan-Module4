<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2/1/2023
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div>
    <form action="/calculator">
        <div class="row">
            <div class="input-group input-group-sm mb-3 col-lg-3">
                <input type="text" name="num1" value="${num1}" class="form-control">
            </div>
            <div class="input-group input-group-sm mb-3 col-lg-3">
                <input type="text" name="num2" value="${num2}" class="form-control">
            </div>
            <label class="form-label">RESULT</label>
            <div class="input-group input-group-sm mb-3 col-lg-3">
                <input type="text" class="form-control" value="${result}" readonly>
            </div>
        </div>
        <input type="submit" name="operator" value="Addition(+)">
        <input type="submit" name="operator" value="Subtraction(-)">
        <input type="submit" name="operator" value="Multiplication(*)">
        <input type="submit" name="operator" value="Division(/)">
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
