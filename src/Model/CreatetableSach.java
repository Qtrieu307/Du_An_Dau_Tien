package Model;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;

import Model.Sach;

public class CreatetableSach {
	
	   public static DefaultTableModel setTableSach(List<Sach> listItem, String[] listColum) {
	        DefaultTableModel dtm = new DefaultTableModel() {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }

	            @Override
	            public Class<?> getColumnClass(int columnIndex) {
	                return columnIndex == 7 ? Boolean.class : String.class;
	            }
	        };

	        dtm.setColumnIdentifiers(listColum);

	        // Check if listItem is not null before processing
	        if (listItem != null) {
	            for (int i = 0; i < listItem.size(); i++) {
	                Sach sach = listItem.get(i);
	                Object[] obj = new Object[listColum.length];
	                obj[0] = sach.getID();
	                obj[1] =sach.getMaSach();
	          
	                obj[2] =sach.getTenSach();
	                obj[3] = sach.getTenTacGia();
	                obj[4] = sach.getNgayXuatBan();
	               
	                obj[5] =sach.getSoLuong();
	                obj[6] =sach.getGiaTien();

	                dtm.addRow(obj);
	            }
	        }

	        return dtm;
	    }
	}


