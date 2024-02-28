/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO1;

import Entity.timeSlots;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model1.Classes;
import model1.Students;

/**
 *
 * @author Hai Nam
 */
public class ClassDAO extends DBContext {

    public Classes toClasses(ResultSet rs) throws SQLException {
        Classes classes = new Classes();
        classes.setClassID(rs.getInt("ClassID"));
        classes.setClassName(rs.getString("ClassName"));
        return classes;
    }

    public Classes get(int id) {
        try {
            String query = "SELECT * FROM [Classes] where ClassID = ?";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               return toClasses(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public List<Students> getCLassforStudent(int classID) {
        List<Students> listS = new ArrayList<>();

        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "select s.StudentID, s.FirstName, s.MSV, s.LastName, c.ClassID, c.ClassName from\n"
                    + "StudentEnrollments se join Classes c on se.ClassID = c.ClassID\n"
                    + "join Students s on se.StudentID = s.StudentID\n"
                    + "where c.ClassID= ? ";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, classID);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                // Retrieve product details from each row
                int studentID = resultSet.getInt(1);
                String msv = resultSet.getString(3);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(4);

                // Create a Product object with the retrieved data
                Students s = new Students(studentID, firstName, lastName, msv);

                // Add the product to the list
                listS.add(s);
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listS;
    }

    public List<Classes> getAllClass() {
        List<Classes> listC = new ArrayList<>();
        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "select * from Classes";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                // Retrieve product details from each row
                int classID = resultSet.getInt("ClassID");
                String className = resultSet.getString("ClassName");

                // Create a Product object with the retrieved data
                Classes c = new Classes(classID, className);

                // Add the product to the list
                listC.add(c);
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listC;
    }

    public Classes getClassByID(int classID) {
        Classes c = null;
        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "select * from Classes where classID = ?";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, classID);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                // Retrieve product details from each row
                int classId = resultSet.getInt(1);
                String className = resultSet.getString(2);

                // Create a Product object with the retrieved data
                c = new Classes(classID, className);

                // Add the product to the list
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return c;
    }

    public List<Students> searchStudentsofClass(String keyword, int classID) {
        List<Students> studentsList = new ArrayList<>();

        try {
            String query = "select s.StudentID, s.FirstName, s.MSV, s.LastName, c.ClassID, c.ClassName from\n"
                    + "StudentEnrollments se join Classes c on se.ClassID = c.ClassID\n"
                    + "join Students s on se.StudentID = s.StudentID\n"
                    + "where c.ClassID= ? AND ( FirstName LIKE ? OR LastName LIKE ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, classID);
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int studentID = resultSet.getInt("StudentID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String MSV = resultSet.getString("MSV");
                // Create a Product object with the retrieved data
                Students student = new Students(studentID, firstName, lastName, MSV);
                studentsList.add(student);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return studentsList;
    }

    public boolean studentErollment(int studentID, int classID) {
        try {
            // Create SQL query to insert a new teacher
            String query = "insert into StudentEnrollments(StudentID,ClassID) values(?,?)";

            // Create prepared statement with the query
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters for the prepared statement
            statement.setInt(1, studentID);
            statement.setInt(2, classID);
           

            // Execute the insert query
            int rowsAffected = statement.executeUpdate();

            // Check if the insert was successful
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Error adding teacher: " + ex.getMessage());
            return false;
        }
    }
    
    public int getStudentIDbyMSV(String msv) {
        int n =0 ;
        
        
        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "SELECT * FROM Students where MSV = ?";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, msv);
            
            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                // Retrieve product details from each row
                int studentID = resultSet.getInt("StudentID");
                n = studentID;
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        
        return n;
                
    }
    
    public int getClassIDbyName(String className) {
        int n =0 ;
        
        
        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "SELECT * FROM Classes where className = ?";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, className);
            
            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                // Retrieve product details from each row
                int classID = resultSet.getInt("ClassID");
                n = classID;
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        
        return n;
                
    }
    
    public List<Students> getAllStudent() {
        List<Students> studentses = new ArrayList<>();
        
        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "SELECT * FROM Students";

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
                int status  = resultSet.getInt("status");
                // Create a Product object with the retrieved data
                Students student = new Students(studentID, firstName, lastName, email, passwordHash, dob, gender, MSV,status);

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
    
    public boolean delete(int erID) {
        try {
            // Create SQL query to delete a teacher by ID
            String query = "DELETE FROM StudentEnrollments WHERE EnrollmentID = ?";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Set the parameter for the prepared statement
            statement.setInt(1, erID);

            // Execute the query
            int rowsDeleted = statement.executeUpdate();

            // Close the resources
            statement.close();

            // Check if the teacher was successfully deleted
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public int getErID(int studentID, int classID) {
        int n = 0;
        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "SELECT * FROM StudentEnrollments where StudentID = ? AND ClassID = ?";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, studentID);
            statement.setInt(2, classID);
            
            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                // Retrieve product details from each row
                int erID = resultSet.getInt("EnrollmentID");
                n = erID;
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return n;
    }
}
