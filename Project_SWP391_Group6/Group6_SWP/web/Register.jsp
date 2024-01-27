<%-- 
    Document   : Register
    Created on : Jan 27, 2024, 1:54:13 PM
    Author     : minhdang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <style>
            body {
                font-family: Arial, sans-serif;
                text-align: center;
                margin: 50px;
            }
            .button {
                display: inline-block;
                padding: 10px 20px;
                font-size: 16px;
                cursor: pointer;
                text-align: center;
                text-decoration: none;
                outline: none;
                border: none;
                border-radius: 5px;
                color: white;
            }
            .student {
                background-color: #3498db;
            }
            .teacher {
                background-color: #e74c3c;
            }
        </style>
    </head>
    <body>
        <a href="RegisterforStudent.jsp" class="button student">You are student</a>
        <a href="RegisterforTeacher.jsp" class="button teacher">You are teacher</a>
    </body>
</html>
