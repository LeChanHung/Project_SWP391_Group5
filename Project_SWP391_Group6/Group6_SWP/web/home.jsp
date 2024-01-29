<%-- 
    Document   : home
    Created on : Jan 28, 2024, 9:34:28 PM
    Author     : khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <title>Attendance System</title>
</head>
<body>
    <header>
        <div id="user-info">
            <!-- Display user status (Student/Teacher) here ->Edit code here to update --> 
            <p><strong>Student</strong></p>
        </div>
        <h1>Attendance System</h1>
        <div id="logout">
            <a href="#"><strong>Logout</strong></a>
        </div>
    </header>

    <section id="home">
        <h2>Attendance System Of University</h2>
        <table>
            <tbody>
                <tr>
                    <td>
                        <div class="section" id="homepage">
                            <a href="home.jsp"><strong>Home Page</strong></a>
                        </div>
                    </td>

                    <td>
                        <div class="section" id="timetables">
                            <a href=""><strong>Timetables</strong></a>
                        </div>
                    </td>
                    <td>
                        <div class="section" id="report-attendance">
                            <a href=""><strong>Attendance</strong></a>
                        </div>
                    </td>
                    <td>
                        <div class="section" id="schedule">
                            <a href="schedule.jsp"><strong>Schedule</strong></a>
                        </div>
                    </td>
                    <td>
                        <div class="section" id="feedback">
                            <a href=""><strong>Feedback</strong></a>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table> 
    </section>
</body>
</html>
