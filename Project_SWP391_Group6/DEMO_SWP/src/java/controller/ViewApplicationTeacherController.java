/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.ApplicationDAO;
import DAO1.TeacherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model1.Application;
import model1.Teachers;

/**
 *
 * @author minhdang
 */
@WebServlet(name = "ViewApplicationTeacherController", urlPatterns = {"/viewAppTeacher"})
public class ViewApplicationTeacherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Teachers teacher = (Teachers) req.getSession().getAttribute("teacher");
        ApplicationDAO dbAppli = new ApplicationDAO();
        String x = "abc-";
        ArrayList<Application> applications = dbAppli.listByTeacherId(teacher.getTeacherID());

        req.setAttribute("applications", applications);
        req.getRequestDispatcher("View_Application_Teacher.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
