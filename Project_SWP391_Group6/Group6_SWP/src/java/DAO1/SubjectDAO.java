/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model1.Subjects;

/**
 *
 * @author admin
 */
public class SubjectDAO extends DBContext {

    public Subjects toSubjects(ResultSet rs) throws SQLException{
        Subjects subjects = new Subjects();
        subjects.setSubjectID(rs.getInt("SubjectID"));
        subjects.setSubjectName(rs.getString("SubjectName"));
        return subjects;
    }
    
    public List<Subjects> getAllSubject() {
        List<Subjects> subjectses = new ArrayList<>();

        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "select * from Subjects";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);
            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                // Retrieve product details from each row
                int subjectID = resultSet.getInt("SubjectID");
                String subjectName = resultSet.getString("SubjectName");

                // Create a Product object with the retrieved data
                Subjects subject = new Subjects(subjectID, subjectName);

                // Add the product to the list
                subjectses.add(subject);
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return subjectses;
    }
    public Subjects getSubjectByID(int id) {
        Subjects subject = null;
        try {
            // Tạo câu truy vấn SQL để lấy thông tin của một sinh viên bằng MSV
            String query = "SELECT * FROM Subjects WHERE SubjectID=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            // Thực thi truy vấn
            ResultSet resultSet = statement.executeQuery();

            // Kiểm tra xem có sinh viên nào được tìm thấy hay không
            if (resultSet.next()) {
                // Lấy thông tin của sinh viên từ kết quả truy vấn
                int subjectID = resultSet.getInt("SubjectID");
                String subjectName = resultSet.getString("SubjectName");

                // Create a Product object with the retrieved data
                subject = new Subjects(subjectID, subjectName);

            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return subject;
    }
    public int getTotalSubjetcsCount() {
        int total = 0;
        try {
            String query = "SELECT COUNT(*) AS total FROM Subjects";
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

    public Subjects get(int id) {
        try {
            String query = "select * from Subjects where SubjectID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
               return toSubjects(resultSet);
            }
            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
     public ArrayList<Subjects> getAllSubjectTeacher(int teacherId, int classId) {
        ArrayList<Subjects> subjectses = new ArrayList<>();
        try {
            Set<Integer> disSubject = new HashSet<>();
            String query = "SELECT [ScheduleID]\n"
                    + "      ,[ClassID]\n"
                    + "      ,[TeacherID]\n"
                    + "      ,[SubjectID]\n"
                    + "      ,[DayOfWeek]\n"
                    + "      ,[SlotID]\n"
                    + "  FROM [swp].[dbo].[WeeklySchedules] where TeacherID = ? and ClassID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, teacherId);
            statement.setInt(2, classId);
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                int subjectID = resultSet.getInt("SubjectID");
                disSubject.add(subjectID);
            }

            for (Integer integer : disSubject) {
                subjectses.add(get(integer));
            }
            // Close the resources
            resultSet.close();
            statement.close();
            return subjectses;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return subjectses;
    }
     

    public static void main(String[] args) {
        SubjectDAO c = new SubjectDAO();
        List<Subjects> list = c.getAllSubject();
        System.out.println(list.get(0).getSubjectName());
    }
}
