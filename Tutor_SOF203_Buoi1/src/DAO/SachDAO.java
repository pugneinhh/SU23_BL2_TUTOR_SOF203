/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.MuonSach;
import java.util.ArrayList;

/**
 *
 * @author Phanh
 */
public class SachDAO {
    ArrayList<MuonSach> list=new ArrayList();
    public ArrayList<MuonSach> getAll(){
        return list;
    }
    public void addSach(MuonSach s){
        list.add(s);
    }
    public void deleteSach(int index){
        list.remove(index);
    }
}
