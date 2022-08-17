<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="text-center">
        <h1>TỜ KHAI Y TẾ</h1>
        <p>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG,THÔNG TIN CỦA ANH / CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT, ĐỀ PHÒNG TRÁNH DỊCH BỆNH TRUYỀN NHIỄM.</p>
        <P class="text-danger">khuyến cáo: khai báo sai lệch là vi phạm pháp luật việt nam và có thể xử lý hình sự.</P>
    </div>
    <form:form action="/add" method="post" modelAttribute="person">
            <table class="table">
                <tr>
                    <td colspan="6">
                        <p>Họ tên</p>
                        <form:input path="name" cssClass="form-control"></form:input>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p>Ngày sinh</p>
                        <form:select path="dateOfBirth" items="${year}" cssClass="form-control"></form:select>
                    </td>
                    <td colspan="2">
                        <p>Giới tính</p>
                        <form:select path="gender" items="${gender}" cssClass="form-control"></form:select>
                    </td>
                    <td colspan="2">
                        <p>Quốc Gia</p>
                        <form:select path="country" items="${country}" cssClass="form-control"></form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Số hộ chiếu hoặc số CMND</p>
                        <form:input path="idCard" cssClass="form-control"></form:input>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Thông tin đi lại</p>
                        <form:radiobuttons path="travelInformation" items="${travel}" cssClass="form-check-input"></form:radiobuttons>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <p>Số hiệu phương tiện</p>
                        <form:input path="vehicleNumber" cssClass="form-control"></form:input>
                    </td>
                    <td colspan="3">
                        <p>Số ghế</p>
                        <form:input path="seats" cssClass="form-control"></form:input>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Ngày khởi hành</p>
                        <form:select path="startDay" items="${day}"></form:select>
                        <form:select path="startMonth" items="${month}"></form:select>
                        <form:select path="startYear" items="${year}"></form:select>
                    </td>
                    <td>
                        <p>Ngày kết thúc</p>
                        <form:select path="endDay" items="${day}"></form:select>
                        <form:select path="endMonth" items="${month}"></form:select>
                        <form:select path="endYear" items="${year}"></form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Tròng vòng 14 ngày qua anh/chị có đến Tỉnh/Thành phố nào không?(*)</p>
                        <form:textarea path="description" cssClass="form-control"></form:textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" class="btn btn-success">Gửi tờ khai</button>
                    </td>
                </tr>
            </table>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</body>
</html>
