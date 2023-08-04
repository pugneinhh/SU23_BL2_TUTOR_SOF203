/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Responsitory.NhanVienRespon;
import java.util.ArrayList;
import model.NhanVien;

/**
 *
 * @author Phanh
 */
public class NhanVienServiceImp implements NhanVienService {

    NhanVienRespon nvr = new NhanVienRespon();

    @Override
    public ArrayList<NhanVien> getAllNV() {
        return nvr.getAllNV();
    }
    
    @Override
    public NhanVien getNVByMa(String ma) {
        return nvr.getNVByMa(ma);
    }
    
    @Override
    public Integer addNV(NhanVien nv) {
        return nvr.addNV(nv);
    }
    
    @Override
    public Integer deleteNV(String ma) {
        return nvr.deleteNV(ma);
    }
    
}
