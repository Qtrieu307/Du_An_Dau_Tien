
package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controller.ChuyenMangHinh;
import Model.DanhMucBean;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    private JPanel jpnRoot;
	private JPanel jpnView;

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 830);
   setTitle("Quản Lí");
       URL urlIconmanage =Main.class.getResource("logojava.png");
       Image img =Toolkit.getDefaultToolkit().createImage(urlIconmanage);
	     setIconImage(img);
	     setBackground(new Color(95,158,160));

        jpnRoot = new JPanel();
        jpnRoot.setBorder(new EmptyBorder(5, 5, 20, 20));
        jpnRoot.setLayout(new BorderLayout());

       QLthemuonPanel jpnView =new QLthemuonPanel();

        JPanel jpnMenu = new JPanel();
        jpnMenu.setLayout(new BorderLayout());

    
        
        JPanel jpnqltv = new JPanel();
        JLabel jlbqltv = new JLabel("Quản Lí Thư Viện");
        jpnqltv.add(jlbqltv);
        jpnqltv.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       

        JPanel jpntrangchu = new JPanel();
        JLabel btnTrangChu = new JLabel("Trang Chủ");
        btnTrangChu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("home.png"))));
         jpntrangchu.setBackground(new Color(192,192,192));
      
        jpntrangchu.add(btnTrangChu);
        jpntrangchu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       
      


        JPanel jpnqlsach = new JPanel();
        JLabel btnQLSach = new JLabel("Quản Lý Sách");
        btnQLSach.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("sach.png"))));
   
        jpnqlsach.add(btnQLSach);
        jpnqlsach.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      
        jpnqlsach.setBackground(new Color(76, 175, 80));


        JPanel jpnqlthemuon = new JPanel();
        JLabel btnQLTheMuon = new JLabel("Quản Lý Thẻ Mượn");
        btnQLTheMuon.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("themuon.png"))));
      
        jpnqlthemuon.add(btnQLTheMuon);
        jpnqlthemuon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       jpnqlthemuon.setBackground(new Color(76, 175, 80));

        JPanel jpnthongke =new JPanel();
        JLabel btnthongke =new JLabel("Thống Kê");
        btnthongke.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("thogke.png"))));
        
        jpnthongke.add(btnthongke);
        jpnthongke.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jpnthongke.setBackground(new Color(76, 175, 80));
        
        
        JPanel jpndannxuat = new JPanel();
        JButton btnDangXuat = new JButton("Đăng Xuất");
        btnDangXuat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("logout.png"))));
    
        
       btnDangXuat.setBackground(new Color(76, 175, 80));
        btnDangXuat.addActionListener(e -> {
         
        	int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất?", "Thông báo", JOptionPane.YES_NO_OPTION);

        	if (result == JOptionPane.YES_OPTION) {
        	    // Người dùng chọn "Có"
        	    this.dispose();
        	    DangNhapJframe frame = new DangNhapJframe();
        	    frame.setLocationRelativeTo(null);
        	    frame.setVisible(true);
        	    frame.setTitle("Đăng Nhập Hệ Thống");
        	} else {
        	  
        	}
        });

        jpndannxuat.add(btnDangXuat);
      
        jpndannxuat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jpndannxuat.setBackground(new Color(76, 175, 80));


        JPanel jpnnut = new JPanel();
        jpnnut.setLayout(new GridLayout(8, 1,30,50));
        JPanel jpn1=new JPanel();
        jpn1.setBackground(new Color(95,158,160));
        JPanel jpn2=new JPanel();
        jpn2.setBackground(new Color(95,158,160));
        
        jpnnut.add(jpn1);
        jpnnut.add(jpntrangchu);
	        jpnnut.add(jpnqlsach);
	        jpnnut.add(jpnqlthemuon);
	        jpnnut.add(jpnthongke);
        jpnnut.add(jpndannxuat);
        jpnnut.add(jpn2);

        jpnMenu.add(jpnqltv, BorderLayout.NORTH);
        jpnMenu.add(jpnnut, BorderLayout.CENTER);
        jpnMenu.setBackground(Color.BLACK);
        jpnnut.setBackground(new Color(95,158,160));
        jpnMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        

        jpnRoot.add(jpnView, BorderLayout.CENTER);
        jpnRoot.add(jpnMenu, BorderLayout.WEST);

        setContentPane(jpnRoot);
    
        ChuyenMangHinh chuyenMangHinh =new ChuyenMangHinh(jpnView);
        
        chuyenMangHinh.setView(jpnqltv, jlbqltv);
        List<DanhMucBean> listItem =new ArrayList<>() ;
        listItem.add(new DanhMucBean("TrangChu",jpntrangchu,btnTrangChu));
        listItem.add(new DanhMucBean("QuanLyTheMuon",jpnqlthemuon,btnQLTheMuon));
        listItem.add(new DanhMucBean("QuanLySach",jpnqlsach,btnQLSach));
        listItem.add(new DanhMucBean("ThongKe",jpnthongke,btnthongke));	
     
        chuyenMangHinh.setEvent(listItem);
    }
}
     
   
