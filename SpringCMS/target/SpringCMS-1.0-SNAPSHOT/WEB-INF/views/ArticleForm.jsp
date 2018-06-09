<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 08.05.18
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add edit book</title>
</head>
<body>

<form:form method="post" modelAttribute="article">

    <form:hidden path="created" value="${created}"/>
    <form:input path="title" placeholder="title" />
    <form:errors path="title"/>
    <form:input path="rating" placeholder="rating"/>
    <form:errors path="rating"/>
    <form:textarea path="content" placeholder="content"/>
    <form:errors path="content"/>
    <form:select multiple="multiple" path="authors" items="${authors}" itemLabel="lastName" itemValue="id" placeholder="authors" />
    <form:errors path="authors"/>
    <form:select multiple="multiple" path="categories" items="${categories}" itemLabel="name" itemValue="id" placeholder="categories" />
    <form:errors path="categories"/>
    <form:checkbox path="draft" placeholder="draft"/>

    <input type="submit" value="save">
</form:form>

</body>
</html>
