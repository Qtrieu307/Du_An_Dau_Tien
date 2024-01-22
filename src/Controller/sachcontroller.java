package Controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import Model.Sach;
import service.SachService;
import service.Sachseriviceiplm;
import View.QLSACHFrame;
import View.QLSachPanel;

public class sachcontroller {
     private JButton btnsave ;
     private JTextField jtfID;
     private JTextField jtfMaSach;
     private JTextField jtfTenSach;
     private JTextField jtfTenTacGia;
     private JDateChooser dateChooser;
     private JTextField jtfSoLuong;
     private JTextField jtfGiaTien;
     private JLabel jlbMsg;
 	 private JButton btndelete;
 	 
 	 private Sach sach =null;
 	 private SachService sachService=null;
	public sachcontroller(JButton btnsave,JTextField jtfID, JTextField jtfMaSach, JTextField jtfTenSach, JTextField jtfTenTacGia,
			JDateChooser dateChooser, JTextField jtfSoLuong, JTextField jtfGiaTien, JLabel jlbMsg, JButton btndelete) {
		super();
		this.btnsave = btnsave;
		this.jtfID=jtfID;
		this.jtfMaSach = jtfMaSach;
		this.jtfTenSach = jtfTenSach;
		this.jtfTenTacGia = jtfTenTacGia;
		this.dateChooser = dateChooser;
		this.jtfSoLuong = jtfSoLuong;
		this.jtfGiaTien = jtfGiaTien;
		this.jlbMsg = jlbMsg;
		this.btndelete = btndelete;
		this.sachService =new Sachseriviceiplm();
	}
	public void setView(Sach sach) {
		this.sach =sach;
		jtfID.setText("#"+sach.getID());
		jtfMaSach.setText(sach.getMaSach());
		jtfTenSach.setText(sach.getTenSach());
		jtfTenTacGia.setText(sach.getTenTacGia());
		dateChooser.setDate(sach.getNgayXuatBan());
		jtfSoLuong.setText(""+sach.getSoLuong());
		jtfGiaTien.setText(""+sach.getGiaTien());
		
	}
	public void setEvent() {
		btnsave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(!NoNull()) {
						jlbMsg.setText("Vui Lòng Nhập Dữ Liệu Bắt Buộc !!!!");
					
					}	else {
						sach.setMaSach(jtfMaSach.getText().trim());
						sach.setTenSach(jtfTenSach.getText().trim());
						sach.setTenTacGia(jtfTenTacGia.getText().trim());
						sach.setNgayXuatBan(new java.sql.Date(dateChooser.getDate().getTime()));
					    sach.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
					    sach.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
					    sach.setGiaTien(Double.parseDouble(jtfGiaTien.getText()));
					if (showDialog()) {
						int ID =sachService.createOrUpdate(sach);
						if (ID!=0) {
							sach.setID(ID);
							jtfID.setText("#"+sach.getMaSach());
							jlbMsg.setText("Xử lý cập nhật dữ liệu thành công! Vui lòng làm mới lại bảng");
							
							new QLSACHFrame(sach);
							
						}
						else {
							jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
						}
					}
					}
				} catch(Exception e2) {
					jlbMsg.setText(e2.toString());
					System.out.println(e2.toString()+"bin");
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnsave.setBackground(new Color(200,125,30));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnsave.setBackground(new Color(176,224,230));
			}
		});
		btndelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Không ?", "Confirmation", JOptionPane.YES_NO_OPTION);
		        if (response == JOptionPane.YES_OPTION) {
		            try {
		                sachService.delete(sach);
		                JOptionPane.showMessageDialog(null, "Xóa Thành Công Vui Lòng Cập Nhập Lại Trang <3");
		                System.out.println("Delete Successful");
		            } catch (Exception ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Error deleting record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btndelete.setBackground(new Color(200,125,30));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btndelete.setBackground(new Color(176,224,230));
			}
		});
	}
	
		
	 public boolean NoNull () {
		   return jtfTenSach.getText() != null && !jtfTenSach.getText().equalsIgnoreCase(""); 
	   }

	   private boolean showDialog() {
	       int dialogResult = JOptionPane.showConfirmDialog(null,
	               "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
	       return dialogResult == JOptionPane.YES_OPTION;
	   }
	  
	   
	   public java.sql.Date covertDateToDateSql(Date d) {
	       return new java.sql.Date(d.getTime());
	   }
 	 
}