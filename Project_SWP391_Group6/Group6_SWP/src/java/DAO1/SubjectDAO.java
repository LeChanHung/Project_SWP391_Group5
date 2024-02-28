/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public static void main(String[] args) {
        SubjectDAO c = new SubjectDAO();
        List<Subjects> list = c.getAllSubject();
        System.out.println(list.get(0).getSubjectName());
    }
}
