/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO1;

import Entity.timeSlots;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model1.TrainingOffice;

/**
 *
 * @author Hai Nam
 */
public class SlotDAO extends DBContext {

    public timeSlots toTimeSlots(ResultSet rs) throws SQLException {
        timeSlots ts = new timeSlots();
        ts.setSlotID(rs.getInt("SlotID"));
        ts.setSlotNumber(rs.getInt("SlotNumber"));
        ts.setSlotStartTime(rs.getTimestamp("SlotStartTime"));
        ts.setSlotEndTime(rs.getTimestamp("SlotEndTime"));
        return ts;
    }

    public ArrayList<timeSlots> list() {
        ArrayList<timeSlots> tList = new ArrayList<>();
        try {
            String query = "SELECT * FROM [TimeSlots]";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                timeSlots ts = toTimeSlots(rs);
                tList.add(ts);
            }
            return tList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tList;
    }
    
    public timeSlots get(int id) {
        try {
            String query = "SELECT * FROM [TimeSlots] where SlotID = ?";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               return toTimeSlots(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
