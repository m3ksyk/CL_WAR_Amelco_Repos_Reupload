<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 08.05.18
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> add/edit person</h1>
    <form:form method="post" modelAttribute="person">
        <form:input path="login" placeholder="Login"/>
        <form:input path="password" placeholder="password"/>
        <form:input path="email" placeholder="email"/>
        <input type="submit" value="save">
    </form:form>

</body>
</html>
