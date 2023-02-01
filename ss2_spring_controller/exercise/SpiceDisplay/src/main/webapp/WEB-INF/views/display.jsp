<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2/1/2023
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SELECT SANDWICH SPICE</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>CHOICE OF SANDWICH CONDIMENTS</h1>
<form action="/select-spice">
    <div class="form-check">
        <input type="checkbox" class="form-check-input mt-0"  name="condiment" id="lettuce" value="Lettuce">
        <label for="lettuce"> Lettuce</label><br>
    </div>
    <div class="form-check">
        <input type="checkbox" class="form-check-input mt-0"  name="condiment" id="tomato" value="Tomato">
        <label for="tomato"> Tomato</label><br>
    </div>
    <div class="form-check">
        <input type="checkbox" class="form-check-input mt-0"  name="condiment" id="mustard" value="Mustard">
        <label for="mustard"> Mustard</label><br>
    </div>
    <div class="form-check">
        <input type="checkbox" class="form-check-input mt-0"  name="condiment" id="sprouts" value="Sprouts">
        <label for="sprouts"> Sprouts</label><br>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
