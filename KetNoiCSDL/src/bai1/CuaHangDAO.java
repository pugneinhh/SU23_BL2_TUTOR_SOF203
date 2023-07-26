/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phanh
 */
public class CuaHangDAO {

    Connection con = DBConnect.getConnection();//kết nối
    ArrayList<CuaHang> list = new ArrayList<>();

    public ArrayList<CuaHang> getAll() {
        String query = "SELECT * FROM CuaHang";//viết câu truy vấn
        try {
            PreparedStatement ps = con.prepareStatement(query);//tạo đối tượng preparedstatement
            ps.execute();
            ResultSet rs = ps.getResultSet();//khởi tạo đối tượng ResulSet
            while (rs.next()) {//lấy dữ liệu từ đối tượng ResultSet
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String diaChi = rs.getString("DiaChi");
                String thanhPho = rs.getString("ThanhPho");
                String quocGia = rs.getString("QuocGia");
                CuaHang ch = new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);
                list.add(ch);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<CuaHang> getByMa() {
        String query = "SELECT * FROM CuaHang where ma like ?";//viết câu truy vấn
        try {
            PreparedStatement ps = con.prepareStatement(query);//tạo đối tượng preparedstatement
            ps.setString(1, "CH%");//set gtri cho tham số hỏi chấm ?
            ps.execute();
            ResultSet rs = ps.getResultSet();//khởi tạo đối tượng ResulSet
            while (rs.next()) {//lấy dữ liệu từ đối tượng ResultSet
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String diaChi = rs.getString("DiaChi");
                String thanhPho = rs.getString("ThanhPho");
                String quocGia = rs.getString("QuocGia");
                CuaHang ch = new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);
                list.add(ch);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//    public CuaHang insertCH(CuaHang ch){
//        try {
//            String sql="INSERT INTO CUAHANG VALUES(NEWID(),?,?,?,?,?)";//viết câu truy vấn
//            JDBCHelper.excuteUpdate(sql, ch.getMa(),ch.getTen(),ch.getDiaChi(),ch.getThanhPho(),ch.getQuocGia());
//            return ch;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }

    public Integer insertCH(CuaHang ch) {
        Integer row = 0;
        try {
            String sql = "INSERT INTO CUAHANG VALUES(NEWID(),?,?,?,?,?)";//viết câu truy vấn
            PreparedStatement ps = con.prepareStatement(sql);//tạo đối tượng preparedstatement
            ps.setString(1, ch.getMa());
            ps.setString(2, ch.getTen());
            ps.setString(3, ch.getDiaChi());
            ps.setString(4, ch.getThanhPho());
            ps.setString(5, ch.getQuocGia());
            row = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
    }

    public CuaHang updateCH(CuaHang ch) {
        String sql = "UPDATE CUAHANG SET MA=?, TEN=?,DIACHI=?,THANHPHO=?,QUOCGIA=? WHERE ID=?";//viết câu truy vấn
        JDBCHelper.excuteUpdate(sql, ch.getMa(), ch.getTen(), ch.getDiaChi(), ch.getThanhPho(), ch.getQuocGia(),ch.getId());
        return ch;
    }
    public Integer deleteCH(String id){
        String sql="DELETE FROM CUAHANG WHERE ID=?";
        int row=JDBCHelper.excuteUpdate(sql, id);
        return row;
    }
}
