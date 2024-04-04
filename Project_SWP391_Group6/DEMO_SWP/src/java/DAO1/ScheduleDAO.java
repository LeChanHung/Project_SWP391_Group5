/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO1;

import Entity.timeSlots;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model1.Attendance;
import model1.Classes;
import model1.Schedule;
import model1.Subjects;
import model1.Teachers;

/**
 *
 * @author Hai Nam
 */
public class ScheduleDAO extends DBContext {

    public Schedule toSchedule(ResultSet rs) throws SQLException {
        Schedule schedule = new Schedule();
        schedule.setScheduleID(rs.getInt("ScheduleID"));
        ClassDAO dbClass = new ClassDAO();
        Classes classes = dbClass.get(rs.getInt("ClassID"));
        schedule.setClassID(classes);

        TeacherDAO dbTeacher = new TeacherDAO();
        Teachers tc = dbTeacher.get(rs.getInt("TeacherID"));
        schedule.setTeacherID(tc);

        SlotDAO dbSlot = new SlotDAO();
        timeSlots ts = dbSlot.get(rs.getInt("SlotID"));
        schedule.setSlot(ts);

        SubjectDAO dbSubject = new SubjectDAO();
        Subjects subjects = dbSubject.get(rs.getInt("SubjectID"));
        schedule.setSubjectID(subjects);

        schedule.setDayOfWeek(rs.getInt("DayOfWeek"));

        return schedule;
    }

    public Schedule toScheduleAttend(ResultSet rs) throws SQLException {
        Schedule schedule = new Schedule();
        schedule.setScheduleID(rs.getInt("ScheduleID"));
        ClassDAO dbClass = new ClassDAO();
        Classes classes = dbClass.get(rs.getInt("ClassID"));
        schedule.setClassID(classes);

        TeacherDAO dbTeacher = new TeacherDAO();
        Teachers tc = dbTeacher.get(rs.getInt("TeacherID"));
        schedule.setTeacherID(tc);

        SlotDAO dbSlot = new SlotDAO();
        timeSlots ts = dbSlot.get(rs.getInt("SlotID"));
        schedule.setSlot(ts);

        SubjectDAO dbSubject = new SubjectDAO();
        Subjects subjects = dbSubject.get(rs.getInt("SubjectID"));
        schedule.setSubjectID(subjects);

        Attendance attendance = new Attendance();
        attendance.setStatus(rs.getString("Status"));

        schedule.setAttendance(attendance);
        schedule.setStatus(rs.getInt("status"));
        schedule.setDayOfWeek(rs.getInt("DayOfWeek"));
        return schedule;
    }

    public Schedule toScheduleAttendID(ResultSet rs) throws SQLException {
        Schedule schedule = new Schedule();
        schedule.setScheduleID(rs.getInt("ScheduleID"));
        ClassDAO dbClass = new ClassDAO();
        Classes classes = dbClass.get(rs.getInt("ClassID"));
        schedule.setClassID(classes);

        TeacherDAO dbTeacher = new TeacherDAO();
        Teachers tc = dbTeacher.get(rs.getInt("TeacherID"));
        schedule.setTeacherID(tc);

        SlotDAO dbSlot = new SlotDAO();
        timeSlots ts = dbSlot.get(rs.getInt("SlotID"));
        schedule.setSlot(ts);

        SubjectDAO dbSubject = new SubjectDAO();
        Subjects subjects = dbSubject.get(rs.getInt("SubjectID"));
        schedule.setSubjectID(subjects);

        Attendance attendance = new Attendance();
        attendance.setStatus(rs.getString("Status"));
        attendance.setAttendanceID(rs.getInt("AttendanceID"));
        schedule.setAttendance(attendance);

        schedule.setDayOfWeek(rs.getInt("DayOfWeek"));

        return schedule;
    }

