/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Phanh
 */
public class CuaHangDAO {
    Connection con=DBConnect.getConnection();//kết nối
    ArrayList<CuaHang> list=new ArrayList<>();
    public ArrayList<CuaHang> getAll(){
        String query="SELECT * FROM CuaHang";//viết câu truy vấn
        try{
            PreparedStatement ps=con.prepareStatement(query);//tạo đối tượng preparedstatement
            ps.execute();
            ResultSet rs=ps.getResultSet();//khởi tạo đối tượng ResulSet
            while(rs.next()){//lấy dữ liệu từ đối tượng ResultSet
                String id=rs.getString("Id");
                String ma=rs.getString("Ma");
                String ten=rs.getString("Ten");
                String diaChi=rs.getString("DiaChi");
                String thanhPho=rs.getString("ThanhPho");
                String quocGia=rs.getString("QuocGia");
                CuaHang ch=new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);
                list.add(ch);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<CuaHang> getByMa(){
         String query="SELECT * FROM CuaHang where ma like ?";//viết câu truy vấn
         try{
            PreparedStatement ps=con.prepareStatement(query);//tạo đối tượng preparedstatement
            ps.setString(1, "CH%");//set gtri cho tham số hỏi chấm ?
            ps.execute();
            ResultSet rs=ps.getResultSet();//khởi tạo đối tượng ResulSet
            while(rs.next()){//lấy dữ liệu từ đối tượng ResultSet
                String id=rs.getString("Id");
                String ma=rs.getString("Ma");
                String ten=rs.getString("Ten");
                String diaChi=rs.getString("DiaChi");
                String thanhPho=rs.getString("ThanhPho");
                String quocGia=rs.getString("QuocGia");
                CuaHang ch=new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);
                list.add(ch);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
