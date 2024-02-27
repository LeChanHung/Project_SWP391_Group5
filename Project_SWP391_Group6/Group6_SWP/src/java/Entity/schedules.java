/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Duy Anh
 */
public class schedules {
    private int SubjectID;
    private String SubjectName;
    private String Fullname;
    private String ClassName;
    private String DayOfWeak;

    public schedules() {
    }

    public schedules(int SubjectID, String SubjectName, String Fullname, String ClassName, String DayOfWeak) {
        this.SubjectID = SubjectID;
        this.SubjectName = SubjectName;
        this.Fullname = Fullname;
        this.ClassName = ClassName;
        this.DayOfWeak = DayOfWeak;
    }

    

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public String getDayOfWeak() {
        return DayOfWeak;
    }

    public void setDayOfWeak(String DayOfWeak) {
        this.DayOfWeak = DayOfWeak;
    }

    @Override
    public String toString() {
        return "schedules{" + "SubjectID=" + SubjectID + ", SubjectName=" + SubjectName + ", Fullname=" + Fullname + ", ClassName=" + ClassName + ", DayOfWeak=" + DayOfWeak + '}';
    }

    
    
}
