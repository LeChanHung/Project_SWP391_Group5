
package controller;

import DAOO.loginDAO;
import DAOO.loginSTDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;
import model.Teacher;
import model.TrainingOffice;

/**
 *
 * @author DUYLC10
 */
@WebServlet(name="loginStudentTeacher", urlPatterns={"/loginStudentTeacher"})
public class loginStudentTeacher extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        loginSTDAO loginSTDAO = new loginSTDAO();
         HttpSession session = request.getSession();
        Student s = null;
        Teacher t = null;
        try {
            s = loginSTDAO.authenticateStudent(email, password);
            t = loginSTDAO.authenticateTeacher(email, password);
        } catch (Exception ex) {
        }
        if (s != null) { 
            session.setAttribute("student", s);
            response.sendRedirect("homePageStudent.jsp");   
        } else if(t!=null) {
            session.setAttribute("teacher", t);
            response.sendRedirect("homePageTeacher.jsp");
        }else {
            request.setAttribute("error", "Sai TK or MK");
            request.getRequestDispatcher("loginStudentTeacher.jsp").forward(request, response);
        }
    }
    


}
