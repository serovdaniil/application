<%--
  Created by IntelliJ IDEA.
  User: serov
  Date: 19.11.2022
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Показатели безопасной эксплуатации энергоблока №2</title>
</head>
<body>
<div style="
width: 99%;
height: auto;
border: #4c51da solid 5px;"
>
    <%@include file="/WEB-INF/jsp/common/Header.jsp" %>

    <h1 style="text-align: center">Показатели безопасной эксплуатации энергоблока №2</h1>
    <ul>
        <c:forEach var="safInd" items="${requestScope.safInds}">
            <li style="margin-bottom: 25px">
                <a href="${pageContext.request.contextPath}/controller?command=edit_saf_val&safIndId=${safInd.id}&unitId=2&safIndName=${safInd.name}">${safInd.name}</a>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
