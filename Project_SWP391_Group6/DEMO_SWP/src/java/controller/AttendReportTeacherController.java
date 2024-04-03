/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.ClassDAO;
import DAO1.SubjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model1.Classes;
import model1.Subjects;
import model1.Teachers;

/**
 *
 * @author Hai Nam
 */
@WebServlet(name = "AttendReportTeacherController", urlPatterns = {"/attendReportdd"})
public class AttendReportTeacherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Teachers teachers = (Teachers) req.getSession().getAttribute("teacher");
        if(teachers == null)System.out.println("teacher is null");

        ClassDAO dbClass = new ClassDAO();
        ArrayList<Classes> classes = dbClass.getClassTeacher(teachers.getTeacherID());
        
        req.setAttribute("classes", classes);
        req.getRequestDispatcher("listAttendReportTeacher.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
