/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class Students {

    /*
    [StudentID] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [varchar](50) NULL,
	[LastName] [varchar](50) NULL,
	[Email] [varchar](255) NULL,
	[PasswordHash] [varchar](255) NULL,
	[dob] [date] NULL,
	[gender] [nvarchar](50) NULL,
	[MSV] [nvarchar](20) NULL,
     */

    private int studentID;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private Date dob;
    private String gender;
    private String MSV;
    private int status;
    List<Classes> listC;

    public Students() {
    }

    public Students(int studentID, String firstName, String lastName, String email, String passwordHash, Date dob, String gender, String MSV) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.dob = dob;
        this.gender = gender;
        this.MSV = MSV;
    }
    public Students(int studentID, String firstName, String lastName, String MSV, String email, String gender,java.sql.Date dob) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.MSV = MSV;
        this.email = email;
        this.gender = gender;
        this.dob = dob;  
    }

    public Students(int studentID, String firstName, String lastName, String email, String passwordHash, java.sql.Date dob, String gender,
            String MSV, int status) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.dob = dob;
        this.gender = gender;
        this.MSV = MSV;
        this.status = status;
    }

    public Students(int studentID, String firstName, String lastName, String MSV) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.MSV = MSV;

    }
      public Students(int studentID, String MSV) {
        this.studentID = studentID;
        this.MSV = MSV;
    }

    public List<Classes> getListC() {
        return listC;
    }

    public void setListC(List<Classes> listC) {
        this.listC = listC;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMSV() {
        return MSV;
    }

    public void setMSV(String MSV) {
        this.MSV = MSV;
    }

}
