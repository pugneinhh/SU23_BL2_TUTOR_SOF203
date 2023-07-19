/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Phanh
 */
public class MuonSach {
    private String tenSV;
    private String boMon;
    private int gioiTinh;
    private String tenSach;

    public MuonSach() {
    }

    public MuonSach(String tenSV, String boMon, int gioiTinh, String tenSach) {
        this.tenSV = tenSV;
        this.boMon = boMon;
        this.gioiTinh = gioiTinh;
        this.tenSach = tenSach;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getBoMon() {
        return boMon;
    }

    public void setBoMon(String boMon) {
        this.boMon = boMon;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    @Override
    public String toString() {
        return "MuonSach{" + "tenSV=" + tenSV + ", boMon=" + boMon + ", gioiTinh=" + gioiTinh + ", tenSach=" + tenSach + '}';
    }
    
}
