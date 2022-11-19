<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="ru">

<head>
    <title>Показатель безопасной эксплуатации энергоблока №2</title>
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
            height: 35px;
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
    <script src="https://www.google.com/jsapi"></script>
    <script>
        google.load("visualization", "1", {packages: ["corechart"]});
        google.setOnLoadCallback(drawChart);

        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Год', 'Россия', 'США'],
                ['1860', 1.3, 70],
                ['1885', 2000, 3120],
                ['1901', 12170, 9920]
            ]);
            var options = {
                title: 'Добыча нефти',
                hAxis: {title: 'Год'},
                vAxis: {title: 'Тыс. тонн'}
            };
            var chart = new google.visualization.ColumnChart(document.getElementById('oil'));
            chart.draw(data, options);
        }
    </script>

</head>
<body>
<div style="
width: 99%;
height: 700px;
border: #4c51da solid 5px;"
>

    <%@include file="/WEB-INF/jsp/common/Header.jsp" %>

    <h2 style="text-align: center">Показатель безопасной эксплуатации энергоблока №2</h2>

    <div>
        <form name="edit-employee" method="post">
            <div>
                <c:forEach var="error" items="${employee.errors}">
                    <p>${error}</p>
                </c:forEach>
            </div>
            <div>
                <label>Отчетный период:
                    <input class="container" type="text" name="lastName" value=""/>
                </label>
            </div>
            <div>
                <label>Пользователь:
                    <input class="container" type="text" name="firstName" value=""/>
                </label>
            </div>
            <div>
                <label>Значение:
                    <input class="container" type="text" name="patronymic" value=""/>
                </label>
            </div>
            <input type="hidden" name="id" value="${employee.id}">

            <div>
                <button type="submit" class="button" name="command" value="update_employee"
                        formaction="${pageContext.request.contextPath}/controller?">Сохранить
                </button>
                <button type="submit" class="button" name="command" value="second"
                        formaction="${pageContext.request.contextPath}/controller?">Назад
                </button>
            </div>
        </form>
    </div>

    <div id="oil" style="width: 450px; height: 250px; margin-top: 50px"></div>

    <div style="margin-left: 700px">
        <table>
            <tr>
                <th>№ Записи</th>
                <th>Дата внесения данных</th>
                <th>Отчетный период данных</th>
                <th>Пользователь</th>
                <th>Значение показателя безопасности</th>
            </tr>
            <tr>
                <td>1</td>
                <td>12.11.2022</td>
                <td>2022</td>
                <td>Иванов И.И.</td>
                <td>59</td>
            </tr>

            <tr>
                <td>2</td>
                <td>1.11.2021</td>
                <td>2021</td>
                <td>Иванов И.И.</td>
                <td>589</td>
            </tr>
        </table>
    </div>


</div>
</body>
</html>