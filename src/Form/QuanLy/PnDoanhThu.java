/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form.QuanLy;

import Code.KetNoi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author n18dc
 */
public class PnDoanhThu extends javax.swing.JPanel {

    /**
     * Creates new form PnDoanhThu
     */
    public PnDoanhThu() {
        initComponents();
    }

    public boolean kiemTraNgay(String ngaybd, String thangbd, String nambd, String ngaykt, String thangkt, String namkt, String ngayht, String thanght, String namht) {
        if (Integer.parseInt(namht) > Integer.parseInt(nambd) && Integer.parseInt(namht) < Integer.parseInt(namkt)) {
            return true;
        } else if (Integer.parseInt(namht) == Integer.parseInt(nambd) && Integer.parseInt(namht) < Integer.parseInt(namkt)) {
            if (Integer.parseInt(thanght) >= Integer.parseInt(thangbd)) {
                if (Integer.parseInt(ngayht) >= Integer.parseInt(ngaybd)) {
                    return true;
                }
            }
        } else if ((Integer.parseInt(namht) > Integer.parseInt(nambd) && Integer.parseInt(namht) == Integer.parseInt(namkt)) || (Integer.parseInt(namht) == Integer.parseInt(nambd) && Integer.parseInt(namht) == Integer.parseInt(namkt))) {
            if (Integer.parseInt(thanght) < Integer.parseInt(thangkt)) {
                return true;
            } else if (Integer.parseInt(thanght) == Integer.parseInt(thangkt)) {
                if (Integer.parseInt(ngayht) <= Integer.parseInt(ngaykt)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void doanhThu(String ngaybd, String thangbd, String nambd, String ngaykt, String thangkt, String namkt) {
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.setNumRows(0);
        Connection ketNoi = KetNoi.layKetNoi();
        String sql = "select * from VE_XE";
        int sum = 0;
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(7).equals("1")) {
                    String ngayht = rs.getString(5).substring(0, 2);
                    String thanght = rs.getString(5).substring(3, 5);
                    String namht = rs.getString(5).substring(6, 10);
                    if (kiemTraNgay(ngaybd, thangbd, nambd, ngaykt, thangkt, namkt, ngayht, thanght, namht)) {
                        vt = new Vector();
                        vt.add(rs.getString(1)); // lấy dữ liệu ở cột 1
                        vt.add(rs.getString(3)); // lấy dữ liệu ở cột 3
                        vt.add(rs.getString(4)); // lấy dữ liệu ở cột 4
                        vt.add(rs.getString(5)); // lấy dữ liệu ở cột 5
                        vt.add(rs.getString(6)); // lấy dữ liệu ở cột 6
                        vt.add(rs.getString(7)); // lấy dữ liệu ở cột 7
                        sum += Integer.parseInt(rs.getString(4));
                        dtm.addRow(vt);
                    }
                    System.err.println("==================");
                }
            }
            jLabel_DoanhThu.setText(String.valueOf(sum));
            jTable2.setModel(dtm);
        } catch (SQLException e) {
            Logger.getLogger(PnDoanhThu.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jComboBox_thangBatDau = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_thangKetThuc = new javax.swing.JComboBox<>();
        jLabel_DoanhThu = new javax.swing.JLabel();
        jComboBox_ngayKetThuc = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox_namBatDau = new javax.swing.JComboBox<>();
        jButton_Xem = new javax.swing.JButton();
        jComboBox_namKetThuc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_ngayBatDau = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("/");

        jComboBox_thangBatDau.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jComboBox_thangBatDau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jComboBox_thangBatDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_thangBatDauActionPerformed(evt);
            }
        });

        jLabel7.setText("Tổng Doanh Thu :");

        jComboBox_thangKetThuc.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jComboBox_thangKetThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jLabel_DoanhThu.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jComboBox_ngayKetThuc.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jComboBox_ngayKetThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox_ngayKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ngayKetThucActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("vnd");

        jComboBox_namBatDau.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jComboBox_namBatDau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022" }));

        jButton_Xem.setText("Xem");
        jButton_Xem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemActionPerformed(evt);
            }
        });

        jComboBox_namKetThuc.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jComboBox_namKetThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022" }));
        jComboBox_namKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_namKetThucActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Từ :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Đến :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("/");

        jComboBox_ngayBatDau.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jComboBox_ngayBatDau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("/");

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Vé", "Vị Trí Ghế", "Giá Vé", "Ngày Đi", "Mã Chuyến", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(23);
        jTable2.setRowMargin(3);
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("/");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_DoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(490, 490, 490)
                        .addComponent(jButton_Xem, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_ngayBatDau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_ngayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox_thangKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox_thangBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_namBatDau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox_namKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_thangBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_namBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_thangKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_namKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jButton_Xem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_DoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_thangBatDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_thangBatDauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_thangBatDauActionPerformed

    private void jButton_XemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XemActionPerformed
        // TODO add your handling code here:
        String ngaybd = jComboBox_ngayBatDau.getSelectedItem().toString();
        String thangbd = jComboBox_thangBatDau.getSelectedItem().toString();
        String nambd = jComboBox_namBatDau.getSelectedItem().toString();
        String ngaykt = jComboBox_ngayKetThuc.getSelectedItem().toString();
        String thangkt = jComboBox_thangKetThuc.getSelectedItem().toString();
        String namkt = jComboBox_namKetThuc.getSelectedItem().toString();

        doanhThu(ngaybd, thangbd, nambd, ngaykt, thangkt, namkt);
    }//GEN-LAST:event_jButton_XemActionPerformed

    private void jComboBox_ngayKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ngayKetThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_ngayKetThucActionPerformed

    private void jComboBox_namKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_namKetThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_namKetThucActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Xem;
    private javax.swing.JComboBox<String> jComboBox_namBatDau;
    private javax.swing.JComboBox<String> jComboBox_namKetThuc;
    private javax.swing.JComboBox<String> jComboBox_ngayBatDau;
    private javax.swing.JComboBox<String> jComboBox_ngayKetThuc;
    private javax.swing.JComboBox<String> jComboBox_thangBatDau;
    private javax.swing.JComboBox<String> jComboBox_thangKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_DoanhThu;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
