/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TrainingOffice;
import DAOO.loginDAO;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc acer
 */

@WebServlet("/login")
public class loginTrainingOffice extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String officeName = request.getParameter("officeName");
        String password = request.getParameter("password");
        loginDAO loginDAO = new loginDAO();
        TrainingOffice user = null;
        try {
            user = loginDAO.authenticateUser(officeName, password);
        } catch (Exception ex) {
        }
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            if (user.getRole() == 0) {
                response.sendRedirect("pdt.jsp");
            } else if (user.getRole() == 1) {
                response.sendRedirect("admin.jsp");
            }
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
