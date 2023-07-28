/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nhanvien;

import bai1.CuaHang;
import bai1.CuaHangDAO;
import chucvu.ChucVu;
import chucvu.ChucVuDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phanh
 */
public class QLyNhanVien extends javax.swing.JFrame {
       NhanVienDAO nvd=new NhanVienDAO();
       chucvu.ChucVuDAO cvd=new ChucVuDAO();
       CuaHangDAO chd=new CuaHangDAO();
       DefaultTableModel dtm=new DefaultTableModel();
       DefaultComboBoxModel<chucvu.ChucVu> dcmCV=new DefaultComboBoxModel<>();
       DefaultComboBoxModel<CuaHang> dcmCH=new DefaultComboBoxModel<>();
       
    /**
     * Creates new form QLyNhanVien
     */
    public QLyNhanVien() {
        initComponents();
        dtm=(DefaultTableModel) tblBang.getModel();
        cbbChucVu.setModel((DefaultComboBoxModel)dcmCV);
        cbbCuaHang.setModel((DefaultComboBoxModel)dcmCH);
        loadTable();
        loadcbbCV();
        loadcbbCH();
    }
    public void loadTable(){
        dtm.setRowCount(0);
        ArrayList<NhanVien> list=nvd.getALLNV();
        for (NhanVien o : list) {
            Object[] rowData={
                o.getId(),
                o.getMa(),
                o.getTen(),
                o.getTenDem(),
                o.getHo(),
                o.getGioiTinh(),
                o.getNgaySinh(),
                o.getDiaChi(),
                o.getSdt(),
                o.getMatKhau(),
                o.getCuaHang().getTen(),
                o.getChucVu().getTen(),
                o.getTrangThai()==0?"Đi làm":"Nghỉ làm"
            };
            dtm.addRow(rowData);
        }
    }
    public void loadcbbCV(){
        ArrayList<chucvu.ChucVu> listCV=cvd.getAllChucVu();
        for (ChucVu o : listCV) {
            dcmCV.addElement(new ChucVu(o.getId(), o.getMa(), o.getTen()));
        }
    }
    public void loadcbbCH(){
        ArrayList<CuaHang> listCH=chd.getAll();
        for (CuaHang o : listCH) {
            dcmCH.addElement(new CuaHang(o.getId(), o.getMa(), o.getTen(), o.getDiaChi(), o.getThanhPho(), o.getQuocGia()));
        }
    }
    public void clearForm(){
        txtMa.setText("");
        txtID.setText("");
        txtTen.setText("");
        txtTenDem.setText("");
        txtHo.setText("");
        txtNSinh.setText("");
        txtDChi.setText("");
        txtSDT.setText("");
        txtMk.setText("");
        rdoNam.setSelected(true);
        rdoDiLam.setSelected(true);
    }
    public NhanVien getFormData(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
           try {
               date=sdf.parse(txtNSinh.getText());
           } catch (ParseException ex) {
               Logger.getLogger(QLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
           }
        String ma=txtMa.getText().trim();
        String ten=txtTen.getText().trim();
        String tenDem=txtTenDem.getText().trim();
        String ho=txtHo.getText().trim();
        String ngaySinh=txtNSinh.getText().trim();
        String diaChi=txtDChi.getText().trim();
        String sdt=txtSDT.getText().trim();
        String mk=txtMk.getText().trim();
        String gt=rdoNam.isSelected()==true?"Nam":"Nữ";//check xem radio nam có được chọn hay không? nếu được chọn => trả về "Nam",nếu không trả về "Nữ"
        int tt=rdoDiLam.isSelected()==true?0:1;
        CuaHang ch=(CuaHang) cbbCuaHang.getModel().getSelectedItem();
        ChucVu cv=(ChucVu) cbbChucVu.getModel().getSelectedItem();
        if(ma.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            txtMa.requestFocus();
            return null;
        }
        if(ten.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            txtTen.requestFocus();
            return null;
        }
        if(tenDem.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            txtTenDem.requestFocus();
            return null;
        }
        if(ma.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            txtMa.requestFocus();
            return null;
        }
        if(ho.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            txtHo.requestFocus();
            return null;
        }
        if(ngaySinh.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            txtNSinh.requestFocus();
            return null;
        }else{
            
            try {
             Date d = sdf.parse(txtNSinh.getText());
            } catch (ParseException ex) {
               ex.printStackTrace();
               JOptionPane.showMessageDialog(this, "Sai định dạng ngày sinh");
               txtNSinh.requestFocus();
               return null;
            } 
        }
        if(diaChi.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            txtDChi.requestFocus();
            return null;
        }
        if(sdt.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            txtSDT.requestFocus();
            return null;
        }else{
            String ktsdt="0\\d{9}";
            if(txtSDT.getText().trim().matches(ktsdt)==false){
                JOptionPane.showMessageDialog(this, "Sai định dạng số điện thoại");
                txtSDT.requestFocus();
                return null;
            }
        }
        if(mk.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            txtMk.requestFocus();
            return null;
        }
        NhanVien nv=new NhanVien(null, ma, ten, tenDem, ho, gt, date, diaChi, sdt, mk, ch, cv, tt);
        return nv;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupGT = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenDem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtNSinh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDChi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMk = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbbCuaHang = new javax.swing.JComboBox<>();
        cbbChucVu = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rdoDiLam = new javax.swing.JRadioButton();
        rdoNghi = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IDNV", "Mã NV", "Tên", "Tên đệm", "Họ", "giới tính", "ngày sinh", "địa chỉ", "sdt", "mật khẩu", "cửa hàng", "chức vụ", "trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Quản Lý Nhân Viên");

        jLabel2.setText("ID");

        jLabel3.setText("Mã");

        jLabel4.setText("Tên");

        jLabel5.setText("Tên Đệm");

        jLabel6.setText("Họ");

        jLabel7.setText("giới tính");

        groupGT.add(rdoNam);
        rdoNam.setText("Nam");

        groupGT.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel8.setText("Ngày sinh");

        jLabel9.setText("Địa chỉ");

        jLabel10.setText("SDT");

        jLabel11.setText("Mật khẩu");

        jLabel12.setText("Cửa hàng");

        jLabel13.setText("Chức vụ");

        jLabel14.setText("Trạng thái");

        buttonGroup1.add(rdoDiLam);
        rdoDiLam.setText("Đi làm");

        buttonGroup1.add(rdoNghi);
        rdoNghi.setText("Nghỉ làm");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");

        btnXoa.setText("Xóa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(125, 125, 125)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(3, 3, 3)
                                        .addComponent(txtNSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDChi, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMk, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbbCuaHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoDiLam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel7)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnThem)
                                        .addGap(73, 73, 73)
                                        .addComponent(btnSua))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnXoa)
                                .addGap(221, 221, 221)))
                        .addGap(0, 201, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtDChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtMk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbbCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(rdoDiLam)
                    .addComponent(rdoNghi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        NhanVien nv=getFormData();
        if(nv==null){
            return;
        }
        if(nvd.insertNV(nv)!=null){
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTable();
            clearForm();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
       int row=tblBang.getSelectedRow();
       if(row<0){
           return;
       }
       txtID.setText(tblBang.getValueAt(row, 0).toString());
       txtMa.setText(tblBang.getValueAt(row, 1).toString());
       txtTen.setText(tblBang.getValueAt(row, 2).toString());
       txtTenDem.setText(tblBang.getValueAt(row, 3).toString());
       txtHo.setText(tblBang.getValueAt(row, 4).toString());
       txtNSinh.setText(tblBang.getValueAt(row, 6).toString());
       txtDChi.setText(tblBang.getValueAt(row, 7).toString());
       txtSDT.setText(tblBang.getValueAt(row, 8).toString());
       txtMk.setText(tblBang.getValueAt(row, 9).toString());
       String gt=tblBang.getValueAt(row, 5).toString();
       if(gt.equalsIgnoreCase("Nam")){//kiểm tra xem gt ở bảng nếu trùng với Nam thì tích chọn vào rdoNam
           rdoNam.setSelected(true);
       }else{
           rdoNu.setSelected(true);
       }
      
       dcmCH.setSelectedItem(getByTen( tblBang.getValueAt(row, 10).toString()));
       dcmCV.setSelectedItem(getByCV(tblBang.getValueAt(row, 11).toString()));
       String tt=tblBang.getValueAt(row, 12).toString();
       if(tt.equalsIgnoreCase("Đi làm")){
           rdoDiLam.setSelected(true);
       }else{
           rdoNghi.setSelected(true);
       }
    }//GEN-LAST:event_tblBangMouseClicked
    public CuaHang getByTen(String ten){
        
        ArrayList<CuaHang> listCH=chd.getAll();
        for (CuaHang o : listCH) {
            if(o.getTen().equals(ten)){
                return new CuaHang(o.getId(), o.getMa(), o.getTen(), o.getDiaChi(), o.getThanhPho(), o.getQuocGia());
            }
        }
        return null;
    }
    public ChucVu getByCV(String ten){
        ArrayList<ChucVu> list=cvd.getAllChucVu();
        for (ChucVu o : list) {
            if(o.getTen().equals(ten)){
                return new ChucVu(o.getId(), o.getMa(), o.getTen());
            }
        }
        return null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbCuaHang;
    private javax.swing.ButtonGroup groupGT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoDiLam;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNghi;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtDChi;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMk;
    private javax.swing.JTextField txtNSinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDem;
    // End of variables declaration//GEN-END:variables
}
