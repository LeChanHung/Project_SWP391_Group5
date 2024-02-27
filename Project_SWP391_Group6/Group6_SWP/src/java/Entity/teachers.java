/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Duy Anh
 */
public class teachers {

    private int TeacherID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String PasswordHash;

    public teachers() {
    }

    public teachers(int TeacherID, String FirstName, String LastName, String Email, String PasswordHash) {
        this.TeacherID = TeacherID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.PasswordHash = PasswordHash;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    @Override
    public String toString() {
        return "teachers{" + "TeacherID=" + TeacherID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", PasswordHash=" + PasswordHash + '}';
    }
    
    
}
