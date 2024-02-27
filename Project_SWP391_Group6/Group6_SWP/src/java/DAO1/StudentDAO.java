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
import java.util.Date;

/**
 *
 * @author admin
 */
public class StudentDAO extends DBContext {

    public List<Students> getAllStudent() {
        List<Students> studentses = new ArrayList<>();

        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "select * from Students";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);
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
                // Create a Product object with the retrieved data
                Students student = new Students(studentID, firstName, lastName, email, passwordHash, dob, gender, MSV);

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

                Students student = new Students(studentID, firstName, lastName, email, passwordHash, dob, gender, MSV);
                studentsList.add(student);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return studentsList;
    }

    public boolean addStudent(String firstName, String lastName, String email, String passwordHash, String dob, String gender, String MSV) {
        try {
            // Create SQL query to insert a new student
            String query = "INSERT INTO Students (FirstName, LastName, Email, PasswordHash, dob, gender, MSV) VALUES (?, ?, ?, ?, ?, ?, ?)";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters for the prepared statement
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, passwordHash);
            statement.setString(5, dob);
            statement.setString(6, gender);
            statement.setString(7, MSV);

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

    public static void main(String[] args) {
        StudentDAO c = new StudentDAO();
        List<Students> list = c.getAllStudent();
        System.out.println(list.get(0).getMSV());
    }
}
