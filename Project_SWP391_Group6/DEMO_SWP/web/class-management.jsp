<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="header.jsp"></jsp:include>
    <!DOCTYPE html>
    <html lang="en">
        <head>

            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
            <title>Class Management</title>
        </head>
        <body>
        <c:if test="${not empty mess}">
            <script>
                window.addEventListener("load", function(){
                alert("${mess}");
                }
            </script>
        </c:if>
        <div class="container">
            <h1>Class Management</h1>
            <h2 style="text-align: center">Class List</h2>


            <div class="row">
                <div class="col-md-12">
                    <div class="d-flex justify-content-between mb-3">
                        <!-- Button to open the modal for adding a new subject -->
                        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addClassModal">Add Class</button>

                        <!-- Button to open the modal for adding a new student -->
                       
                    </div>

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Class ID</th>                           
                                <th>Class Name</th>                            
                                <th>Action</th> <!-- Added Action column -->
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="s" items="${listclass}">
                                <!-- Check if the current student matches the search criteria -->
                                <c:if test="${empty param.searchKeyword or fn:containsIgnoreCase(s.firstName, param.searchKeyword) or fn:containsIgnoreCase(s.lastName, param.searchKeyword)}">
                                    <tr>
                                        <td>${s.classID}</td>

                                        <td>${s.className}</td>

                                        <td>
                                            <!-- Add buttons or links for edit and delete actions -->
                                            <a class="btn btn-success" href="classstudent?cid=${s.classID}">View Student</a>
                                        </td> 
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Modal for adding a new student -->
        <div class="modal fade" id="addClassModal" tabindex="-1" role="dialog" aria-labelledby="addStudentModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addStudentModalLabel">Add New Class</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <!-- Form for adding a new student -->
                        <form action="${pageContext.request.contextPath}/classstudent" method="POST">


                            <div class="mb-3">
                                <label for="MSV" class="form-label">Class Name</label>
                                <input type="text" class="form-control" id="MSV" name="className" required>
                            </div>
                            <div id="errorMessage" style="display: none; color: red;">${err}</div>
                            <button type="submit" class="btn btn-primary">SUBMIT</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                
        <!-- JavaScript code for delete confirmation -->
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

        

        <jsp:include page="footer.jsp"></jsp:include>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
    </body>
</html>
