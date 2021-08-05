<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>

<body>
<div class="row">
    <div class="col-md-2">
        <%@include file="_Layout.jsp"%>
    </div>
    <div class="col-md-10">
        <table class="table table-striped" style="width: 90% ; margin-top: 50px">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Degree</th>
                </tr>

            </thead>
            <tbody>

            </tbody>


            



        </table>
    </div>
</div>


</body>
</html>
