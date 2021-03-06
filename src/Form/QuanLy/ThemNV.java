/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form.QuanLy;

import Code.KetNoi;
import Code.MaHoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hoang
 */
public class ThemNV extends javax.swing.JFrame {

    /**
     * Creates new form ThemNV
     */
    public ThemNV() {
        initComponents();
        loaiNhanVien();
    }

    // Hàm Tự Tạo Mã Nhân Viên Mới
    public String maNV(String chucVu) {
        Connection ketNoi = KetNoi.layKetNoi();
        String sql = "select * from NHAN_VIEN order by MaNV DESC";
        String maNVmoi = "";
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(6).equals(chucVu)) {
                    maNVmoi = rs.getString(1);
                    break;
                }
            }
            ps.close();
            ketNoi.close();
        } catch (SQLException e) {
            Logger.getLogger(ThemNV.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println(maNVmoi);
        if (Integer.parseInt(maNVmoi.substring(2)) < 10) {
            int maSo = Integer.parseInt(maNVmoi.substring(2)) + 1;
            String maChu = maNVmoi.substring(0, 2);
            maNVmoi = maChu + "0" + String.valueOf(maSo);
        } else {
            int maSo = Integer.parseInt(maNVmoi.substring(2)) + 1;
            String maChu = maNVmoi.substring(0, 2);
            maNVmoi = maChu + String.valueOf(maSo);
        }

        return maNVmoi;
    }

    //Hàm Lấy Loại Nhân Viên
    public void loaiNhanVien() {
        Connection ketNoi = KetNoi.layKetNoi();
        String sql = "select * from LOAI_NHAN_VIEN";

        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jComboBox_ChucVu.addItem(rs.getString(1) + " - " + rs.getString(2));
            }
            ketNoi.close();
        } catch (SQLException e) {
            Logger.getLogger(ThemNV.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void themTaiKhoan(String taiKhoan, String loaiTaiKhoan) {
        String mk=new MaHoa("123456").maHoa();
        Connection ketNoi = KetNoi.layKetNoi();
        String sql = "insert into TAI_KHOAN values (?,?,?)";

        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            ps.setString(2, mk);
            ps.setString(3, loaiTaiKhoan);
            ps.executeUpdate();
            ps.close();
            ketNoi.close();
        } catch (SQLException e) {
            Logger.getLogger(ThemNV.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean ktTaiKhoan(String taiKhoan) {
        boolean kt = true;
        Connection ketNoi = KetNoi.layKetNoi();
        String sql = "select * from TAI_KHOAN";

        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(taiKhoan)) {
                    kt = false;
                    JOptionPane.showMessageDialog(this, "Tài Khoản Đã Được Sử Dụng. Vui Lòng Chọn Tên Tài Khoản Khác");
                    break;
                }
            }
            ketNoi.close();
        } catch (SQLException e) {
            Logger.getLogger(ThemNV.class.getName()).log(Level.SEVERE, null, e);
        }
        return kt;
    }

    public void themNhanVien(String maNV, String hoTen, String CMND, String gioiTinh, String dienThoai, String chucVu, String taiKhoan) {
        Connection ketNoi = KetNoi.layKetNoi();
        String sql = "insert into NHAN_VIEN values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, maNV);
            ps.setString(2, hoTen);
            ps.setString(3, CMND);
            ps.setString(4, gioiTinh);
            ps.setString(5, dienThoai);
            ps.setString(6, chucVu);
            ps.setString(7, taiKhoan);
            ps.executeUpdate();

            ps.close();
            ketNoi.close();
            JOptionPane.showMessageDialog(this, "Thêm Nhân Viên Thành Công");
            JOptionPane.showMessageDialog(this, "Vui Lòng Đăng Nhập Vào Tài Khoản và Đổi Mật Khẩu Lại");
        } catch (SQLException e) {
            Logger.getLogger(ThemNV.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel_maNV = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_tenNV = new javax.swing.JTextField();
        jTextField_SDT = new javax.swing.JTextField();
        jTextField_CMND = new javax.swing.JTextField();
        jRadioButton_Nam = new javax.swing.JRadioButton();
        jRadioButton_Nu = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox_ChucVu = new javax.swing.JComboBox<>();
        jTextField_maNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_taiKhoan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel_maNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_maNV.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_maNV.setText("Mã Nhân Viên");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(500, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mã Nhân Viên :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tên Nhân Viên :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("CMND : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Chức Vụ : ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Điện Thoại : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Giới Tính :");

        jTextField_tenNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextField_SDT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextField_CMND.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        buttonGroup1.add(jRadioButton_Nam);
        jRadioButton_Nam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton_Nam.setText("Nam");

        buttonGroup1.add(jRadioButton_Nu);
        jRadioButton_Nu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton_Nu.setText("Nữ");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Quay lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox_ChucVu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_ChucVu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_ChucVuItemStateChanged(evt);
            }
        });
        jComboBox_ChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox_ChucVuMouseClicked(evt);
            }
        });

        jTextField_maNV.setEditable(false);
        jTextField_maNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_maNV.setForeground(new java.awt.Color(255, 51, 51));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Tài Khoản :");

        jTextField_taiKhoan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Mật Khẩu Được Đặt Mặc Định Là : 123456");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("Vui Lòng Đăng Nhập và Đổi Mật Khẩu Ngay");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_maNV))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton_Nam)
                                        .addGap(35, 35, 35)
                                        .addComponent(jRadioButton_Nu))
                                    .addComponent(jTextField_CMND, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField_taiKhoan))
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_taiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_CMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton_Nam)
                    .addComponent(jRadioButton_Nu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String maNV, hoTen, CMND, gioiTinh, dienThoai, chucVu, taiKhoan, loaiTaiKhoan;
        if (jTextField_tenNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Điền Tên Nhân Viên");
        } else if (jTextField_CMND.getText().isEmpty() || !jTextField_CMND.getText().matches("[0-9]{9,11}")) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Xem Lại CMND");
        } else if (!jRadioButton_Nu.isSelected() && !jRadioButton_Nam.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Giới Tính");
        } else if (!jTextField_SDT.getText().matches("0\\d{9,10}") || jTextField_SDT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Xem Lại SDT");
        } else if (jTextField_taiKhoan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Tài Khoản Muốn Tạo");
        } else if (jTextField_taiKhoan.getText().length() < 6) {
            JOptionPane.showMessageDialog(this, "Tài Khoản Không Được Ít Hơn 6 Ký Tự");
        } else {
            maNV = jTextField_maNV.getText();
            hoTen = jTextField_tenNV.getText();
            CMND = jTextField_CMND.getText();
            taiKhoan = jTextField_taiKhoan.getText();
            if (jRadioButton_Nam.isSelected()) {
                gioiTinh = jRadioButton_Nam.getText();
            } else {
                gioiTinh = jRadioButton_Nu.getText();
            }
            dienThoai = jTextField_SDT.getText();
            chucVu = jComboBox_ChucVu.getSelectedItem().toString();
            chucVu = chucVu.substring(0, chucVu.indexOf(" -"));
            if (chucVu.equals("AD")) {
                loaiTaiKhoan = "0";
            } else {
                loaiTaiKhoan = "1";
            }
            if (ktTaiKhoan(taiKhoan)) {
                themTaiKhoan(taiKhoan, loaiTaiKhoan);
                themNhanVien(maNV, hoTen, CMND, gioiTinh, dienThoai, chucVu, taiKhoan);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox_ChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_ChucVuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_ChucVuMouseClicked

    private void jComboBox_ChucVuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_ChucVuItemStateChanged
        // TODO add your handling code here:
        String maChucVu = jComboBox_ChucVu.getSelectedItem().toString();
        maChucVu = maChucVu.substring(0, maChucVu.indexOf(" -"));
        jTextField_maNV.setText(maNV(maChucVu));
    }//GEN-LAST:event_jComboBox_ChucVuItemStateChanged

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
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox_ChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_maNV;
    private javax.swing.JRadioButton jRadioButton_Nam;
    private javax.swing.JRadioButton jRadioButton_Nu;
    private javax.swing.JTextField jTextField_CMND;
    private javax.swing.JTextField jTextField_SDT;
    private javax.swing.JTextField jTextField_maNV;
    private javax.swing.JTextField jTextField_taiKhoan;
    private javax.swing.JTextField jTextField_tenNV;
    // End of variables declaration//GEN-END:variables
}
