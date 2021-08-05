<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Employers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>


    <div align="center" >
<table class="table table-striped" style="width: 90% ; margin-top: 50px" >
    <tr>
        <th>Username</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Position</th>
        <th>Disabled</th>
        <th>Account Expired</th>
        <th>Account Locked</th>
        <th>Delete Employee</th>
        <th>Update Employee</th>

    </tr>
    <c:forEach items="${employees}" var="employee">
    <tr>
        <td>${employee.username}</td>
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
        <td>${employee.email}</td>
        <td>${employee.position}</td>
        <td>${employee.disabled}</td>
        <td>${employee.accountExpired}</td>
        <td>${employee.accountLocked}</td>
        <td><a href="/admin/employees/delete/${employee.employeeId}" class="btn btn-danger">Delete</a></td>
        <td><a href="/admin/employees/edit/${employee.employeeId}" class="btn btn-success">Update</a></td>

    </tr>

    </c:forEach>
</table>
    </div >
    <div align="center" style="margin-top: 40px ;">
        <a  href="/admin/employees/edit/newEmployee" class="btn btn-Primary">New Employee</a>

    </div>

</body>
</html>
