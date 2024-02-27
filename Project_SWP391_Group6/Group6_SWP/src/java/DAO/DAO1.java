/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO1.DBContext;
import Entity.classes;
import Entity.feedbacks;
import Entity.schedules;
import Entity.students;
import Entity.subjects;
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
public class DAO1 extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<feedbacks> getAllFeedback() {
        List<feedbacks> list = new ArrayList<>();

        String query = "select Feedbacks.StudentID,Feedbacks.OfficeID,Feedbacks.FeedbackText,Feedbacks.FeedbackDate, Students.FirstName, Students.LastName,Students.Email from Feedbacks\n"
                + "inner join Students on Students.StudentID = Feedbacks.StudentID";
        try {
            //  conn = new DBContext().getConnection();
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                feedbacks f = new feedbacks(rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                list.add(f);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

//    public List<feedbacks> getAllFeedback(int currentPage, int recordsPerPage) {
//        List<feedbacks> list = new ArrayList<>();
//        int startIndex = (currentPage - 1) * recordsPerPage;
//        String query = "select Feedbacks.StudentID,Feedbacks.OfficeID,Feedbacks.FeedbackText,Feedbacks.FeedbackDate, Students.FirstName, Students.LastName,Students.Email from Feedbacks\n"
//                + "inner join Students on Students.StudentID = Feedbacks.StudentID\n"
//                + "order by FeedbackID\n"
//                + "limit ? offset ?";
//        try {
//            //  conn = new DBContext().getConnection();
//            ps = connection.prepareStatement(query);
//            ps.setInt(1, recordsPerPage);
//            ps.setInt(2, startIndex);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                feedbacks f = new feedbacks(rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7));
//                list.add(f);
//            }
//            return list;
//        } catch (Exception e) {
//        }
//        return null;
//    }
    public List<subjects> getAllSubject() {
        List<subjects> list = new ArrayList<>();
        String query = "select * from Subjects";
        try {
            // conn = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                subjects sub = new subjects(rs.getInt(1),
                        rs.getString(2));
                list.add(sub);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<students> getAllStudent() {
        List<students> list = new ArrayList<>();
        String query = "select * from Students";
        try {
            // conn = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                students s = new students(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                list.add(s);
            }

            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<classes> getAllClass() {
        List<classes> list = new ArrayList<>();
        String query = "select*from Classes where ClassID='1'";
        try {
            // conn = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                classes c = new classes(rs.getInt(1), rs.getString(2));
                list.add(c);

            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void insertFeedback(int StudentID, String FeedbackText) {
        String query = "insert into Feedbacks(StudentID,OfficeID,FeedbackText,FeedbackDate)\n"
                + "values(?,'1',?,'2023-02-01');";
        try {
            // conn = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, StudentID);
            ps.setString(2, FeedbackText);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void insertFeedbackOffice(int FeedbackID, String ResponseText) {
        String query = "insert into OfficeResponses(FeedbackID,ResponseText,ResponseDate)\n"
                + "values('?','?','2023-02-01');";
        try {
            //  conn = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, FeedbackID);
            ps.setString(2, ResponseText);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public int authenticationStudent(String email, String password) {
        String query = "SELECT StudentID FROM Students WHERE Email = '?' AND PasswordHash = '?'";
        try {
            // conn = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {

                return rs.getInt("StudentID");
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public List<schedules> getAllSchedules() {
        List<schedules> list = new ArrayList<>();
        String query = "select WeeklySchedules.SubjectID,Subjects.SubjectName,Teachers.FirstName + ' ' + Teachers.LastName AS TeacherFullName,Classes.ClassName,WeeklySchedules.DayOfWeek from WeeklySchedules\n"
                + "inner join Classes on Classes.ClassID=WeeklySchedules.ClassID\n"
                + "inner join Teachers on Teachers.TeacherID=WeeklySchedules.TeacherID\n"
                + "inner join Subjects on Subjects.SubjectID=WeeklySchedules.SubjectID\n"
                + "inner join TimeSlots on TimeSlots.SlotID = WeeklySchedules.SlotID\n"
                + "\n"
                + "where WeeklySchedules.ClassID='1';";
        try {
            //    conn = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                schedules sc = new schedules(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(sc);

            }
            return list;
        } catch (Exception e) {
        }

        return null;
    }

    public int totalFeedback() {
        String query = "select count(*) from Feedbacks \n";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int pagingFeedback(String search) {
        String query = "select count(*) from Feedbacks \n"
                + "inner join Students\n"
                + "on Feedbacks.StudentID = Students.StudentID\n"
                + "where Students.FirstName like ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<feedbacks> getAllFeedbackBySearch(String search) {
        List<feedbacks> list = new ArrayList<>();
        String query = "SELECT COUNT(Feedbacks.StudentID) AS TotalCount,\n"
                + "       Students.FirstName,\n"
                + "       Students.LastName,\n"
                + "       Students.Email\n"
                + "FROM Feedbacks\n"
                + "INNER JOIN Students ON Feedbacks.StudentID = Students.StudentID\n"
                + "WHERE Students.FirstName LIKE ?\n"
                + "GROUP BY Students.FirstName, Students.LastName, Students.Email;";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                while (rs.next()) {
                    rs.getInt(1);
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<feedbacks> getFeedbackBySearchAndPaging(String search, int index) {
        List<feedbacks> list = new ArrayList<>();
        String query = " select * from Feedbacks f join Students s on f.StudentID = s.StudentID\n"
                + " where s.[FirstName] like '%" + search + "%'\n "
                + " order by f.FeedbackDate desc\n"
                + " OFFSET ? ROWS FETCH NEXT 4  ROWS ONLY";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, (index - 1) * 4);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new feedbacks(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(5), rs.getString(6), rs.getString(8), rs.getString(9), rs.getString(10)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public int countFeedbackBySearch(String search) {
        List<feedbacks> list = new ArrayList<>();
        String query = " select count(*) from Feedbacks f join Students s on f.StudentID = s.StudentID\n"
                + " where f.FeedbackText like '%" + search + "%'\n";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<students> getStudentAttendance() {
        List<students> list = new ArrayList<>();
        String query = "select Students.StudentID,FirstName,MSV from StudentEnrollments\n"
                + "inner join Students on Students.StudentID=StudentEnrollments.StudentID\n"
                + "inner join Classes on Classes.ClassID=StudentEnrollments.ClassID";
        try {
            //  conn = new DBContext().getConnection();
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                students s = new students( rs.getInt(1),rs.getString(2),rs.getString(3));
                list.add(s);
            }
            return list;
        } catch (Exception e) {
        }
        return null;

    }

    public static void main(String[] args) {
        DAO1 dao = new DAO1();
        List<students> list = dao.getStudentAttendance();
        for (students s : list) {
            System.out.println(s.getStudentID()+s.getFirstName()+s.getMSV());
        }
//        int count = dao.countFeedbackBySearch("");
//        System.out.println(count);
    }
}
