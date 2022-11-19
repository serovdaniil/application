<%@ page contentType="text/html;charset=UTF-8" %>
<div>
    <c:forEach var="exception" items="${exception}">
        <p>${exception}</p>
    </c:forEach>
</div>