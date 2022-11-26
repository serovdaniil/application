
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
                <a href="${pageContext.request.contextPath}/controller?command=edit_saf_val&safIndId=${safInd.id}&unitId=2&safIndName=${safInd.name}&meas=${safInd.meas}">${safInd.name}</a>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
