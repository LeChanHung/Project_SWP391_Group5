/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minhdang
 */
public class Teacher {
    private int TeacherId;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private int role;

    public Teacher() {
    }

    public Teacher(int TeacherId, String firstName, String lastName, String email, String passwordHash, int role) {
        this.TeacherId = TeacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(int TeacherId) {
        this.TeacherId = TeacherId;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    
}
