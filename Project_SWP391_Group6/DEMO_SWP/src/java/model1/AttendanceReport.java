/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

/**
 *
 * @author admin
 */
public class AttendanceReport {
    private Students student;
    private Classes classes;
    private Subjects subject;
    private Teachers teacher;
    private String status;
    private float percent;

    public AttendanceReport() {
    }

    public AttendanceReport(Students student, Classes classes, Subjects subject, Teachers teacher, String status, float percent) {
        this.student = student;
        this.classes = classes;
        this.subject = subject;
        this.teacher = teacher;
        this.status = status;
        this.percent = percent;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }


    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    
    
}
