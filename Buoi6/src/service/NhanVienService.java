package service;

import java.util.ArrayList;
import model.NhanVien;

public interface NhanVienService {

    public ArrayList<NhanVien> getAllNV();

    public NhanVien getNVByMa(String ma);

    public Integer addNV(NhanVien nv);

    public Integer deleteNV(String ma);
}
