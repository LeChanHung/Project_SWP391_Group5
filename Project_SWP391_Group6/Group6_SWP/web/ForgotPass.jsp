<%-- 
    Document   : ForgotPass
    Created on : Jan 28, 2024, 5:47:18 PM
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
            <h1>Forgot Password</h1> 
            <form action=""> 
                <label for="first">Enter your email:</label> 
                <input type="text" id="mail" 
                       name="mail" 
                       placeholder="Email" required> 
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
