/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO1;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model1.Application;
import model1.Students;
import model1.TrainingOffice;

/**
 *
 * @author lecha
 */
public class ApplicationDAO extends DBContext {

    private Application toApplication(ResultSet rs) throws SQLException {
        Application application = new Application();
        application.setId(rs.getInt("id"));
        application.setContent(rs.getString("content"));
        application.setStatus(rs.getInt("status"));
        application.setCreatedAt(rs.getDate("createdAt"));
        application.setComment(rs.getString("comment"));
        application.setFilePath(rs.getString("filePath"));
        System.out.println(rs.getString("comment"));
        StudentDAO dbStudent = new StudentDAO();
        Students students = dbStudent.getStudentByStudentID(rs.getInt("studentId"));
        System.out.println(students.getStudentID());
        application.setStudentId(students);
        return application;
    }

    public ArrayList<Application> list() {
        ArrayList<Application> applications = new ArrayList<>();
        try {
            String query = "SELECT * FROM [Application] order by createdAt desc";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                applications.add(toApplication(rs));
            }
            return applications;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applications;
    }
    
    public ArrayList<Application> listByStudentId(int studentId) {
        ArrayList<Application> applications = new ArrayList<>();
        try {
            String query = "SELECT * FROM [Application] where studentId = ? order by createdAt desc";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                applications.add(toApplication(rs));
            }
            return applications;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applications;
    }

    public Application get(int id) {
        try {
            String query = "SELECT * FROM [Application] WHERE id = ?";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return toApplication(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(Application model) {
        try {
            String query = "insert into Application(content, studentId, status, createdAt, filePath) values"
                    + "(?,?,0,?,?)";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, model.getContent());
            ps.setInt(2, model.getStudentId().getStudentID());
            Date today = new Date();
            java.sql.Date dateSql = new java.sql.Date(today.getTime());
            ps.setDate(3, dateSql);
            ps.setString(4, model.getFilePath());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(Application model) {
        try {
            String query = "update Application set status = ?, comment = ? where id = ?";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, model.getStatus());
            ps.setString(2, model.getComment());
            ps.setInt(3, model.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
