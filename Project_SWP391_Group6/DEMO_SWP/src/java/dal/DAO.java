/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import DAO1.DBContext;
import Entity.classes;
import Entity.timeSlots;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import model1.Attendance;
import model1.DetailClass;
import model1.Report;
import model1.Schedule;
import model1.Subjects;
import model1.Teachers;

/**
 *
 * @author minhdang
 */
public class DAO extends DBContext {

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

    public List<Report> stuReport(int StudentID, int status, int SubjectID) {
        List<Report> list = new ArrayList<>();
        String sql = """
                     SELECT ts.SlotNumber, a.AttendanceDate, ts.SlotStartTime, ts.SlotEndTime, a.Status
                                       FROM [Attendance] a
                                       inner join StudentEnrollments se on se.EnrollmentID = a.EnrollmentID
                                       inner join WeeklySchedules ws on ws.ScheduleID = a.ScheduleID
                                       inner join TimeSlots ts on ts.SlotID = ws.SlotID
                                       where se.StudentID = ? and ws.SubjectID = ?""";
        try {
            if (status == 1) {
                sql += " AND a.Status='Attend'";
            } else if (status == 2) {
                sql += " AND a.Status='Absent'";
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, StudentID);
            ps.setInt(2, SubjectID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Report r = new Report();
                timeSlots ts = new timeSlots();
                Attendance a = new Attendance();
                ts.setSlotNumber(rs.getInt("SlotNumber"));
                a.setAttendanceDate(rs.getDate("AttendanceDate"));
                ts.setSlotStartTime(rs.getTimestamp("SlotStartTime"));
                ts.setSlotEndTime(rs.getTimestamp("SlotEndTime"));
                a.setStatus(rs.getString("Status"));
                r.setAttendance(a);
                r.setSlot(ts);
                list.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int countSlots(int StudentID, int SubjectID) {
        String sql = """
                    SELECT COUNT(*) as 'cnt' FROM 
                                          WeeklySchedules ws 
                                         where StudentID = ? and ws.SubjectID = ?
                                         """;
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, StudentID);
            ps.setInt(2, SubjectID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("cnt");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public DetailClass detailSlot(String ScheduleID) {

        String sql = "select ws.ScheduleID, ts.SlotNumber,ts.SlotStartTime,ts.SlotEndTime,t.FirstName,t.LastName,sub.SubjectName,c.ClassName from WeeklySchedules ws \n"
                + "                join TimeSlots ts on ws.SlotID = ts.SlotID\n"
                + "                join Teachers t on ws.TeacherID = t.TeacherID\n"
                + "                join Subjects sub on ws.SubjectID = sub.SubjectID\n"
                + "                join Classes c on ws.ClassID = c.ClassID\n"
                + "                where ws.ScheduleID = ?";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ScheduleID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetailClass dc = new DetailClass();
                timeSlots ts = new timeSlots();
                Teachers t = new Teachers();
                Subjects sub = new Subjects();
                classes c = new classes();
                ts.setSlotNumber(rs.getInt("SlotNumber"));
                ts.setSlotStartTime(rs.getTimestamp("SlotStartTime"));
                ts.setSlotEndTime(rs.getTimestamp("SlotEndTime"));
                t.setFirstName(rs.getString("FirstName"));
                t.setLastName(rs.getString("LastName"));
                sub.setSubjectName(rs.getString("SubjectName"));
                c.setClassName(rs.getString("ClassName"));
                dc.setSlot(ts);
                dc.setTeacher(t);
                dc.setSubjects(sub);
                dc.setClasses(c);
                return dc;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;

    }

    public static void main(String[] args) {

        DAO dao = new DAO();

        DetailClass dc = dao.detailSlot("1");

        System.out.println("Slot Number: " + dc.getSlot().getSlotNumber());
        System.out.println("Slot Start Time: " + dc.getSlot().getSlotStartTime());
        System.out.println("Slot End Time: " + dc.getSlot().getSlotEndTime());
        System.out.println();

//        List<Report> resultList = dao.stuReport(16, 0);
//
//        for (Report r : resultList) {
//            System.out.println("Slot Number: " + r.getSlot().getSlotNumber());
//            System.out.println("Attendance Date: " + r.getAttendance().getAttendanceDate());
//            System.out.println("Slot Start Time: " + r.getSlot().getSlotStartTime());
//            System.out.println("Slot End Time: " + r.getSlot().getSlotEndTime());
//            System.out.println("Status: " + r.getAttendance().getStatus());
//            System.out.println();
//        }
    }
}
