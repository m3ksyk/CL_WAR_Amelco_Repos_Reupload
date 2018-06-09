<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 08.05.18
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add publisher</title>
</head>
<body>

<form:form method="post" modelAttribute="category">

    <form:input path="name" placeholder="name" />
    <form:errors path="name"/>
    <form:textarea path="description" placeholder="description"/>
    <form:errors path="description"/>
    <input type="submit" value="save">
</form:form>


</body>
</html>
