<%-- 
    Document   : RegisterforStudent
    Created on : Jan 27, 2024, 2:07:43 PM
    Author     : minhdang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css"
    </head>
    <body>
        <div class="main"> 
        <h1>Student</h1> 
        <form action=""> 
            <label for="first">Enter Full Name:</label> 
            <input type="text" id="name" 
                   name="name" 
                   placeholder="FullName" required> 
  
            <label for="last">Enter MSSV</label> 
            <input type="text" id="mssv" 
                   name="mssv" 
                   placeholder="MSSV" required> 
  
            <label for="dob">Date of Birth:</label> 
            <input type="date" 
                   id="dob" name="dob" 
                   placeholder="Enter your DOB" required> 
            
            <label for="email">Email:</label> 
            <input type="email" id="email" 
                   name="email" 
                   placeholder="Enter your email" required>
  
            <label for="password">Password:</label> 
            <input type="password" id="password" 
                   name="password"
                   placeholder="Enter your password" required>
            
             <label for="repassword">Re-type Password:</label> 
            <input type="password" id="repassword" 
                   name="repassword" 
                   placeholder="Re-Enter your password" required> 
            <span id="pass"></span> 
  
            <label for="gender">Gender:</label> 
            <select id="gender" name="gender" required> 
                <option value="male">Male</option> 
                <option value="female">Female</option> 
                <option value="other">Other</option> 
            </select> 
  
            <div class="wrap"> 
                <button type="submit" onclick="solve()"> 
                  Submit 
                  </button> 
            </div> 
        </form> 
    </div>
        <script src="js/script.js"></script>
    </body>
</html>
