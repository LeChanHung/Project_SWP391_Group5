<%-- 
    Document   : Schedule
    Created on : Feb 27, 2024, 8:11:57 AM
    Author     : minhdang
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPT University</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/homepage.css">
    </head>
    <body>
        <header class="header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <img src="https://cdn.haitrieu.com/wp-content/uploads/2021/10/Logo-Dai-hoc-FPT.png" alt="Đại học FPT Logo" class="mr-2" style="width: 150px; height: auto;margin-right: 1250px">
                    </div>
                    <div class="col-md-4 text-right">
                        <c:if test="${sessionScope.teacher != null}">
                            <button class="btn btn-danger">${sessionScope.teacher.getFirstName()} ${sessionScope.teacher.getLastName()}</button>
                        </c:if>
                        <a href="logout"><button class="btn btn-danger ml-2">Log out</button></a>
                    </div>
                </div>
            </div>
        </header>

        <div id="content">
            <h2 style="padding-left: 600px;">Weekly Timetable</h2>
            <form method="get" action="tchTimeTable">
                YEAR:
                <select id="yearSelect" name="year" onchange="this.form.submit()" onchange="">
                    <option value="2024" <c:if test="${requestScope.year eq 2024}">selected</c:if>>2024</option>
                    </select>
                    <select id="weekSelect" name="week" onchange="this.form.submit()">
                        /*<c:forEach items="${requestScope.weeks}" var="w" varStatus="loop">
                        <option value="${w}" <c:if test="${requestScope.fromandto eq w}">selected</c:if>>${requestScope.weeksto[loop.index]}</option>
                    </c:forEach>
                </select>
            </form>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <td>
                            <c:forEach items="${dayOfWeeks}" var="d">
                                <c:choose>
                                    <c:when test="${d eq 1}"><th>Monday</th></c:when>
                                <c:when test="${d eq 2}"><th>Tuesday</th></c:when>
                                <c:when test="${d eq 3}"><th>Wednesday</th></c:when>
                                <c:when test="${d eq 4}"><th>Thursday</th></c:when>
                                <c:when test="${d eq 5}"><th>Friday</th></c:when>
                                <c:when test="${d eq 6}"><th>Saturday</th></c:when>
                                <c:when test="${d eq 7}"><th>Sunday</th></c:when>
                                </c:choose>
                            </c:forEach>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${slots}" var="s">
                        <tr>
                            <td>Slots ${s.getSlotNumber()}
                                <br>
                                <fmt:formatDate value="${s.getSlotStartTime()}" pattern="HH:mm"/>
                                -
                                <fmt:formatDate value="${s.getSlotEndTime()}" pattern="HH:mm"/>
                            </td>
                            <c:forEach items="${dayOfWeeks}" var="d">
                                <td>
                                    <c:forEach items="${schedules}" var="sc">
                                            <!--<p>${sc.getDayOfWeek()} - ${d},${sc.getSlot().getSlotNumber()}-${s.getSlotNumber()}</p>-->
                                        <c:if test="${sc.getDayOfWeek() eq d and sc.getSlot().getSlotNumber() eq s.getSlotNumber()}">
                                            <p>
                                                ${sc.getSubjectID().getSubjectName()}
                                                -
                                                ${sc.getClassID().getClassName()}
                                                <br>
                                                <fmt:formatDate value="${s.getSlotStartTime()}" pattern="HH:mm"/>
                                                -
                                                <fmt:formatDate value="${s.getSlotEndTime()}" pattern="HH:mm"/>
                                                <br>
                                                <c:choose>
                                                    <c:when test="${sc.getAttendance().getStatus() ne null}"><p style="color: green">Took Attendance</p></c:when>
                                                <c:when test="${sc.getAttendance().getStatus() eq null}"><p><a href="attendance?classId=${sc.getClassID().getClassID()}&scId=${sc.getScheduleID()}">Take Attend</a></p></c:when>
                                            </c:choose>
                                            </p>
                                        </c:if>
                                    </c:forEach>
                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div style="padding-bottom: 3em"></div>
        </div>
        <div style="padding-bottom: 3em"></div>
        <footer class="footer" style="margin-top: 1em">
            &copy; 2024 Đại học FPT. All rights reserved.
            <p>Địa chỉ:KM29 Đại lộ Thăng Long,Thạch Hòa,Thạch Thất,Hà Nội</p>
        </footer>
        <!-- Bootstrap JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
