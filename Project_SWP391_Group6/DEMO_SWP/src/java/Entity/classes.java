/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Duy Anh
 */
public class classes {
    private int ClassID;
    private String ClassName;

    public classes() {
    }

    public classes(int ClassID, String ClassName) {
        this.ClassID = ClassID;
        this.ClassName = ClassName;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int ClassID) {
        this.ClassID = ClassID;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    @Override
    public String toString() {
        return "classes{" + "ClassID=" + ClassID + ", ClassName=" + ClassName + '}';
    }
    
    
}
