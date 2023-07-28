/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chucvu;

import bai1.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phanh
 */
public class ChucVuDAO {
    public ArrayList<ChucVu> getAllChucVu(){
        ArrayList<ChucVu> list=new ArrayList<>();
        String sql="SELECT * FROM CHUCVU";
        ResultSet rs=JDBCHelper.executeQuery(sql);
        try {
            while(rs.next()){
                list.add(new ChucVu(rs.getString(1),rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public ChucVu getCVByID(String id){
        
        String sql="SELECT * FROM CHUCVU WHERE ID=?";
        ResultSet rs=JDBCHelper.executeQuery(sql,id);
        try {
            while(rs.next()){
                return new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return null;
    }
}
