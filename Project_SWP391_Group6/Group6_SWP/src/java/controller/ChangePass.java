/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.ChangePasss;
import Entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author lecha
 */
@WebServlet(name = "ChangePass", urlPatterns = {"/changepass"})
public class ChangePass extends HttpServlet {

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
            out.println("<title>Servlet ChangePass</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePass at " + request.getContextPath() + "</h1>");
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
//        String m = request.getParameter("mail");
        Student student = (Student) request.getSession().getAttribute("student");
        String op = request.getParameter("opass");
        String m = student.getEmail();
        String p = request.getParameter("pass");
        String rp = request.getParameter("rpass");
        ChangePasss dao = new ChangePasss();

        Student a = dao.check(m, op);
        if (a == null) {
            String msg = "Old password is incorrect";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
        } else {
//            Student ac = new Student(
//                    a.getFirstName(), 
//                    a.getLastName(), 
//                    m, 
//                    p, 
//                    a.getGender(), 
//                    a.getDob(), 
//                    a.getMSV());

            if (!p.equals(rp)) {
                String msg = "RePassword is not same as new password";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
            }
            dao.changePass(m, p);
            response.sendRedirect("index.html");
//            HttpSession session = request.getSession();
//            session.setAttribute("student", ac);
//            response.sendRedirect("index.html");
        }
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
        processRequest(request, response);
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
