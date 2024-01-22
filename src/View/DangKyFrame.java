package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Dao.DBconnection;

public class DangKyFrame extends JFrame{
    public DangKyFrame() {
    	setSize(900,350);
    	setLocationRelativeTo(null);
    	 URL urlIconmanagea =Main.class.getResource("logojava.png");
         Image img =Toolkit.getDefaultToolkit().createImage(urlIconmanagea);
  	     setIconImage(img);
    	setLayout(new FlowLayout());
    	JPanel jpnanh =new JPanel();
    	
    	 jpnanh.setPreferredSize(new Dimension(450,315));
    	 URL urlIconmanage = DangKyFrame.class.getResource("dangnhap.jpg");
         ImageIcon imageIcon = new ImageIcon(urlIconmanage);
         JLabel label = new JLabel(imageIcon);

         // Add the JLabel to the JPanel
         jpnanh.add(label);
    	 add(jpnanh);
    	 
    	 
    	 JPanel jpnchu =new JPanel();
    	
    	 jpnchu.setLayout(new GridLayout(8,2,50,10));
    	 
    	 JPanel jpn3 =new JPanel();
    	 JPanel jpn4 =new JPanel();
    	 JLabel jlbtendangnhap =new JLabel("Tên Đăng Nhập");
    	 jlbtendangnhap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("acc.png"))));
    	 JTextField jtftendangnhap =new JTextField();
    	 jtftendangnhap.setPreferredSize(new Dimension(170,20));
    	 
    	 JLabel jlbmatkhau =new JLabel("Mật Khẩu");
    	 jlbmatkhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("pas.png"))));
    	 JPasswordField jtfmatkhau =new JPasswordField();
    	 
    	 JLabel jlbnhaplaimatkhau =new JLabel("Nhập Lại Mật Khẩu");
    	 jlbnhaplaimatkhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("pas.png"))));
    	 JPasswordField jtfnhaplaimatkhau =new JPasswordField();
    	  
    	 JLabel jlbmail =new JLabel("Email");
    	 jlbmail.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("mail.png"))));
    	 JTextField jtfmail =new JTextField();
    	 
    	 JPanel jpnnut =new JPanel();
    	 jpnnut.setLayout(new FlowLayout());
    	 JPanel jpn1= new JPanel();
    	 JButton btnquaylaidangnhap =new JButton("Quay Lại Đăng Nhập");
    	 btnquaylaidangnhap.setBackground(new Color(176,224,230));
    	 btnquaylaidangnhap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("back.png"))));
    	 JButton btndangky =new JButton("Đăng Ký");
    	 btndangky.setBackground(new Color(176,224,230));
    	 btndangky.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("dangky.png"))));
    	 
    	 JPanel jpn40 = new JPanel();
    	 JPanel jpn5 =new JPanel();
    	 JPanel jpn6 =new JPanel();
    	 jpnchu.add(jpn3);
    	 jpnchu.add(jpn4);
    	 jpnchu.add(jlbtendangnhap);
    	 jpnchu.add(jtftendangnhap);
    	 jpnchu.add(jlbmatkhau);
    	 jpnchu.add(jtfmatkhau);
    	 jpnchu.add(jlbnhaplaimatkhau);
    	 jpnchu.add(jtfnhaplaimatkhau);
    	 jpnchu.add(jlbmail);
    	 jpnchu.add(jtfmail);
    	 jpnchu.add(btnquaylaidangnhap);
    	 jpnchu.add(btndangky);
    	 jpnchu.add(jpn40);
    	 jpnchu.add(jpn5);
    	 jpnchu.add(jpn6);
    	 add(jpnchu);
    	 
    	
    	 btndangky.addMouseListener(new MouseAdapter() {
    		 @Override
    		public void mouseClicked(MouseEvent e) {
    			if (jtftendangnhap.getText().length()==0||jtfmatkhau.getText().length()==0||jtfnhaplaimatkhau.getText().length()==0) {
    				   JOptionPane.showMessageDialog(null, "Không được để thông tin trống ");
   	                return;
    			}else 
    				if (jtfmatkhau.getText().length()<6) 
    					   JOptionPane.showMessageDialog(null, "Mật Khẩu Nhiều Hơn 6 Kí Tự");
    				
    			
    			else {
    				if (!jtfmatkhau.getText().equals(jtfnhaplaimatkhau.getText())) {
    					 JOptionPane.showMessageDialog(null, "Mật khẩu và Nhập lại mật khẩu không khớp!");
    			            return;
    				}
    				Connection connection =DBconnection.getConnection();
    					String sql = "INSERT INTO `cuoiky1`.`tai_khoan` ( `ten_dang_nhap`, `mat_khau`, `tinh_trang`, `mail`) VALUES (?,?,?,?);";
    				
    					try {
    						 PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    						 ps.setString(1,jtftendangnhap.getText() );
    				         ps.setString(2, jtfmatkhau.getText());
    				         ps.setString(3, "1");
    				         ps.setString(4, jtfmail.getText());
    				         int n = ps.executeUpdate();
    							
    					     if (n != 0) {
    		                        JOptionPane.showMessageDialog(null, "Đăng ký thành công ");
    		                    } else {
    		                        JOptionPane.showMessageDialog(null, "Đăng ký thất bại! ");
    		                    }
    		                } catch (SQLException ex) {
    		                ex.printStackTrace();
    		                System.out.println(ex.toString());
    		                JOptionPane.showMessageDialog(null, " Tên đăng nhập đã có người sử dụng! ");
    		            }
    				
    		}
    			}
    		 @Override
    		public void mouseEntered(MouseEvent e) {
    			 btndangky.setBackground(new Color(200,125,30));
    		}
    		 @Override
    		public void mouseExited(MouseEvent e) {
    			btndangky.setBackground(new Color(176,224,230));
    		}
    		
		});
    	 btnquaylaidangnhap.addMouseListener(new MouseAdapter() {
    		 @Override
    		public void mouseClicked(MouseEvent e) {
    			dispose();
    			DangNhapJframe frame =new DangNhapJframe();
    			
    			frame.setVisible(true);
    			frame.setLocationRelativeTo(null);
    			
    			super.mouseClicked(e);
    		}
    		 @Override
    		public void mouseEntered(MouseEvent e) {
    			btnquaylaidangnhap.setBackground(new Color(200,125,30));
    			super.mouseEntered(e);
    		}
    		 @Override
    		public void mouseExited(MouseEvent e) {
    			 btnquaylaidangnhap.setBackground(new Color(176,224,230));
    		}
		});
    	 jtfmail.addKeyListener(new KeyAdapter() {
    		 public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                	if (jtftendangnhap.getText().length()==0||jtfmatkhau.getText().length()==0||jtfnhaplaimatkhau.getText().length()==0) {
	     				   JOptionPane.showMessageDialog(null, "Không được để thông tin trống ");
	    	                return;
	     			}
	     			else {
	     				if (!jtfmatkhau.getText().equals(jtfnhaplaimatkhau.getText())) {
	     					 JOptionPane.showMessageDialog(null, "Mật khẩu và Nhập lại mật khẩu không khớp!");
	     			            return;
	     				}
	     				Connection connection =DBconnection.getConnection();
	     					String sql = "INSERT INTO `cuoiky1`.`tai_khoan1` (`Ten_dang_nhap`, `Mat_khau`, `Tinh_Trang`) VALUES (?,?,?);";
	     				
	                	try {
   						 PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
   						 ps.setString(1,jtftendangnhap.getText() );
   				         ps.setString(2, jtfmatkhau.getText());
   				         ps.setString(3, "1");
   				         ps.setString(4, jtfmail.getText());
   				         int n = ps.executeUpdate();
   							
   					     if (n != 0) {
   		                        JOptionPane.showMessageDialog(null, "Đăng ký thành công ");
   		                    } else {
   		                        JOptionPane.showMessageDialog(null, "Đăng ký thất bại! ");
   		                    }
   		                } catch (SQLException ex) {
   		                ex.printStackTrace();
   		                System.out.println(ex.toString());
   		                JOptionPane.showMessageDialog(null, " Tên đăng nhập đã có người sử dụng! ");
   		            }
   				
   		}
	                }}
		});
    }
    
    
	}
    


