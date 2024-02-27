/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Duy Anh
 */
public class students {

    private int StudentID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String PasswordHash;
    private String gender;
    private String dob;
    private String MSV;

    public students() {
    }

    public students(int StudentID, String FirstName, String LastName, String Email, String PasswordHash, String gender, String dob, String MSV) {
        this.StudentID = StudentID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.PasswordHash = PasswordHash;
        this.gender = gender;
        this.dob = dob;
        this.MSV = MSV;
    }

    public students(int StudentID, String FirstName, String MSV) {
        this.StudentID = StudentID;
        this.FirstName = FirstName;
        this.MSV = MSV;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMSV() {
        return MSV;
    }

    public void setMSV(String MSV) {
        this.MSV = MSV;
    }

    @Override
    public String toString() {
        return "students{" + "StudentID=" + StudentID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", PasswordHash=" + PasswordHash + ", gender=" + gender + ", dob=" + dob + ", MSV=" + MSV + '}';
    }

}
