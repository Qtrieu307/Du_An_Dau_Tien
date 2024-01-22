package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.print.DocFlavor.URL;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import Controller.sachcontroller;
import Dao.SachDao;
import Model.Sach;

public class QLSACHFrame extends JFrame {
   
	public QLSACHFrame (Sach sach ) {
		setBackground(Color.gray);
		java.net.URL urlIconmanage =QLSACHFrame.class.getResource("logojava.png");
	     Image img =Toolkit.getDefaultToolkit().createImage(urlIconmanage);
	     setIconImage(img);
		
		setSize(1300,700);
		setTitle("Thông Tin");
		
	    JPanel jpnRoot =new JPanel();
	    jpnRoot.setLayout(new BorderLayout());
	    
	    
	    JPanel jpnNorth =new JPanel();
	    jpnNorth.setLayout(new GridLayout(1,3));
	    
	    JLabel jlbMsg =new JLabel("");
	    
	    JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton btnSave = new JButton("Cập Nhập");
        btnSave.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("save.png"))));
        btnSave.setBackground(new Color(176,224,230));
        buttonPanel.add(btnSave);
        JButton btndelete =new JButton("Xóa");
        btndelete.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("exit.png"))));
        btndelete.setBackground(new Color(176,224,230));
        buttonPanel.add(btndelete);
        jpnNorth.add(jlbMsg);
        jpnNorth.add(buttonPanel);
        	
        
        
        JPanel jpnView =new JPanel();
        jpnView.setBackground(Color.gray);
        jpnView.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng Tin Th\u1EBB M\u01B0\u1EE3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        jpnView.setLayout(new GridLayout(6,2,20,40));
        
        JPanel jpnt=new JPanel();
             JPanel jpn1= new JPanel();
             jpn1.setBackground(Color.gray);
             JPanel jpn2= new JPanel();
             jpn2.setBackground(Color.gray);
        jpnView.add(jpn2);
        jpnView.add(jpn1);
        
        JPanel jpnID=new JPanel();
        jpnID.setBackground(Color.gray);
        
        JLabel jlbID =new JLabel("         ID                     ");
        jlbID.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("id.png"))));
        jlbID.setFont(new Font("Tahoma", Font.BOLD, 14));
        jpnID.add(jlbID);
        JTextField jtfID =new JTextField();
        jtfID.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jtfID.setPreferredSize(new Dimension(258,20));		
        jpnID.add(jtfID);
        jpnView.add(jpnID);     
        
        JPanel jpnMaSach=new JPanel();
        jpnMaSach.setBackground(Color.gray);
               
        JLabel jlbMaSach = new JLabel("Mã Sách      ");
        jlbMaSach.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("book.png"))));
        jlbMaSach.setFont(new Font("Tahoma", Font.BOLD, 14));			
		jpnMaSach.add(jlbMaSach);
		
		JTextField jtfMaSach = new JTextField();
		jtfMaSach.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfMaSach.setPreferredSize(new Dimension(258,20));		
		jpnMaSach.add(jtfMaSach);		
		jpnView.add(jpnMaSach);
		
	
		
		JPanel jpnTenSach=new JPanel();
		jpnTenSach.setBackground(Color.gray);		
		JLabel jlbTenSach = new JLabel("            Tên Sách         ");
		jlbTenSach.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("book.png"))));
		jlbTenSach.setFont(new Font("Tahoma", Font.BOLD, 14));		
		jpnTenSach.add(jlbTenSach);		
		JTextField jtfTenSach = new JTextField();
		jtfTenSach.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTenSach.setPreferredSize(new Dimension(258,20));			
		jpnTenSach.add(jtfTenSach);		
		jpnView.add(jpnTenSach);
		
		
		
		JPanel jpnTenTacGia =new JPanel();
		jpnTenTacGia.setBackground(Color.gray);		
		JLabel jlbTenTacGia = new JLabel("Tên Tác Giả");
		jlbTenTacGia.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("acc.png"))));
		jlbTenTacGia.setFont(new Font("Tahoma", Font.BOLD, 14));				
		jpnTenTacGia.add(jlbTenTacGia);
		JTextField jtfTenTacGia = new JTextField();
		jtfTenTacGia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTenTacGia.setPreferredSize(new Dimension(258,20));			
		jpnTenTacGia.add(jtfTenTacGia);		
		jpnView.add(jpnTenTacGia);
		
	
		 
		
		
		JPanel jpnNXB=new JPanel();
		jpnNXB.setBackground(Color.gray);
		
		JLabel jlbNgayXuatBan = new JLabel("Ngày Xuất Bản          ");
		jlbNgayXuatBan.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("lich.png"))));
		jlbNgayXuatBan.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbNgayXuatBan.setHorizontalAlignment(SwingConstants.LEFT);
		
		jpnNXB.add(jlbNgayXuatBan);
//	    JTextField 	jtfNgaySinh = new JTextField();
//	    jtfNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
//	    jtfNgaySinh.setColumns(50);
//		
//		jpnNS.add(jtfNgaySinh);
		
		  JDateChooser dateChooser = new JDateChooser();
		  dateChooser.setDateFormatString("yyyy-MM-dd");
		  dateChooser.setPreferredSize(new Dimension(258,20));
		  jpnNXB.add(dateChooser);
		 jpnView.add(jpnNXB);
		  
		 JPanel jpnSoLuong =new JPanel();
		 jpnSoLuong.setBackground(Color.gray);			
			JLabel jlbSoLuong = new JLabel("Số Lượng     ");
			jlbSoLuong.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("soluong.png"))));
			jlbSoLuong.setFont(new Font("Tahoma", Font.BOLD, 14));						
			jpnSoLuong.add(jlbSoLuong);			
			JTextField jtfSoGiaTien = new JTextField();
			jtfSoGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jtfSoGiaTien.setPreferredSize(new Dimension(258,20));				
			jpnSoLuong.add(jtfSoGiaTien);			
			jpnView.add(jpnSoLuong);
		
		
			JPanel jpnGiaTien =new JPanel();
			jpnGiaTien.setBackground(Color.gray);
			
			JLabel jlbGiaTien = new JLabel("   Giá Tiền                 ");
			jlbGiaTien.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("gia.png"))));
			jlbGiaTien.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			
			jpnGiaTien.add(jlbGiaTien);

			JTextField jtfGiaTien = new JTextField();
			jtfGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jtfGiaTien.setPreferredSize(new Dimension(258,20));	
			
			jpnGiaTien.add(jtfGiaTien);
			
			jpnView.add(jpnGiaTien);
			
		
		
		
	
	
		JPanel jpnd=new JPanel();
        JPanel jpn4= new JPanel();
        jpn4.setBackground(Color.gray);
        JPanel jpn5= new JPanel();
        jpn5.setBackground(Color.gray);
        jpnView.add(jpn4);
        jpnView.add(jpn5);
  
        
		
		
  
        jpnRoot.add(jpnView,BorderLayout.CENTER);
        jpnRoot.add(jpnNorth,BorderLayout.NORTH);
        
    
        add(jpnRoot);
        
       
        setSize(1000,600);
      sachcontroller controller =new sachcontroller(btnSave,jtfID, jtfMaSach, jtfTenSach, jtfTenTacGia, dateChooser, jtfSoGiaTien, jtfGiaTien, jlbMsg, btndelete);
      controller.setView(sach);
      controller.setEvent();
	}
	
}
