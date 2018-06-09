<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 08.05.18
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add author</title>
</head>
<body>

<form:form method="post" modelAttribute="author">
    <form:hidden path="id" value="${id}" />
    <form:input path="firstName" placeholder="firstName" />
    <form:errors path="firstName"/>
    <form:input path="lastName" placeholder="lastName"/>
    <form:errors path="lastName"/>
    <form:input path="birthDate" placeholder="birthDate"/>
    <form:errors path="birthDate"/>
    <input type="submit" value="save">
</form:form>

</body>
</html>
