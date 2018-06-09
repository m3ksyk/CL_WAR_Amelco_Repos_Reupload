<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 08.05.18
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>person details</title>
</head>
<body>
<h1> add/edit person details</h1>

<form:form method="post" modelAttribute="person">
    <form:input path="login" placeholder="login" />
    <form:input path="password" placeholder="password"/>
    <form:input path="email" placeholder="email"/>
    <form:input path="firstName" placeholder="firstName"/>
    <form:input path="lastName" placeholder="lastName"/> <br>
    Gender
    male: <form:radiobutton path="gender" value="M" placeholder="gender"/>
    female: <form:radiobutton path="gender" value="F" placeholder="gender"/>
    <form:select path="country" items="${countryItems}" placeholder="country" />
    <form:textarea path="notes" placeholder="notes"/>
    <form:checkbox path="mailingList" placeholder="mailingList" />
    <form:select multiple="multiple" path="skills" items="${skills}" placeholder="skills" />
    <form:checkboxes path="hobbies" items="${hobbies}" placeholder="hobbies" />

    <input type="submit" value="save">
</form:form>

</body>
</html>
