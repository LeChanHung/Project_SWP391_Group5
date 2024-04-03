/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Duy Anh
 */
public class feedbacks {
        private int FeedbackID;
        private int StudentID;
        private int OfficeID;
        private String FeedbackText;
        private String FeedbackDate;
        private String FirstName;
        private String LastName;
        private String Email;
        

    public feedbacks() {
    }

    public feedbacks(int FeedbackID, int StudentID, int OfficeID, String FeedbackText, String FeedbackDate, String FirstName, String LastName, String Email) {
        this.FeedbackID = FeedbackID;
        this.StudentID = StudentID;
        this.OfficeID = OfficeID;
        this.FeedbackText = FeedbackText;
        this.FeedbackDate = FeedbackDate;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
    }

    public feedbacks(String FeedbackText, String FeedbackDate, String FirstName, String LastName, String Email) {
   
        this.FeedbackText = FeedbackText;
        this.FeedbackDate = FeedbackDate;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
    }

    

    public int getFeedbackID() {
        return FeedbackID;
    }

    public void setFeedbackID(int FeedbackID) {
        this.FeedbackID = FeedbackID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getOfficeID() {
        return OfficeID;
    }

    public void setOfficeID(int OfficeID) {
        this.OfficeID = OfficeID;
    }

    public String getFeedbackText() {
        return FeedbackText;
    }

    public void setFeedbackText(String FeedbackText) {
        this.FeedbackText = FeedbackText;
    }

    public String getFeedbackDate() {
        return FeedbackDate;
    }

    public void setFeedbackDate(String FeedbackDate) {
        this.FeedbackDate = FeedbackDate;
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

    @Override
    public String toString() {
        return "feedbacks{" + "FeedbackID=" + FeedbackID + ", StudentID=" + StudentID + ", OfficeID=" + OfficeID + ", FeedbackText=" + FeedbackText + ", FeedbackDate=" + FeedbackDate + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + '}';
    }

    
}
