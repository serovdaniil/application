<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style>
        a.button7 {
            font-weight: 700;
            color: white;
            margin-left: 50px;
            margin-bottom: 50px;
            text-decoration: none;
            padding: .8em 1em calc(.8em + 3px);
            border-radius: 3px;
            background: #4c51da;
            box-shadow: #4c51da;
            transition: 0.2s;
        }
        a.button7:hover { background: #4c51da; }
        a.button7:active {
            background: #4c51da;
            box-shadow: #4c51da;
        }
    </style>

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

    <a class="button7" href="${pageContext.request.contextPath}/controller?command=call_report_cur_sys&unitId=${requestScope.idUnit}">
        Ранжировать список по расстоянию до наихудшего события
    </a>

    <ul style="margin-top: 50px">
        <c:forEach var="sysEquip" items="${requestScope.sysEquips}">
            <li style="margin-bottom: 25px">
                <a href="${pageContext.request.contextPath}/controller?command=edit_sys_equip&sysEquipId=${sysEquip.id}&unitId=${requestScope.idUnit}&sysEquipName=${sysEquip.nameSys}&kks=${sysEquip.kks}">
                        ${sysEquip.nameSys}(${sysEquip.kks})
                </a>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
