<%-- 
    Document   : HomePage
    Created on : Jan 24, 2024, 8:12:36 AM
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

        <div class="container-fluid">
            <div class="row">
                <nav class="col-md-2 d-none d-md-block bg-light sidebar" style="padding-bottom: 400px;">
                    <div class="sidebar-sticky">
                        <h5 class="my-4" style="color: black;">Menu</h5>
                        <div class="nav flex-column">
                            <a class="nav-link" href="#" onclick="showContent('Weekly Timetable')">Weekly Timetable</a>
                            <a class="nav-link" href="#" onclick="showContent('Attendance Report')">Attendance Report</a>
                            <a class="nav-link" href="#" onclick="showContent('Feedback')">Feedback</a>
                        </div>
                    </div>
                </nav>

                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                    <div id="content">
                        <!-- Nội dung sẽ được hiển thị ở đây khi người dùng nhấp vào các phần -->
                        
                    </div>
                </main>
            </div>
        </div>
        <footer class="footer">
            &copy; 2024 Đại học FPT. All rights reserved.
            <p>Địa chỉ:KM29 Đại lộ Thăng Long,Thạch Hòa,Thạch Thất,Hà Nội</p>
        </footer>
        <!-- Bootstrap JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <script>
                                function showContent(content) {
                                    // Lấy ra phần nội dung dựa vào tham số content và hiển thị nó
                                    var contentDiv = document.getElementById('content');
                                    // Simulatation - Thay thế bằng dữ liệu thực từ server
                                    var fakeData = "Nội dung cho phần " + content;
                                    contentDiv.innerHTML = fakeData;
                                }
        </script>
    </body>
</html>
