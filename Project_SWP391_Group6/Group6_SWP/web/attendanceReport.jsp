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
                            <a href="TeacherHomePage.jsp">
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
                            <a href="#">
                                <i class="fas fa-chart-bar"></i>
                                <span class="nav-item">Attendance</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-cog"></i>
                                <span class="nav-item">Setting</span>
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
                        <c:forEach items="${i.allSubject}" var="i">
                            <div class="card">
                                <img src="https://inkythuatso.com/uploads/thumbnails/800/2023/03/9-anh-dai-dien-trang-inkythuatso-03-15-27-03.jpg">

                                <h4>${i.subjectName}</h4>

                                <p>SE</p>
                                <div class="per">
                                    <table>
                                        <tr>
                                            <td><span>85%</span></td>
                                            <td><span>87%</span></td>
                                        </tr>
                                        <tr>
                                            <td>Week</td>
                                            <td>Month</td>
                                        </tr>
                                    </table>
                                    <button><a class="view" href="detailAttendance.jsp">View</a></button>
                                </div>

                            </div>
                        </c:forEach>
                    </div>  
                </div>  


                <section class="attendance">
                    <div class="attendance-list">
                        <h1>Student List</h1>
                        <table class="table">
                            <thead>

                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>MSSV</th>
                                    <th>Date</th>
                                    <th>Gender</th>
                                    <th>Class</th>
                                    <th>Detail</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${i.allStudent}" var="s">
                                    <tr class="active">

                                        <td>${s.studentID}</td>
                                        <td>${s.firstName}</td>
                                        <td>${s.MSV}</td>
                                        <td>${s.dob}</td>
                                        <td>${s.gender}</td>
                                        <td>
                                            <c:forEach items="${i.allClass}" var='c'>
                                                ${c.className}
                                            </c:forEach>
                                        </td> 
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

