/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhanvien;
import bai1.CuaHang;
import bai1.DBConnect;
import bai1.JDBCHelper;
import chucvu.ChucVu;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Phanh
 */
public class NhanVienDAO {
    Connection con=DBConnect.getConnection();
    public ArrayList<NhanVien> getALLNV(){
            ArrayList<NhanVien> listNV=new ArrayList<>();
            String sql="select * from nhanvien join CuaHang on CuaHang.Id=NhanVien.IdCH join ChucVu on ChucVu.id=NhanVien.IdCV";
            ResultSet rs=JDBCHelper.executeQuery(sql);
            try {
            while(rs.next()){
                ChucVu cv=new ChucVu(rs.getString(21), rs.getString(22), rs.getString(23));
                CuaHang ch=new CuaHang(rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20));
                NhanVien nv=new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), ch, cv, rs.getInt(14));
                listNV.add(nv);
            }
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listNV;
    }
    public NhanVien insertNV(NhanVien nv){
        String sql="INSERT INTO NHANVIEN(ID,MA,TEN,TENDEM,HO,GIOITINH,NGAYSINH,DIACHI,SDT,MATKHAU,TRANGTHAI,IDCH,IDCV) VALUES (NEWID(),?,?,?,?,?,?,?,?,?,?,?,?)";
        JDBCHelper.excuteUpdate(sql, nv.getMa(),nv.getTen(),nv.getTenDem(),nv.getHo(),nv.getGioiTinh(),nv.getNgaySinh(),nv.getDiaChi(),nv.getSdt(),nv.getMatKhau(),nv.getTrangThai(),nv.getCuaHang().getId(),nv.getChucVu().getId());
        return nv;
    }
    public NhanVien updateNV(NhanVien nv){
        String sql="UPDATE NHANVIEN SET MA=?,TEN=?,TENDEM=?,HO=?,GIOITINH=?,NGAYSINH=?,DIACHI=?,SDT=?,MATKHAU=?,TRANGTHAI=?,IDCH=?,IDCV=? WHERE ID=?";
        JDBCHelper.excuteUpdate(sql, nv.getMa(),nv.getTen(),nv.getTenDem(),nv.getHo(),nv.getGioiTinh(),nv.getNgaySinh(),nv.getDiaChi(),nv.getSdt(),nv.getMatKhau(),nv.getTrangThai(),nv.getCuaHang().getId(),nv.getChucVu().getId(),nv.getId());
        return nv;
    }
    public Integer deleteNV(String id){
        String sql="DELETE FROM NHANVIEN WHERE ID=?";
        int row=JDBCHelper.excuteUpdate(sql, id);
        return row;
    }
}
