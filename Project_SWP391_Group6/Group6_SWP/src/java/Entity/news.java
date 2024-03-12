/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Duy Anh
 */
public class news {
    private int NewID;
    private String img;
    private String title;
    private String content;
    private int OfficeID;
    private String date;
    public news() {
    }

    public news( int NewID,String img, String title, String content,String date) {
        this.NewID = NewID;
        this.img = img;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getNewID() {
        return NewID;
    }

    public void setNewID(int NewID) {
        this.NewID = NewID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOfficeID() {
        return OfficeID;
    }

    public void setOfficeID(int OfficeID) {
        this.OfficeID = OfficeID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return "news{" + "NewID=" + NewID + ", img=" + img + ", title=" + title + ", content=" + content + ", OfficeID=" + OfficeID + '}';
    }
    
    
    
}
