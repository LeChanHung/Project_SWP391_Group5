/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO1.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

        // If searchKeyword is not empty, perform search
        HttpSession session = request.getSession();
        StudentDAO dao = new StudentDAO();
        List<Students> list = dao.getAllStudent();

        List<Students> studentses;

        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            // If a search keyword is provided, perform the search
            studentses = dao.searchStudents(searchKeyword);
        } else {
            // If no search keyword, get all teachers
            studentses = dao.getAllStudent();
        }

        // Set the list of teachers as a request attribute
        request.setAttribute("liststudent", studentses);
        request.getRequestDispatcher("student-management.jsp").forward(request, response);
    }

   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");

    if (action != null && action.equals("delete")) {
        // If the action is to delete a student
        int studentID = Integer.parseInt(request.getParameter("studentId"));

        // Create an instance of StudentDAO
        StudentDAO studentDAO = new StudentDAO();

        // Call the deleteStudent method to delete the student
        boolean success = studentDAO.deleteStudent(studentID);

        if (success) {
            // Student deleted successfully
            response.sendRedirect(request.getContextPath() + "/student_manager");
        } else {
            // Handle failure, you may redirect to an error page or display a message
            response.getWriter().println("Failed to delete student.");
        }
    } else {
        // If the action is not delete, assume it's adding a new student
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String passwordHash = request.getParameter("passwordHash");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String MSV = request.getParameter("MSV");

        // Create an instance of StudentDAO
        StudentDAO studentDAO = new StudentDAO();

        // Call the addStudent method to add the new student
        boolean success = studentDAO.addStudent(firstName, lastName, email, passwordHash, dob, gender, MSV);

        // Redirect to the student management page
        response.sendRedirect(request.getContextPath() + "/student_manager");
    }
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
