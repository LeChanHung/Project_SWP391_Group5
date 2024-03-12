<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Class Detail</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #666;
        }

        input[type="text"] {
            width: calc(100% - 12px);
            padding: 6px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="button"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="button"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Class Detail</h1>
        <form action="detailslot" method="get">
            <label for="slot">Slot:</label>
            <h3>${dt.getSlot().getSlotNumber()}</h3><br><br>
            
            <label for="startTime">Start Time:</label>
            <h3><fmt:formatDate value="${dt.getSlot().getSlotStartTime()}" pattern="HH:mm"/></h3><br><br>
            
            <label for="endTime">End Time:</label>
            <h3><fmt:formatDate value="${dt.getSlot().getSlotEndTime()}" pattern="HH:mm"/></h3><br><br>
            
            <label for="lecture">Lecture:</label>
            <h3>${dt.getTeacher().getFirstName()}${dt.getTeacher().getLastName()}</h3><br><br>
            
            <label for="lecture">Subject:</label>
            <h3>${dt.getSubjects().getSubjectName()}</h3><br><br>
            
            <label for="lecture">Class:</label>
            <h3>${dt.getClasses().getClassName()}</h3><br><br>
            
            <input type="button" value="Back" onclick="history.back()">
        </form>
    </div>
</body>
</html>
