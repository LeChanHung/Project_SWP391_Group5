/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author minhdang
 */
public class DAO extends DBContext{
    
    public void Register(String firstName,String lastName,String email,String passwordHash,String gender,String dob,String MSV){
        String sql = "insert into Students(FirstName,LastName,Email,PasswordHash,gender,dob,MSV) values(?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, passwordHash);
            ps.setString(5, gender);
            ps.setString(6, dob);
            ps.setString(7, MSV);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
}
