<%-- 
    Document   : listAttendReportSubject
    Created on : Mar 10, 2024, 1:53:07 PM
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
        <table border="1">
            <thead>
                <tr>
                    <th>MSV</th>
                    <c:forEach begin="1" step="1" end="30" varStatus="i">
                    <th>${i.index}</th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${students}" var="s" varStatus="loop">
                    <tr>
                        <td>${s.MSV}</td>
                        <c:forEach items="${listAllStu.get(loop.index)}" var="sc">
                            <td>
                                <c:if test="${sc.attendance.status eq null}">NOT YET</c:if>
                                <c:if test="${sc.attendance.status ne null}">${sc.attendance.status}</c:if>
                                </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
