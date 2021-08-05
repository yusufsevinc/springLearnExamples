<%--
  Created by IntelliJ IDEA.
  User: sevinc
  Date: 30.07.2021
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
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
