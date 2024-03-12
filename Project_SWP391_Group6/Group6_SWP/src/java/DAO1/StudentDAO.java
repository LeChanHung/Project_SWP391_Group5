/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO1;

import java.util.ArrayList;
import java.util.List;
import model1.Students;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author admin
 */
public class StudentDAO extends DBContext {

    public List<Students> getAllStudent(int page, int pageSize) {
        List<Students> studentses = new ArrayList<>();
        int offset = (page - 1) * pageSize;
        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "SELECT * FROM Students ORDER BY StudentID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

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
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String passwordHash = resultSet.getString("PasswordHash");
                Date dob = resultSet.getDate("dob");
                String gender = resultSet.getString("gender");
                String MSV = resultSet.getString("MSV");
                int status = resultSet.getInt("status");
                // Create a Product object with the retrieved data
                Students student = new Students(studentID, firstName, lastName, email, passwordHash, dob, gender, MSV, status);

                // Add the product to the list
                studentses.add(student);
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return studentses;
    }

    public List<Students> searchStudents(String keyword) {
        List<Students> studentsList = new ArrayList<>();

        try {
            String query = "SELECT * FROM Students WHERE FirstName LIKE ? OR LastName LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int studentID = resultSet.getInt("StudentID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String passwordHash = resultSet.getString("PasswordHash");
                Date dob = resultSet.getDate("dob");
                String gender = resultSet.getString("gender");
                String MSV = resultSet.getString("MSV");
                int status = resultSet.getInt("status");
                // Create a Product object with the retrieved data
                Students student = new Students(studentID, firstName, lastName, email, passwordHash, dob, gender, MSV, status);
                studentsList.add(student);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return studentsList;
    }

    public boolean addStudent(String firstName, String lastName, String email, String passwordHash, Date dob, String gender, String MSV, int status) {
        try {
            // Create SQL query to insert a new student
            String query = "INSERT INTO Students (FirstName, LastName, Email, PasswordHash, dob, gender, MSV, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters for the prepared statement
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, passwordHash);
            statement.setDate(5, dob);
            statement.setString(6, gender);
            statement.setString(7, MSV);
            statement.setInt(8, status);
            // Execute the query
            int rowsInserted = statement.executeUpdate();

            // Close the resources
            statement.close();

            // Check if the student was successfully added
            return rowsInserted > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(int studentID) {
        try {
            // Create SQL query to delete a student by studentID
            String query = "DELETE FROM Students WHERE StudentID = ?";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameter for the prepared statement
            statement.setInt(1, studentID);

            // Execute the query
            int rowsDeleted = statement.executeUpdate();

            // Close the resources
            statement.close();

            // Check if the student was successfully deleted
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean updateStudent(int studentID, String firstName, String lastName, String email, String passwordHash, Date dob, String gender, String MSV, int status) {
        try {
            // Tạo câu truy vấn SQL để cập nhật thông tin sinh viên
            String query = "UPDATE Students SET FirstName=?, LastName=?, Email=?, PasswordHash=?, dob=?, gender=?, MSV=?, status=? WHERE StudentID=?";

            // Tạo prepared statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Đặt các tham số cho prepared statement
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, passwordHash);
            statement.setDate(5, dob);
            statement.setString(6, gender);
            statement.setString(7, MSV);
            statement.setInt(8, status);
            statement.setInt(9, studentID);

            // Thực thi truy vấn
            int rowsUpdated = statement.executeUpdate();

            // Đóng các tài nguyên
            statement.close();

            // Kiểm tra xem thông tin sinh viên đã được cập nhật thành công hay không
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // Bổ sung phương thức để lấy thông tin của một sinh viên bằng MSV
    public Students getStudentByMSV(String MSV) {
        Students student = null;
        try {
            // Tạo câu truy vấn SQL để lấy thông tin của một sinh viên bằng MSV
            String query = "SELECT * FROM Students WHERE MSV=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, MSV);

            // Thực thi truy vấn
            ResultSet resultSet = statement.executeQuery();

            // Kiểm tra xem có sinh viên nào được tìm thấy hay không
            if (resultSet.next()) {
                // Lấy thông tin của sinh viên từ kết quả truy vấn
                int studentID = resultSet.getInt("StudentID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String passwordHash = resultSet.getString("PasswordHash");
                Date dob = resultSet.getDate("dob");
                String gender = resultSet.getString("gender");
                int status = resultSet.getInt("status");
                // Tạo đối tượng Students từ thông tin lấy được
                student = new Students(studentID, firstName, lastName, email, passwordHash, dob, gender, MSV, status);
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return student;
    }

    public int getTotalStudentsCount() {
        int total = 0;
        try {
            String query = "SELECT COUNT(*) AS total FROM Students";
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

    public List<Students> Paging(List<Students> list, int pageParam, int size) {
        if (list.isEmpty()) {
            return list;
        }
        return list.subList((pageParam - 1) * size, size * pageParam >= list.size() ? list.size() : size * pageParam);
    }

    public void Register(String firstName, String lastName, String email, String passwordHash, String gender, String dob, String MSV) {
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

    /*
    public static void main(String[] args) {
        StudentDAO c = new StudentDAO();
        List<Students> list = c.getAllStudent();
        System.out.println(list.get(0).getMSV());
    }
     */

    public Students getStudentByStudentID(int studentId) {
        Students student = null;
        try {
            // Tạo câu truy vấn SQL để lấy thông tin của một sinh viên bằng MSV
            String query = "SELECT * FROM Students WHERE StudentID=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, studentId);

            // Thực thi truy vấn
            ResultSet resultSet = statement.executeQuery();

            // Kiểm tra xem có sinh viên nào được tìm thấy hay không
            if (resultSet.next()) {
                // Lấy thông tin của sinh viên từ kết quả truy vấn
                int studentID = resultSet.getInt("StudentID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String passwordHash = resultSet.getString("PasswordHash");
                String MSV = resultSet.getString("MSV");
                Date dob = resultSet.getDate("dob");
                String gender = resultSet.getString("gender");
//                int status = resultSet.getInt("status");
                // Tạo đối tượng Students từ thông tin lấy được
                student = new Students(studentID, firstName, lastName, email, passwordHash, dob, gender, MSV);
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return student;
    }
}
