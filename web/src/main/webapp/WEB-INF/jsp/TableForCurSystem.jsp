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


<h2 style="text-align: center">${requestScope.safIndName}</h2>
<div style="width: 99%; height: 100%; border: #4c51da solid 5px;">
    <div style="height: 100%; width: 100%">
        <table>
            <tr>
                <th>№ Записи</th>
                <th>Дата внесения данных</th>
                <th>Оценка</th>
                <th>Пользователь</th>
                <th>Расстояние до наихудшего события</th>
            </tr>
            <c:forEach var="curStatus" items="${requestScope.values}" varStatus="it">
                <tr>
                    <td>${it.index+1}</td>
                    <td>${curStatus.date}</td>
                    <td>${curStatus.mark.name}</td>
                    <td>${curStatus.user.surname}</td>
                    <td>${curStatus.distant}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
