/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import java.util.ArrayList;
import model.HocKy;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.JDBCHelper;
/**
 *
 * @author Phanh
 */
public class HocKyResponsitory {
    public ArrayList<HocKy> getAllHK(){
        ArrayList<HocKy> list=new ArrayList<>();
        try {
            
            String sql="SELECT id,ten,co_so,so_sv_nhap_hoc from hoc_ky";
            ResultSet rs=JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(new HocKy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HocKyResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public Integer addHK(HocKy hk){
        String sql="INSERT INTO hoc_ky(ten, co_so,so_sv_nhap_hoc) VALUES ( ?, ?, ?)";
        int row=JDBCHelper.excuteUpdate(sql, hk.getTen(),hk.getCoSo(),hk.getSoSV());
        return row;
    }
    public Integer updateHK(HocKy hk){
        String sql="UPDATE hoc_ky SET ten=?,co_so=?,so_sv_nhap_hoc=? WHERE id=?";
        int row=JDBCHelper.excuteUpdate(sql, hk.getTen(),hk.getCoSo(),hk.getSoSV(),hk.getId());
        return row;
    }
    public Integer deleteHK(String id){
        String sql="DELETE FROM hoc_ky WHERE id=?";
        int row=JDBCHelper.excuteUpdate(sql, id);
        return row;
    }
}
