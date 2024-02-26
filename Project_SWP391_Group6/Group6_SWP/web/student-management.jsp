<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:useBean id="sd" class="DAO1.StudentDAO" scope="request"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
    <title>Student Management</title>
</head>
<body>
    <div class="container">
        <h1>Student Management</h1>
        <h2 style="text-align: center">Student List</h2>

        <div class="row mb-3">
            <div class="col-md-6 offset-md-3">
                <form action="${pageContext.request.contextPath}/student_manager" method="GET" class="d-flex">
                    <input type="text" class="form-control" name="searchKeyword" placeholder="Search by name">
                    <button type="submit" class="btn btn-outline-secondary">Search</button>
                </form>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="d-flex justify-content-between mb-3">
                    <!-- Button to open the modal for adding a new subject -->
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addCateModal">Add Subject</button>

                    <!-- Button to open the modal for adding a new student -->
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addStudentModal">Add Student</button>
                </div>

                <table class="table">
                    <thead>
                        <tr>
                            <th>Student ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Password Hash</th>
                            <th>DOB</th>
                            <th>Gender</th>
                            <th>MSV</th>
                            <th>Action</th> <!-- Added Action column -->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="s" items="${liststudent}">
                            <!-- Check if the current student matches the search criteria -->
                            <c:if test="${empty param.searchKeyword or fn:containsIgnoreCase(s.firstName, param.searchKeyword) or fn:containsIgnoreCase(s.lastName, param.searchKeyword)}">
                                <tr>
                                    <td>${s.studentID}</td>
                                    <td>${s.firstName}</td>
                                    <td>${s.lastName}</td>
                                    <td>${s.email}</td>
                                    <td>${s.passwordHash}</td>
                                    <td>${s.dob}</td>
                                    <td>${s.gender}</td>
                                    <td>${s.MSV}</td>
                                    <td>
                                        <!-- Add buttons or links for edit and delete actions -->
                                        <a class="btn btn-sm btn-primary" href="edit-student?id=${s.studentID}">Edit</a>
                                        <button type="button" class="btn btn-sm btn-danger" onclick="confirmDelete('${pageContext.request.contextPath}', ${s.studentID})">Delete</button>
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
    <div class="modal fade" id="addStudentModal" tabindex="-1" role="dialog" aria-labelledby="addStudentModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addStudentModalLabel">Add Student</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <!-- Form for adding a new student -->
                    <form action="${pageContext.request.contextPath}/student_manager" method="POST">
                        <div class="mb-3">
                            <label for="firstName" class="form-label">First Name</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" required>
                        </div>
                        <div class="mb-3">
                            <label for="lastName" class="form-label">Last Name</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="passwordHash" class="form-label">Password Hash</label>
                            <input type="password" class="form-control" id="passwordHash" name="passwordHash" required>
                        </div>
                        <div class="mb-3">
                            <label for="dob" class="form-label">Date of Birth</label>
                            <input type="date" class="form-control" id="dob" name="dob" required>
                        </div>
                        <div class="mb-3">
                            <label for="gender" class="form-label">Gender</label>
                            <select class="form-select" id="gender" name="gender" required>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <!-- Add more options as needed -->
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="MSV" class="form-label">Student ID</label>
                            <input type="text" class="form-control" id="MSV" name="MSV" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Add Student</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- JavaScript code for delete confirmation -->
    <script>
        function confirmDelete(contextPath, studentId) {
            var confirmation = confirm("Are you sure you want to delete this student?");

            if (confirmation) {
                // Set the action and studentId in the form and submit it
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", contextPath + "/student_manager");
                form.innerHTML = '<input type="hidden" name="action" value="delete">'
                    + '<input type="hidden" name="studentId" value="' + studentId + '">';
                document.body.appendChild(form);
                form.submit();
            }
        }
    </script>

    <jsp:include page="footer.jsp"></jsp:include>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
</body>
</html>
