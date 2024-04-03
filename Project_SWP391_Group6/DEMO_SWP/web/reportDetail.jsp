<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <a href="#">
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
                                <a href="attendanceReport.jsp">
                                    <i class="fas fa-chart-bar"></i>
                                    <span class="nav-item">Attendance</span>
                                </a>
                            </li>
                       
                            <li>
                                <a href="#" class="logout">
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

                        <section class="attendance">
                            <div class="attendance-list">
                                <h1>Student Report</h1>
                                <table class="table">
                                    <thead>

                                        <tr>
                                            <th>ID</th>
                                            <th>Subject</th>
                                            <th>Teacher</th>
                                            <th>Class</th>
                                            <th>Day Of Week</th>

                                            <th>Detail</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${i.allSchedules}" var="i">
                                        <tr class="active">

                                            <td>${i.subjectID}</td>
                                            <td>${i.subjectName}</td>
                                            <td>${i.fullname}</td>
                                            <td>${i.className}</td>
                                            <td>${i.dayOfWeak}</td>

                                            <td><button>View</button></td>

                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>    
                        </div>
                    </section>
                </section>
            </div>
        


    </body>
</html>

