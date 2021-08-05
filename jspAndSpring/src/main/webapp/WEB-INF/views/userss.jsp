
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Details</title>
</head>
<style>

    table
    {
        width:40%;
    }
    td
    {
        text-align: center;
    }
</style>
<body>
<table border="2" style="border: #ff3d5a" >
    <tr>
        <th>User Id</th>
        <th>Name</th>
        <th>Surname</th>
    </tr>
    <c:forEach items="${userss}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
    </tr>

    </c:forEach>

</body>
</html>
