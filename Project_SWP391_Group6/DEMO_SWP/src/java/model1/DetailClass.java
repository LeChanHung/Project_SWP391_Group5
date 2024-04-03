/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

import Entity.classes;
import Entity.timeSlots;

/**
 *
 * @author minhdang
 */
public class DetailClass {
    private timeSlots slot;
    private Teachers teacher;
    private Subjects subjects;
    private classes classes;

    public DetailClass() {
    }

    public DetailClass(timeSlots slot, Teachers teacher, Subjects subjects, classes classes) {
        this.slot = slot;
        this.teacher = teacher;
        this.subjects = subjects;
        this.classes = classes;
    }

    public timeSlots getSlot() {
        return slot;
    }

    public void setSlot(timeSlots slot) {
        this.slot = slot;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public classes getClasses() {
        return classes;
    }

    public void setClasses(classes classes) {
        this.classes = classes;
    }
    
}