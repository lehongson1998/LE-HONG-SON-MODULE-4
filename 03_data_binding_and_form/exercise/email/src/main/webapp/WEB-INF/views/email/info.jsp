<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Languages :${boxEmail.languages}</h3>
<h3>Page Size :${boxEmail.pageSize}</h3>
<h3>Spams Filter :
    <c:if test="${boxEmail.spamFilter == true}">Enable</c:if>
    <c:if test="${boxEmail.spamFilter == false}">disable</c:if>
</h3>
<h3>Signature :${boxEmail.signature}</h3>
</body>
</html>
