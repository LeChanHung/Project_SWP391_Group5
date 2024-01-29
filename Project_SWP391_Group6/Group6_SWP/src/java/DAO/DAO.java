/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Context.DBContext;
import Entity.admin;
import Entity.clas;
import Entity.phongdaotao;
import Entity.student;
import Entity.student1;
import Entity.subject;
import Entity.teacher;
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
    
    public admin getAdminByEmail(String mail){
        try {
            String query = "SELECT * FROM admin where adEmail = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                admin a = new admin(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public phongdaotao getPdtByEmail(String mail){
        try {
            String query = "SELECT * FROM phong_dao_tao WHERE systemUser_email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                phongdaotao a = new phongdaotao(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<student1> getAllStudent1() {
        List<student1> list = new ArrayList<>();
        String query = "select * from student\n" +
                        "where class_ID='1'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                 student1 s1= new student1(rs.getInt(1),
                         rs.getString(2), 
                         rs.getString(5), 
                         rs.getDate(8), 
                         rs.getString(9));
                 list.add(s1);
            }
            
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public teacher getTeacherByEmail(String mail){
        try {
            String query = "SELECT * FROM teacher where teacher_email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            teacher a = new teacher();
            while (rs.next()) {     
                a.setId(rs.getInt("teacher_ID"));
                a.setName(rs.getString("teacher_name"));
                a.setEmail(rs.getString("teacher_email"));
                a.setPassword(rs.getString("teacher_password"));
                a.setDate(rs.getDate("dob"));
                a.setGender(rs.getString("gender"));
            
//                teacher a = new teacher(
//                        rs.getInt("teacher_ID"), 
//                        rs.getString("teacher_name"), 
//                        rs.getString("teacher_email"), 
//                        rs.getString("teacher_password"),
//                        rs.getDate("dob"), 
//                        rs.getString("gender"));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public student getStudentByEmail(String mail){
        try {
            String query = "SELECT * FROM student where [student_email] = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                student a = new student(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getDate(8), 
                        rs.getString(9), 
                        rs.getInt(10));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
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
    
    public List<subject> getAllSubject() {
        List<subject> list = new ArrayList<>();
        String query = "select * from subject";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                subject sub = new subject(rs.getInt(1),
                        rs.getString(2));
                list.add(sub);
            }
            
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<clas> getAllClass() {
        List<clas> list = new ArrayList<>();
        String query = "select * from class\n" +
                        "where class_ID='1'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                clas c = new clas(
                        rs.getString(2));
                list.add(c);
            }
            
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
//        List<student> list = dao.getAllStudent();
//        for (student object : list) {
//            System.out.println(object);
//        }
        phongdaotao tea = dao.getPdtByEmail("pdt01@fpt.edu.vn");
        System.out.println(tea.getSystemUser_ID());
    }
}
