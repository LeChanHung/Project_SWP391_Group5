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
import model1.Students;

/**
 *
 * @author lecha
 */
@WebServlet(name = "SendApplicationController", urlPatterns = {"/sendApplication"})
public class SendApplicationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Send_Application.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Students student = (Students) req.getSession().getAttribute("student");
        String type = req.getParameter("type");
        String[] content = req.getParameterValues("content");
        ApplicationDAO dbAppli = new ApplicationDAO();

        for (String str : content) {
            if (str != null && str.length() > 0) {
                Application model = new Application();
                String strCon = str;
                switch (type) {
                    case "diemdanh":
                        strCon = "Đơn miễn điểm danh - " + strCon;
                        break;
                    case "thoihoc":
                        strCon = "Đơn xin thôi học - " + strCon;
                        break;
                    case "baoluu":
                        strCon = "Đơn xin bảo lưu - " + strCon;
                        break;
                    case "nhaphoc":
                        strCon = "Đơn xin nhập học - " + strCon;
                        break;
                    default:
                        strCon = "Đơn khác - " + strCon;
                        break;
                }
                model.setContent(strCon);
                model.setStudentId(student);
                dbAppli.insert(model);
                req.setAttribute("msg", "Send application successfully!!");
                req.getRequestDispatcher("Send_Application.jsp").forward(req, resp);
            }
        }
    }

}
