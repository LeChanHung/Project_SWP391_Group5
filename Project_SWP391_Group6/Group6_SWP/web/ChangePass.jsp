<%-- 
    Document   : ChangePass
    Created on : Jan 28, 2024, 5:53:24 PM
    Author     : lecha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="main"> 
            <h1>Change Password</h1> 
            <form action=""> 
                <label for="first">Enter your old Password</label> 
                <input type="text"  
                       name="oldpass" 
                       placeholder="Old password" required>
                
                <label for="first">Enter your new Password</label> 
                <input type="text" 
                       name="newpass" 
                       placeholder="New password" required> 
                
                <label for="first">Confirm Password</label> 
                <input type="text"  
                       name="cofipass" 
                       placeholder="Confirm password" required>
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
