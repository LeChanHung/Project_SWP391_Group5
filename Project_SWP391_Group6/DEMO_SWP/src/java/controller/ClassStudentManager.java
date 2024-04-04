/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAO1.ClassDAO;
import DAO1.SlotDAO;
import DAO1.StudentDAO;
import DAO1.SubjectDAO;
import DAO1.TeacherDAO;
import Entity.timeSlots;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model1.Classes;
import model1.Students;
import model1.Subjects;
import model1.Teachers;

/**
 *
 * @author admin
 */
@WebServlet(name="ClassStudentManager", urlPatterns={"/classstudent"})
public class ClassStudentManager extends HttpServlet {
   
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
            out.println("<title>Servlet ClassStudentManager</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClassStudentManager at " + request.getContextPath () + "</h1>");
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
        String searchKeyword = request.getParameter("searchKeyword");
        String classID_raw = request.getParameter("cid");
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
        
        SubjectDAO subDao = new SubjectDAO();
        TeacherDAO tDao = new TeacherDAO();
        SlotDAO slDao = new SlotDAO();
        
        ArrayList<timeSlots> slot = slDao.list();
        List<Teachers> listT = tDao.getAllTeacher1();
        List<Classes> listC1 = dao.getAllClass();               
        List<Students> studentStudying1 = sDao.getAllStudentByClassId(classID);
        List<Subjects> listS = subDao.getAllSubject();
        
        request.setAttribute("listStudent1",studentStudying1);
        request.setAttribute("listClass", listC1);
        request.setAttribute("listSubject", listS);
        request.setAttribute("listTeacher", listT);
        request.setAttribute("listSlot", slot);
        
        request.setAttribute("listStudying",studentStudying);
        request.setAttribute("liststudent", studentsList);
        request.setAttribute("listclass", listC);
        request.setAttribute("name", c);
        request.getRequestDispatcher("classStudent.jsp").forward(request, response);
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
        ClassDAO dao = new ClassDAO();
        String className = request.getParameter("className");
        boolean success = dao.addClass(className);
         if (success) {
            response.sendRedirect(request.getContextPath() + "/class_manager");
        } 
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
