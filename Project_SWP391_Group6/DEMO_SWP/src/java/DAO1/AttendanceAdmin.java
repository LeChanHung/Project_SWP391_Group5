/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import model1.AttendanceReport;
import model1.Classes;
import model1.Schedule;
import model1.SendMail;
import model1.Students;
import model1.Subjects;
import model1.Teachers;

/**
 *
 * @author admin
 */
public class AttendanceAdmin extends DBContext {

    DecimalFormat df = new DecimalFormat("#.0");

    public List<AttendanceReport> getAttendanceReport(int id, int sid, String searchKeyword, int page, int pageSize) {
        List<AttendanceReport> list = new ArrayList<>();
        int offset = (page - 1) * pageSize;
        ClassDAO cDao = new ClassDAO();
        StudentDAO sDao = new StudentDAO();
        SubjectDAO sjDAO = new SubjectDAO();
        TeacherDAO tDao = new TeacherDAO();

        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query1 = "SELECT w.SubjectID, w.TeacherID, w.ClassID, s.StudentID, st.FirstName, st.LastName,st.Email, a.Status, COUNT(a.Status) AS total\n"
                    + "                     FROM WeeklySchedules w \n"
                    + "                    JOIN Attendance a ON w.ScheduleID = a.ScheduleID\n"
                    + "                    JOIN StudentEnrollments s ON a.EnrollmentID = s.EnrollmentID \n"
                    + "                    join Students st on st.StudentID = s.StudentID\n"
                    + "                   GROUP BY w.SubjectID, st.FirstName, st.LastName,w.TeacherID, w.ClassID, s.StudentID,st.Email, a.Status   				   \n"
                    + "				  Having 1=1";
            if (searchKeyword != null) {
                query1 += "and (st.FirstName like '%" + searchKeyword + "%'or st.LastName LIKE '%" + searchKeyword + "%')";
            }

            if (id != 0) {
                query1 += "and w.ClassID = " + id;
            }

            if (sid != 0) {
                query1 += "and w.SubjectID = " + sid;
            }

            String query2 = "   ORDER BY w.SubjectID\n"
                    + "				   OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

            String query = query1 + query2;

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, offset);
            statement.setInt(2, pageSize);
            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                // Retrieve product details from each row
                int studentID = resultSet.getInt("StudentID");
                int teacherID = resultSet.getInt("TeacherID");
                int classID = resultSet.getInt("ClassID");
                int subjectID = resultSet.getInt("SubjectID");
                String status = resultSet.getString("Status");
                String email = resultSet.getString("Email");
                int total = resultSet.getInt("total");
                float percent = (float) 0.0;
                if (status.equals("0")) {
                    percent = (float) ((total / 20.0) * 100);
                }
                // 
                Students student = sDao.getStudentByID(studentID);
                Classes classes = cDao.getClassByID(classID);
                Subjects subject = sjDAO.getSubjectByID(subjectID);
                Teachers teacher = tDao.getTeacherByID(teacherID);
                // Create a Product object with the retrieved data
                AttendanceReport ar = new AttendanceReport(student, classes, subject, teacher, status, email, percent);
                list.add(ar);
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public boolean insertSendMails(String email, float percent) {
        try {
            // Create SQL query to insert a new teacher
            String query = "INSERT INTO SendMails (email,[percent]) VALUES (?,?)";

            // Create prepared statement with the query
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters for the prepared statement
            statement.setString(1, email);
            statement.setFloat(2, percent);

            // Execute the insert query
            int rowsAffected = statement.executeUpdate();

            // Check if the insert was successful
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Error adding teacher: " + ex.getMessage());
            return false;
        }
    }

    public int getTotalWeeklySchedulesCount(int classID) {

        int total = 0;
        try {
            String query = "SELECT count(*) as total\n"
                    + "                     FROM WeeklySchedules w \n"
                    + "                    JOIN Attendance a ON w.ScheduleID = a.ScheduleID\n"
                    + "                    JOIN StudentEnrollments s ON a.EnrollmentID = s.EnrollmentID \n"
                    + "                    join Students st on st.StudentID = s.StudentID\n"
                    + "					where 1=1";

            if (classID != 0) {
                query += "and w.ClassID =" + classID;
            }
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt("total");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return total;
    }

    public List<AttendanceReport> getListAR() {
        List<AttendanceReport> list = new ArrayList<>();

        ClassDAO cDao = new ClassDAO();
        StudentDAO sDao = new StudentDAO();
        SubjectDAO sjDAO = new SubjectDAO();
        TeacherDAO tDao = new TeacherDAO();

        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "SELECT w.SubjectID, w.TeacherID, w.ClassID, s.StudentID, st.FirstName, st.LastName,st.Email,a.Status, COUNT(a.Status) AS total\n"
                    + "                     FROM WeeklySchedules w \n"
                    + "                    JOIN Attendance a ON w.ScheduleID = a.ScheduleID\n"
                    + "                    JOIN StudentEnrollments s ON a.EnrollmentID = s.EnrollmentID \n"
                    + "                    join Students st on st.StudentID = s.StudentID\n"
                    + "                   GROUP BY w.SubjectID, st.FirstName, st.LastName,w.TeacherID, w.ClassID, s.StudentID,st.Email, a.Status   				   \n"
                    + "				  Having 1=1";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                // Retrieve product details from each row
                int studentID = resultSet.getInt("StudentID");
                int teacherID = resultSet.getInt("TeacherID");
                int classID = resultSet.getInt("ClassID");
                int subjectID = resultSet.getInt("SubjectID");
                String status = resultSet.getString("Status");
                String email = resultSet.getString("Email");
                int total = resultSet.getInt("total");
                float percent = (float) 0.0;
                if (status.equals("0")) {
                    percent = (float) ((total / 20.0) * 100);
                }
                // 
                Students student = sDao.getStudentByID(studentID);
                Classes classes = cDao.getClassByID(classID);
                Subjects subject = sjDAO.getSubjectByID(subjectID);
                Teachers teacher = tDao.getTeacherByID(teacherID);
                // Create a Product object with the retrieved data
                AttendanceReport ar = new AttendanceReport(student, classes, subject, teacher, status, email, percent);
                list.add(ar);
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<SendMail> getSendMail() {
        List<SendMail> list = new ArrayList<>();

        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "SELECT * FROM SendMails";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                // Retrieve product details from each row
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                float percent = resultSet.getFloat("percent");
                SendMail s = new SendMail(id, email, percent);
                list.add(s);

            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public void updateStatus(int id, String status) {
        try {
            String query = "UPDATE Attendance SET Status = ? where AttendanceID = ?";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /*
    public static void main(String[] args) {
        AttendanceAdmin a = new AttendanceAdmin();
        List<AttendanceReport> list = a.getAttendanceReport(1,"t");
        System.out.println(list.get(1).getStudent().getLastName());
    }
     */
}
