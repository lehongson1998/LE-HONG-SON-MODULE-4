
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>calculator</title>
</head>
<body>
<form action="/calculator" method="post">
    <h1>Calculator</h1>
    <input type="text" name="number1" value="${number1}">
    <input type="text" name="number2" value="${number2}">
    <button type="submit" value="+" name="operator">Addition(+)</button>
    <button type="submit" value="-" name="operator">Subtraction(-)</button>
    <button type="submit" value="*" name="operator">Multiplication(*)</button>
    <button type="submit" value="/" name="operator">Division(/)</button>
</form>
<h1>result: ${result}</h1>
</body>
</html>
