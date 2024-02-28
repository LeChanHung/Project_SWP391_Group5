/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.ScheduleDAO;
import DAO1.SlotDAO;
import Entity.timeSlots;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import model1.Schedule;
import model1.Students;

/**
 *
 * @author Hai Nam
 */
@WebServlet(name = "TimeTableStudentController", urlPatterns = {"/stuTimeTable"})
public class TimeTableStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Students students = (Students) req.getSession().getAttribute("student");
        if (students == null) {
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }

        ArrayList<Integer> dayOfWeeks = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        req.setAttribute("dayOfWeeks", dayOfWeeks);

        SlotDAO dbSlot = new SlotDAO();
        ArrayList<timeSlots> slots = dbSlot.list();
        req.setAttribute("slots", slots);

        ScheduleDAO dbSchedule = new ScheduleDAO();
        ArrayList<Schedule> schedules = dbSchedule.listSchedulesStudent(students.getStudentID());
        req.setAttribute("schedules", schedules);
        System.out.println(schedules.toString());

        req.getRequestDispatcher("StudentSchedule.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}