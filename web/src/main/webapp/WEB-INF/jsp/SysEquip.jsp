<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выявление, систем (элементов), требующих особого внимания для обеспечения безопасной эксплуатации энергоблока №1</title>
</head>
<body>
<div style="
width: 99%;
height: auto;
border: #4c51da solid 5px;"
>
    <%@include file="/WEB-INF/jsp/common/Header.jsp" %>

    <h1 style="text-align: center">Выявление, систем (элементов), требующих особого внимания для обеспечения безопасной эксплуатации энергоблока №${requestScope.idUnit}</h1>
    <ul>
        <c:forEach var="sysEquip" items="${requestScope.sysEquips}">
            <li style="margin-bottom: 25px">
                <a href="${pageContext.request.contextPath}/controller?command=edit_sys_equip&sysEquipId=${sysEquip.id}&unitId=${requestScope.idUnit}&sysEquipName=${sysEquip.nameSys}">
                        ${sysEquip.nameSys}(${sysEquip.kks})
                </a>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
