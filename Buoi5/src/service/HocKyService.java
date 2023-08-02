/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.HocKy;
import responsitory.HocKyResponsitory;

/**
 *
 * @author Phanh
 */
public class HocKyService {
    private final HocKyResponsitory hkr;

    public HocKyService() {
        this.hkr=new HocKyResponsitory();
    }
     public ArrayList<HocKy> getAllHK(){
         return hkr.getAllHK();
     }
     public Integer addHK(HocKy hk){
         return hkr.addHK(hk);
     }
     public Integer updateHK(HocKy hk){
         return hkr.updateHK(hk);
     }
     public Integer deleteHK(String id){
         return hkr.deleteHK(id);
     }
}
