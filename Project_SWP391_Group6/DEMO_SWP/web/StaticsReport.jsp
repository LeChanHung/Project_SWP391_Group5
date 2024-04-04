<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <jsp:useBean id="i" class="DAO.DAO1" scope="request"></jsp:useBean>


            <title>Attendance Report</title>
            <link rel="stylesheet" type="text/css" href="style.css">   
            <link href= "css/attendance.css" rel="stylesheet" type="text/css" />
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
        </head>
        <body>

            <div class="container">
                <nav>
                    <ul>
                        <li>
                            <a href="#" class="logo">
                                <img src="https://cdn.haitrieu.com/wp-content/uploads/2021/10/Logo-Dai-hoc-FPT.png">

                            </a>
                        </li>
                        <li>
                            <a href="StudentHomepage.jsp">
                                <i class="fas fa-menorah"></i>
                                <span class="nav-item">Home</span>
                            </a>
                        </li>
                        <li>
                            <a href="feedback.jsp">
                                <i class="fas fa-comment"></i>
                                <span class="nav-item">Feedback</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-database"></i>
                                <span class="nav-item">Schedule</span>
                            </a>
                        </li>
                        <li>
                            <a href="stuReport">
                                <i class="fas fa-chart-bar"></i>
                                <span class="nav-item">Attendance</span>
                            </a>
                        </li>

                        <li>
                            <a href="logout" class="logout">
                                <i class="fas fa-sign-out-alt"></i>
                                <span class="nav-item">Log out</span>
                            </a>
                        </li>
                    </ul>
                </nav>

                <section class="main">
                    <div class="main-top">
                        <h1>Attendance</h1>
                        <i class="fas fa-user-cog"></i>
                    </div>
                    <form action="statics" method="GET" id="filterForm">
                        <label for="statusFilter">Filter by Status:</label>
                        <select name="statusFilter" id="statusFilter">
                            <option value="0">All</option>
                            <option value="1">Attended</option>
                            <option value="2">Absent</option>
                        </select>
                        <input type="submit" value="Apply">
                        <input type="hidden" name="id" value="${id}">
                </form>
                <section class="attendance">
                    <div class="attendance-list">
                        <h1>Report</h1>
                        <table class="table">
                            <thead>

                                <tr>
                                    <th>Slot</th>
                                    <th>Day</th>
                                    <th>StartTime</th>
                                    <th>EndTime</th>
                                    <th>Status</th>


                                </tr>
                            </thead>
                            <tbody>
                                <%-- Initialize counters for attended and absent sessions --%>
                                <c:set var="attendedCount" value="0"/>
                                <c:set var="absentCount" value="0"/>
                                <c:forEach items="${requestScope.listSta}" var="s">
                                    <tr class="active">
                                        <td>${s.slot.slotNumber}</td>
                                        <td>${s.attendance.attendanceDate}</td>
                                        <td><fmt:formatDate value="${s.slot.getSlotStartTime()}" pattern="HH:mm"/></td>
                                        <td><fmt:formatDate value="${s.slot.getSlotEndTime()}" pattern="HH:mm"/></td>
                                        <td>${s.attendance.status}</td>

                                        <c:choose>
                                            <c:when test="${s.attendance.status == 'Attend'}">
                                                <c:set var="attendedCount" value="${attendedCount + 1}"/>
                                            </c:when>
                                            <c:when test="${s.attendance.status == 'Absent'}">
                                                <c:set var="absentCount" value="${absentCount + 1}"/>
                                            </c:when>
                                        </c:choose>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td colspan="5" style="color : green">Number of attended sessions: ${attendedCount}</td>
                                </tr>
                                <tr>
                                    <td colspan="5" style="color : red">Number of absent sessions: ${absentCount}</td>
                                </tr>
                                <tr>
                                    <c:set var="percent" value="${(absentCount*100)/totalSlot}"></c:set>
                                    <td colspan="5"> 
                                    <c:if test="${percent <= 20}">
                                            <p style="color: green">Total Absent: ${percent} %</p>
                                        </c:if>
                                        <c:if test="${percent > 20}">
                                            <p style="color: red">Total Absent: ${percent} %
                                                <br>
                                            Attend Fail
                                            </p>
                                        </c:if>
                                    </td>
                                </tr>
                            </tbody>
                        </table>    
                    </div>
                </section>
            </section>
        </div>

    </body>
</html>