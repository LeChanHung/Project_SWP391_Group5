
package DAOO;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model1.TrainingOffice;
import java.sql.Connection;

public class loginDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public TrainingOffice authenticateUser(String officeName, String password) {

        try {
            String query = "SELECT * FROM TrainingOffice WHERE OfficeName=? AND Password=?";
            new DBContext();
            conn = DBContext.getConnect();
            ps = conn.prepareStatement(query);
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

    public static void main(String[] args) {
        TrainingOffice user = new TrainingOffice();
        loginDAO l = new loginDAO();
        user = l.authenticateUser("admin", "123");
        System.out.println(user.getOfficeID());
    }
}
