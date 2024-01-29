<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Teacher Management</title>
    <!-- Thêm các thẻ meta, CSS và JavaScript references nếu cần -->
</head>
<body>

<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <h2>Teacher Management</h2>
    
    <!-- Hiển thị danh sách giáo viên -->
    <h3>Teachers</h3>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Date of Birth</th>
                <th>Class ID</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="teacher" items="${teachers}">
                <tr>
                    <td>${teacher.teacher_ID}</td>
                    <td>${teacher.teacher_name}</td>
                    <td>${teacher.teacher_email}</td>
                    <td>${teacher.dob}</td>
                    <td>${teacher.class_ID}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <!-- Hiển thị danh sách môn học -->
    <h3>Subjects</h3>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="subject" items="${listSubjects}">
                <tr>
                    <td>${subject.subject_ID}</td>
                    <td>${subject.subject_name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Phân trang -->
    <div>
        <c:if test="${totalPages > 1}">
            <ul>
                <c:forEach var="i" begin="1" end="${totalPages}">
                    <li><a href="teacher-management?page=${i}&pageSize=${pageSize}">${i}</a></li>
                </c:forEach>
            </ul>
        </c:if>
    </div>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>
