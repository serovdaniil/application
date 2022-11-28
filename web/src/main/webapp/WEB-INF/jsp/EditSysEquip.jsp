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

    <h2 style="text-align: center">Выявление и прогнозирование тенденций изменения состояния безопасной эксплуатации энергоблока
        №${requestScope.unitId}</h2>

    <h2 style="text-align: center">${requestScope.safIndName}</h2>

    <div>
        <form name="edit-saf_ind" method="post">
            <div>
                <label>Пользователь:
                <select id="user-input" name="iserId">
                    <c:forEach var="user" items="${requestScope.users}">
                        <option value="${user.id}">${user.surname} ${user.name} ${user.patronymic}</option>
                    </c:forEach>
                </select>
            </label>
            </div>
            <div>
                <label>${requestScope.crits[0].name}:
                    <select id="crit0-input" name="crit0">
                        <option></option>
                        <c:forEach var="mark" items="${requestScope.mark0}">
                            <option value="${mark.id}">${mark.name}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div>
                <label>${requestScope.crits[1].name}:
                    <select id="crit0-input" name="crit1">
                        <option></option>
                        <c:forEach var="mark" items="${requestScope.mark1}">
                            <option value="${mark.id}">${mark.name}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div>
                <label>${requestScope.crits[2].name}:
                    <select id="crit0-input" name="crit2">
                        <option></option>
                        <c:forEach var="mark" items="${requestScope.mark2}">
                            <option value="${mark.id}">${mark.name}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div>
                <label>${requestScope.crits[3].name}:
                    <select id="crit0-input" name="crit3">
                        <option></option>
                        <c:forEach var="mark" items="${requestScope.mark3}">
                            <option value="${mark.id}">${mark.name}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div>
                <label>${requestScope.crits[4].name}:
                    <select id="crit0-input" name="crit4">
                        <option></option>
                        <c:forEach var="mark" items="${requestScope.mark4}">
                            <option value="${mark.id}">${mark.name}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <input type="hidden" name="sysEquipId" value="${requestScope.sysEquipId}">
            <input type="hidden" name="unitId" value="${requestScope.unitId}">
            <input type="hidden" name="sysEquipName" value="${requestScope.sysEquipName}">

            <div>
                <button type="submit" class="button" name="command" value="add_sys_equip"
                        formaction="${pageContext.request.contextPath}/controller?">Сохранить
                </button>
                <button type="submit" class="button" name="command" value="second"
                        formaction="${pageContext.request.contextPath}/controller?">Назад
                </button>
            </div>
            <button type="submit" name="command"
                    value="show_table_for_saf_val&idUnit=${requestScope.unitId}&idSafInd=${requestScope.safIndId}"
                    formaction="${pageContext.request.contextPath}/controller?command=show_table_for_cur_status&idUnit=${requestScope.unitId}&idSafInd=${requestScope.safIndId}&safIndName=${requestScope.safIndName}&idSystem=${requestScope.sysEquipId}">
                Отобразить значения показателя в таблице
            </button>
            <button type="submit" name="command" value="second"
                    formaction="${pageContext.request.contextPath}/controller?command=show_diagram_for_cur_status&idUnit=${requestScope.unitId}&idSafInd=${requestScope.safIndId}&safIndName=${requestScope.safIndName}&idSystem=${requestScope.sysEquipId}">
                Отобразить значения показателя в диаграмме
            </button>
        </form>
    </div>
</div>
</body>
</html>