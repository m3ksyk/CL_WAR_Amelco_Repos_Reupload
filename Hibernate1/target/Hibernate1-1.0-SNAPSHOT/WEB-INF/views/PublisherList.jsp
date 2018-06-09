<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 08.05.18
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href=/publisher/form> Add new publisher</a>

<ul>

    <c:forEach items="${publishers}" var="publisher">
    <li>
        <p>${publisher.name} </p>

        <a href="/publisher/deleteauthor/${publisher.id}"> delete </a>
        <a href="/publisher/updateform/${publisher.id}"> edit </a>
</ul>
</li>
</c:forEach>
</ul>

</body>
</html>
