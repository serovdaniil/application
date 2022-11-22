<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="ru">
<head>
    <title>Информационный справочник показателей безопасной эксплуатации Белорусской АЭС</title>
    <style>
        p {
            text-align: center;
            font-family: "Times New Roman";
            font-size: 65px;
            solid-color: #4c51da;
            line-height: 200px;
        }

    </style>
</head>
<body>
<div style="
width: 99%;
height: 800px;
border: #4c51da solid 5px;"
>
    <p> Информационный справочник показателей безопасной эксплуатации Белорусской АЭС</p>

    <a style=" display: inline-block;
    width: 150px;
    height: 40px;
    font-size: 20px;
    padding-top: 5px;
    margin-top: 80px;
    margin-left: 80px;
    border: #4c51da 2px solid;
    text-transform: uppercase;
    text-decoration: none;
    text-align: center;
float: left"
       href="${pageContext.request.contextPath}/controller?command=second"
    >
        Вход
    </a>
</div>
</body>
</html>