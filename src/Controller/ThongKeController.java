package Controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Dao.ThongKeDaoipl;
import Model.Sach;
import Model.TheMuon;
import service.ThongKeServiceiplm;
import service.Thongkeservice;

public class ThongKeController {
   private Thongkeservice thongkeservice =null;
   public ThongKeController() {
	   this.thongkeservice =new ThongKeServiceiplm();
	   
   }
   public void setdataToBieuDo(JPanel jpnItem) {
	    List<TheMuon> listItem = thongkeservice.getList();
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

	    if (listItem != null) {
	        for (TheMuon item : listItem) {
	            // Assuming item.getName() returns the name of the card holder
	           dataset.addValue(item.getSosachdamuon(), "Số Sách Đã Mượn", "");
	           dataset.addValue(item.getSosachdatra(), "Số Sách Đã Trả", "");
	           dataset.addValue(item.getSosachdamuon()-item.getSosachdatra(),"Số Sách Chưa Trả","");
	           
	           
	        }
	        JFreeChart chart =ChartFactory.createBarChart("Thống Kê Số Lượng Mượn Và Trả", "Mượn Và Trả ", "Số Sách", dataset);
	        
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 150));

	        jpnItem.removeAll();
	        jpnItem.setLayout(new CardLayout());
	        jpnItem.add(chartPanel);
	        jpnItem.validate();
	        jpnItem.repaint();
	    }

	 
	

   }
   public void setdataToBieuDo2(JPanel jpnItem) {
	   DefaultPieDataset dataset = new DefaultPieDataset();
	   List<Sach> listItem =thongkeservice.getListSach();
	   
	   if(listItem != null) {
		   for(Sach item :listItem) {
			   dataset.setValue(item.getTenSach(), item.getSoLuong());
		   }
		   JFreeChart chart =ChartFactory.createPieChart("Biểu đồ tròn Số Lượng Sách", dataset, true, true, false);
		   ChartPanel chartPanel = new ChartPanel(chart);
		   jpnItem.removeAll();
	        jpnItem.setLayout(new CardLayout());
	        jpnItem.add(chartPanel);
	        jpnItem.validate();
	        jpnItem.repaint();
	   }
	   
   }
}
