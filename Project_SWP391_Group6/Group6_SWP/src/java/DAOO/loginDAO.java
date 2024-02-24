
package DAOO;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.TrainingOffice;
import java.sql.Connection;
import model.Student;
import model.Teacher;

public class LoginDAO extends DBContext{

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public TrainingOffice authenticateTrainingOffice(String officeName, String password) {

        try {
            String query = "SELECT * FROM TrainingOffice WHERE OfficeName=? AND password=?";
            new DBContext();
//            conn = DBContext.getConnect();
            ps = connection.prepareStatement(query);
            ps.setString(1, officeName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TrainingOffice user = new TrainingOffice();
                user = new TrainingOffice();
                user.setOfficeID(rs.getInt("OfficeID"));
                user.setOfficeName(rs.getString("OfficeName"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
        public Student authenticateStudent(String email, String password) {

        try {
            String query = "SELECT * FROM Students WHERE Email=? AND PasswordHash=?";
//            new DBContext();
//            conn = DBContext.getConnect();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("StudentID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEmail(rs.getString("Email"));
                s.setPasswordHash(rs.getString("PasswordHash"));
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
     public Teacher authenticateTeacher(String email, String password) {

        try {
            String query = "SELECT * FROM Teachers WHERE Email=? AND PasswordHash=?";
//            new DBContext();
//            conn = DBContext.getConnect();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Teacher t = new Teacher();
                t.setId(rs.getInt("TeacherID"));
                t.setFirstName(rs.getString("FirstName"));
                t.setLastName(rs.getString("LastName"));
                t.setEmail(rs.getString("Email"));
                t.setPasswordHash(rs.getString("PasswordHash"));
                return t;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        TrainingOffice user = new TrainingOffice();
        LoginDAO l = new LoginDAO();
        user = l.authenticateTrainingOffice("admin", "123");
        System.out.println(user.getOfficeID());
    }
}
