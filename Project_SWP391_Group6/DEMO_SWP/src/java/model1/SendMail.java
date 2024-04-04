/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

/**
 *
 * @author admin
 */
public class SendMail {
    private int id;
    private String email;
    private float percent;

    public SendMail() {
    }

    public SendMail(int id, String email, float percent) {
        this.id = id;
        this.email = email;
        this.percent = percent;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
    
    
}
