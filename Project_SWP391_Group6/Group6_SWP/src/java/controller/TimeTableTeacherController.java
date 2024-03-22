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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
import model1.Schedule;
import model1.Students;
import model1.Teachers;

/**
 *
 * @author Hai Nam
 */
@WebServlet(name = "TimeTableTeacherController", urlPatterns = {"/tchTimeTable"})
public class TimeTableTeacherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teachers teachers = (Teachers) req.getSession().getAttribute("teacher");
        if (teachers == null) {
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
//        ArrayList<Schedule> schedules = dbSchedule.listSchedulesTeacher(teachers.getTeacherID());
        ArrayList<Schedule> schedules = dbSchedule.listSchedulesTeacher(teachers.getTeacherID(), from, to);

        req.setAttribute("schedules", schedules);
        System.out.println("Teacher");
        System.out.println(schedules.toString());

        req.getRequestDispatcher("Schedule.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public static ArrayList<String> getWeekStartEndDates(int year, String mid) {
        ArrayList<String> weekStartEndDates = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, 1);

        while (date.getYear() == year) {
            LocalDate weekStart = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate weekEnd = weekStart.plusDays(6);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            weekStartEndDates.add("Week " + weekStart.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR) + " starting on "
//                    + weekStart.format(formatter) + " and ending on " + weekEnd.format(formatter));
            weekStartEndDates.add(weekStart.format(formatter).substring(5) + mid + weekEnd.format(formatter).substring(5));

            date = weekEnd.plusDays(1);
        }
        weekStartEndDates.remove(0);
        return weekStartEndDates;
    }

    public static ArrayList<String> getWeekStartEndDates1(int year, String mid) {
        ArrayList<String> weekStartEndDates = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, 1);

        while (date.getYear() == year) {
            LocalDate weekStart = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate weekEnd = weekStart.plusDays(6);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            weekStartEndDates.add("Week " + weekStart.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR) + " starting on "
//                    + weekStart.format(formatter) + " and ending on " + weekEnd.format(formatter));
            weekStartEndDates.add(weekStart.format(formatter).substring(0, 5) + mid + weekEnd.format(formatter).substring(0, 5));

            date = weekEnd.plusDays(1);
        }
        weekStartEndDates.remove(0);
        return weekStartEndDates;
    }
}
