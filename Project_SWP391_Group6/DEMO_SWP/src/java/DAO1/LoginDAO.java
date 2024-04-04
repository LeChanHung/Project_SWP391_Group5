
package DAO1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model1.TrainingOffice;
import model1.Students;
import model1.Teachers;
import model1.TrainingOffice;

public class LoginDAO extends DBContext{

    public TrainingOffice authenticateTrainingOffice(String officeName, String password) {

        try {
            String query = "SELECT * FROM TrainingOffice WHERE OfficeName=? AND password=?";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
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
    
        public Students authenticateStudent(String email, String password) {

        try {
            String query = "SELECT * FROM Students WHERE Email=? AND PasswordHash=?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Students s = new Students();
                s.setStudentID(rs.getInt("StudentID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setMSV(rs.getString("MSV"));
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
    
     public Teachers authenticateTeacher(String email, String password) {

        try {
            String query = "SELECT * FROM Teachers WHERE Email=? AND PasswordHash=?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Teachers t = new Teachers();
                t.setTeacherID(rs.getInt("TeacherID"));
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
