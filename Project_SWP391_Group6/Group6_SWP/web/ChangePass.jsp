<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/ChangePass.css">
    </head>
    <body>
        <div class="main"> 
            <h1>Change Password</h1> 
            <h3 style="color: red">${requestScope.msg}</h3>
            <form action="changepass"> 
                <label for="first">Enter your old Password</label> 
                <input type="password"  
                       name="opass" 
                       placeholder="Old password" requirea
                <!--<input type="hidden" name="mail" value="hunglche160179@fpt.edu.vn">--> 
                <label for="first">Enter your new Password</label> 
                <input type="password" 
                       name="pass" 
                       placeholder="New password" required> 
                
                <label for="first">Confirm Password</label> 
                <input type="password"  
                       name="rpass" 
                       placeholder="Confirm password" required>
                <div class="wrap"> 
                    <button type="submit" > 
                        Submit 
                    </button> 
                    
                    
                </div> 
            </form> 
        </div>
        
    </body>
</html>
