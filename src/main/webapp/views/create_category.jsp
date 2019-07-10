<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/category/save" modelAttribute="categorydto">
    Kategoria<br>
    Nazwa: <form:input path="name"/><br>
    Opis: <form:input path="description"/><br>
    <form:hidden path="id" value="${categorydto.id}"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
