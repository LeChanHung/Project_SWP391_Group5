/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Context.DBContext;
import Entity.student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duy Anh
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null ;

    public void getAllFeedback(int id, String text, String fullName, String email) {

        String query = "insert into feedback (feedback_ID,feedback_text,student_name,student_email)\n" +
                        " values ('?','?','?','?')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, text);
            ps.setString(3,fullName);
            ps.setString(4, email);
            ps.executeUpdate();
        } catch (Exception e) {
         
        }

    }

    public List<student> getAllStudent() {
        List<student> list = new ArrayList<>();
        String query = "select student_id,student_name,student_email,"
                + "student_password,student_msv,student_ava,"
                + "dob,gender,class_ID from student";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new student(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<student> list = dao.getAllStudent();
        for (student object : list) {
            System.out.println(object);
        }
    }
}
