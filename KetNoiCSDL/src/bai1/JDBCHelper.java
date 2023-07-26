/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;
import java.sql.*;
/**
 *
 * @author Phanh
 */
public class JDBCHelper {
    public static Integer excuteUpdate(String sql,Object ...args){
        Connection con=null;
        Integer row=0;
        PreparedStatement ps=null;
        try {
            con=DBConnect.getConnection();//tạo kết nối
            ps=con.prepareStatement(sql);//tạo ps
            //gán các giá trị cho các ? trong các câu lệnh sql
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            row=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
   
}
