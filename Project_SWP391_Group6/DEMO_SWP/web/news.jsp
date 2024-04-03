<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href= "css/news.css" rel="stylesheet" type="text/css" /><meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

        <style>
            body,h1,h2,h3,h4,h5 {
                font-family: "Raleway", sans-serif
            }
        </style>
    </head>
    <body class="w3-light-grey">

        <!-- w3-content defines a container for fixed size centered content, 
        and is wrapped around the whole page content, except for the footer in this example -->
        <div class="w3-content" style="max-width:1400px">

            <!-- Header -->
            <header class="w3-container w3-center w3-padding-32"> 
                <div class="header">
                    <a href="#default" class="logo">FPT University</a>
                    <div class="header-right">
                        <a class="active" href="StudentHomepage.jsp">Home</a>
                        <a href="#contact">Contact</a>
                        <a href="#about">Log out</a>
                    </div>
                </div>
                <h1><b>NEWS</b></h1>

            </header>

            <!-- Grid -->
            <div class="w3-row">

                <!-- Blog entries -->
                <div class="w3-col l8 s12">
                    <!-- Blog entry -->
                    <c:forEach items="${newList}" var="n">
                        <div class="w3-card-4 w3-margin w3-white">
                            <img src="${n.img}" alt="Nature" style="width:100%">
                            <div class="w3-container">
                                <h3><b>${n.title}</b></h3>
                                <h5> <span class="w3-opacity">${n.date}</span></h5>
                            </div>

                            <div class="w3-container">
                                <p>${n.content}</p>
                                <div class="w3-row">

                                </div>
                            </div>
                        </div>
                        <hr>
                    </c:forEach>
                    <!-- END BLOG ENTRIES -->
                </div>

                <!-- Introduction menu -->
                <div class="w3-col l4">
                    <!-- About Card -->
                    <div class="w3-card w3-margin w3-margin-top">
                        <img src="https://bcp.cdnchinhphu.vn/334894974524682240/2023/9/8/anh-1-tcbc-mo-khoa-vi-mach-ban-dan-v12-16941379887451289815705.jpg" style="width:100%">
                        <div class="w3-container w3-white">
                            <h4><b>FPT University</b></h4>
                            <p>Many students have heard many names of FPT but do not clearly understand what FPT University is? Or many people wonder if FPT school is a public or private school? What is FPT University? FPT is a private (people-founded) university providing undergraduate training that is rated as the top quality today.</p>
                        </div>
                    </div><hr>



                    <!-- Labels / tags -->


                    <!-- END Introduction Menu -->
                </div>

                <!-- END GRID -->
            </div><br>

            <!-- END w3-content -->
        </div>

        <!-- Footer -->
        <footer class="w3-container w3-dark-grey w3-padding-32 w3-margin-top">
            <!-- Pagination -->
            <c:set var="page" value="${requestScope.page}"/>
            <nav aria-label="...">
                <ul class="pagination">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                    </li>
                    <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                        <li class="page-item"><a class="page-link" href="news?page=${i}">${i}</a></li>

                    </c:forEach>

                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>


        </footer>

    </body>
</html>
