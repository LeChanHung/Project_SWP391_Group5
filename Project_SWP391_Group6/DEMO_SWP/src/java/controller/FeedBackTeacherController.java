/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.FeedbackTeacherDAO;
import DAO1.SubjectDAO;
import DAO1.TeacherDAO;
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
 * @author lecha
 */
@WebServlet(name = "FeedBackTeacherController", urlPatterns = {"/feedBackTeacher"})
public class FeedBackTeacherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_subjectId = req.getParameter("subjectId");
        String raw_teacherId = req.getParameter("teacherId");

        int subjectId = Integer.parseInt(raw_subjectId);
        int teacherId = Integer.parseInt(raw_teacherId);

        SubjectDAO dbSubject = new SubjectDAO();
        TeacherDAO dbTeacher = new TeacherDAO();

        Subjects subject = dbSubject.get(subjectId);
        Teachers teacher = dbTeacher.get(teacherId);

        req.setAttribute("subject", subject);
        req.setAttribute("teacher", teacher);

        req.getRequestDispatcher("dofeedback.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_subjectId = req.getParameter("subjectId");
        String raw_teacherId = req.getParameter("teacherId");
        String raw_proRate = req.getParameter("proRate");
        String raw_teachRate = req.getParameter("teachRate");
        String comment = req.getParameter("comment");
        
        HttpSession session = req.getSession();
        Students student = (Students) session.getAttribute("student");
        
        int subjectId = Integer.parseInt(raw_subjectId);
        int teacherId = Integer.parseInt(raw_teacherId);
        int proRate = Integer.parseInt(raw_proRate);
        int teachRate = Integer.parseInt(raw_teachRate);
        
        
        FeedBackTeacher fbt = new FeedBackTeacher();
        fbt.setStudentId(student);
        Subjects subject = new Subjects();
        subject.setSubjectID(subjectId);
        fbt.setSubjectId(subject);
        Teachers teacher = new Teachers();
        teacher.setTeacherID(teacherId);
        fbt.setTeacherId(teacher);
        fbt.setProRate(proRate);
        fbt.setTeachRate(teachRate);
        fbt.setComment(comment);
        
        FeedbackTeacherDAO dbFeedBackTeacher = new FeedbackTeacherDAO();
        dbFeedBackTeacher.insert(fbt);
        
        resp.sendRedirect("teacherFeed");

    }
}
