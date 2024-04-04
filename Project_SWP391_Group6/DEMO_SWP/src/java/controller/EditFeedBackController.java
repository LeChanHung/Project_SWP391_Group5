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
import model1.FeedBackTeacher;
import model1.Students;
import model1.Subjects;
import model1.Teachers;

/**
 *
 * @author minhdang
 */
@WebServlet(name = "EditFeedBackController", urlPatterns = {"/editFeedBack"})
public class EditFeedBackController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);

        FeedbackTeacherDAO dbFeedback = new FeedbackTeacherDAO();
        FeedBackTeacher fbt = dbFeedback.get(id);

        req.setAttribute("fbt", fbt);
        req.getRequestDispatcher("editFeedback.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FeedbackTeacherDAO dbFeedback = new FeedbackTeacherDAO();
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        String raw_proRate = req.getParameter("proRate");
        String raw_teachRate = req.getParameter("teachRate");
        String comment = req.getParameter("comment");

        int proRate = Integer.parseInt(raw_proRate);
        int teachRate = Integer.parseInt(raw_teachRate);

        FeedBackTeacher fbt = new FeedBackTeacher();
        fbt.setProRate(proRate);
        fbt.setTeachRate(teachRate);
        fbt.setComment(comment);
        fbt.setId(id);

        dbFeedback.update(fbt);

        resp.sendRedirect("teacherFeed");
    }

}
