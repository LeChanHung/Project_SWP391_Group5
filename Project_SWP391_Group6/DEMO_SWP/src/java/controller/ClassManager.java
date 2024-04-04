/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO1.ClassDAO;
import DAO1.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model1.Classes;
import model1.Students;

/**
 *
 * @author admin
 */
public class ClassManager extends HttpServlet {

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
            out.println("<title>Servlet ClassManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClassManager at " + request.getContextPath() + "</h1>");
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
        String searchKeyword = request.getParameter("searchKeyword");
        String classID_raw = request.getParameter("class");
        StudentDAO sDao = new StudentDAO();
        ClassDAO dao = new ClassDAO();
        int classID;
        if (classID_raw == null) {
            classID = 2;
        } else {
            classID = Integer.parseInt(classID_raw);
        }

        List<Students> studentsList;
        List<Classes> listC = dao.getAllClass();
        Classes c = dao.getClassByID(classID);
        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            studentsList = dao.searchStudentsofClass(searchKeyword,classID);
        } else {
             studentsList = dao.getCLassforStudent(classID);
        }
        List<Students> studentStudying = sDao.getStudentStudying(classID);
        
        request.setAttribute("listStudying",studentStudying);
        request.setAttribute("liststudent", studentsList);
        request.setAttribute("listclass", listC);
        request.setAttribute("name", c);
        request.getRequestDispatcher("class-management.jsp").forward(request, response);
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
        String action = request.getParameter("action");
        String cid_raw = request.getParameter("cid");
        int cid = Integer.parseInt(cid_raw);
    if (action != null && action.equals("delete")) {
        // Xử lý xóa sinh viên
        String msv = request.getParameter("msv1");
        String className = request.getParameter("className1");
        
        ClassDAO classDAO = new ClassDAO();
        int studentID = classDAO.getStudentIDbyMSV(msv);
        int classID = classDAO.getClassIDbyName(className);
        int erID = classDAO.getErID(studentID, classID);
        boolean success = classDAO.delete(erID);
        if (success) {
            response.sendRedirect(request.getContextPath() + "/classstudent?cid="+cid);
        } else {
            response.getWriter().println("Failed to delete student.");
        }
    } else if (action != null && action.equals("edit")) {
        // Xử lý cập nhật thông tin sinh viên
    
    } else {
        // Nếu không phải là xóa hoặc cập nhật, giả định là thêm sinh viên mới
        String className = request.getParameter("className");  
        String MSV = request.getParameter("msv");
        ClassDAO classDAO = new ClassDAO();
        int studentID = classDAO.getStudentIDbyMSV(MSV);
        int classID = classDAO.getClassIDbyName(className); 
        
        List<Students> listS = classDAO.getAllStudent();
        List<Classes> listC = classDAO.getAllClass();
        boolean check = false;
        int countCheck = 0;
        for(int i = 0; i<listS.size();i++){
            if(studentID==listS.get(i).getStudentID()) {
                countCheck++;
            }
        }
        for(int i = 0; i<listC.size();i++){
            if(classID==listC.get(i).getClassID()) {
                countCheck++;
            }
        }
        boolean success = classDAO.studentErollment(studentID, classID);
         if (success) {
            response.sendRedirect(request.getContextPath() + "/classstudent?cid="+cid);
        } 
        
        
    
    }
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
