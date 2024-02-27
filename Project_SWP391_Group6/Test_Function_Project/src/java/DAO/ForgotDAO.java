/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author lecha
 */
public class ForgotDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean checkEmailExists(String Email) {
        try {
            String query = "select * from Students where Email=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Email);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

            query = "select * from Teachers where Email=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

            return false;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updatePassword(String Email, String Password) {
        try {
            String query = "update Students set PasswordHash = ? where Email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Password);
            ps.setString(2, Email);
            ps.executeUpdate();

            query = "update Teachers set PasswordHash = ? where Email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Password);
            ps.setString(2, Email);
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
