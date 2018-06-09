<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 09.05.18
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>validation</title>
</head>
<body>

    <c:forEach items="${violations}" var="violation">

        <p>${violation.propertyPath} :: ${violation.message} </p> <br>
    </c:forEach>
</body>
</html>
