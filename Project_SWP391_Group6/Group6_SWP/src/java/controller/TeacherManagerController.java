/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO1.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model1.Teachers;

/**
 *
 * @author admin
 */
@WebServlet(name = "TeacherManagerController", urlPatterns = {"/teacher_manager"})
public class TeacherManagerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TeacherManagerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeacherManagerController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        TeacherDAO dao = new TeacherDAO();
        List<Teachers> list = dao.getAllTeacher();
        String searchKeyword = request.getParameter("searchKeyword");
        List<Teachers> teachers;

        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            // If a search keyword is provided, perform the search
            teachers = dao.searchTeachers(searchKeyword);
        } else {
            // If no search keyword, get all teachers
            teachers = dao.getAllTeacher();
        }

        // Set the list of teachers as a request attribute
        request.setAttribute("listteacher", teachers);
        request.setAttribute("listteacher", list);
        request.getRequestDispatcher("teacher-management.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int teacherId = Integer.parseInt(request.getParameter("teacherId"));
            TeacherDAO dao = new TeacherDAO();
            boolean isDeleted = dao.deleteTeacher(teacherId);
            response.sendRedirect(request.getContextPath() + "/teacher_manager");
        } else if ("edit".equals(action)) {
            int teacherId = Integer.parseInt(request.getParameter("teacherId"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String passwordHash = request.getParameter("passwordHash");

            Teachers updatedTeacher = new Teachers(teacherId, firstName, lastName, email, passwordHash);
            TeacherDAO dao = new TeacherDAO();
            boolean isEdited = dao.editTeacher(updatedTeacher);
            response.sendRedirect(request.getContextPath() + "/teacher_manager");
        } else {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String passwordHash = request.getParameter("passwordHash");

            Teachers newTeacher = new Teachers(0, firstName, lastName, email, passwordHash);
            TeacherDAO dao = new TeacherDAO();
            boolean isAdded = dao.addTeacher(newTeacher);
            response.sendRedirect(request.getContextPath() + "/teacher_manager");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
