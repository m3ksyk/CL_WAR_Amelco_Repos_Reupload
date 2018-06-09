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
<a href=/category/form> Add new category</a>

<ul>

    <c:forEach items="${categorys}" var="category">
    <li>
        <p>${category.name} </p>

        <a href="/category/deleteauthor/${category.id}"> delete </a>
        <a href="/category/updateform/${category.id}"> edit </a>
</ul>
</li>
</c:forEach>
</ul>

</body>
</html>
