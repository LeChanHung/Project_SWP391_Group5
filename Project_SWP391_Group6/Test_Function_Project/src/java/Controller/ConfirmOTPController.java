/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ForgotDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import utils.EmailUtils;

/**
 *
 * @author lecha
 */
@WebServlet(name = "ConfirmOTPController", urlPatterns = {"/confirmOTP"})
public class ConfirmOTPController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ForgotPass_OTP.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String otp = req.getParameter("otp");

        String real_otp = (String) req.getSession().getAttribute("otp");
        String email = (String) req.getSession().getAttribute("email");

        if (!otp.equals(real_otp)) {
            req.setAttribute("message", "WRONG OTP");
            req.getRequestDispatcher("ForgotPass_OTP.jsp").forward(req, resp);
        }
        String newPassword = EmailUtils.generatePassword();

        EmailUtils.sendEmail(email, "FPT UNIVERSITY ATTEND", "YOUR NEW PASSWORD:" + newPassword);
        ForgotDAO dbForgot = new ForgotDAO();
        dbForgot.updatePassword(email, newPassword);
        System.out.println(real_otp);
        req.getSession().removeAttribute("otp");
        req.getSession().removeAttribute("email");
        req.setAttribute("message", "Your new password is sent to your email");
        req.getRequestDispatcher("ForgotPass_OTP.jsp").forward(req, resp);

    }

}
