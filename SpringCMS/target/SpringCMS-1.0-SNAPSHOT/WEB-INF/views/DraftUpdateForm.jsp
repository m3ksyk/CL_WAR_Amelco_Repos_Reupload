<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 09.05.18
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    <form:hidden path="id" value="${id}" />
    <form:input path="title" placeholder="title" />
    <form:errors path="title"/>
    <form:textarea path="content" placeholder="content"/>
    <form:errors path="content"/>
    
    <form:hidden path="draft" value="${true}" />

    <input type="submit" value="save">
</form:form>


</body>
</html>
