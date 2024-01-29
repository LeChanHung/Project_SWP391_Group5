<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <jsp:useBean id="sub" class="dao.DAO" scope="request"></jsp:useBean>
        <jsp:useBean id="s" class="dao.DAO" scope="request"></jsp:useBean>
        <jsp:useBean id="c" class="dao.DAO" scope="request"></jsp:useBean>
        
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
                                <span class="nav-item">Dashboard</span>
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
                            <a href="#">
                                <i class="fas fa-cog"></i>
                                <span class="nav-item">Setting</span>
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
                        <h1>Student List</h1>
                        <table class="table">
                            <thead>
                                
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>MSSV</th>
                                    <th>Date</th>
                                    <th>Present Percent</th>
                                    <th>Absent Percent</th>
                                    <th>Detail</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${s.allStudent1}" var="s">
                                <tr class="active">
                               
                                    <td>${s.id}</td>
                                    <td>${s.name}</td>
                                    <td>${s.msv}</td>
                                    <td>${s.dob}</td>
                                    <td>80%</td>
                                    <td>20%</td>
                                    
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

