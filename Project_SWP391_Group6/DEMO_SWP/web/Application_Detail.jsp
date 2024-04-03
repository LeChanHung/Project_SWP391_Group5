<%-- 
    Document   : Application_Detail
    Created on : Mar 10, 2024, 2:19:59 PM
    Author     : lecha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 800px;
                margin: 20px auto;
                padding: 20px;
                background-color: #f9f9f9;
                border: 1px solid #ddd;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .header {
                background-color: #333;
                color: #fff;
                padding: 10px;
                text-align: center;
            }

            .detail {
                margin-top: 20px;
            }

            .detail h2 {
                margin-bottom: 10px;
                font-size: 1.5em;
            }

            .detail p {
                margin-bottom: 10px;
            }

            .button {
                display: inline-block;
                background-color: #007bff;
                color: #fff;
                padding: 10px 20px;
                text-decoration: none;
                border-radius: 5px;
            }

            .button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="header" style="background-color: #45a049">
                <h1>Detail Page</h1>
            </div>

            <div class="detail">
                <h2>Detail Title</h2>
                <p><strong>Name:</strong> ${app.studentId.firstName} ${app.studentId.lastName}</p>
                <p><strong>MSV:</strong> ${app.studentId.MSV}</p>
                <p><strong>Content:</strong>${app.content}</p>
                <!-- Thêm các phần tử khác cho chi tiết đơn hàng tại đây -->
            </div>
            <c:if test="${sessionScope.teacher ne null}">
                <c:if test="${app.status eq 0}">
                    <a href="updateStatus?id=${app.id}&status=1" class="button" style="background-color: #45a049">Accept</a>
                    <a href="updateStatus?id=${app.id}&status=0" class="button" style="background-color: red">Deny</a>
                </c:if>
                <c:if test="${app.status ne 0}">
                    <c:if test="${app.status eq 1}">
                        <p>Status: Accepted</p>
                    </c:if>
                    <c:if test="${app.status ne -1}">
                        <p>Status: Denied</p>
                    </c:if>
                </c:if>
            </c:if>
            <c:if test="${sessionScope.teacher eq null}">
                <c:if test="${app.status eq 0}">
                    <p>Status: Not Yet</p>
                </c:if>
                <c:if test="${app.status ne 0}">
                    <c:if test="${app.status eq 1}">
                        <p>Status: Accepted</p>
                    </c:if>
                    <c:if test="${app.status ne -1}">
                        <p>Status: Denied</p>
                    </c:if>
                </c:if>
            </c:if>
            <a class="nav-link" href="viewApplication">View Application</a>
        </div>
    </body>
</body>
</html>
