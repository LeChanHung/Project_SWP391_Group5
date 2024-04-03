<%-- 
    Document   : listAttendReportTeacher
    Created on : Mar 9, 2024, 10:29:30 PM
    Author     : nocol
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${classes}" var="c">
                <li><a href="attendClass?classId=${c.classID}">${c.className}</a></li>
                </c:forEach>
        </ul>
    </body>
</html>
