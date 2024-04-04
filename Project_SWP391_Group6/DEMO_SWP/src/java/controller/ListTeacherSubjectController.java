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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model1.FeedBackTeacher;
import model1.Students;

/**
 *
 * @author lecha
 */
@WebServlet(name = "ListTeacherSubjectController", urlPatterns = {"/teacherFeed"})
public class ListTeacherSubjectController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Students student = (Students) session.getAttribute("student"); // Lấy đối tượng Student từ session
        FeedbackTeacherDAO dbFeedbackTeacher = new FeedbackTeacherDAO();
        ArrayList<FeedBackTeacher> feedBackTeachers = dbFeedbackTeacher.listTeacherFeed(student.getStudentID());

        req.setAttribute("feedBackTeachers", feedBackTeachers);
        req.getRequestDispatcher("listfeedback2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
