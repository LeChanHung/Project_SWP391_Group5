/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOO;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Student;
import model.Teacher;



public class loginSTDAO {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Student authenticateStudent(String email, String password) {

        try {
            String query = "SELECT * FROM Students WHERE email=? AND PasswordHash=?";
            new DBContext();
            conn = DBContext.getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("StudentID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEmail(rs.getString("Email"));
                s.setPasswordHash(rs.getString("PasswordHash"));
                s.setRole(rs.getInt("role"));
                
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
     public Teacher authenticateTeacher(String email, String password) {

        try {
            String query = "SELECT * FROM Teachers WHERE email=? AND PasswordHash=?";
            new DBContext();
            conn = DBContext.getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Teacher t = new Teacher();
                t.setId(rs.getInt("StudentID"));
                t.setFirstName(rs.getString("FirstName"));
                t.setLastName(rs.getString("LastName"));
                t.setEmail(rs.getString("Email"));
                t.setPasswordHash(rs.getString("PasswordHash"));
                t.setRole(rs.getInt("role"));
                
                return t;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
     
     public static void main(String[] args) {
        loginSTDAO l = new loginSTDAO();
        Student s = l.authenticateStudent("anhptkhe1604332@fpt.edu.vn", "123");
        
         System.out.println(s.getEmail());
        
    }
    
    
}
