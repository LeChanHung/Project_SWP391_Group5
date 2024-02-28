<%-- 
    Document   : dashboard
    Created on : Jan 27, 2024, 8:52:54 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link rel="stylesheet" href="css/stylee.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    </head>
</head>
<body>
    <div class="sidebar">
        <div class="logo"></div>
        <ul class="menu">
            <li class="active">
                <a href="#" >
                    <i class="fas fa-tachometer-alt"></i>
                    <span>Dashboard</span>
                </a>    
            </li>

            <li>
                <a href="#" class="submenu-toggle">
                    <i class="fas fa-user"></i>
                    <span>Manager</span>
                </a>
                <ul class="submenu">
                    <li>
                        <a href="teacher_manager">
                            <i class="fas fa-chalkboard-teacher"></i>
                            <span>Manager Teacher</span>
                        </a>
                    </li>
                    <li>
                        <a href="student_manager">
                            <i class="fas fa-user-graduate"></i>
                            <span>Manager Student</span>
                        </a>
                    </li>
                    <li>
                        <a href="class_manager">
                            <i class="fas fa-user-graduate"></i>
                            <span>Manager Class</span>
                        </a>
                    </li>
                </ul>
            </li>

            <li>
                <a href="#">
                    <i class="fas fa-chart-line"></i>
                    <span>Statistics</span>
                </a>    
            </li>
            <li>
                <a href="#">
                    <i class="fas fa-calendar-check"></i>
                    <span>Attendance</span>
                </a>    
            </li>
            <li>
                <a href="listFeedback">
                    <i class="fas fa-file-alt"></i>
                    <span>FeedBack</span>
                </a>    
            </li>


            <li>
                <a href="#">
                    <i class="fas fa-question-circle"></i>
                    <span>FAQ</span>
                </a>    
            </li>


            <li>
                <a href="logout.jsp">
                    <i class="fas fa-sign-out-alt"></i>
                    <span>Logout</span>
                </a>    
            </li>
        </ul>
    </div>

    <div class="main--content">
        <div class="header--wrapper">
            <div class="header--title">
                <span></span>
                <h2>Phòng Đào Tạo</h2>
            </div>
            <div class="user--info">
                <div class="search--box">
                    <i class="fas fa-search"></i>
                    <input type="text" placeholder="Search...">
                </div>
                <img src="image/namit.jpg" alt="">
            </div>
        </div>
        <div class="card--container">
            <h3 class="main--title">Today</h3>
            <div class="card--wrapper">
                <div class="payment--card light-red">
                    <div class="card--header">
                        <div class="amount">
                            <span class="title">
                                Student View
                            </span>
                            <span class="amount-value">7000</span>
                        </div>
                        <i class="fas fa-eye icon"></i>
                    </div>
                    <span class="card-detail">********12</span>
                </div>

                <div class="payment--card light-purple ">
                    <div class="card--header">
                        <div class="amount">
                            <span class="title">
                                Teacher View
                            </span>
                            <span class="amount-value">500</span>
                        </div>
                        <i class="fas fa-eye icon"></i>
                    </div>
                    <span class="card-detail">********12</span>
                </div>

                <div class="payment--card light-green ">
                    <div class="card--header">
                        <div class="amount">
                            <span class="title">
                                Student View
                            </span>
                            <span class="amount-value">7000</span>
                        </div>
                        <i class="fas fa-eye icon"></i>
                    </div>
                    <span class="card-detail">********12</span>
                </div>
            </div>
        </div>

        <div class="tabular--wapper">
            <h3 class="main-title"></h3>
        </div>

    </div>

</body>
</html>
