<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


    <style>
        #graph.graph{
            border: 1px dashed #77FF5C;
            padding: 5px;
        }
        #graph .item{
            margin: 2px;
            color: #fff;
            text-shadow: 1px 1px 1px #000;
            padding: 3px;
            border-radius: 3px;
            background-color: #00508C;
            box-shadow: 0 0 1px #2280AC;
        }
        #graph .item:hover{
            background-color: #2280AC;
            box-shadow: 0 0 2px #2280AC;
        }

        #graph.horizontal{
            width: 200px;
        }
        #graph.horizontal .item{
            height: 20px;
            text-align: right;
        }
        #graph.vertical{
            height: 310px;
            width: auto;
            margin-left: 30%;
            padding-bottom: 10px;
        }
        #graph.vertical .item{
            width: ${requestScope.wight}px;
            float: left;
            display: inline-block;
        }
    </style>

</head>
<body>
<div style="
width: 99%;
height: auto;
border: #4c51da solid 5px;"
>
    <%@include file="/WEB-INF/jsp/common/Header.jsp" %>

    <h2 style="text-align: center">Выявление, систем (элементов), требующих особого внимания для обеспечения безопасной эксплуатации
        энергоблока №${requestScope.unitId}</h2>

    <h2 style="text-align: center">${requestScope.sysEquipName} (${requestScope.kks})</h2>

    <div id="graph" class="graph vertical">
        <c:forEach var="percentage" items="${requestScope.values}">
            <div class="item" style="height:${percentage.percentage}px;margin-top:${percentage.height}px; text-align: center">${percentage.period}</div>
        </c:forEach>
    </div>
   <div style="text-align: center"> По оси абсцисс отложена "Дата". По оси ординат отложено значения для конкретной даты.</div>
</div>
</body>
</html>
