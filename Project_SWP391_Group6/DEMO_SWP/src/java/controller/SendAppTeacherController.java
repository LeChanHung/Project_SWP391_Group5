/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.ApplicationDAO;
import DAO1.FeedbackTeacherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author minhdang
 */
@WebServlet(name = "SendAppTeacherController", urlPatterns = {"/sendAppTeacher"})
public class SendAppTeacherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_teacherId = req.getParameter("teacherId");
        int teacherId = Integer.parseInt(raw_teacherId);
        String raw_Id = req.getParameter("id");
        int id = Integer.parseInt(raw_Id);
        
        ApplicationDAO dbApp = new ApplicationDAO();
        dbApp.updateTeacherId(teacherId, id);
        resp.sendRedirect("viewApplication");
    }

}
