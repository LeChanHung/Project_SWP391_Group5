<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FPT University Academic Portal</title>

    </head>

    <body>

        <div class="container">
            <h1>FPT University Academic Portal</h1>
            <nav class="navbar navbar-expand-lg navbar-light bg-light " style="margin: 30px 0px;">
                <div class="container-fluid">
                    <a class="navbar-brand" href="StudentHomepage.jsp">Home</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                </div>
            </nav>

            <h2>List of feedbacks for Student</h2>
            <table class="table" style="margin: 50px 0px;">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Lecturer</th>
                        <th scope="col">Subject</th>
                        <th scope="col">Do Feedback</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${feedBackTeachers}" var="fbt" varStatus="loop">
                        <tr>
                            <th scope="row">${loop.index+1}</th>
                            <td>${fbt.teacherId.firstName} ${fbt.teacherId.lastName}</td>
                            <td>${fbt.subjectId.subjectName}</td>
                            <td>
                                <a href="feedBackTeacher?teacherId=${fbt.teacherId.teacherID}&subjectId=${fbt.subjectId.subjectID}">Do feedback</a>
                                <!--<a href="#">See feedback details</a>-->
                            </td>
                        </tr>
                    </c:forEach>      
                </tbody>
            </table>
        </div>

    </body>

</html>