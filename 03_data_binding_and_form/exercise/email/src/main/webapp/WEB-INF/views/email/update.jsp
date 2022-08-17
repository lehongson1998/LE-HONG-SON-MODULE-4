<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/update" method="post" modelAttribute="email">
    <fieldset>
        <table>
            <legend>Setting box mail</legend>
            <tr>
                <td>Language :</td>
                <td><form:select path="languages" items="${languages}"></form:select></td>
            </tr>
            <tr>
                <td>Page size :</td>
                <td>
                    <form:select path="pageSize" items="${pageSize}"></form:select>
                </td>
            </tr>
            <tr>
                <td>Spams filter :</td>
                <td>
                    <form:checkbox path="spamFilter"></form:checkbox>
                    <label>Enable spams filter</label>
                </td>
            </tr>
            <tr>
                <td>Signature :</td>
                <td>
                    <form:textarea path="signature"></form:textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <form:button>update</form:button>
                </td>
                <td>
                    <button type="button">Cancel</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
