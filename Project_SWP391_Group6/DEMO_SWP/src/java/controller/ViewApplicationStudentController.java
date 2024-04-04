/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.ApplicationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model1.Application;
import model1.Students;

/**
 *
 * @author lecha
 */
@WebServlet(name = "ViewApplicationStudentController", urlPatterns = {"/viewStudentAppli"})
public class ViewApplicationStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Students student = (Students) req.getSession().getAttribute("student");
        ApplicationDAO dbAppli = new ApplicationDAO();

        ArrayList<Application> applications = dbAppli.listByStudentId(student.getStudentID());

        req.setAttribute("applications", applications);
        req.getRequestDispatcher("View_Application_Student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
