
package model;


public class NhanVien {
    //khai báo thuộc tính
    private String ma;
    private String ten;
    private String sdt;
    private int trangThai;
    //constructor

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String sdt, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }
    //getter and setter

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "ma=" + ma + ", ten=" + ten + ", sdt=" + sdt + ", trangThai=" + trangThai + '}';
    }
    
}
