/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

import Entity.timeSlots;

/**
 *
 * @author minhdang
 */
public class Report {
    private timeSlots slot;
    private Attendance attendance;

    public Report() {
    }

    public Report(timeSlots slot, Attendance attendance) {
        this.slot = slot;
        this.attendance = attendance;
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
