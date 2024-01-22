package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.QuanLySachController;
import Controller.QuanLyTheMuonController;

public class QLSachPanel extends JPanel  {

    private static final long serialVersionUID = 1L;
    private JTextField jtfsearch;
    private JButton btnAdd;
	private JPanel jpnView;
	private JButton btnrefresh;

    public QLSachPanel() {
        JPanel jpnRoot = new JPanel();
        jpnRoot.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 2));

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        jtfsearch = new JTextField(50);
        JLabel lblTimKiem = new JLabel("Tìm Kiếm");
        lblTimKiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("tim.png"))));
        searchPanel.add(lblTimKiem);
        searchPanel.add(jtfsearch);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        btnAdd = new JButton("+ Thêm Mới");
      
        btnAdd.setBackground(new Color(176,224,230));

        buttonPanel.add(btnAdd);
        JButton  btnrefresh =new JButton("Làm Mới");
        btnrefresh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("lammoi.png"))));
        
        btnrefresh.setBackground(new Color(176,224,230));

        buttonPanel.add(btnrefresh);

        northPanel.add(searchPanel);
        northPanel.add(buttonPanel);
        jpnRoot.add(northPanel, BorderLayout.NORTH);

        JPanel jpnView = new JPanel();
        jpnRoot.add(jpnView, BorderLayout.CENTER);
        add(jpnRoot);
    

   QuanLySachController controller =new QuanLySachController(jpnView, btnAdd, jtfsearch, btnrefresh);
   controller.setDataToTable();
   controller.setEvent();
    }

  
}
