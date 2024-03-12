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
import model1.Application;

/**
 *
 * @author lecha
 */
@WebServlet(name = "UpdateStatusController", urlPatterns = {"/updateStatus"})
public class UpdateStatusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_status = req.getParameter("status");
        int status = Integer.parseInt(raw_status);
        if(status == 0)status = -1;
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        ApplicationDAO dbApp = new ApplicationDAO();
        Application model = new Application();
        model.setId(id);
        model.setStatus(status);
        dbApp.updateStatus(model);
        resp.sendRedirect("viewApplication");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
