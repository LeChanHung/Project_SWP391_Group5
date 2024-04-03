/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.AttendanceAdmin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author lecha
 */
@WebServlet(name = "UpdateAttendController", urlPatterns = {"/updateAttend"})
public class UpdateAttendController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        String raw_classId = req.getParameter("classId");
        int classId = Integer.parseInt(raw_classId);
        String raw_subjectId = req.getParameter("subjectId");
        int subjectId = Integer.parseInt(raw_subjectId);
        String status = req.getParameter("status");
        if(status.equals("Attend"))status="Absent";
        else status="Attend";
        
        AttendanceAdmin dbAttend = new AttendanceAdmin();
        dbAttend.updateStatus(id, status);
        String urlResponse = "attendSubjects?subjectId="+subjectId+"&classId="+classId;
        resp.sendRedirect(urlResponse);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
