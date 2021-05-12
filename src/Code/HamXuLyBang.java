/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import Form.GDChinh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author n18dc
 */
public class HamXuLyBang {
    // Load dữ liệu từ database vào bảng
    public void loadDuLieuVaoBang(JTable tb, String sql){
        DefaultTableModel dtm=(DefaultTableModel)tb.getModel();
        dtm.setNumRows(0);
        //tb.setModel(dtm);
        Connection ketnoi=Code.KetNoi.layKetNoi();
        
        try {
            PreparedStatement ps=ketnoi.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            Vector vt;
            while(rs.next()){
                vt=new Vector();
                for(int i=1;i<=tb.getColumnCount();i++){
                    vt.add(rs.getString(i));
                }
                dtm.addRow(vt);
            }
            // Nếu là bảng Vé Xe thì đổi trạng thái Vé xe từ số về String
            if(tb.getColumnName(0).equalsIgnoreCase("Ghế ngồi")){
                for(int i=0;i<dtm.getRowCount();i++){
                    if(dtm.getValueAt(i, dtm.getColumnCount()-1).equals("1")){
                        dtm.setValueAt("Đã thanh toán", i, dtm.getColumnCount()-1);
                    }
                    else if(dtm.getValueAt(i, dtm.getColumnCount()-1).equals("0")){
                        dtm.setValueAt("Chưa thanh toán", i, dtm.getColumnCount()-1);
                    }
                }
            }
            // Nếu là bảng Chuyến xe thì đổi trạng thái Vé xe từ số về String
            if(tb.getColumnName(0).equalsIgnoreCase("Mã chuyến")){
                for(int i=0;i<dtm.getRowCount();i++){
                    if(dtm.getValueAt(i, dtm.getColumnCount()-1).equals("0")){
                        dtm.setValueAt("Đang hoạt động", i, dtm.getColumnCount()-1);
                    }
                    else if(dtm.getValueAt(i, dtm.getColumnCount()-1).equals("1")){
                        dtm.setValueAt("Đã dừng", i, dtm.getColumnCount()-1);
                    }
                }
            }
            tb.setModel(dtm);

            rs.close();
            ps.close();
            ketnoi.close();
        } catch (SQLException e) {
            Logger.getLogger(GDChinh.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public String selectRow(JTable tb, int numRow){
        
        try {
            return tb.getValueAt(tb.getSelectedRow(), numRow).toString();
        } catch (NullPointerException e) {
            return "";
        }
    }
    //------------------Hàm sắp xếp các dòng của bảng------------------------
    public void sapXepBang(JTable tb ,int xepTheoCot,int kieuXep)// xepTheo: cột cần xếp, kieuXep: 0=tăng hoặc 1=giảm
    {
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tb.getModel());
        tb.setRowSorter(sorter);

        ArrayList <RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
        if(kieuXep==0){
            sortKeys.add(new RowSorter.SortKey(xepTheoCot, SortOrder.ASCENDING));
        }
        else if(kieuXep==1){
            sortKeys.add(new RowSorter.SortKey(xepTheoCot, SortOrder.DESCENDING));
        }
        sorter.setSortKeys(sortKeys); 
    }  
    
    //-----------------Hàm lọc dữ liệu trong bảng----------------------
    public void locDuLieuVeXe(JTable tbGoc,JTable tbLoc, String tram, String ngay, String gio, int chuyenXe){

        DefaultTableModel dtm=(DefaultTableModel)tbLoc.getModel();
        dtm.setNumRows(0);
        Vector vt;
        for(int i=0;i<tbGoc.getRowCount();i++)//Duyệt từng cột của bảng tạm
        {
            // lấy những cột thỏa trạm, ngày, giờ, chuyến đi, đưa vào bảng hiện thị
            if(tbGoc.getValueAt(i, 8).toString().equals(tram) && tbGoc.getValueAt(i, 6).toString().equals(ngay) 
                    && tbGoc.getValueAt(i, 7).toString().equals(gio) && Integer.parseInt(tbGoc.getValueAt(i, 2).toString())==chuyenXe)
            {
                vt=new Vector();
                vt.add(Integer.parseInt(tbGoc.getValueAt(i, 0).toString()));
                for(int j=1;j<tbGoc.getColumnCount();j++){
                    vt.add(tbGoc.getValueAt(i, j));
                }
                dtm.addRow(vt);
                
            }
        }
        
        tbLoc.setModel(dtm);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tbLoc.setDefaultRenderer(Integer.class, centerRenderer);
        // sắp xếp bảng tăng dần theo ghế
        sapXepBang(tbLoc ,0,0);
    }
    
    // Lọc tất cả các hàng có dữ liệu ở cột cotLoc là str
    public void locTatCa(JTable tb, String str, int cotLoc){
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tb.getModel())); 
        tb.setRowSorter(sorter);
        try {
            if(cotLoc>-1){//nếu cột lọc -1 thì lọc tất cả các cột xem cột nào = str
                sorter.setRowFilter(RowFilter.regexFilter(str,cotLoc));
            }else {
                sorter.setRowFilter(RowFilter.regexFilter(str));
            }
        } 
        catch(PatternSyntaxException pse) {
            System.out.println("Bad regex pattern");
        }
    }
}