/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form.NhanVien;

import Code.BanVeXe;
import Form.DangKyKhach;
import Form.DoiMatKhau;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author n18dc
 */
public class PnTTCaNhan extends javax.swing.JPanel {

    /**
     * Creates new form PnTTCaNhan
     */
    private JLabel lbAc;
    private JLabel lbName;
    public PnTTCaNhan(JLabel lb, JLabel lbName) {
        this.lbAc=lb;
        this.lbName=lbName;
        initComponents();
        loadThongTinNV();
        //quyenChinhSua();
    }


    private void setEdit(boolean trangThai){
        txtMaNV.setEditable(trangThai);
        txtTen.setEditable(trangThai);
        txtCMND.setEditable(trangThai);
        txtTK.setEditable(trangThai);
//        txtMK.setEditable(trangThai);
        txtSDT.setEditable(trangThai);
        rBtnNam1.setEnabled(trangThai);
        rBtnNu1.setEnabled(trangThai);
//        btnSeePass.setEnabled(!trangThai);
        btnDoiMatKhau.setVisible(trangThai);
    }
    

    
    private void loadThongTinNV(){
        Connection connect=Code.KetNoi.layKetNoi();
        String sql="SELECT CMND, GioiTinh, DienThoai, NV.MaLoaiNV, LNV.ChucVu FROM NHAN_VIEN NV,LOAI_NHAN_VIEN LNV WHERE MaNV='"+BanVeXe.primaryKey+"' AND NV.MaLoaiNV=LNV.MaLoaiNV";
        try {
            PreparedStatement ps=connect.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                txtMaNV.setText(BanVeXe.primaryKey);
                txtTen.setText(BanVeXe.hoTen);
                txtCMND.setText(rs.getString(1));
                if(rs.getString(2).equalsIgnoreCase("Nam")){rBtnNam1.setSelected(true);}
                txtSDT.setText(rs.getString(3));
                txtTK.setText(BanVeXe.Account);
                
            }
            rs.close();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            Logger.getLogger(PnTTCaNhan.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
   
    private void loadHieuChinhTT(String maNV, String ten, String CMND, String gioiTinh, String sdt, String taiKhoan){
        Connection connect=Code.KetNoi.layKetNoi();
        if(!taiKhoan.equals(BanVeXe.Account)){// ki???m tra th??ng tin t??i kho???n c?? kh??c hi???n t???i ko
            String sql="UPDATE TAI_KHOAN SET TaiKhoan=?WHERE TaiKhoan='"+BanVeXe.Account+"'";
            try {
                PreparedStatement ps=connect.prepareStatement(sql);
                ps.setString(1, taiKhoan);
                ps.executeUpdate();
                // dong ket noi
                ps.close();
            } catch (SQLException e) {
                Logger.getLogger(PnTTCaNhan.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        String sql2="UPDATE NHAN_VIEN SET HoTen=?, CMND=?, GioiTinh=?, DienThoai=? WHERE MaNV='"+maNV+"'";
        try {
            PreparedStatement ps=connect.prepareStatement(sql2);
            ps.setString(1, ten);
            ps.setString(2, CMND);
            ps.setString(3, gioiTinh);
            ps.setString(4, sdt);
            ps.executeUpdate();
            // dong ket noi
            ps.close();
            connect.close();
        } catch (SQLException e) {
            Logger.getLogger(PnTTCaNhan.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbThongBao = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtTK = new javax.swing.JTextField();
        rBtnNam1 = new javax.swing.JRadioButton();
        rBtnNu1 = new javax.swing.JRadioButton();
        btnChinhSua = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Th??ng tin c?? nh??n:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("Th??ng tin T??i Kho???n:");

        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("H??? T??n:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("S??T:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setText("Gi???i T??nh:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setText("T??n T??i Kho???n:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setText("M?? NV:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setText("CMND/CCCD:");

        lbThongBao.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbThongBao.setForeground(new java.awt.Color(0, 204, 0));
        lbThongBao.setText("Nh??n vi??n ch??? c?? quy???n ?????i m???t kh???u");
        lbThongBao.setVisible(false);

        txtMaNV.setEditable(false);
        txtMaNV.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        txtTen.setEditable(false);
        txtTen.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        txtCMND.setEditable(false);
        txtCMND.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        txtSDT.setEditable(false);
        txtSDT.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        txtTK.setEditable(false);
        txtTK.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        buttonGroup1.add(rBtnNam1);
        rBtnNam1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rBtnNam1.setText("Nam");
        rBtnNam1.setEnabled(false);

        buttonGroup1.add(rBtnNu1);
        rBtnNu1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rBtnNu1.setSelected(true);
        rBtnNu1.setText("N???");
        rBtnNu1.setEnabled(false);

        btnChinhSua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnChinhSua.setText("Ch???nh s???a");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnHuy.setText("H???y");
        btnHuy.setVisible(false);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDoiMatKhau.setText("?????i m???t kh???u");
        btnDoiMatKhau.setVisible(false);
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(466, 466, 466)
                .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rBtnNam1)
                                    .addGap(29, 29, 29)
                                    .addComponent(rBtnNu1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(13, 13, 13)
                                            .addComponent(jLabel23))
                                        .addComponent(jLabel17))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(32, 32, 32))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel22))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel14))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(166, 166, 166))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(lbThongBao))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDoiMatKhau)
                                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(172, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(463, 463, 463)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rBtnNam1)
                                        .addComponent(rBtnNu1)))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbThongBao)))
                .addGap(43, 43, 43)
                .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        // TODO add your handling code here:
        if(btnChinhSua.getText().equalsIgnoreCase("Ch???nh s???a")){//chuy???n qua ch???c n??ng ch???nh s???a
            btnChinhSua.setText("L??u");
            btnHuy.setVisible(true);
//            txtMK.setText(BanVeXe.pass);
            
            if(BanVeXe.quyen.equals("Nh??n vi??n")){
//                txtMK.setEditable(true);
                btnDoiMatKhau.setVisible(true);
                lbThongBao.setVisible(true);
//                btnSeePass.setEnabled(false);
            }else
            {
                setEdit(true);
            }
            
        }else{// chuy???n qua ch???c n??ng l??u
            
            // L??u c??c gi?? tr??? ch???nh s???a v??o bi???n
            String maNV=txtMaNV.getText();
            String ten=txtTen.getText();
            String gt=(rBtnNam1.isSelected())?"Nam":"N???";
            String cmnd=txtCMND.getText();
            String sdt=txtSDT.getText();
            String tk=txtTK.getText();
//            String mk=txtMK.getText();
            JPasswordField pass =new JPasswordField();
            pass.setText("123456");
            JLabel lb=new JLabel();
//            pass.setText(mk);
            
            //ki???m tra regex
            DangKyKhach ktLoi=new DangKyKhach();
            if(!ktLoi.ktLoi(txtTen, txtSDT, txtTK, pass, rBtnNam1, rBtnNu1, lb, lb, lb, lb, lb)){
                JOptionPane.showMessageDialog(this, "Vui l??ng xem l???i th??ng tin");
                return;
            }
            if (cmnd.isEmpty() || !cmnd.matches("[0-9]{9,11}")) {
                JOptionPane.showMessageDialog(this, "Vui L??ng Xem L???i CMND");
                return;
            }
            
            //Th???c hi???n ch???nh s???a
            loadHieuChinhTT(maNV, ten, cmnd, gt, sdt, tk);
            
            //Load l???i th??ng tin
            BanVeXe.setBanVeXe(tk, BanVeXe.pass, ten, gt, BanVeXe.quyen);
            lbAc.setText(tk);
            lbName.setText(ten);
            JOptionPane.showMessageDialog(this, "Hi???u ch???nh th??ng tin th??nh c??ng");
//            txtMK.setText("**********");
            btnChinhSua.setText("Ch???nh s???a");
            btnHuy.setVisible(false);
            setEdit(false);
            lbThongBao.setVisible(false);
            
        }
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        
        // ????a n??t "L??u" v??? tr???ng th??i "Ch???nh s???a"
        btnChinhSua.setText("Ch???nh s???a");
        
        // T???t n??t h???y
        btnHuy.setVisible(false);
        
//        // T???t hi???n th??? m???t kh???u
//        txtMK.setText("**********");
//        
        // T???t th??ng b??o
        lbThongBao.setVisible(false);
        
        // Kh??a c??c textField l???i
        setEdit(false);
        
        // Load l???i th??ng tin
        loadThongTinNV();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO add your handling code here:
        new DoiMatKhau(BanVeXe.Account).setVisible(true);
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnHuy;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JRadioButton rBtnNam1;
    private javax.swing.JRadioButton rBtnNu1;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
