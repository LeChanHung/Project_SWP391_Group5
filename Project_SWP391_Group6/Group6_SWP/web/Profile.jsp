<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/Profile.css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <!-- Font Awesome CSS -->
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css'>
        
    </head>
    <body>
        <div class="student-profile py-4">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="card shadow-sm">
                            <div class="card-header bg-transparent border-0">
                                <h3 class="mb-0" style="color: #4CAF50"><i class="far fa-clone pr-1"></i>Full name:${user.getFirstName()} ${user.getLastName()}</h3>
                            </div>
                            <div class="card-body pt-0">
                                <table class="table table-bordered">
                                    <tr>
                                        <th width="30%" style="color: #4CAF50">Email</th>
                                        <td width="2%">:</td>
                                        <td>${user.getEmail()}</td>
                                    </tr>
                                    <tr>
                                        <th width="30%" style="color: #4CAF50">Gender	</th>
                                        <td width="2%">:</td>
                                        <td>${user.getGender()}</td>
                                    </tr>
                                    <tr>
                                        <th width="30%" style="color: #4CAF50">Date of bird</th>
                                        <td width="2%">:</td>
                                        <td>${user.getDob()}</td>
                                    </tr>
                                    <tr>
                                        <th width="30%" style="color: #4CAF50">MSV</th>
                                        <td width="2%">:</td>
                                        <td>${user.getMSV()}</td>
                                    </tr>
                                    
                                </table>
                                <a href="ChangePass.jsp" style="color: #4CAF50">Change Password</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
