/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO1.AttendanceAdmin;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model1.AttendanceReport;
import model1.SendMail;
import utils.EmailUtils;

/**
 *
 * @author admin
 */
@WebServlet(name = "SendMails", urlPatterns = {"/sendMails"})
public class SendMails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SendMails</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendMails at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AttendanceAdmin dao = new AttendanceAdmin();
        List<AttendanceReport> listAR = dao.getListAR();
        List<SendMail> listSend = dao.getSendMail();
        
        for (int i = 0; i < listAR.size(); i++) {
            int countSameEmail = 0;
            for (int j = 0; j < listSend.size(); j++) {
                if((listAR.get(i).getEmail().equals(listSend.get(j).getEmail()) && listAR.get(i).getPercent() == listSend.get(j).getPercent()) ) {
                    countSameEmail ++;
                }
                
               
            }
            if(countSameEmail==0) {
                if (listAR.get(i).getPercent() >= 5.0 && listAR.get(i).getPercent() <= 20.0) {
                        boolean succces = dao.insertSendMails(listAR.get(i).getEmail(), listAR.get(i).getPercent());
                        EmailUtils.sendEmail(listAR.get(i).getEmail(),
                                "FPT UNIVERSITY ATTEND",
                                "(Nếu em đã được duyệt đơn miễn điểm danh, vui lòng bỏ qua email này)."
                                + "Phòng Dịch vụ sinh viên thông báo đến em về tình trạng điểm danh của em như sau: Môn" + listAR.get(i).getSubject().getSubjectName() + ":" + listAR.get(i).getPercent() + "%" + "absent");
                    }
            }
        }
        response.sendRedirect("AttendanceAdmin");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
