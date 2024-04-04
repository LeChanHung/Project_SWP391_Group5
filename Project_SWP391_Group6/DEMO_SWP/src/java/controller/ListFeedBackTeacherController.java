/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.FeedbackTeacherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model1.FeedBackTeacher;
import model1.Teachers;

/**
 *
 * @author lecha
 */
@WebServlet(name = "ListFeedBackTeacherController", urlPatterns = {"/listFeedTeacher"})
public class ListFeedBackTeacherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FeedbackTeacherDAO dbFeedback = new FeedbackTeacherDAO();
        Teachers teacher = (Teachers) req.getSession().getAttribute("teacher");
        ArrayList<FeedBackTeacher> feedBackTeachers = dbFeedback.listByTeacherId(teacher.getTeacherID());
    
        req.setAttribute("feedBackTeachers", feedBackTeachers);
        req.getRequestDispatcher("listfeedback3.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
