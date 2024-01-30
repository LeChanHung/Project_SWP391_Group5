/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

/**
 *
 * @author admin
 */
public class Classes {
    private int classID;
    private String className;

    public Classes() {
        // Constructor mặc định
    }

    public Classes(int classID, String className) {
        this.classID = classID;
        this.className = className;
    }

    // Getter và Setter cho các thuộc tính

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
