<%-- 
    Document   : Register
    Created on : Jan 30, 2024, 4:06:05 PM
    Author     : minhdang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Form</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                flex-direction: column;
                min-height: 100vh;
            }

            form {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 500px;
                margin: auto; /* Center the form horizontally */
                margin-bottom: 20px; /* Add some space between form and footer */

            }

            label {
                display: block;
                margin-bottom: 8px;
            }

            input,
            select {
                width: 100%;
                padding: 8px;
                margin-bottom: 16px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            button {
                background-color: #4caf50;
                color: #fff;
                padding: 10px 15px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            button:hover {
                background-color: #45a049;
            }

            .header {
                background-color: #4CAF50;
                padding: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                text-align: center;
                margin-bottom: 15px;
            }

            .header img {
                width: 150px;
                height: auto;

            }

            .footer {
                background-color: #4CAF50;
                padding: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                text-align: center;
                margin-top: auto; /* Push footer to the bottom */
            }
        </style>
    </head>
    <body>
        <div class="header">
            <img src="https://cdn.haitrieu.com/wp-content/uploads/2021/10/Logo-Dai-hoc-FPT.png" alt="Đại học FPT Logo" class="mr-2">
        </div>

        <form action="register" method="post">
            <h3>Register</h3>
            <label for="first_name">First Name:</label>
            <input type="text" id="first_name" name="first_name" required>

            <label for="last_name">Last Name:</label>
            <input type="text" id="last_name" name="last_name" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required oninput="validateEmail()">

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="gender">Giới tính:</label>
            <select id="gender" name="gender" required>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>

            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" required>

            <label for="msv">Student ID:</label>
            <input type="text" id="msv" name="msv" required>

            <button type="submit">Register</button>
            <br>
            <span  style="color: red;">${msg}</span>
        </form>
        <div class="footer">
            &copy; 2024 Đại học FPT. All rights reserved.
            <p>Địa chỉ: KM29 Đại lộ Thăng Long, Thạch Hòa, Thạch Thất, Hà Nội</p>
        </div>
        <script>
        </script>
    </body>
</html>
