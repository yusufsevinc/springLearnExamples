<%--
  Created by IntelliJ IDEA.
  User: sevinc
  Date: 10.07.2021
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<html>
<head>
    <title>New Employee</title>
</head>
<body>
<div align="center" style="margin-top: 50px">

    <h2 style="color:darkorange">New Employee</h2>

    <form:form action="save" method="post" modelAttribute="employee" cssStyle="margin: 50px">

        <table border="0" cellpadding="5">


            <tr>
                <td>Username:</td>
                <td><form:input path="username"   type = "text" required = "true"   /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password" type="password"  required = "true"   /></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName"  required = "true" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName"  required = "true" /></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><form:input path="email" type="email" required = "true"/> </td>
            </tr>
            <tr>
                <td>Position: </td>
                <td>  <form:input path="position" required = "true"/></td>
            </tr>
            <tr>
                <td>Disabled: </td>
                <td>
                    <form:radiobutton path = "disabled" value = "0" label = "False" />
                    <form:radiobutton path = "disabled" value = "1" label = "True" />
                </td>

            </tr>
            <tr>
                <td>Account Expired: </td>
                <td>
                    <form:radiobutton path = "accountExpired" value = "0" label = "False" />
                    <form:radiobutton path = "accountExpired" value = "1" label = "True" />
                </td>
            </tr>
            <tr>
                <td>Account Locked: </td>
                <td>
                    <form:radiobutton path = "accountLocked" value = "0" label = "False" />
                    <form:radiobutton path = "accountLocked" value = "1" label = "True" />
                </td>
            </tr>
            <tr>
                <td>Role: </td>
                <td>
                    <form:radiobutton path = "role" value = "ADMIN" label = "ADMIN" />
                    <form:radiobutton path = "role" value = "USER" label = "USER" checked ="true"/>
                </td>
            </tr>
            <td colspan="2"><input type="submit" value="Save" class="btn btn-Primary"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
