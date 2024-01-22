package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.DanhMucBean;
import View.QLSachPanel;
import View.QLthemuonPanel;
import View.QLthuvienPanel;
import View.ThongKePanel;



public class ChuyenMangHinh {

	private JPanel root;
	private String kindSelected="";
	private List<DanhMucBean> listItem;
	
	
	public ChuyenMangHinh(JPanel jpnRoot) {
		this.root=jpnRoot;
		
	}
	public void setView(JPanel jpnItem,JLabel jlbItem) {
		kindSelected="TrangChu";
	    jpnItem.setBackground(new Color(192,192,192));
	    jlbItem.setBackground(new Color(192,192,192));
	    
	    
	    root.removeAll();
	    root.setLayout(new BorderLayout());
	    root.add(new QLthuvienPanel());
	    root.validate();
	    root.repaint();
	     
		
	}
	public void setEvent(List<DanhMucBean> listItem){
		this.listItem=listItem;
		for(DanhMucBean item : listItem) {
			  item.getJlb().addMouseListener(new LabelEvent( item.getKind(), item.getJpn(), item.getJlb()));
			
		}
		
	}
	class LabelEvent implements MouseListener{

		
		private JPanel node;
		private String kind;
		private JPanel jpnItem;
		private JLabel jlbItem;
		
		
		public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
			
			this.node = node;
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItem = jlbItem;
			
		}
		  

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			switch (kind) {
			case "TrangChu":
				node =new QLthuvienPanel();
				break;
			case "QuanLyTheMuon":
				node = new QLthemuonPanel();
				break;
			case "QuanLySach":
				node=new  QLSachPanel();
				break;
			case "ThongKe":
				node=new  ThongKePanel();
				break;
				
			default:
				break;
			}
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
	     	setChangeBackground(kind);
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
			 
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			jpnItem.setBackground(new Color(192,192,192));
	        jlbItem.setBackground(new Color(192,192,192));
	      
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(76, 175, 80));
                jlbItem.setBackground(new Color(76, 175, 80));
          }
		
			
		}
		private void setChangeBackground(String kind) {
			for (DanhMucBean item :listItem) {
				if (item.getKind().equalsIgnoreCase(kind)) {
					 jpnItem.setBackground(new Color(192,192,192));
					
					 jlbItem.setBackground(new Color(192,192,192));
					
				}else {
					 jpnItem.setBackground(new Color(76,175,80));
					 jlbItem.setBackground(new Color(76,175,80));
				}
			}
		}
		
	}
}
