/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAO1.AttendanceAdmin;
import DAO1.ClassDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model1.AttendanceReport;
import model1.Classes;
import model1.Students;

/**
 *
 * @author admin
 */
@WebServlet(name="AttendanceAdmin", urlPatterns={"/AttendanceAdmin"})
public class AttendanceAdminController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet AttendanceAdmin</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendanceAdmin at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         AttendanceAdmin dao = new  AttendanceAdmin();
        List<AttendanceReport> list = new ArrayList<>();
        String searchKeyword = request.getParameter("searchKeyword");
        String cid = request.getParameter("cid");
        String classID_raw = request.getParameter("class");
        String pageStr = request.getParameter("page"); // Thêm tham số trang
        int page = pageStr != null ? Integer.parseInt(pageStr) : 1; // Mặc định là trang 1
        int pageSize = 9; // Kích thước trang
        ClassDAO cDao = new ClassDAO();
        int classID;
        if(cid=="") {
                classID = 0;
            }
       else if (cid!=null) { 
            
            classID = Integer.parseInt(cid); 
        } else if(classID_raw == null) 
        {
            classID = 0;
        } 
        else {
            classID = Integer.parseInt(classID_raw);           
        }
      
        List<Classes> listC = cDao.getAllClass();
        Classes c = cDao.getClassByID(classID); 
        list = dao.getAttendanceReport(classID, searchKeyword, page, pageSize);
        
        request.setAttribute("listclass", listC);
        request.setAttribute("name", c);
        request.setAttribute("currentPage", page);
        int totalTeachers = dao.getTotalWeeklySchedulesCount(classID);
        int totalPages = (int) Math.ceil((double) totalTeachers / pageSize);
        request.setAttribute("totalPages", totalPages);

       
        request.setAttribute("listReport", list);
        request.getRequestDispatcher("AttendanceReportAdmin.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
