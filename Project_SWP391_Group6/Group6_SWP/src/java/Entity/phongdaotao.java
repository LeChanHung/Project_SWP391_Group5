/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author lecha
 */
public class phongdaotao {
    private int systemUser_ID;
    private String systemUser_email;
    private String systemUser_password;
    private int role_ID;

    public phongdaotao() {
    }

    public phongdaotao(int systemUser_ID, String systemUser_email, String systemUser_password, int role_ID) {
        this.systemUser_ID = systemUser_ID;
        this.systemUser_email = systemUser_email;
        this.systemUser_password = systemUser_password;
        this.role_ID = role_ID;
    }

    public int getSystemUser_ID() {
        return systemUser_ID;
    }

    public void setSystemUser_ID(int systemUser_ID) {
        this.systemUser_ID = systemUser_ID;
    }

    public String getSystemUser_email() {
        return systemUser_email;
    }

    public void setSystemUser_email(String systemUser_email) {
        this.systemUser_email = systemUser_email;
    }

    public String getSystemUser_password() {
        return systemUser_password;
    }

    public void setSystemUser_password(String systemUser_password) {
        this.systemUser_password = systemUser_password;
    }

    public int getRole_ID() {
        return role_ID;
    }

    public void setRole_ID(int role_ID) {
        this.role_ID = role_ID;
    }
    
    
}
