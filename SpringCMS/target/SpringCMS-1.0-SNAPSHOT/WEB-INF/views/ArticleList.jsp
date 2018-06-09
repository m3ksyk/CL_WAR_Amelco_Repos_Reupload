<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 08.05.18
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>

<c:forEach items="${articles}" var="article">
    <li>
        <p>${article.title}</p>
        <p>${article.description}</p>

    <ul> <c:forEach items="${article.authors}" var="author" >
        <li>
        <p> ${author.firstName} ${author.lastName}</p>
        </li>

    </c:forEach>
    </ul>
        <p>${publisher.name}</p>
        <a href="/article/deletearticle/${article.id}"> delete </a>
        <a href="/article/updateform/${article.id}"> edit </a>
</ul>
    </li>
</c:forEach>
</ul>
</body>
</html>
