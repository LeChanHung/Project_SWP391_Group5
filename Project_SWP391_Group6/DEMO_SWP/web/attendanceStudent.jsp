<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <jsp:useBean id="s" class="DAO.DAO1" scope="request"></jsp:useBean>


            <title>Attendance Report</title>
            <link rel="stylesheet" type="text/css" href="style.css">   
            <link href= "css/attendance.css" rel="stylesheet" type="text/css" />
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
        </head>
        <body>
            <form action="report" method="post">
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
                                <a href="stuTimeTable">
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
                    
                        <div class="subject">              
                        <div class="users"> 
                        <c:forEach items="${requestScope.listSub}" var="s">
                            <div class="card">
                                <img src="https://inkythuatso.com/uploads/thumbnails/800/2023/03/9-anh-dai-dien-trang-inkythuatso-03-15-27-03.jpg">

                                <h4>${s.subjectName}</h4>

                                <div class="per">      
                                    <button><a class="view" href="statics?id=${s.subjectID}">View</a></button>
                                </div>

                            </div>
                        </c:forEach>
                    </div>  
                </div>  

                </section>
            </div>
        </form>


    </body>
</html>