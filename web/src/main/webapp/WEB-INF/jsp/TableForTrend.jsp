<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.safIndName} - Эноргоблок №${requestScope.unitId}</title>
</head>
<body>
<style>
    <%@include file="/WEB-INF/css/style.css"%>
</style>

<%@include file="/WEB-INF/jsp/common/Header.jsp" %>

<h2 style="text-align: center">Выявление и прогнозирование тенденций изменения состояния безопасной эксплуатации энергоблока №${requestScope.unitId}</h2>

<h2 style="text-align: center">${requestScope.safIndName}</h2>
<div style="width: 99%; height: 100%; border: #4c51da solid 5px;">
    <div style="height: 100%; width: 100%">
        <table>
            <tr>
                <th>№ Записи</th>
                <th>Дата внесения данных</th>
                <th>Отчетный период данных</th>
                <th>Пользователь</th>
                <th>Среднее значение показателя безопасности(${requestScope.meas})</th>
            </tr>
            <c:forEach var="safVal" items="${requestScope.trends}" varStatus="it">
                <tr>
                    <td>${it.index+1}</td>
                    <td>${safVal.date}</td>
                    <td>${safVal.period}</td>
                    <td>${safVal.user.surname}</td>
                    <td>${safVal.value}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
