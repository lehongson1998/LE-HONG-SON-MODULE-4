<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/add" method="post">
    <h1>Sandwich Condiment</h1>
    <c:forEach items="${spice}" var="spice">
        <input type="checkbox" name="condiment" value="${spice}"><label>${spice}</label>
    </c:forEach>
    <input type="submit" value="select">
</form>
<c:if test="${select != null}">
    <h3>Spice of Sandwich selected</h3>
    <c:forEach items="${select}" var="select">
        <p>${select}</p>
    </c:forEach>
</c:if>
<c:if test="${message != null}">
    <h2 style="color: red">${message}</h2>
</c:if>
</body>
</html>
