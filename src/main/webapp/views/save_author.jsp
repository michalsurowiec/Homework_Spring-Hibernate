<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/author/save" modelAttribute="authordto">
    Autor<br>
    Imię: <form:input path="firstName"/><br>
    Nazwisko: <form:input path="lastName"/><br>
    <form:hidden path="id" value="${authordto.id}"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
