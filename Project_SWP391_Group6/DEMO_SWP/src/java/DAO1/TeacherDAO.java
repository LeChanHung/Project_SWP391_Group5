package DAO1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model1.Teachers;

/**
 *
 * @author admin
 */
public class TeacherDAO extends DBContext {

    public Teachers toTeacher(ResultSet rs) throws SQLException {
        Teachers teachers = new Teachers();
        teachers.setTeacherID(rs.getInt("TeacherID"));
        teachers.setFirstName(rs.getString("FirstName"));
        teachers.setLastName(rs.getString("LastName"));
        teachers.setEmail(rs.getString("Email"));
        teachers.setPasswordHash(rs.getString("PasswordHash"));
        return teachers;
    }

    public List<Teachers> getAllTeacher(int page, int pageSize) {
        List<Teachers> teacherses = new ArrayList<>();
        int offset = (page - 1) * pageSize;

        try {
            // Calculate the offset based on the page number and page size

            // Create SQL query with LIMIT and OFFSET clauses
            String query = "SELECT * FROM Teachers ORDER BY TeacherID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, offset);
            statement.setInt(2, pageSize);
            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
                // Retrieve product details from each row
                int teacherID = resultSet.getInt("TeacherID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String passwordHash = resultSet.getString("PasswordHash");
                boolean isTeaching = resultSet.getBoolean("isTeaching");
                // Create a Product object with the retrieved data
                Teachers teacher = new Teachers(teacherID, firstName, lastName, email, passwordHash, isTeaching);

                // Add the product to the list
                teacherses.add(teacher);
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return teacherses;
    }

    public List<Teachers> searchTeachers(String keyword) {
        List<Teachers> teachers = new ArrayList<>();

        try {
            String query = "SELECT * FROM Teachers WHERE FirstName LIKE ? OR LastName LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters for the prepared statement
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int teacherID = resultSet.getInt("TeacherID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String passwordHash = resultSet.getString("PasswordHash");
                boolean isTeaching = resultSet.getBoolean("isTeaching");
                // Create a Teacher object with the retrieved data
                Teachers teacher = new Teachers(teacherID, firstName, lastName, email, passwordHash, isTeaching);

                // Add the teacher to the list
                teachers.add(teacher);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return teachers;
    }

    public boolean addTeacher(Teachers teacher) {
        try {
            // Create SQL query to insert a new teacher
            String query = "INSERT INTO Teachers (FirstName, LastName, Email, PasswordHash, isTeaching) VALUES (?, ?, ?, ?, ?)";

            // Create prepared statement with the query
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters for the prepared statement
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getEmail());
            statement.setString(4, teacher.getPasswordHash());
            statement.setBoolean(5, teacher.isTeaching()); // Assuming isTeaching() returns a boolean value

            // Execute the insert query
            int rowsAffected = statement.executeUpdate();

            // Check if the insert was successful
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Error adding teacher: " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteTeacher(int teacherID) {
        try {
            // Create SQL query to delete a teacher by ID
            String query = "DELETE FROM Teachers WHERE TeacherID = ?";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Set the parameter for the prepared statement
            statement.setInt(1, teacherID);

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

    public boolean editTeacher(Teachers teacher) {
        try {
            // Create SQL query to update a teacher's information
            String query = "UPDATE Teachers SET FirstName = ?, LastName = ?, Email = ?, PasswordHash = ?, IsTeaching = ? WHERE TeacherID = ?";

            // Create prepared statement with the query
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters for the prepared statement
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getEmail());
            statement.setString(4, teacher.getPasswordHash());
            statement.setBoolean(5, teacher.isTeaching()); // Assuming isTeaching() returns a boolean value
            statement.setInt(6, teacher.getTeacherID());

            // Execute the update query
            int rowsAffected = statement.executeUpdate();

            // Check if the update was successful
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Error editing teacher: " + ex.getMessage());
            return false;
        }
    }

    public int getTotalTeachersCount() {
        int total = 0;
        try {
            String query = "SELECT COUNT(*) AS total FROM Teachers";
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

    public Teachers getTeacherByID(int id) {
        Teachers teacher = null;
        try {
            // Tạo câu truy vấn SQL để lấy thông tin của một sinh viên bằng MSV
            String query = "SELECT * FROM Teachers WHERE TeacherID=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            // Thực thi truy vấn
            ResultSet resultSet = statement.executeQuery();

            // Kiểm tra xem có sinh viên nào được tìm thấy hay không
            if (resultSet.next()) {
                // Lấy thông tin của sinh viên từ kết quả truy vấn
                int teacherID = resultSet.getInt("TeacherID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String passwordHash = resultSet.getString("PasswordHash");
                boolean isTeaching = resultSet.getBoolean("isTeaching");
                // Create a Product object with the retrieved data
                teacher = new Teachers(teacherID, firstName, lastName, email, passwordHash, isTeaching);

            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return teacher;
    }

    public List<Teachers> Paging(List<Teachers> list, int pageParam, int size) {
        if (list.isEmpty()) {
            return list;
        }
        return list.subList((pageParam - 1) * size, size * pageParam >= list.size() ? list.size() : size * pageParam);
    }

    public Teachers get(int id) {

        try {
            String query = "select * from Teachers where TeacherID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return toTeacher(resultSet);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public ArrayList<Teachers> list() {
        ArrayList<Teachers> teachers = new ArrayList<>();
        try {
            String query = "select * from Teachers";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                teachers.add(toTeacher(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return teachers;
    }
    
    public List<Teachers> getAllTeacher1() {
         List<Teachers> teachers = new ArrayList<>();

        try {
            String query = "SELECT * FROM Teachers";
            PreparedStatement statement = connection.prepareStatement(query);         

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int teacherID = resultSet.getInt("TeacherID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String passwordHash = resultSet.getString("PasswordHash");
                boolean isTeaching = resultSet.getBoolean("isTeaching");
                // Create a Teacher object with the retrieved data
                Teachers teacher = new Teachers(teacherID, firstName, lastName, email, passwordHash, isTeaching);

                // Add the teacher to the list
                teachers.add(teacher);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return teachers;
    }
    /* 
    public static void main(String[] args) {
        TeacherDAO teacherDAO = new TeacherDAO();
        List<Teachers> teachersList = teacherDAO.getAllTeacher();
        
        if (!teachersList.isEmpty()) {
            // Print the email of the first teacher in the list
            System.out.println(teachersList.get(0).getEmail());
        } else {
            System.out.println("No teachers found.");
        }
    }
     */
}
