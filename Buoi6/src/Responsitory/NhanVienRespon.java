package Responsitory;

import java.util.ArrayList;
import model.NhanVien;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.JDBCHelper;

public class NhanVienRespon {

    public ArrayList<NhanVien> getAllNV() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            String sql = "SELECT MA,TEN,SDT,TRANGTHAI FROM NhanVien";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public NhanVien getNVByMa(String ma) {
        String sql = "SELECT MA,TEN,SDT,TRANGTHAI FROM NhanVien WHERE MA=?";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, ma);
            while (rs.next()) {
                return new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Integer addNV(NhanVien nv) {
        String sql = "INSERT INTO NHANVIEN(ID,MA,TEN,SDT,TRANGTHAI) VALUES(NEWID(),?,?,?,?)";
        int row = JDBCHelper.excuteUpdate(sql, nv.getMa(), nv.getTen(), nv.getSdt(), nv.getTrangThai());
        return row;
    }

    public Integer deleteNV(String ma) {
        String sql = "DELETE FROM NHANVIEN WHERE MA=?";
        int row = JDBCHelper.excuteUpdate(sql, ma);
        return row;
    }
}
