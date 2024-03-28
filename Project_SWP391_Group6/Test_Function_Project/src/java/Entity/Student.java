/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author lecha
 */
public class Student {
//    private int id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String PasswordHash;
    private String gender;
    private Date dob;
    private String MSV;

    public Student() {
    }

    public Student(String FirstName, String LastName, String Email, String PasswordHash, String gender, Date dob, String MSV) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.PasswordHash = PasswordHash;
        this.gender = gender;
        this.dob = dob;
        this.MSV = MSV;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMSV() {
        return MSV;
    }

    public void setMSV(String MSV) {
        this.MSV = MSV;
    }

    

    
    
    

    
    
}