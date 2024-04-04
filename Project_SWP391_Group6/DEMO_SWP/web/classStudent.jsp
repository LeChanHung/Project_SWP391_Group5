<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="header.jsp"></jsp:include>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
            <title>Student Class</title>
        </head>
        <body>
            <div class="container">
                <div class="row" >


                    <div class="col-md-12">
                        <div class="d-flex justify-content-between mb-3">
                            <!-- Button to open the modal for adding a new subject -->
                            <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addStudentModal">Add Student</button>
                             <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addTeacherModal">Add Teacher</button> 
                            <!-- Button to open the modal for adding a new teacher -->
                            <a class="btn btn-primary" href="class_manager">Back</a>
                        </div>

                        <table class="table">
                            <thead>
                                <tr>
                                    <th>MSV</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>                                
                                    <th>DOB</th>
                                    <th>Gender</th>


                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="t" items="${liststudent}">
                                <!-- Check if the current teacher matches the search criteria -->
                                <c:if test="${empty param.searchKeyword or fn:containsIgnoreCase(t.firstName, param.searchKeyword) or fn:containsIgnoreCase(t.lastName, param.searchKeyword)}">
                                    <tr>
                                        <td>${t.MSV}</td>
                                        <td>${t.firstName}</td>
                                        <td>${t.lastName}</td>
                                        <td>${t.email}</td>
                                        <td>${t.dob}</td>
                                        <td>${t.gender}</td>


                                        <td>
                                            <!-- Add buttons or links for edit and delete actions -->

                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>



    <!-- Modal for adding a new student -->
    <div class="modal fade" id="addStudentModal" tabindex="-1" role="dialog" aria-labelledby="addStudentModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addStudentModalLabel">Enroll Student</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <!-- Form for adding a new student -->
                    <form action="${pageContext.request.contextPath}/class_manager" method="POST">
                        <div class="mb-3">
                            <label for="firstName" class="form-label">MSV</label>                              
                            <select class="form-control" id="firstName" name="msv" required="">
                                <c:forEach var="s" items="${listStudying}">
                                    <option var="${s.MSV}">${s.MSV}</option>
                                </c:forEach>

                            </select>
                        </div>
                        <input type="hidden" value="${name.classID}" name="cid"/>
                        <div class="mb-3">
                            <label for="MSV" class="form-label">Class Name</label>
                            <input type="text" value="${name.className}" class="form-control" id="MSV" name="className" readonly required>
                        </div>
                        <div id="errorMessage" style="display: none; color: red;">${err}</div>
                        <button type="submit" class="btn btn-primary">Enroll</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addTeacherModal" tabindex="-1" role="dialog" aria-labelledby="addStudentModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addStudentModalLabel">Add New Teacher</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <!-- Form for adding a new student -->
                    <form action="${pageContext.request.contextPath}/classteacher" method="POST">

                        <div class="mb-3">
                            <label  class="form-label">MSV</label>                              
                            <select class="form-control"  name="teacher" required="">
                                <c:forEach var="s" items="${listTeacher}">
                                    <option value="${s.teacherID}">${s.firstName} ${s.lastName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="firstName" class="form-label">Class</label>     
                            <input type="text" class="form-control" value="${name.className}" readonly/>
                            <input type="hidden" class="form-control" id="MSV" name="class" value="${name.classID}" />
                        </div>

                        <div class="mb-3">
                            <label for="firstName" class="form-label">MSV</label>                              
                            <select class="form-control" id="firstName" name="student" required="">
                                <c:forEach var="s" items="${listStudent1}">
                                    <option value="${s.studentID}">${s.MSV}</option>
                                </c:forEach>

                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="firstName" class="form-label">Slot</label>                              
                            <select class="form-control" id="firstName" name="slot" required="">
                                <c:forEach var="s" items="${listSlot}">
                                    <option value="${s.slotID}">${s.slotNumber}</option>
                                </c:forEach>

                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="firstName" class="form-label">Subject</label>                              
                            <select class="form-control" id="firstName" name="subject" required="">
                                <c:forEach var="s" items="${listSubject}">
                                    <option value="${s.subjectID}">${s.subjectName}</option>
                                </c:forEach>

                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="MSV" class="form-label">Day of Week</label>
                            <input type="text" class="form-control" id="MSV" name="dayofweek" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Date Created</label>
                            <input type="date" class="form-control" id="the-date" name="dateCreated">
                        </div>




                        <div id="errorMessage" style="display: none; color: red;">${err}</div>
                        <button type="submit" class="btn btn-primary">SUBMIT</button>
                    </form>
                </div>
            </div>
        </div>
    </div>         



    <script>
        function confirmDelete(contextPath, msv1, className1) {
            var confirmation = confirm("Are you sure you want to delete this student?");

            if (confirmation) {
                // Set the action and studentId in the form and submit it
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", contextPath + "/class_manager");
                form.innerHTML = '<input type="hidden" name="action" value="delete">'
                        + '<input type="hidden" name="msv1" value="' + msv1 + '">' +
                        '<input type="hidden" name="className1" value="' + className1 + '">';
                document.body.appendChild(form);
                form.submit();
            }
        }
    </script>
    <script>
            var date = new Date();

            var day = date.getDate();
            var month = date.getMonth() + 1;
            var year = date.getFullYear();

            if (month < 10)
                month = "0" + month;
            if (day < 10)
                day = "0" + day;

            var today = year + "-" + month + "-" + day;


            document.getElementById('the-date').value = today;
        </script>

    <jsp:include page="footer.jsp"></jsp:include>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>

</body>
</html>
