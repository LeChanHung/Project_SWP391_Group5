<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>


<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <link href= "css/listFeedback.css" rel="stylesheet" type="text/css" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
            rel="stylesheet">
        <title>Student Feedback</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
        <jsp:useBean id="i" class="DAO.DAO1" scope="request"></jsp:useBean>
    </head>

    <body>
        <section id="testimonials">
            <div class="testimonial-heading">
                <span>Student</span>
                <h1>Feedback</h1>
            </div>

            <div class="testimonial-box-container">
            <c:forEach items="${i.allFeedback}" var="f">
                <div class="testimonial-box">
                    <div class="box-top">
                        <div class="profile">
                            <div class="profile-img">
                                <img src="https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg"/>
                            </div>
                            <div class="name-user">
                                <strong>${f.firstName}</strong>
                                <span>${f.email}</span>
                            </div>
                        </div>
                        <div class="reviews">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="far fa-star"></i>
                        </div>

                    </div>


                    <div class="client-comment">
                        ${f.feedbackText}
                    </div>
                    <a href="responseFeedback.jsp">Response</a>
                </div>
            </c:forEach>
            </div>
        </section>

    </body>

</html>