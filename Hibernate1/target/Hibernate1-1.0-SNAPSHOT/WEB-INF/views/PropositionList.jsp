<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 09.05.18
  Time: 16:00
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

    <c:forEach items="${props}" var="prop">
        <li>
            <p>${prop.title}</p>
            <p>${prop.description}</p>

        </li>
    </c:forEach>
</ul>

</body>
</html>
