<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employers</title>

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
<table border="2" style="border:darkorange" >
    <tr>
        <th>Username</th>
        <th>Email</th>
        <th>Position</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
    <tr>
        <td>${employee.username}</td>
        <td>${employee.email}</td>
        <td>${employee.position}</td>
        <td>${employee.role}</td>

    </tr>

    </c:forEach>

</body>
</html>
