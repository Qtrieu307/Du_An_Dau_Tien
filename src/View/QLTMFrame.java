package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

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

import Controller.TheMuonController;
import Model.Sach;
import Model.TheMuon;

public class QLTMFrame extends JFrame {
	


	public QLTMFrame(TheMuon theMuon) {
		setBackground(Color.gray);
		URL urlIconmanage =Main.class.getResource("logojava.png");
	     Image img =Toolkit.getDefaultToolkit().createImage(urlIconmanage);
	     setIconImage(img);
		
		setSize(1300,700);
		setTitle("Thẻ Mượn");
		
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
        jpnView.setLayout(new GridLayout(5,2,20,40));
        
      
        JPanel jpn1= new JPanel();
        jpn1.setBackground(Color.gray);
        JPanel jpn2= new JPanel();
        jpn2.setBackground(Color.gray);
        jpnView.add(jpn2);
        jpnView.add(jpn1);
        
             
        
      
        
        JPanel jpnMathe=new JPanel();
        jpnMathe.setBackground(Color.gray);
        JLabel jlbMaThe = new JLabel("Mã Thẻ                  ");
        jlbMaThe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("id.png"))));
		jlbMaThe.setFont(new Font("Tahoma", Font.BOLD, 14));			
		jpnMathe.add(jlbMaThe);
		
		JTextField jtfMaThe = new JTextField();
		jtfMaThe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfMaThe.setPreferredSize(new Dimension(258,20));		
		jpnMathe.add(jtfMaThe);		
		jpnView.add(jpnMathe);
		
	
		
		JPanel jpnTNm =new JPanel();
		jpnTNm.setBackground(Color.gray);
		
		JLabel jlbTenNguoiMuon = new JLabel("Tên Người Mượn");
		jlbTenNguoiMuon.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("acc.png"))));
		jlbTenNguoiMuon.setFont(new Font("Tahoma", Font.BOLD, 14));		
		jpnTNm.add(jlbTenNguoiMuon);
		
		JTextField jtfTenNguoiMuon = new JTextField();
		jtfTenNguoiMuon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfTenNguoiMuon.setPreferredSize(new Dimension(258,20));	
		
		jpnTNm.add(jtfTenNguoiMuon);
		
		jpnView.add(jpnTNm);
		
		JPanel jpnSSDM =new JPanel();
		jpnSSDM.setBackground(Color.gray);
		
		JLabel jlbSoSachDaMuon = new JLabel("Số Sách Đã Mượn");
		jlbSoSachDaMuon.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("soluong.png"))));
		jlbSoSachDaMuon.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		jpnSSDM.add(jlbSoSachDaMuon);

		JTextField jtfSoSachDaMuon = new JTextField();
		jtfSoSachDaMuon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfSoSachDaMuon.setPreferredSize(new Dimension(258,20));	
		
		jpnSSDM.add(jtfSoSachDaMuon);
		
		jpnView.add(jpnSSDM);
		
	
		 
		JPanel jpnSSDT =new JPanel();
		jpnSSDT.setBackground(Color.gray);
		
		JLabel jlbSoSachDaTra = new JLabel("Số Sách Đã Trả   ");
		jlbSoSachDaTra.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("soluong.png"))));
		jlbSoSachDaTra.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		jpnSSDT.add(jlbSoSachDaTra);
		
		JTextField jtfSoSachDaTra = new JTextField();
		jtfSoSachDaTra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfSoSachDaTra.setPreferredSize(new Dimension(258,20));	
		
		jpnSSDT.add(jtfSoSachDaTra);
		
		jpnView.add(jpnSSDT);
		
		JPanel jpnNS=new JPanel();
		jpnNS.setBackground(Color.gray);
		
		JLabel jlbNgaySinh = new JLabel("Ngày Sinh         ");
		jlbNgaySinh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("lich.png"))));
		jlbNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbNgaySinh.setHorizontalAlignment(SwingConstants.LEFT);
		
		jpnNS.add(jlbNgaySinh);
//	    JTextField 	jtfNgaySinh = new JTextField();
//	    jtfNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
//	    jtfNgaySinh.setColumns(50);
//		
//		jpnNS.add(jtfNgaySinh);
		
		  JDateChooser dateChooser = new JDateChooser();
		  dateChooser.setDateFormatString("yyyy-MM-dd");
		  dateChooser.setPreferredSize(new Dimension(200,20));
		  jpnNS.add(dateChooser);
		 
		
			
		
		JPanel jpnGT =new JPanel();
		jpnGT.setBackground(Color.gray);
		JLabel jlbGioiTinh = new JLabel("Giới Tính");
		jlbGioiTinh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("gioitinh.png"))));
		jlbGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbGioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		
		jpnGT.add(jlbGioiTinh);
	
	    JPanel jpn3=new JPanel();
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(Color.gray);
	
		jpn3.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBackground(Color.gray);
		
		jpn3.add(rdbtnNu);
		
		ButtonGroup buttonGroup = new ButtonGroup() ;
		buttonGroup.add(rdbtnNam);
		buttonGroup.add(rdbtnNu);
		
		jpnView.add(jpnGT);
		jpnView.add(jpnNS);
		JPanel jpnd=new JPanel();
        JPanel jpn4= new JPanel();
        jpn4.setBackground(Color.gray);
        JPanel jpn5= new JPanel();
        jpn5.setBackground(Color.gray);
        jpnView.add(jpn4);
        jpnView.add(jpn5);
  
        
		jpnGT.add(jpn3);
		jpn3.setBackground(Color.gray);
		
		
  
        jpnRoot.add(jpnView,BorderLayout.CENTER);
        jpnRoot.add(jpnNorth,BorderLayout.NORTH);
        
    
        add(jpnRoot);
        
       
        setSize(1000,600);
       
      
   TheMuonController controller = new TheMuonController(btnSave, jtfMaThe, jtfTenNguoiMuon, jtfSoSachDaMuon, jtfSoSachDaTra, dateChooser, rdbtnNam, rdbtnNu,jlbMsg, btndelete);
   
    		 

controller.setView(theMuon);   

controller.setEvent();
 
	}
	 


}
