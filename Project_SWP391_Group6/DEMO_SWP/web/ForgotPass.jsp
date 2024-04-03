<%-- 
    Document   : ForgotPass
    Created on : Feb 27, 2024, 6:38:10 PM
    Author     : lecha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/ForgotPass.css">
    </head>
    <body>
        <div class="main"> 
            <h1>Enter your email:</h1> 
            <h3 style="color: red">${requestScope.msg}</h3>
            <form action="forget" method="POST"> 
                <!--<label for="first">Enter your email</label>--> 
                <!--                <input type="password"  
                                       name="opass" 
                                       placeholder="Email" required>-->
                <input type="text" name="mail" required>
                <p style="color: red">${message}</p>
                <div class="wrap"> 
                    <button type="submit" > 
                        Submit 
                    </button> 
                </div> 
            </form> 
        </div>

    </body>
</html>
