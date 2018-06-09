<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 26.04.18
  Time: 16:20
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
<c:forEach items="${cart.cartItems}" var="cartItem">
    <li>  <%@ include file="addtocart.jsp" %> </li>
</c:forEach>

    <%--W koszyku jest ${cartItems.size} pozycji.--%>
    <%--W koszyku jest <ilość produktów> produktów.--%>
        <%--Wartość koszyka to: <wartość produktów>.--%>
</ul>

</body>
</html>
