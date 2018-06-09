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

<form:form method="post" modelAttribute="book">
    <form:errors path="*"/>

    <form:input path="title" placeholder="title" />
    <form:errors path="title"/>
    <form:input path="rating" placeholder="rating"/>
    <form:errors path="rating"/>
    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id" placeholder="publisher" />
    <form:errors path="publisher"/>
    <form:textarea path="description" placeholder="description"/>
    <form:errors path="description"/>
    <form:select multiple="multiple" path="authors" items="${authors}" itemLabel="lastName" itemValue="id" placeholder="authors" />
    <form:errors path="authors"/>
    <form:input path="pages" placeholder="pages"/>
    <form:errors path="pages"/>
    <form:checkbox path="proposition" placeholder="proposition"/>
    <input type="submit" value="save">
</form:form>

</body>
</html>
