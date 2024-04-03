<%-- 
    Document   : listAttendReportClass
    Created on : Mar 10, 2024, 12:01:44 PM
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
            <c:forEach items="${subjects}" var="s">
                <li><a href="attendSubjects?subjectId=${s.subjectID}&classId=${classId}">${s.subjectName}</a></li>
            </c:forEach>
        </ul>
    </body>
</html>
