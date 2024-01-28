/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author lecha
 */
public class admin {
    private int adminID;
    private String adEmail;
    private String adPassword;
    private int role_ID;

    public admin() {
    }

    public admin(int adminID, String adEmail, String adPassword, int role_ID) {
        this.adminID = adminID;
        this.adEmail = adEmail;
        this.adPassword = adPassword;
        this.role_ID = role_ID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdEmail() {
        return adEmail;
    }

    public void setAdEmail(String adEmail) {
        this.adEmail = adEmail;
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword;
    }

    public int getRole_ID() {
        return role_ID;
    }

    public void setRole_ID(int role_ID) {
        this.role_ID = role_ID;
    }
    
    
}
