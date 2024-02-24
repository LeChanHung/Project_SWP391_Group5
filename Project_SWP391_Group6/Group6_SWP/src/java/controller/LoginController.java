/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAOO.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;
import model.Teacher;
import model.TrainingOffice;

/**
 *
 * @author Hai Nam
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

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
        response.sendRedirect("Login.jsp");
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
        processRequest(request, response);
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
        String nameOrEmail = request.getParameter("name");
        String password = request.getParameter("password");

        LoginDAO ldao = new LoginDAO();
        HttpSession session = request.getSession();
        Student s = null;
        Teacher t = null;
        TrainingOffice o = null;
        try {
            s = ldao.authenticateStudent(nameOrEmail, password);
            t = ldao.authenticateTeacher(nameOrEmail, password);
            o = ldao.authenticateTrainingOffice(nameOrEmail, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (s != null) {
            session.setAttribute("student", s);
            
            response.sendRedirect("StudentHomePage.jsp");
        } else if (t != null) {
            session.setAttribute("teacher", t);
            response.sendRedirect("TeacherHomePage.jsp");
        } else if (o != null) {
            session.setAttribute("office", o);
            response.sendRedirect("OfficeHomePage.jsp");
        } else {
            request.setAttribute("error", "Sai TK or MK");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
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
