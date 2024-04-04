<%-- 
    Document   : View_Application
    Created on : Mar 9, 2024, 5:29:45 PM
    Author     : lecha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Xem Đơn</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            header {
                background-color: #333;
                color: #fff;
                padding: 20px;
                text-align: center;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 10px;
                text-align: left;
            }

            /* Chỉ hiển thị tối đa 50 ký tự trong cột thứ 3 */
            td:nth-child(3) {
                max-width: 150px;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
            }
        </style>
    </head>
    <body>
        <header style="background-color: #45a049">
            <h1>View Application</h1>
        </header>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Application Type</th>
                    <th>Content</th>
                    <th>Status</th>
                    <td>Comment</td>
                    <th>Action</th>
                    <th>Send to teacher</th>
                    <th>Created At</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${applications}" var="a">
                    <tr>
                        <td>${a.id}</td>
                        <td>${a.content.split('-')[0]}</td>
                        <td>
                            <c:forEach items="${a.content.split('-')}" var="str" varStatus="loop">
                                <c:if test="${loop.index ne 0}">
                                    <p>${str} </p>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:if test="${a.status eq 0}">
                                <p>Status: Not Yet</p>
                            </c:if>
                            <c:if test="${a.status ne 0}">
                                <c:if test="${a.status eq 1}">
                                    <p style="color: green">Status: Accepted</p>
                                </c:if>
                                <c:if test="${a.status eq -1}">
                                    <p style="color: red">Status: Denied</p>
                                </c:if>
                            </c:if>
                        </td>
                        <td><c:if test="${a.comment ne null}">${a.comment}</c:if></td>
                            <td>
                            <c:if test="${!a.content.split('-')[0].equals('Đơn xin điểm danh ')}">
                                <a href="updateStatus?id=${a.id}"><button>Detail and Evalute</button></a>
                            </c:if>
                            <c:if test="${a.content.split('-')[0].equals('Đơn xin điểm danh ')}">
                                <c:if test="${a.teacherId ne null}">
                                    <c:if test="${a.status eq 0}">
                                        <a href="detailAppli?id=${a.id}"><button>Detail</button></a>
                                    </c:if>
                                    <c:if test="${a.status ne 0}">
                                        <a href="updateStatus?id=${a.id}"><button>Detail and Evalute</button></a>
                                    </c:if>
                                </c:if>
                                <c:if test="${a.teacherId eq null}">

                                </c:if>
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${a.content.split('-')[0].equals('Đơn xin điểm danh ')}">
                                <c:if test="${a.teacherId eq null}">
                                    <form method="post" action="sendAppTeacher">
                                        <select name="teacherId">
                                            <c:forEach items="${teachers}" var="t">
                                                <option value="${t.teacherID}">${t.firstName} ${t.lastName}</option>
                                            </c:forEach>
                                        </select>
                                        <button>Send</button>
                                        <input type="hidden" name="id" value="${a.id}">
                                    </form>
                                </c:if>
                                <c:if test="${a.teacherId ne null}">
                                    <p style="color: green">Sent</p>
                                </c:if>
                            </c:if>
                        </td>
                        <td>${a.createdAt}</td>
                    </tr>
                </c:forEach>
                <!-- Thêm các hàng dữ liệu khác tại đây nếu cần -->
                <c:if test="${sessionScope.student ne null}">
                <a class="nav-link" href="StudentHomepage.jsp">Homepage</a>
            </c:if>
            <c:if test="${sessionScope.office ne null}">
                <a class="nav-link" href="index">Homepage</a>
            </c:if>
        </tbody>
    </table>
</body>
</html>

