<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="ru">

<head>
    <title>${requestScope.safIndName}</title>
    <style>
        input {
            border-radius: 10px;
            border: #4c51da 2px solid;
            margin: 5px 15px 15px;
        }

        label {
            font-size: 20px;
            margin-left: 10px;
        }

        button {
            display: inline-block;
            width: 125px;
            height: auto;
            margin-left: 20px;
            font-size: 15px;
            border-radius: 10px;
            border: #4c51da 2px solid;
            text-transform: uppercase;
            text-decoration: none;
            text-align: center;
            float: left
        }
    </style>
</head>
<body>
<div style="
width: 99%;
height: 700px;
border: #4c51da solid 5px;"
>

    <%@include file="/WEB-INF/jsp/common/Header.jsp" %>

    <h2 style="text-align: center">Показатели безопасной эксплуатации энергоблока №${requestScope.unitId}</h2>

    <h2 style="text-align: center">${requestScope.safIndName}</h2>

    <div>
        <form name="edit-saf_ind" method="post">
            <div>
                <label>Отчетный период:
                    <input class="container" type="text" name="year" value=""/> год
                </label>
            </div>
            <div>
                <label>Пользователь:
                    <select id="roleNew-input" name="iserId">
                        <c:forEach var="user" items="${requestScope.users}">
                            <option value="${user.id}">${user.surname} ${user.name} ${user.patronymic}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div>
                <label>Значение для отчетного периода:
                    <input class="container" type="text" name="value" value=""/> ${requestScope.meas}
                </label>
            </div>
            <input type="hidden" name="safIndId" value="${requestScope.safIndId}">
            <input type="hidden" name="unitId" value="${requestScope.unitId}">
            <input type="hidden" name="safIndName" value="${requestScope.safIndName}">

            <div>
                <button type="submit" class="button" name="command" value="add_saf_val"
                        formaction="${pageContext.request.contextPath}/controller?">Сохранить
                </button>
                <button type="submit" class="button" name="command" value="second"
                        formaction="${pageContext.request.contextPath}/controller?">Назад
                </button>
            </div>
            <button type="submit" name="command" value="show_table_for_saf_val&idUnit=${requestScope.unitId}&idSafInd=${requestScope.safIndId}"
                    formaction="${pageContext.request.contextPath}/controller?command=show_table_for_saf_val&idUnit=${requestScope.unitId}&idSafInd=${requestScope.safIndId}&safIndName=${requestScope.safIndName}&meas=${requestScope.meas}">Отобразить значения показателя в таблице
            </button>
            <button type="submit" name="command" value="second"
                    formaction="${pageContext.request.contextPath}/controller?command=show_diagram_for_saf_val&idUnit=${requestScope.unitId}&idSafInd=${requestScope.safIndId}&safIndName=${requestScope.safIndName}&meas=${requestScope.meas}">Отобразить значения показателя в диаграмме
            </button>
        </form>
    </div>
</div>




</body>
</html>