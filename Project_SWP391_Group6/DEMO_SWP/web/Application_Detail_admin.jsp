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
            <form method="post" action="updateStatus">
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
                <c:if test="${app.status eq 0}">
                    <p>Status: <input type="radio" name="status" value="1" checked>Accept <input type="radio" name="status" value="-1">Deny 
                    </p>
                    <p><strong>Comment:</strong><textarea name="comment" rows="5" cols="10">${app.comment}</textarea></p>
                    <button>Evalute</button>
                </c:if>
                <c:if test="${app.status ne 0}">
                    <c:if test="${app.status eq 1}">
                        <p>Status: Accepted</p>
                    </c:if>
                    <c:if test="${app.status ne -1}">
                        <p>Status: Denied</p>
                    </c:if>
                    <p><strong>Comment:</strong><c:if test="${app.comment ne null}">${app.comment}</c:if></p>
                </c:if>
                <input type="hidden" value="${id}" name="id">
            </form>
            <button onclick="downloadFile('${app.filePath}')">Download File Attached</button>
            <a class="nav-link" href="viewApplication">View Application</a>
        </div>
    </body>
    <script>
        function downloadFile(filePath) {
            // URL of the file to be downloaded
            var fileUrl = filePath + ''; // Replace with the actual file URL

            // Create an anchor element
            var anchor = document.createElement('a');
            anchor.href = fileUrl;
            // Split the file path by '/'
            var parts = fileUrl.split('/');

            // Get the last part which is the filename
            var filename = parts[parts.length - 1];
            // Set the download attribute with desired file name
            anchor.download = filename; // Replace with the desired file name

            // Append the anchor element to the document body
            document.body.appendChild(anchor);

            // Trigger the click event on the anchor element
            anchor.click();

            // Remove the anchor element from the document body
            document.body.removeChild(anchor);
        }
    </script>
</body>
</html>
