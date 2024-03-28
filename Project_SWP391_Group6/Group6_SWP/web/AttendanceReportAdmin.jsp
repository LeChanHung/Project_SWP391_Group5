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
           
      
            <title>Attendance Report</title>
        </head>
        <body>
            <div class="container">
                <h1 class="text-center">Attendance Report</h1>
                
            <c:set value="${name}" var="name"></c:set>


                <div class="container px-4 text-center">
                    <form id="classForm" action="${pageContext.request.contextPath}/AttendanceAdmin?cid=${name.classID}" method="GET" class="d-flex">
                    <div class="col-md-4 ">
                        <input type="text" class="form-control" name="searchKeyword" placeholder="Search by name">
                    </div>
                    
                    <label class="form-label">Class Name</label>
                    <select  class="form-select mb-3  " id="gender" name="class" required">
                        <option value = 0>All</option>
                        <c:forEach var="c" items="${listclass}">
                            <option value="${c.classID}" 
                           <c:if test="${c.classID == name.classID}">selected</c:if>
                           >${c.className}</option>
                        </c:forEach>
                    </select>
                    <div><button type="submit" class="btn btn-outline-secondary" >Filter</button></div>
                </form>
            </div>



            <div class="row">
                <div class="col-md-12">
                    <div class="d-flex justify-content-between mb-3">
                        <!-- Button to open the modal for adding a new subject -->


                        <!-- Button to open the modal for adding a new student -->

                    </div>

                    <table class="table">
                        <thead>
                            <tr>
                                <th>MSV</th>
                                <th>Student Name</th>
                                <th>Subject</th>
                                <th>Class</th>
                                <th>Absent</th>                               

                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="s" items="${listReport}">
                                <!-- Check if the current student matches the search criteria -->          
                            <td>${s.student.MSV}</td>
                            <td>${s.student.firstName} ${s.student.lastName}</td>
                            <td>${s.subject.subjectName}</td>                                       
                            <td>${s.classes.className}</td>
                            <td>${s.percent}%</td>


                            </tr>                               
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

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
                            <a class="page-link" href="?page=${pageNumber}&amp;pageSize=${pageSize}&amp;cid=${name.classID}">${pageNumber}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage < totalPages}">
                <li class="page-item">
                    <a class="page-link" href="?page=${currentPage + 1}&amp;pageSize=${pageSize}&amp;cid=${name.classID}">Next &raquo;</a>
                </li>
            </c:if>
        </ul>
    </nav>
    <!-- JavaScript code for delete confirmation -->
    

    <jsp:include page="footer.jsp"></jsp:include>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
</body>
</html>
