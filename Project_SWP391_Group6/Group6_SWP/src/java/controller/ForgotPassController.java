/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.ForgotDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import utils.EmailUtils;
import utils.StringUtils;

/**
 *
 * @author lecha
 */
@WebServlet(name = "ForgotPassController", urlPatterns = {"/forget"})
public class ForgotPassController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ForgotPass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_email = req.getParameter("mail");
        boolean checkValid = StringUtils.isValidEmail(raw_email);
        if (!checkValid) {
            System.out.println("WTFEmailEmpty");
            req.setAttribute("message", "WRONG EMAIL BECAUSE INVALID");
            req.getRequestDispatcher("ForgotPass.jsp").forward(req, resp);
        }

        ForgotDAO dbForgot = new ForgotDAO();
        boolean checkinDb = dbForgot.checkEmailExists(raw_email);
        if (!checkinDb) {
            System.out.println("WTFCheckEmail");
            req.setAttribute("message", "WRONG EMAIL BECAUSE IS NOT EXIST IN DATABASE");
            req.getRequestDispatcher("ForgotPass.jsp").forward(req, resp);
        }
        
        String OTP = EmailUtils.generateOTP();
        EmailUtils.sendEmail(raw_email,
                "FPT UNIVERSITY ATTEND",
                "IT IS YOUR OTP CODE:" + OTP);
        System.out.println("WTF");
        req.getSession().setAttribute("otp", OTP);
        req.getSession().setAttribute("email", raw_email);
        req.getRequestDispatcher("ForgotPass_OTP.jsp").forward(req, resp);
    }

}
