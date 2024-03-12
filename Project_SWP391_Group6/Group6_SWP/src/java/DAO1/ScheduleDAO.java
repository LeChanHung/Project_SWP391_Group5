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
                           SELECT ws.[ScheduleID]
                                 ,ws.[ClassID]
                                 ,[TeacherID]
                                 ,[SubjectID]
                                 ,[DayOfWeek]
                                 ,[SlotID],
                                 a.[Status] 
                             FROM [swp].[dbo].[WeeklySchedules] ws
                             inner join Classes c on c.ClassID = ws.ClassID
                             inner join StudentEnrollments se on se.ClassID = c.ClassID
                             inner join Students s on s.StudentID = se.StudentID
                             left join Attendance a on a.ScheduleID = ws.ScheduleID
                             where s.StudentID = ?""";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentID);
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

    public ArrayList<Schedule> listSchedulesTeacher(int teacherID) {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            String query = """
                           SELECT  distinct ws.[ScheduleID]
                                                            ,ws.[ClassID]
                                                            ,ws.[TeacherID]
                                                            ,[SubjectID]
                                                            ,[DayOfWeek]
                                                            ,[SlotID],
                           								 'Attend' as 'Status'
                                                        FROM [swp].[dbo].[WeeklySchedules] ws
                                                        inner join Teachers t on ws.TeacherID = t.TeacherID
                                                      left join Attendance a on a.ScheduleID = ws.ScheduleID
                                                        where ws.[ScheduleID] in (
                           							 SELECT  distinct ws.[ScheduleID]
                                                        FROM [swp].[dbo].[WeeklySchedules] ws
                                                        inner join Teachers t on ws.TeacherID = t.TeacherID
                                                      left join Attendance a on a.ScheduleID = ws.ScheduleID
                                                        where ws.TeacherID = ?)
                           
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
                    +" [AttendanceID],\n"
                    + "	  a.Status\n"
                    + "  FROM [swp].[dbo].[WeeklySchedules] ws\n"
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
}
