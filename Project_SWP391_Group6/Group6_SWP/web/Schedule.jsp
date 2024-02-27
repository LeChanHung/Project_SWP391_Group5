<%-- 
    Document   : Schedule
    Created on : Feb 27, 2024, 8:11:57 AM
    Author     : minhdang
--%>

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
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Slot</th>
                <th>Mon</th>
                <th>Tue</th>
                <th>Wed</th>
                <th>Thu</th>
                <th>Fri</th>
                <th>Sat</th>
                <th>Sun</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>Math</td>
                <td>History</td>
                <td>Biology</td>
                <td>Chemistry</td>
                <td>Physics</td>
                <td>English</td>
                <td>Literature</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Science</td>
                <td>Geography</td>
                <td>Science</td>
                <td>Math</td>
                <td>History</td>
                <td>Biology</td>
                <td>Chemistry</td>
            </tr>
            
        </tbody>
    </table>
</div>

        <footer class="footer">
            &copy; 2024 Đại học FPT. All rights reserved.
            <p>Địa chỉ:KM29 Đại lộ Thăng Long,Thạch Hòa,Thạch Thất,Hà Nội</p>
        </footer>
        <!-- Bootstrap JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
