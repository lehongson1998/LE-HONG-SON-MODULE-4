<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Họ tên</th>
        <th>Năm sinh</th>
        <th>Giới tính</th>
        <th>Quốc Gia</th>
        <th>Số CMND</th>
        <th>Thông tin Phương tiện</th>
    </tr>
    <tr>
        <c:forEach items="${personMedical}" var="medical">
            <td>${medical.name}</td>
            <td>${medical.dateOfBirth}</td>
            <td>${medical.gender}</td>
            <td>${medical.country}</td>
            <td>${medical.idCard}</td>
            <td>${medical.travelInformation}</td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