    public ArrayList<Schedule> list() {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            String query = "SELECT * FROM [WeeklySchedules]";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule schedule = toSchedule(rs);
                schedules.add(schedule);
            }
            return schedules;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schedules;
    }

    public ArrayList<Schedule> listSchedulesStudent(int studentID) {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            String query = """
                          SELECT distinct ws.[ScheduleID]
                                                              ,ws.[ClassID]
                                                              ,[TeacherID]
                                                              ,[SubjectID]
                                                              ,[DayOfWeek]
                                                              ,[SlotID],
                                                              a.[Status] 
                                                          FROM [WeeklySchedules] ws
                                                          inner join Classes c on c.ClassID = ws.ClassID
                                                          inner join StudentEnrollments se on se.ClassID = c.ClassID
                                                          inner join Students s on s.StudentID = se.StudentID
                                                          left join Attendance a on a.ScheduleID = ws.ScheduleID
                                                          where ws.ScheduleID in (
                            SELECT  distinct ws.[ScheduleID]
                                                            FROM [swp].[dbo].[WeeklySchedules] ws
                                                            inner join Classes c on c.ClassID = ws.ClassID
                                                          inner join StudentEnrollments se on se.ClassID = c.ClassID
                                                          inner join Students s on s.StudentID = se.StudentID
                                                          left join Attendance a on a.ScheduleID = ws.ScheduleID
                                                                                     where s.StudentID= ?) """;
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("count");
                Schedule schedule = toScheduleAttend(rs);
                schedules.add(schedule);
            }
            return schedules;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schedules;
    }

    public ArrayList<Schedule> listSchedulesTeacher(int teacherID) {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            String query = """
 SELECT [ScheduleID]
                      ,[ClassID]
                      ,[TeacherID]
                      ,[SubjectID]
                      ,[DayOfWeek]
                      ,[SlotID]
                      ,[StudentID]
                      ,[status]
                  FROM [WeeklySchedules]   where TeacherID = ?
                           """;
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, teacherID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule schedule = toScheduleAttend(rs);
                schedules.add(schedule);
            }
            return schedules;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schedules;
    }

    public ArrayList<Schedule> listSchedulesStuSub(int teacherID, int classId, int studentId, int subjectId) {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            String query = "SELECT ws.[ScheduleID]\n"
                    + "      ,ws.[ClassID]\n"
                    + "      ,[TeacherID]\n"
                    + "      ,[SubjectID]\n"
                    + "      ,[DayOfWeek]\n"
                    + "      ,[SlotID],\n"
                    + " [AttendanceID],\n"
                    + "	  a.Status\n"
                    + "  FROM [WeeklySchedules] ws\n"
                    + "  inner join Classes c on ws.ClassID = c.ClassID\n"
                    + "  inner join StudentEnrollments se on se.ClassID = c.ClassID\n"
                    + "  inner join Students s on s.StudentID = se.StudentID\n"
                    + "  left join Attendance a on a.ScheduleID = ws.ScheduleID and a.EnrollmentID = se.EnrollmentID\n"
                    + "  where se.StudentID = ? and se.ClassID = ? and TeacherID = ? and SubjectID = ?";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentId);
            ps.setInt(2, classId);
            ps.setInt(3, teacherID);
            ps.setInt(4, subjectId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule schedule = toScheduleAttendID(rs);
                schedules.add(schedule);
            }
            return schedules;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schedules;
    }

    public void updateSchedule(int scId, int status) {
        try {
            String query = "UPDATE [WeeklySchedules] set [status] = ? where ScheduleID = ?";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, status);
            ps.setInt(2, scId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Schedule> listSchedulesTeacher(int teacherID, java.sql.Date from, java.sql.Date to) {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            String query = """
 SELECT [ScheduleID]
                      ,[ClassID]
                      ,[TeacherID]
                      ,[SubjectID]
                      ,[DayOfWeek]
                      ,[SlotID]
                      ,[StudentID]
                      ,[status]
                  FROM [WeeklySchedules]   where TeacherID = ? and dateCreated between ? and ?
                           """;
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, teacherID);
            ps.setDate(2, from);
            ps.setDate(3, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule schedule = toScheduleAttend(rs);
                schedules.add(schedule);
            }
            return schedules;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schedules;
    }

    public ArrayList<Schedule> listSchedulesStudent(int studentID, java.sql.Date from, java.sql.Date to) {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            String query = """
                         SELECT  [ScheduleID]
                                ,ws.[ClassID]
                                ,[TeacherID]
                                ,[SubjectID]
                                ,[DayOfWeek]
                                ,[SlotID]
                                ,[status]
                                ,[dateCreated]
                            FROM [WeeklySchedules] ws
                            where ws.StudentID = ? and dateCreated between ? and ?""";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentID);
            ps.setDate(2, from);
            ps.setDate(3, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("count");
                Schedule schedule = toScheduleAttend(rs);
                schedules.add(schedule);
            }

            query = "SELECT [AttendanceID]\n"
                    + "      ,a.[EnrollmentID]\n"
                    + "      ,a.[ScheduleID]\n"
                    + "      ,[AttendanceDate]\n"
                    + "      ,a.[Status]\n"
                    + "  FROM [Attendance] a\n"
                    + "  right join WeeklySchedules ws on ws.ScheduleID = a.ScheduleID\n"
                    + "  inner join StudentEnrollments se on se.EnrollmentID = a.EnrollmentID\n"
                    + "  where se.StudentID = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, studentID);
            rs = ps.executeQuery();
            ArrayList<Attendance> attendances = new ArrayList<>();
            while(rs.next()){
                Attendance attendance = new Attendance();
                Schedule schedule = new Schedule();
                schedule.setScheduleID(rs.getInt("ScheduleID"));
                attendance.setSchedule(schedule);
                attendance.setStatus(rs.getString("Status"));
                attendances.add(attendance);
            }
            ArrayList<Schedule> newSchedules = new ArrayList<>();
            for (Schedule loopSchedule : schedules) {
                loopSchedule.setAttendance(new Attendance());
                for (Attendance loopAttendance : attendances) {
                   if(loopSchedule.getScheduleID() == 
                           loopAttendance.getSchedule().getScheduleID()){
                       loopSchedule.setAttendance(loopAttendance);
                       break;
                   }
                }
                newSchedules.add(loopSchedule);
            }
            return newSchedules;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schedules;
    }
    
     public boolean addWeeklySchedule(int classID, int teacherID, int subjectID, int studentID, int slotID, int dayofWeek, Date dateCreated) {
        try {
            // Create SQL query to insert a new student
            String query = "INSERT INTO WeeklySchedules(ClassID,TeacherID,SubjectID,DayOfWeek,SlotID,StudentID,dateCreated) VALUES (?, ?, ?, ?, ?, ?, ?)";

            // Create prepared statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters for the prepared statement
            statement.setInt(1, classID);
            statement.setInt(2, teacherID);
            statement.setInt(3, subjectID);
            statement.setInt(4, dayofWeek);
            statement.setInt(5, slotID);
            statement.setInt(6, studentID);
            statement.setDate(7, (java.sql.Date) dateCreated);
       
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
    

}
