/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model1.Application;
import model1.FeedBackTeacher;

/**
 *
 * @author lecha
 */
public class FeedbackTeacherDAO extends DBContext {

    private FeedBackTeacher toFeedBackTeacher(ResultSet rs) throws SQLException {
        FeedBackTeacher fbt = new FeedBackTeacher();
        fbt.setId(rs.getInt("id"));
        fbt.setProRate(rs.getInt("proRate"));
        fbt.setTeachRate(rs.getInt("teachRate"));
        fbt.setComment(rs.getString("comment"));
        TeacherDAO dbTeacher = new TeacherDAO();
        SubjectDAO dbSubject = new SubjectDAO();
        StudentDAO dbStudent = new StudentDAO();
        fbt.setTeacherId(dbTeacher.get(rs.getInt("TeacherID")));
        fbt.setSubjectId(dbSubject.get(rs.getInt("SubjectID")));
        fbt.setStudentId(dbStudent.getStudentByID(rs.getInt("StudentID")));
        return fbt;
    }

    public ArrayList<FeedBackTeacher> list() {
        ArrayList<FeedBackTeacher> feedBackTeachers = new ArrayList<>();
        try {
            String query = "SELECT * FROM [Feedback_Teacher] order by createdAt desc";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                feedBackTeachers.add(toFeedBackTeacher(rs));
            }
            return feedBackTeachers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return feedBackTeachers;
    }

    public ArrayList<FeedBackTeacher> listByTeacherId(int teacherId) {
        ArrayList<FeedBackTeacher> feedBackTeachers = new ArrayList<>();
        try {
            String query = "SELECT * FROM [Feedback_Teacher] where TeacherID = ? order by createdAt desc";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, teacherId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                feedBackTeachers.add(toFeedBackTeacher(rs));
            }
            return feedBackTeachers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return feedBackTeachers;
    }

    public ArrayList<FeedBackTeacher> listTeacherFeed(int studentId) {
        ArrayList<FeedBackTeacher> feedBackTeachers = new ArrayList<>();
        try {
            String query = """
                           select distinct TeacherID,SubjectID from WeeklySchedules 
                           where StudentID = ?""";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FeedBackTeacher findBy = findByTeacherIdAndSubjectIdAndStudentId(rs.getInt("TeacherID"), rs.getInt("SubjectID"), studentId);
                if (findBy != null) {
                    feedBackTeachers.add(findBy);
                    continue;
                }
                FeedBackTeacher fbt = new FeedBackTeacher();
                TeacherDAO dbTeacher = new TeacherDAO();
                SubjectDAO dbSubject = new SubjectDAO();
                fbt.setTeacherId(dbTeacher.get(rs.getInt("TeacherID")));
                fbt.setSubjectId(dbSubject.get(rs.getInt("SubjectID")));
                feedBackTeachers.add(fbt);
            }
            return feedBackTeachers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return feedBackTeachers;
    }

    public FeedBackTeacher findByTeacherIdAndSubjectIdAndStudentId(int teacherId, int subjectId, int studentId) {
        try {
            String query = """
                          SELECT * FROM [Feedback_Teacher] 
                           where TeacherID = ? and SubjectID = ? and StudentID = ?""";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, teacherId);
            ps.setInt(2, subjectId);
            ps.setInt(3, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return toFeedBackTeacher(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public FeedBackTeacher get(int id) {
        try {
            String query = """
                          SELECT * FROM [Feedback_Teacher] 
                           where id = ?""";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return toFeedBackTeacher(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(FeedBackTeacher model) {
        try {
            String query = "insert into Feedback_Teacher(proRate, teachRate, comment,StudentID, SubjectID, TeacherID,createdAt) values"
                    + "(?,?,?,?,?,?,?)";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, model.getProRate());
            ps.setInt(2, model.getTeachRate());
            ps.setString(3, model.getComment());
            ps.setInt(4, model.getStudentId().getStudentID());
            ps.setInt(5, model.getSubjectId().getSubjectID());
            ps.setInt(6, model.getTeacherId().getTeacherID());
            Date today = new Date();
            java.sql.Date dateSql = new java.sql.Date(today.getTime());
            ps.setDate(7, dateSql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(FeedBackTeacher model) {
        try {
            String query = "update Feedback_Teacher set proRate = ?, teachRate = ?, comment = ? where id = ?";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, model.getProRate());
            ps.setInt(2, model.getTeachRate());
            ps.setString(3, model.getComment());
            ps.setInt(4, model.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
