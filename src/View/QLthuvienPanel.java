package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class QLthuvienPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
	private JTextField jtfsearch;

    public QLthuvienPanel() {
        
       
    	 setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    	URL urlIconmanage =Main.class.getResource("tv3.jpg");
	     Image img =Toolkit.getDefaultToolkit().createImage(urlIconmanage);
	   
	     ImageIcon icon = new ImageIcon(img);


          JLabel label = new JLabel(icon);
	        Dimension panelSize = getSize();
	        label.setSize(panelSize);
	        add(label);
       
    }

    
   
}
