/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

import java.util.Date;

/**
 *
 * @author lecha
 */
public class FeedBackTeacher {

    private int id;
    private int proRate;
    private int teachRate;
    private String comment;
    private Teachers teacherId;
    private Students studentId;
    private Subjects subjectId;
    private Date createdAt;
    
    public FeedBackTeacher() {
    }

    public FeedBackTeacher(int id, int proRate, int teachRate, String comment, Teachers teacherId, Students studentId, Subjects subjectId) {
        this.id = id;
        this.proRate = proRate;
        this.teachRate = teachRate;
        this.comment = comment;
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProRate() {
        return proRate;
    }

    public void setProRate(int proRate) {
        this.proRate = proRate;
    }

    public int getTeachRate() {
        return teachRate;
    }

    public void setTeachRate(int teachRate) {
        this.teachRate = teachRate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Teachers getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teachers teacherId) {
        this.teacherId = teacherId;
    }

    public Students getStudentId() {
        return studentId;
    }

    public void setStudentId(Students studentId) {
        this.studentId = studentId;
    }

    public Subjects getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subjects subjectId) {
        this.subjectId = subjectId;
    }

}
