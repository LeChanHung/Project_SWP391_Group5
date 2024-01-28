/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import Entity.*;

public class lessonDAO implements DAOInterface<lesson>{

    @Override
    public ArrayList<lesson> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public lesson selectById(lesson t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(lesson t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertAll(ArrayList<lesson> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(lesson t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteAll(ArrayList<lesson> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(lesson t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public lesson selectByStudent_ID(lesson t, student m){
        lesson result = null;
        try{
            Connection con = Entity.JDBCUtil.getConnection();
            String sql = """
                         SELECT lesson.lesson_name
                         FROM lesson
                         JOIN student ON lesson.student_id = student.student_id
                         WHERE student.student_email = ?""";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, m.getStudent_email());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                int lesson_id = rs.getInt("lesson_ID");
                String lesson_name = rs.getString("lesson_name");
                Date date = rs.getDate("date");
                result = new lesson(lesson_id, lesson_name, date);
            }
        }catch(SQLException e){
            
        }
        return result;
    }
}
