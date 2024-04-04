/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.ScheduleDAO;
import DAO1.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model1.Schedule;
import model1.Students;
import model1.Teachers;

/**
 *
 * @author nocol
 */
@WebServlet(name = "AttendReportSubjectController", urlPatterns = {"/attendSubjects"})
public class AttendReportSubjectController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_classId = req.getParameter("classId");
        int classId = Integer.parseInt(raw_classId);
        String raw_subjectId = req.getParameter("subjectId");
        int subjectId = Integer.parseInt(raw_subjectId);
        Teachers teachers = (Teachers) req.getSession().getAttribute("teacher");
        if (teachers == null) {
            System.out.println("teacher is null");
        }
        
        StudentDAO dbStudent = new StudentDAO();
        ScheduleDAO dbSchedule = new ScheduleDAO();
        ArrayList<Students> students = dbStudent.getAllStudentByClassId(classId);
        ArrayList<ArrayList<Schedule>> listAllStu = new ArrayList<>();
        for (Students stu : students) {
            System.out.println(stu.getStudentID());
            ArrayList<Schedule> stus = dbSchedule.listSchedulesStuSub(teachers.getTeacherID(), classId, stu.getStudentID(), subjectId);
            listAllStu.add(stus);
        }
        ArrayList<Schedule> allSlot = new ArrayList<>();
        for (ArrayList<Schedule> arrayList : listAllStu) {
            allSlot = arrayList;
            break;
        }
        req.setAttribute("allSlot", allSlot);
        req.setAttribute("listAllStu", listAllStu);
        req.setAttribute("students", students);
        req.setAttribute("classId", classId);
        req.setAttribute("subjectId", subjectId);
        req.getRequestDispatcher("listAttendReportSubject.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
