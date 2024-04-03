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
@WebServlet(name = "DetailApplicationController", urlPatterns = {"/detailAppli"})
public class DetailApplicationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        
        ApplicationDAO dbAppli = new ApplicationDAO();
        Application app = dbAppli.get(id);
        
        req.setAttribute("app", app);
        req.getRequestDispatcher("Application_Detail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
    // Giang oi sap xong chua
    // sap r b cu di ngu di ti t tat may cho
    //

}
