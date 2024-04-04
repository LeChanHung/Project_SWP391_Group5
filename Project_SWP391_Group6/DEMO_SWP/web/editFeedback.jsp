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
        <form method="post" action="editFeedBack">
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

                <h2>List of feedbacks for ${sessionScope.student.firstName} ${sessionScope.student.lastName} (${sessionScope.student.MSV})</h2>

                <div style="margin: 30px 0px;">
                    <p>Lecturer: ${fbt.teacherId.firstName} ${fbt.teacherId.lastName}</p>
                    <p>Subject: ${fbt.subjectId.subjectName}</p>
                </div>

                <div style="margin: 30px 0px;">
                    <h3>Edit Feedback</h3>
                </div>


                <div style="display: flex;justify-content: space-around;">
                    <div>
                        <h6>Professional quality</h6>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="proRate" id="1" value="5"
                                   <c:if test="${fbt.proRate eq 5}">checked</c:if>
                                       >
                                   <label class="form-check-label" for="1">
                                       Very good
                                   </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="proRate" id="2" value="4"
                                <c:if test="${fbt.proRate eq 4}">checked</c:if>

                                    >
                                <label class="form-check-label" for="2">
                                    Good
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="proRate" id="3" value="3"
                                <c:if test="${fbt.proRate eq 3}">checked</c:if>
                                    >
                                <label class="form-check-label" for="1">
                                    Medium
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="proRate" id="4" value="2"
                                <c:if test="${fbt.proRate eq 2}">checked</c:if>
                                    >
                                <label class="form-check-label" for="2">
                                    Bad
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="proRate" id="5" value="1"
                                <c:if test="${fbt.proRate eq 1}">checked</c:if>
                                    >
                                <label class="form-check-label" for="1">
                                    Very bad
                                </label>
                            </div>
                        </div>


                        <div>
                            <h6>Teach on time</h6>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="teachRate" id="6" value="5" 
                                <c:if test="${fbt.teachRate eq 5}">checked</c:if>
                                    >
                                <label class="form-check-label" for="3">
                                    Very good
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="teachRate" id="7" value="4"
                                <c:if test="${fbt.teachRate eq 4}">checked</c:if>

                                    >
                                <label class="form-check-label" for="4">
                                    Good
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="teachRate" id="8" value="3"
                                <c:if test="${fbt.teachRate eq 3}">checked</c:if>

                                    >
                                <label class="form-check-label" for="3">
                                    Medium
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="teachRate" id="9" value="2"
                                <c:if test="${fbt.teachRate eq 2}">checked</c:if>

                                    >
                                <label class="form-check-label" for="4">
                                    Bad
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="teachRate" id="10" value="1"
                                <c:if test="${fbt.teachRate eq 1}">checked</c:if>
                                    >
                                <label class="form-check-label" for="3">
                                    Very bad
                                </label>
                            </div>
                        </div>
                    </div>



                    <div style="margin: 30px 0px;">
<!--                        <input placeholder="Write your feedback here" 
                               style="width:100%; height: 100px" name="comment"
                               value="${fbt.comment}"
                               required>-->
                    <textarea placeholder="Write your feedback here just 255 characters"  style="width:100%; height: 10em" name="comment"  maxlength="255" required>${fbt.comment}</textarea>
                    </div>

                    <div style="margin: 30px 0px;display: flex;justify-content: center;">
                        <button
                            style="background-color:rgb(48, 100, 198); border-radius: 5px; width: 150px; height: 50px; color: white;">Submit</button>
                    </div>
                    <input type="hidden" name="id" value="${fbt.id}">
            </div>
        </form>

    </body>

</html>