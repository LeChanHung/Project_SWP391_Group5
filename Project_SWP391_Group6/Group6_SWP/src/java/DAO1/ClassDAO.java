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
import model1.Classes;

/**
 *
 * @author Hai Nam
 */
public class ClassDAO extends DBContext {

    public Classes toClasses(ResultSet rs) throws SQLException {
        Classes classes = new Classes();
        classes.setClassID(rs.getInt("ClassID"));
        classes.setClassName(rs.getString("ClassName"));
        return classes;
    }

    public Classes get(int id) {
        try {
            String query = "SELECT * FROM [Classes] where ClassID = ?";
//            conn = DBContext.getConnect();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               return toClasses(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
