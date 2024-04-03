/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO1.StudentDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import model1.Students;

/**
 *
 * @author admin
 */
@WebServlet(name = "StudentManagerController", urlPatterns = {"/student_manager"})
public class StudentManagerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchKeyword = request.getParameter("searchKeyword");

        HttpSession session = request.getSession();
        StudentDAO dao = new StudentDAO();
        String pageStr = request.getParameter("page"); // Thêm tham số trang
        int page = pageStr != null ? Integer.parseInt(pageStr) : 1; // Mặc định là trang 1
        int pageSize = 10; // Kích thước trang

        List<Students> studentsList;

        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            studentsList = dao.searchStudents(searchKeyword);
        } else {
            studentsList = dao.getAllStudent(page, pageSize);
        }

        request.setAttribute("liststudent", studentsList);
        request.setAttribute("currentPage", page);
        int totalStudents = dao.getTotalStudentsCount();
        int totalPages = (int) Math.ceil((double) totalStudents / pageSize);
        request.setAttribute("totalPages", totalPages);
        request.getRequestDispatcher("student-management.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");

    if (action != null && action.equals("delete")) {
        // Xử lý xóa sinh viên
        int studentID = Integer.parseInt(request.getParameter("studentId"));
        StudentDAO studentDAO = new StudentDAO();
        boolean success = studentDAO.deleteStudent(studentID);
        if (success) {
            response.sendRedirect(request.getContextPath() + "/student_manager");
        } else {
            response.getWriter().println("Failed to delete student.");
        }
    } else if (action != null && action.equals("edit")) {
        // Xử lý cập nhật thông tin sinh viên
        int studentID = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String passwordHash = request.getParameter("passwordHash");
        String dob1 = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String MSV = request.getParameter("MSV");
        Date dob = Date.valueOf(dob1);
        int status = Integer.parseInt(request.getParameter("status"));
        StudentDAO studentDAO = new StudentDAO();
        boolean success = studentDAO.updateStudent(studentID, firstName, lastName, email, passwordHash, dob, gender, MSV,status);

        if (success) {
            response.sendRedirect(request.getContextPath() + "/student_manager");
        } else {
            response.getWriter().println("Failed to update student.");
        }
    } else {
        // Nếu không phải là xóa hoặc cập nhật, giả định là thêm sinh viên mới
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String passwordHash = request.getParameter("passwordHash");
        String dob1 = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String MSV = request.getParameter("MSV");
        Date dob = Date.valueOf(dob1);
        StudentDAO studentDAO = new StudentDAO();
        int status = Integer.parseInt(request.getParameter("status"));
        boolean success = studentDAO.addStudent(firstName, lastName, email, passwordHash, dob, gender, MSV,status);
        response.sendRedirect(request.getContextPath() + "/student_manager");
    }
}


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
