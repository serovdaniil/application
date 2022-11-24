<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${cookie.lang.value}"/>
<fmt:setBundle basename="l10n.page.main" var="loc"/>
<script src="js/language-switch.js" type="text/javascript"></script>
<script src="js/print-cash-account-in-header.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/account-drop-down-menu.css">
<html>
<head>
</head>
<body>
<style>
    <%@include file="/WEB-INF/css/headerStyle.css"%>

    p{
        text-align: center;
        font-family: "Times New Roman";
        font-size: 25px;
        solid-color: #4c51da;
    }

</style>
<div><p> Информационный справочник показателей безопасной эксплуатации Белорусской АЭС</p></div>
<div>
<ul id="menu">
    <li><a href="${pageContext.request.contextPath}/controller?command=show_first_power_unit">Раздел 1</a></li>
    <li><a href="${pageContext.request.contextPath}/controller?command=show_second_power_unit">Раздел 2</a></li>
    <li><a href="${pageContext.request.contextPath}/controller?command=third_section">Раздел 3</a></li>
    <li><a>Раздел 4</a></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li><a href="${pageContext.request.contextPath}/controller?command=main">ВЫХОД</a></li>
</ul>
</div>
</body>
</html>