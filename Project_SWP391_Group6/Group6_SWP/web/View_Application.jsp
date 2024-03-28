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
            <h1>Page Title</h1>
        </header>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Application Type</th>
                    <th>Content</th>
                    <th>Status</th>
                    <th>Action</th>
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
                            <c:if test="${sessionScope.office ne null}">
                                <c:if test="${a.status eq 0}">
                                    <a href="updateStatus?id=${a.id}&status=1" class="button" style="background-color: #45a049">Accept</a>
                                    <a href="updateStatus?id=${a.id}&status=0" class="button" style="background-color: red">Deny</a>
                                </c:if>
                                <c:if test="${a.status ne 0}">
                                    <c:if test="${a.status eq 1}">
                                        <p>Status: Accepted</p>
                                    </c:if>
                                    <c:if test="${a.status eq -1}">
                                        <p>Status: Denied</p>
                                    </c:if>
                                </c:if>
                            </c:if>
                            <c:if test="${sessionScope.student eq null}">
                                <c:if test="${a.status eq 0}">
                                    <p>Status: Not Yet</p>
                                </c:if>
                                <c:if test="${a.status ne 0}">
                                    <c:if test="${a.status eq 1}">
                                        <p>Status: Accepted</p>
                                    </c:if>
                                    <c:if test="${a.status eq -1}">
                                        <p>Status: Denied</p>
                                    </c:if>
                                </c:if>
                            </c:if>

                        </td>
                        <td><a href="detailAppli?id=${a.id}">Detail</a></td>
                    </tr>
                </c:forEach>
                <!-- Thêm các hàng dữ liệu khác tại đây nếu cần -->
                <c:if test="${sessionScope.student ne null}">
                <a class="nav-link" href="StudentHomepage.jsp">Homepage</a>
            </c:if>
                <c:if test="${sessionScope.office ne null}">
                <a class="nav-link" href="phongdaotao.jsp">Homepage</a>
            </c:if>
        </tbody>
    </table>
</body>
</html>

