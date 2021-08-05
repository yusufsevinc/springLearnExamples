
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<div align="center" style="margin-top:50px ">

        <h2 style="color:darkorange">Edit Employee</h2>
  <form:form action="save" method="post" modelAttribute="employee" cssStyle="margin-top: 50px">

    <table border="0" cellpadding="5">
      <tr>
        <td>ID: </td>
        <td>${employee.employeeId}
          <form:hidden path="employeeId" />
        </td>
      </tr>

      <tr>
        <td>Username:
        <td>${employee.username}</td>
        <td><form:hidden path="username"   /></td>
      </tr>
      <tr>
        <td>First Name:
        <td>${employee.firstName}</td>
        <td><form:hidden path="firstName"   /></td>
      </tr>
      <tr>
        <td>Last Name:
        <td>${employee.lastName}</td>
        <td><form:hidden path="lastName"   /></td>
      </tr>
      <tr>
        <td>Email: </td>
        <td><form:input path="email"  /> </td>
      </tr>
      <tr>
        <td>Position: </td>
        <td>${employee.position}
          <form:hidden path="position"/>
        </td>
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
          <form:radiobutton path = "role" value = "USER" label = "USER" />
        </td>
      </tr>
        <td colspan="2"><input type="submit" value="Save" class="btn btn-Primary"></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>
