/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.SubjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model1.Subjects;
import model1.Teachers;

/**
 *
 * @author nocol
 */
@WebServlet(name = "AttendReportClassController", urlPatterns = "/attendClass")
public class AttendReportClassController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_classId = req.getParameter("classId");
        int classId = Integer.parseInt(raw_classId);
        Teachers teachers = (Teachers) req.getSession().getAttribute("teacher");
        if (teachers == null) {
            System.out.println("teacher is null");
        }
        SubjectDAO dbSubject = new SubjectDAO();
        ArrayList<Subjects> subjects = dbSubject.getAllSubjectTeacher(teachers.getTeacherID(), classId);
        req.setAttribute("classId", classId);
        req.setAttribute("subjects", subjects);
        req.getRequestDispatcher("listAttendReportClass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
