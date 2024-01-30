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
public class ChangePasss extends DBContext{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null ;
    
    public Student check(String Email,String PasswordHash) {
        try {
            String query = "select * from Students where Email=? and PasswordHash=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Email);
            ps.setString(2, PasswordHash);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                return new Student(
//                        rs.getInt("id"),
                        rs.getString("FirstName"), 
                        rs.getString("LastName"), 
                        Email, 
                        PasswordHash, 
                        rs.getString("gender"), 
                        rs.getDate("dob"), 
                        rs.getString("MSV"));
//                        rs.getInt("role"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void changePass(String email, String pass) {
        String query = "update Students set PasswordHash=? where Email=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
        public static void main(String[] args) {
//        ChangePasss pd = new ChangePasss();
//        Student ab = new Student();
//        pd.check('hunglche160179@fpt.edu.vn', '123');
        
    }
    
}

