/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Timestamp;

/**
 *
 * @author Duy Anh
 */
public class timeSlots {
    private int SlotID;
    private int SlotNumber;
    private Timestamp SlotStartTime;
     private Timestamp SlotEndTime;

    public timeSlots() {
    }

    public timeSlots(int SlotID, int SlotNumber, Timestamp SlotStartTime, Timestamp SlotEndTime) {
        this.SlotID = SlotID;
        this.SlotNumber = SlotNumber;
        this.SlotStartTime = SlotStartTime;
        this.SlotEndTime = SlotEndTime;
    }

    public int getSlotID() {
        return SlotID;
    }

    public void setSlotID(int SlotID) {
        this.SlotID = SlotID;
    }

    public int getSlotNumber() {
        return SlotNumber;
    }

    public void setSlotNumber(int SlotNumber) {
        this.SlotNumber = SlotNumber;
    }

    public Timestamp getSlotStartTime() {
        return SlotStartTime;
    }

    public void setSlotStartTime(Timestamp SlotStartTime) {
        this.SlotStartTime = SlotStartTime;
    }

    public Timestamp getSlotEndTime() {
        return SlotEndTime;
    }

    public void setSlotEndTime(Timestamp SlotEndTime) {
        this.SlotEndTime = SlotEndTime;
    }

    @Override
    public String toString() {
        return "timeSlots{" + "SlotID=" + SlotID + ", SlotNumber=" + SlotNumber + ", SlotStartTime=" + SlotStartTime + ", SlotEndTime=" + SlotEndTime + '}';
    }
     
}
