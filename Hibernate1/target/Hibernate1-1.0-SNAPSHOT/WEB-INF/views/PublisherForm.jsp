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

<form:form method="post" modelAttribute="publisher">

    <form:input path="name" placeholder="name" />
    <form:errors path="name"/>
    <form:input path="nip" placeholder="nip" />
    <form:errors path="nip"/>
    <form:input path="regon" placeholder="regon" />
    <form:errors path="regon"/>
    <input type="submit" value="save">
</form:form>


</body>
</html>
