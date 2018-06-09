<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 26.04.18
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <style>
    tr1 :nth-of-type(2n){
        background:gray;}
    table, td {
        border: 1px solid black;
        padding: 3px;
        text-align: center;
    }
    </style>
</head>
<body>
<c:if test="${empty size}" >
    <c:set var="size" value="10" />
</c:if>
${size}
<table>
    <tr>
        <c:forEach begin="0" end="${size}" step="1" var="j">
            <c:if test="${j==0}">
                <th>x</th>
            </c:if>
            <c:if test="${j!=0}">
                <th>${j}</th>
            </c:if>
        </c:forEach>
    </tr>

    <c:forEach begin="1" end="${size}" step="1" var="i">
        <tr class="tr1">
            <th>${i}</th>
            <c:forEach begin="1" end="${size}" step="1" var="j">
                <td>${i*j}</td>
            </c:forEach>
        </tr>
    </c:forEach>

</table>

</body>
</html>
