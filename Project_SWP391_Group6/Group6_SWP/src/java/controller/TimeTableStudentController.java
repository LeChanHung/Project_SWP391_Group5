/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.ScheduleDAO;
import DAO1.SlotDAO;
import Entity.timeSlots;
import static controller.TimeTableTeacherController.getWeekStartEndDates;
import static controller.TimeTableTeacherController.getWeekStartEndDates1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
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
        ArrayList<String> weeks = getWeekStartEndDates(LocalDate.now().getYear(), " ");
        ArrayList<String> weeksto = getWeekStartEndDates1(LocalDate.now().getYear(), " to ");
        req.setAttribute("weeks", weeks);
        req.setAttribute("weeksto", weeksto);
        ArrayList<Integer> dayOfWeeks = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        req.setAttribute("dayOfWeeks", dayOfWeeks);

        SlotDAO dbSlot = new SlotDAO();
        ArrayList<timeSlots> slots = dbSlot.list();
        req.setAttribute("slots", slots);
        
        Date from, to;
        LocalDate today = LocalDate.now();
        String year = req.getParameter("year");
        String fromandto = req.getParameter("week");
        if (fromandto == null || year == null) {
            LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate endOfWeek = startOfWeek.plusDays(6);
            from = Date.valueOf(startOfWeek);
            to = Date.valueOf(endOfWeek);
            System.out.println("Today");
            System.out.println(from);
            System.out.println(to);
            year = today.getYear() + "";

            // Format the dates into the desired format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
            fromandto = startOfWeek.format(formatter) + " " + endOfWeek.format(formatter);
        } else {
            String[] x = fromandto.split(" ");
            from = Date.valueOf(year + "-" + x[0]);
            to = Date.valueOf(year + "-" + x[1]);
            System.out.println(from);
            System.out.println(to);
        }
        req.setAttribute("year", year);
        req.setAttribute("fromandto", fromandto);

        ScheduleDAO dbSchedule = new ScheduleDAO();
//        ArrayList<Schedule> schedules = dbSchedule.listSchedulesStudent(students.getStudentID());
        ArrayList<Schedule> schedules = dbSchedule.listSchedulesStudent(students.getStudentID(), from, to);

//        schedules.remove(1);
        System.out.println(students.getStudentID());
        req.setAttribute("schedules", schedules);
        for (Schedule schedule : schedules) {
            System.out.println(schedule.getSubjectID().getSubjectName());
        }
        System.out.println(schedules.toString());

        req.getRequestDispatcher("StudentSchedule.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
