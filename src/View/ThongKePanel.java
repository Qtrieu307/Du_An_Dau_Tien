package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.ThongKeController;

public class ThongKePanel extends JPanel {
	
	public ThongKePanel() {
		setBackground(Color.gray);
		setLayout(new GridLayout(2,1));
		JPanel jpn1 =new JPanel();
		JPanel jpn2 =new JPanel();
		
		
		jpn1.setPreferredSize(new Dimension(900,500));
		add(jpn1);
		jpn2.setPreferredSize(new Dimension(900,500));
		add(jpn2);
	
		ThongKeController controller =new ThongKeController();
		controller.setdataToBieuDo(jpn1);
		controller.setdataToBieuDo2(jpn2);
	}

}
