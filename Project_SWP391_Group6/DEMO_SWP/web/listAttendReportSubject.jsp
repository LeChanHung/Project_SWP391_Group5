<%-- 
    Document   : TeacherHomepage
    Created on : Feb 26, 2024, 10:49:29 AM
    Author     : minhdang
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPT University</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/homepage.css">
        <style>
            /* CSS for the table */
            table {
                border-collapse: collapse;
                width: 100%;
            }

            /* CSS for table cells */
            th, td {
                border: 1px solid black;
                padding: 8px;
                text-align: left;
            }

            /* Alternate row background color */
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
        </style>
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

        <div class="container-fluid">
            <div class="row">
                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                    <div id="content">
                        <!-- Nội dung sẽ được hiển thị ở đây khi người dùng nhấp vào các phần -->
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>MSV</th>
                                        <%--<c:forEach begin="1" step="1" end="30" varStatus="i">--%>
                                    <!--                                <th>${i.index}
                                                                        <br>
                                                                        <a href="attendance?classId=${sc.getClassID().getClassID()}&scId=${sc.getScheduleID()}"></a>
                                                                    </th>-->
                                    <%--</c:forEach>--%>
                                    <c:forEach items="${allSlot}" var="as" varStatus="i">
                                        <th>${i.index+1}</th>
                                        </c:forEach>
                                    <th>Absent</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${students}" var="s" varStatus="loop">
                                    <tr>
                                        <td>${s.MSV}</td>
                                        <c:set var="size" value="0"></c:set>
                                        <c:set var="countAttend" value="0"></c:set>
                                        <c:set var="countAbsent" value="0"></c:set>
                                        <c:forEach items="${listAllStu.get(loop.index)}" var="sc">
                                            <td>
                                                <c:if test="${sc.attendance.status eq null}">-</c:if>
                                                <c:if test="${sc.attendance.status ne null}">
        <!--                                            <a href="attendance?scId=${sc.scheduleID}&classId=${classId}">
                                                    ${sc.attendance.status}
                                                </a>-->
                                                    <c:if test="${sc.attendance.status eq 'Attend'}">
                                                        <p style="color: green">P</p>
                                                        <c:set var="countAttend" value="${countAttend+1}"></c:set>
                                                    </c:if>
                                                    <c:if test="${sc.attendance.status eq 'Absent'}">
                                                        <p style="color: red">A</p>
                                                        <c:set var="countAbsent" value="${countAbsent+1}"></c:set>
                                                    </c:if>
                                                </c:if>
                                                <c:set var="size" value="${size+1}"></c:set>
        <!--<a href="attendance?classId=${sc.getClassID().getClassID()}&scId=${sc.getScheduleID()}">Update</a>-->
                                            </td>
                                        </c:forEach>
                                        <c:set var="percent" value="${(countAbsent*100)/size}"></c:set>
                                            <td>
                                            <c:if test="${percent <= 20}">
                                                <p style="color: green">${percent}</p>
                                            </c:if>
                                            <c:if test="${percent > 20}">
                                                <p style="color: red">${percent}</p>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td>Action</td>
                                    <c:forEach items="${allSlot}" var="as" varStatus="i">
                                        <td>
                                            <a href="attendance?scId=${as.scheduleID}&classId=${classId}" target="target">
                                                <button class="btn-primary">Update</button>
                                            </a> 
                                        </td>
                                    </c:forEach>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </main>
            </div>
        </div>
        <div style="margin-bottom: 10em"></div>
        <footer class="footer" >
            &copy; 2024 Đại học FPT. All rights reserved.
            <p>Địa chỉ:KM29 Đại lộ Thăng Long,Thạch Hòa,Thạch Thất,Hà Nội</p>
        </footer>
        <!-- Bootstrap JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
