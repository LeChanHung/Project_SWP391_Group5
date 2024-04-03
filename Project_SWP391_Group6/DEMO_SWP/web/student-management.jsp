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
                        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addStudentModal">Add Student</button>
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
                                <th>Status</th>
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
                                        <td><c:choose>
                                                <c:when test="${s.status == 1}">Studying</c:when>
                                                <c:when test="${s.status == 2}">Bảo Lưu</c:when>
                                                <c:when test="${s.status == 3}">Bỏ Học</c:when>
                                                <c:when test="${s.status == 4}">Hết Học</c:when>
                                                <c:otherwise>undefine</c:otherwise>
                                            </c:choose></td>
                                        <td>
                                            <!-- Add buttons or links for edit and delete actions -->
                                            <a class="btn btn-info" data-bs-toggle="modal" data-bs-target="#editStudentModal-${s.studentID}">Edit</a> 
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

                            <div class="mb-3">
                                <label for="status" class="form-label">Status</label>
                                <select class="form-select" id="status" name="status" required>
                                    <option value="1">Studying</option>
                                    <option value="2">Bảo Lưu</option>
                                    <option value="3">Bỏ Học</option>
                                    <option value="4">Hết Học</option>
                                    <!-- Add more options as needed -->
                                </select>
                            </div>

                            <button type="submit" class="btn btn-primary">Add Student</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal for editing a student -->
        <c:forEach var="s" items="${liststudent}">
            <div class="modal fade" id="editStudentModal-${s.studentID}" tabindex="-1" role="dialog" aria-labelledby="editStudentModalLabel-${t.studentID}" aria-hidden="true">
                <div class="modal-dialog" role="document"/>
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editStudentModalLabel-${s.studentID}">Edit Student</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <!-- Form for editing a student -->
                        <form action="${pageContext.request.contextPath}/student_manager" method="POST">
                            <!-- Add a hidden input field to identify the action as "edit" -->
                            <input type="hidden" name="action" value="edit">
                            <input type="hidden" name="studentId" value="${s.studentID}">

                            <div class="mb-3">
                                <label for="editFirstName" class="form-label">First Name</label>
                                <input type="text" class="form-control" id="editFirstName" name="firstName" value="${s.firstName}" required>
                            </div>
                            <div class="mb-3">
                                <label for="editLastName" class="form-label">Last Name</label>
                                <input type="text" class="form-control" id="editLastName" name="lastName" value="${s.lastName}" required>
                            </div>
                            <div class="mb-3">
                                <label for="editEmail" class="form-label">Email</label>
                                <input type="email" class="form-control" id="editEmail" name="email" value="${s.email}" required>
                            </div>
                            <div class="mb-3">
                                <label for="editPasswordHash" class="form-label">Password Hash</label>
                                <input type="password" class="form-control" id="editPasswordHash" name="passwordHash" value="${s.passwordHash}" required>
                            </div>

                            <div class="mb-3">
                                <label for="editDob" class="form-label">Date of Birth</label>
                                <input type="date" class="form-control" id="editDob" name="dob" value="${s.dob}" required>
                            </div>

                            <div class="mb-3">
                                <label for="gender" class="form-label">Gender</label>
                                <select class="form-select" id="gender" name="gender" required>
                                    <option value="Male" <c:if test="${s.gender=='Male'}">selected</c:if>>Male</option>
                                    <option value="Female" <c:if test="${s.gender=='Female'}">selected</c:if>>Female</option>
                                    <!-- Add more options as needed -->
                                </select>
                            </div>



                                <div class="mb-3">
                                    <label for="editMSV" class="form-label">MSV</label>
                                    <input type="text" class="form-control" id="editMSV" name="MSV" value="${s.MSV}" required>
                            </div>

                            <div class="mb-3">
                                <label for="status" class="form-label">Status</label>
                                <select class="form-select" id="status" name="status" required>
                                    <option value="1" <c:if test="${s.status==1}">selected</c:if>>Studying</option>
                                    <option value="2" <c:if test="${s.status==2}">selected</c:if>>Bảo Lưu</option>
                                    <option value="3" <c:if test="${s.status==3}">selected</c:if>>Bỏ Học</option>
                                    <option value="4" <c:if test="${s.status==4}">selected</c:if>>Hết Học</option>
                                        <!-- Add more options as needed -->
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-warning">Save Changes</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
    </c:forEach>
        
        <nav  class="mt-3 text-center" aria-label="Page navigation example">
            <ul class="pagination d-inline-flex">
                <c:if test="${currentPage > 1}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage - 1}&amp;pageSize=${pageSize}">&laquo; Previous</a>
                    </li>
                </c:if>

                <c:forEach begin="1" end="${totalPages}" var="pageNumber">
                    <c:choose>
                        <c:when test="${pageNumber == currentPage}">
                            <li class="page-item active">
                                <span class="page-link">${pageNumber}</span>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="?page=${pageNumber}&amp;pageSize=${pageSize}">${pageNumber}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${currentPage < totalPages}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage + 1}&amp;pageSize=${pageSize}">Next &raquo;</a>
                    </li>
                </c:if>
            </ul>
        </nav>
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
