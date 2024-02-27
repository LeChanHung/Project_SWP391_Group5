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
        <link rel="stylesheet" href="css/ForgotPass_OTP.css">
    </head>
    <body>
        <div class="main"> 
            <h1>Confirm OTP:</h1> 
            <h3 style="color: red">${requestScope.msg}</h3>
            <form action="confirmOTP" method="POST"> 
                <label for="first">Enter OTP code we sent to your email</label> 
                <input type="text"  
                       name="otp" 
                       placeholder="OTP CODE" required>
                <!--<input type="hidden" name="mail" value="hunglche160179@fpt.edu.vn">-->
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
