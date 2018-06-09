<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 08.05.18
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href=/author/form> Add new author </a>

<ul>

    <c:forEach items="${authors}" var="author">
    <li>
        <p>${author.firstName} </p>
        <p>${author.lastName}</p>
        <p>${author.birthDate}</p>

        <a href="/author/deleteauthor/${author.id}"> delete </a>
        <a href="/author/updateform/${author.id}"> edit </a>
</ul>
</li>
</c:forEach>
</ul>

</body>
</html>
