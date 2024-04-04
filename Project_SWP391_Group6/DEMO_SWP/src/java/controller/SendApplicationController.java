/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO1.ApplicationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model1.Application;
import model1.Students;

/**
 *
 * @author lecha
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
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
                        strCon = "Đơn xin điểm danh - " + strCon;
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
                String imgPath = "";

                String pathF = req.getServletContext().getRealPath("/fileApp");
                System.out.println(pathF);
                File imagesDir = new File(pathF);
                Part filePart = req.getPart("file");
                File[] files = imagesDir.listFiles();
                int count = files.length;

                if (!filePart.getSubmittedFileName().isEmpty()) {

                    File imagesDir1 = new File(pathF, "application" + count + getFileExtension(filePart));
                    filePart.write(imagesDir1.getAbsolutePath());
                    filePart.write(imagesDir.getAbsolutePath() + filePart.getSubmittedFileName());
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SendApplicationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                filePart.write(imagesDir.getAbsolutePath() + filePart.getSubmittedFileName());
                    imgPath = "fileApp/application" + count + getFileExtension(filePart);
                }else{
                    System.out.println("Got error");
                }
                model.setContent(strCon);
                model.setStudentId(student);
                model.setFilePath(imgPath);
                dbAppli.insert(model);
                req.setAttribute("msg", "Send application successfully!!");
                req.getRequestDispatcher("Send_Application.jsp").forward(req, resp);
            }
        }
    }

    private static String getFileExtension(Part file) {
        String name = file.getSubmittedFileName();
        int lastIndexOfDot = name.lastIndexOf(".");
        if (lastIndexOfDot == -1) {
            return "";
        }
        return name.substring(lastIndexOfDot);
    }
}
