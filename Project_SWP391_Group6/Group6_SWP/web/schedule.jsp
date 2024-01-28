<%-- 
    Document   : schedule
    Created on : Jan 28, 2024, 1:39:13 AM
    Author     : khanh
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <title>Attendance System - Schedule</title>
</head>
<body>
    <header>
        <h1>Attendance System - Schedule</h1>
    </header>
    
    <section id="schedule">
        <h2>Student Class Schedules</h2>
        
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
                            <a href="schedule.html"><strong>Schedule</strong></a>
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

        <table id="combined-table">
            <thead>
                <tr>
                    <th></th>
                    <th colspan="7" style="text-align: center;">Schedule</th>
                </tr>
                <tr>
                    <th>Slot</th>
                    <th>Monday</th>
                    <th>Tuesday</th>
                    <th>Wednesday</th>
                    <th>Thursday</th>
                    <th>Friday</th>
                    <th>Saturday</th>
                    <th>Sunday</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Slot 1</td>
                    <td id="monday-slot1"></td>
                    <td id="tuesday-slot1"></td>
                    <td id="wednesday-slot1"></td>
                    <td id="thursday-slot1"></td>
                    <td id="friday-slot1"></td>
                    <td id="saturday-slot1"></td>
                    <td id="sunday-slot1"></td>
                </tr>
                <tr>
                    <td>Slot 2</td>
                    <td id="monday-slot2"></td>
                    <td id="tuesday-slot2"></td>
                    <td id="wednesday-slot2"></td>
                    <td id="thursday-slot2"></td>
                    <td id="friday-slot2"></td>
                    <td id="saturday-slot2"></td>
                    <td id="sunday-slot2"></td>
                </tr>
                <tr>
                    <td>Slot 3</td>
                    <td id="monday-slot3"></td>
                    <td id="tuesday-slot3"></td>
                    <td id="wednesday-slot3"></td>
                    <td id="thursday-slot3"></td>
                    <td id="friday-slot3"></td>
                    <td id="saturday-slot3"></td>
                    <td id="sunday-slot3"></td>
                </tr>
                <tr>
                    <td>Slot 4</td>
                    <td id="monday-slot4"></td>
                    <td id="tuesday-slot4"></td>
                    <td id="wednesday-slot4"></td>
                    <td id="thursday-slot4"></td>
                    <td id="friday-slot4"></td>
                    <td id="saturday-slot4"></td>
                    <td id="sunday-slot4"></td>
                </tr>
            </tbody>
        </table>
    </section>
    
    
</body>
</html>