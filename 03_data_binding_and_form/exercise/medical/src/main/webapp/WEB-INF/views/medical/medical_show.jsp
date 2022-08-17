<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <tr class="bg-success">
        <th>Họ tên</th>
        <th>Năm sinh</th>
        <th>Giới tính</th>
        <th>Quốc Gia</th>
        <th>Số CMND</th>
        <th>Thông tin Phương tiện</th>
        <th>Chỉnh sửa</th>
    </tr>
    <tr>
        <c:forEach items="${personMedical}" var="medical">
            <td>${medical.name}</td>
            <td>${medical.dateOfBirth}</td>
            <td>${medical.gender}</td>
            <td>${medical.country}</td>
            <td>${medical.idCard}</td>
            <td>${medical.travelInformation}</td>
            <td>
                <a class="btn btn-success" href="/form?idCard=${medical.idCard}">Sửa</a>
            </td>
        </c:forEach>
    </tr>
</table>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</body>
</html>
