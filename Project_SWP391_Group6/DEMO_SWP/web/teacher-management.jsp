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
        <title>Teacher Management</title>
    </head>
    <body>
        <div class="container">
            <h1>Teacher Management</h1>
            <h2 style="text-align: center">Teacher List</h2>

            <div class="row mb-3">
                <div class="col-md-6 offset-md-3">
                    <form action="${pageContext.request.contextPath}/teacher_manager" method="GET" class="d-flex">
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

                        <!-- Button to open the modal for adding a new teacher -->
                        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addTeacherModal">Add Teacher</button>
                    </div>

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Teacher ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>Password Hash</th>
                                <th>Status</th>
                                <th>Action</th> 

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="t" items="${listteacher}">
                                <!-- Check if the current teacher matches the search criteria -->
                                <c:if test="${empty param.searchKeyword or fn:containsIgnoreCase(t.firstName, param.searchKeyword) or fn:containsIgnoreCase(t.lastName, param.searchKeyword)}">
                                    <tr>
                                        <td>${t.teacherID}</td>
                                        <td>${t.firstName}</td>
                                        <td>${t.lastName}</td>
                                        <td>${t.email}</td>
                                        <td>${t.passwordHash}</td>
                                        <td>${t.teaching ? 'Teaching' : 'No Teaching'}</td>

                                        <td>
                                            <!-- Add buttons or links for edit and delete actions -->
                                            <a class="btn btn-info" data-bs-toggle="modal" data-bs-target="#editTeacherModal-${t.teacherID}">Edit</a>

                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Modal for adding a new teacher -->
        <div class="modal fade" id="addTeacherModal" tabindex="-1" role="dialog" aria-labelledby="addTeacherModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addTeacherModalLabel">Add Teacher</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <!-- Form for adding a new teacher -->
                        <form action="${pageContext.request.contextPath}/teacher_manager" method="POST">
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
                                <label for="isTeaching" class="form-label">Status</label>
                                <select class="form-select" id="isTeaching" name="isTeaching" required>
                                    <option value="True">Teaching</option>
                                    <option value="False">No Teaching</option>
                                    <!-- Add more options as needed -->
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Add Teacher</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal for editing a teacher -->
        <c:forEach var="t" items="${listteacher}">
            <div class="modal fade" id="editTeacherModal-${t.teacherID}" tabindex="-1" role="dialog" aria-labelledby="editTeacherModalLabel-${t.teacherID}" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="editTeacherModalLabel-${t.teacherID}">Edit Teacher</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <!-- Form for editing a teacher -->
                            <form action="${pageContext.request.contextPath}/teacher_manager" method="POST">
                                <!-- Add a hidden input field to identify the action as "edit" -->
                                <input type="hidden" name="action" value="edit">
                                <input type="hidden" name="teacherId" value="${t.teacherID}">

                                <div class="mb-3">
                                    <label for="editFirstName" class="form-label">First Name</label>
                                    <input type="text" class="form-control" id="editFirstName" name="firstName" value="${t.firstName}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="editLastName" class="form-label">Last Name</label>
                                    <input type="text" class="form-control" id="editLastName" name="lastName" value="${t.lastName}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="editEmail" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="editEmail" name="email" value="${t.email}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="editPasswordHash" class="form-label">Password Hash</label>
                                    <input type="password" class="form-control" id="editPasswordHash" name="passwordHash" value="${t.passwordHash}" required>
                                </div>

                                <div class="mb-3">
                                    <label for="isTeaching" class="form-label">Status</label>
                                    <select class="form-select" id="isTeaching" name="isTeaching" required>
                                        <option value="True" <c:if test="${t.teaching}">selected</c:if>>Teaching</option>
                                        <option value="False" <c:if test="${!t.teaching}">selected</c:if>>No Teaching</option>
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
            function confirmDelete(contextPath, teacherId) {
                var confirmation = confirm("Are you sure you want to delete this teacher?");

                if (confirmation) {
                    // Set the action and teacherId in the form and submit it
                    var form = document.createElement("form");
                    form.setAttribute("method", "post");
                    form.setAttribute("action", contextPath + "/teacher_manager");
                    form.innerHTML = '<input type="hidden" name="action" value="delete">'
                            + '<input type="hidden" name="teacherId" value="' + teacherId + '">';
                    document.body.appendChild(form);
                    form.submit();
                }
            }
        </script>

        <jsp:include page="footer.jsp"></jsp:include>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
    </body>
</html>
