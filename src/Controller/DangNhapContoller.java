package Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.TaiKhoan;
import service.TaiKhoanService;
import service.TaiKhoanServiceImplements;
import View.DangKyFrame;
import View.DangNhapJframe;
import View.Main;

public class DangNhapContoller {
	 private DangNhapJframe dangnhap;
     private JButton btnsubmit;
     private JTextField jtfdangnhap;
     private JTextField jtfmatkhau;
     private JLabel jlnmsg;
     private JLabel jlbDangKy;
     
     private TaiKhoanService taiKhoanService=null;
	public DangNhapContoller(JButton btnsubmit, JTextField jtfdangnhap, JTextField jtfmatkhau, JLabel jlnmsg, DangNhapJframe dangnhap,JLabel jlbDangKy) {
		super();
		this.btnsubmit = btnsubmit;
		this.jtfdangnhap = jtfdangnhap;
		this.jtfmatkhau = jtfmatkhau;
		this.jlnmsg = jlnmsg;
		
		
		
		this.taiKhoanService=new TaiKhoanServiceImplements();
		this.dangnhap =dangnhap;
		this.jlbDangKy =jlbDangKy;
		
	}
	public void setEvent() {
		  jtfmatkhau.addKeyListener(new KeyAdapter() {
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                	try {
		                    if (jtfdangnhap.getText().length() == 0
		                            || jtfmatkhau.getText().length() == 0) {
		                    	jlnmsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
		                    } else {
		                        TaiKhoan taiKhoan = taiKhoanService.login(jtfdangnhap.getText(), jtfmatkhau.getText());
		                        if (taiKhoan == null) {
		                        	jlnmsg.setText("Tên đăng nhập và mật khẩu không đúng!");
		                        	
		                        } else {
		                            if (!taiKhoan.isTinh_trang()) {
		                            	jlnmsg.setText("Tài khoản của bạn đang bị tạm khóa!");
	                            } else {
		                            	
		                            	dangnhap.dispose();
		                                Main frame =new Main();
		                            	
		                            	
		                                frame.setVisible(true);
		                              
		                               
		                            }
		                        }
		                    }
		                } catch (Exception ex) {
		                jlnmsg.setText(ex.toString());
		                System.out.println(ex);
		                }
	                }
	            }
	        });
		btnsubmit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 try {
	                    if (jtfdangnhap.getText().length() == 0
	                            || jtfmatkhau.getText().length() == 0) {
	                    	jlnmsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
	                    } else {
	                        TaiKhoan taiKhoan = taiKhoanService.login(jtfdangnhap.getText(), jtfmatkhau.getText());
	                        if (taiKhoan == null) {
	                        	jlnmsg.setText("Tên đăng nhập hoặc mật khẩu không đúng!");
	                        } else {
	                            if (!taiKhoan.isTinh_trang()) {
	                            	jlnmsg.setText("Tài khoản của bạn đang bị tạm khóa!");
	                            } else {
	                            	
	                            	dangnhap.dispose();
	                                Main frame =new Main();
	                            	
	                            	
	                                frame.setVisible(true);
	                              
	                               
	                            }
	                        }
	                    }
	                } catch (Exception ex) {
	                jlnmsg.setText(ex.toString());
	                System.out.println(ex);
	                }
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnsubmit.setBackground(new Color(200,125,30));
				super.mouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 btnsubmit.setBackground(new Color(176,224,230));
				super.mouseExited(e);
			}
		
		});
		jlbDangKy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dangnhap.dispose();
				DangKyFrame frame= new DangKyFrame();
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setTitle("Đăng Ký Tài Khoản");
				super.mouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				jlbDangKy.setBackground(Color.red);
				super.mouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jlbDangKy.setBackground(Color.blue);
				super.mouseExited(e);
			}
		});
	}
     
}
