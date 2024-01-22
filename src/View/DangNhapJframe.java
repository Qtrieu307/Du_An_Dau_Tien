package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.DangNhapContoller;



public class DangNhapJframe extends JFrame {
     private JLabel jlbmsg;
	public DangNhapJframe() {
    	 
    	 
		  //   this.setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("dangky.png"))));
	    	 setSize(900,350);
	    	 URL urlIconmanagea =Main.class.getResource("logojava.png");
	         Image img =Toolkit.getDefaultToolkit().createImage(urlIconmanagea);
	  	     setIconImage(img);
	    	 setLayout(new FlowLayout());
	    	 JPanel jpnanh= new JPanel();
	    	 jpnanh.setPreferredSize(new Dimension(450,315));
	    	 URL urlIconmanage = DangNhapJframe.class.getResource("dangnhap.jpg");
	         ImageIcon imageIcon = new ImageIcon(urlIconmanage);

	         // Create a JLabel with the ImageIcon
	         JLabel label = new JLabel(imageIcon);

	         // Add the JLabel to the JPanel
	         jpnanh.add(label);
	    	 add(jpnanh);
	    	 
    	 
    	 
    	 JPanel jpnchu =new JPanel();
    	
    	 jpnchu.setLayout(new GridLayout(9,1,50,0) );
    	 jpnchu.setPreferredSize(new Dimension(400,315));
    	 JLabel jpnmsg =new JLabel();
    	 
    	 JLabel jlbtendangnhap =new JLabel("Tên Đăng Nhập");
    	 jlbtendangnhap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("acc.png"))));
    	 
    	 JTextField jtftendangnhap =new JTextField();
    	 
    	 jtftendangnhap.setPreferredSize(new Dimension(200,20));
    	 JLabel jlbmatkhau =new JLabel("Mật Khẩu");
    	 jlbmatkhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("pas.png"))));
    	 JPasswordField jtfmatkhau =new JPasswordField();
    	 jtfmatkhau.setPreferredSize(new Dimension(200,20));
    	 JCheckBox showPasswordCheckBox = new JCheckBox("Hiển thị mật khẩu");
    	 showPasswordCheckBox.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("mat.png"))));
    	  showPasswordCheckBox.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  // Nếu checkbox được chọn, hiển thị mật khẩu
                  // Ngược lại, ẩn mật khẩu
                  if (showPasswordCheckBox.isSelected()) {
                	  jtfmatkhau.setEchoChar((char) 0); // Hiển thị mật khẩu
                  } else {
                	  jtfmatkhau.setEchoChar('\u2022'); // Sử dụng ký tự mặc định (dấu chấm) để ẩn mật khẩu
                  }
              }
          });

    	 JPanel jpnbtn =new JPanel();
    	 jpnbtn.setLayout(new FlowLayout());
    	 JButton btnsubmit =new JButton("Đăng Nhập");
    	 btnsubmit.setBackground(new Color(176,224,230));
    	 btnsubmit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("login.png"))));
    	 JLabel jlbdangky = new JLabel("Đăng Ký Tài Khoản");
    	 jlbdangky.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("dangky.png"))));
         
    	 JPanel jpn3 =new JPanel();
    	 JPanel jpn4=new JPanel();
    	 jpnbtn.add(jpn4);
    	 jpnbtn.add(btnsubmit);
    	 jpnbtn.add(jpn3);
    	 
    	
    	
    	 
    	 jpnchu.add(jpnmsg);
    	 jpnchu.add(jlbtendangnhap);
    	 jpnchu.add(jtftendangnhap);
    	 jpnchu.add(jlbmatkhau);
    	 jpnchu.add(jtfmatkhau);
    	 jpnchu.add(showPasswordCheckBox);
    	
    	 jpnchu.add(jpnbtn);
    	
    	 jpnchu.add(jlbdangky);
    	 
    	 
    	 
    	 add(jpnchu);
    	 
    	 
    	 
    	 
    	 setResizable(false);
    	 
    	 
    
    	 
    	 
    	DangNhapContoller contoller =new DangNhapContoller(btnsubmit, jtftendangnhap, jtfmatkhau, jpnmsg,this,jlbdangky) ;
    	contoller.setEvent();
    	 	 
     }
   
}
