<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выявление и прогнозирование тенденций изменения состояния безопасной эксплуатации энергоблока №1</title>
</head>
<body>
<div style="
width: 99%;
height: auto;
border: #4c51da solid 5px;"
>
    <%@include file="/WEB-INF/jsp/common/Header.jsp" %>

    <h1 style="text-align: center">Выявление и прогнозирование тенденций изменения состояния безопасной эксплуатации энергоблока №1</h1>
    <ul>
        <c:forEach var="safInd" items="${requestScope.safInds}">
            <li style="margin-bottom: 25px">
                <a href="${pageContext.request.contextPath}/controller?command=edit_trend&safIndId=${safInd.id}&unitId=1&safIndName=${safInd.name}&meas=${safInd.meas}">${safInd.name}</a>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
