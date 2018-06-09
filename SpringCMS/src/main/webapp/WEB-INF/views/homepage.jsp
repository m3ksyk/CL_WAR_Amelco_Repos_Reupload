<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 07.05.18
  Time: 19:12
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
                <p>${article.created}</p>
                <p>${article.content}</p>

            </li>
        </c:forEach>
    </ul>
<br>
    <ul>
        <c:forEach items="${categories}" var="category">
            <li>
                <p>${category.name}  </p>
                <a href="/category/read/${category.id}">  view articles </a>

            </li>
        </c:forEach>
    </ul>

</body>
</html>
