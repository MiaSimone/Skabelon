<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: miade
  Date: 06-03-2020
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oversigt</title>
</head>
<body>
    Dette er oversigten.

    <br>
    <br>
    <c:forEach var="customerList" items="${requestScope.customerList}" >
        - ${customerList.email}
        <br>
    </c:forEach>

</body>
</html>
