/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

import java.sql.Date;

/**
 *
 * @author Hai Nam
 */
public class Attendance {

    private int attendanceID;
    private int enrollmentID;
    private Schedule schedule;
    private Date attendanceDate;
    private String status;

    public Attendance() {
    }

    public Attendance(int attendanceID, int enrollmentID, Schedule schedule, Date attendanceDate, String status) {
        this.attendanceID = attendanceID;
        this.enrollmentID = enrollmentID;
        this.schedule = schedule;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }

    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
