
package model;

public class HocKy {
    //thuộc tính private
    private int id;
    private String ten;
    private String coSo;
    private int soSV;
    //constructor không tham số và đầy đủ tham số
    public HocKy() {
    }

    public HocKy(int id, String ten, String coSo, int soSV) {
        this.id = id;
        this.ten = ten;
        this.coSo = coSo;
        this.soSV = soSV;
    }

    public HocKy(String ten, String coSo, int soSV) {
        this.ten = ten;
        this.coSo = coSo;
        this.soSV = soSV;
    }
    
    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCoSo() {
        return coSo;
    }

    public void setCoSo(String coSo) {
        this.coSo = coSo;
    }

    public int getSoSV() {
        return soSV;
    }

    public void setSoSV(int soSV) {
        this.soSV = soSV;
    }
    //toString
    @Override
    public String toString() {
        return "HocKy{" + "id=" + id + ", ten=" + ten + ", coSo=" + coSo + ", soSV=" + soSV + '}';
    }
    
}
