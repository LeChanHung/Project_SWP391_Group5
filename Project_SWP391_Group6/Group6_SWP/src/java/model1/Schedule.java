/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

import Entity.timeSlots;

/**
 *
 * @author Hai Nam
 */
public class Schedule {

    private int scheduleID;
    private Classes classID;
    private Teachers teacherID;
    private Subjects subjectID;
    private int dayOfWeek;
    private timeSlots slot;
    private Attendance attendance;

    public Schedule() {
    }

    public Schedule(int scheduleID, Classes classID, Teachers teacherID, Subjects subjectID, int dayOfWeek, timeSlots slot) {
        this.scheduleID = scheduleID;
        this.classID = classID;
        this.teacherID = teacherID;
        this.subjectID = subjectID;
        this.dayOfWeek = dayOfWeek;
        this.slot = slot;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Classes getClassID() {
        return classID;
    }

    public void setClassID(Classes classID) {
        this.classID = classID;
    }

    public Teachers getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Teachers teacherID) {
        this.teacherID = teacherID;
    }

    public Subjects getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Subjects subjectID) {
        this.subjectID = subjectID;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public timeSlots getSlot() {
        return slot;
    }

    public void setSlot(timeSlots slot) {
        this.slot = slot;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

}
