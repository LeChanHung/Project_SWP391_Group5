/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author Duy Anh
 */
public class student {
    private int id;
    private String name;
    private String email;
    private String password;
    private String msv;
    private String img;
    private Date dob;
    private String gender;
    private int class_id;
    public student() {
    }

    public student(int id, String name, String email, String password, String msv, String img, Date dob, String gender, int class_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.msv = msv;
        this.img = img;
        this.dob = dob;
        this.gender = gender;
        this.class_id = class_id;
    }

    
    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "student{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", msv=" + msv + ", img=" + img + ", dob=" + dob + ", gender=" + gender + ", class_id=" + class_id + '}';
    }

    public String getStudent_email() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    
}
