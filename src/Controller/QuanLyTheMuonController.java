package Controller;



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableRow;

import Model.Createtable;
import Model.TheMuon;
import service.TheMuonService;
import View.QLTMFrame;
import service.TheMuonSeriviceiplm;


public class QuanLyTheMuonController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private Createtable createtable;
    private JButton btnrefresh;
    private final String[] Colum = {"Mã Thẻ", "Tên Người Mượn", "Số Sách Đã Mượn", "Số Sách Đã Trả", "Giới Tính", "Ngày Sinh"};
    private TableRowSorter<TableModel> rowSorter = null;
    private TheMuonService theMuonService = new TheMuonSeriviceiplm(); // Replace with your actual implementation

 
			public QuanLyTheMuonController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch,JButton btnrefresh ) {
		super();
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.jtfSearch = jtfSearch;
		this.btnrefresh =btnrefresh;
		this.createtable =new Createtable();
		
		this.theMuonService = new TheMuonSeriviceiplm();
	}
			


			public QuanLyTheMuonController() {
				this.theMuonService = new TheMuonSeriviceiplm();
				
			}



			public void setDataToTable() {
		        List<TheMuon> listItem = theMuonService.getList();
		        DefaultTableModel model = createtable.setTableTheMuon(listItem, Colum);
		        JTable table = new JTable(model);

		        rowSorter = new TableRowSorter<>(table.getModel());
		        table.setRowSorter(rowSorter);

		        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
		            @Override
		            public void insertUpdate(DocumentEvent e) {
		                String text = jtfSearch.getText();
		                if (text.trim().length() == 0) {
		                    rowSorter.setRowFilter(null);
		                } else {
		                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		                }
		            }

		            @Override
		            public void removeUpdate(DocumentEvent e) {
		                String text = jtfSearch.getText();
		                if (text.trim().length() == 0) {
		                    rowSorter.setRowFilter(null);
		                } else {
		                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		                }
		            }

		            @Override
		            public void changedUpdate(DocumentEvent e) {
		            }
		        });

		        
		        table.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						 if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
			                    DefaultTableModel model = (DefaultTableModel) table.getModel();
			                    int selectedRowIndex = table.getSelectedRow();
			                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

			                    TheMuon theMuon = new TheMuon();
			                    theMuon.setMaThe((int) model.getValueAt(selectedRowIndex, 0));
			                    theMuon.setTenNguoiMuon(model.getValueAt(selectedRowIndex, 1).toString());
			                    System.out.println(selectedRowIndex);

			                    // Uncomment the lines below and update them according to your model
			                    theMuon.setSosachdamuon((int) model.getValueAt(selectedRowIndex, 2));
			                    theMuon.setSosachdatra((int) model.getValueAt(selectedRowIndex, 3));
			                    theMuon.setGioiTinh(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam") ? true : false);
			                    theMuon.setNgaySinh(
			                    	    convertDateToDateSql(
			                    	        convertStringToDate(
			                    	            model.getValueAt(selectedRowIndex, 5).toString(),
			                    	            "yyyy-MM-dd"
			                    	        )
			                    	    )
			                    	);

			                    QLTMFrame frame =new QLTMFrame(theMuon);
								frame.setTitle("Bin");
								frame.setVisible(true);
								frame.setLocationRelativeTo(null);
								frame.setResizable(false);
			                }
						
					}
		            	
		        });



		        
		        // design
		        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		        table.setRowHeight(50);
		        table.validate();
		        table.repaint();
		        
		        JScrollPane scroll = new JScrollPane();
		        scroll.getViewport().add(table);
		        scroll.setPreferredSize(new Dimension(1350, 400));
		        jpnView.removeAll();
		        jpnView.setLayout(new BorderLayout());
		        jpnView.add(scroll);
		       
		        jpnView.validate();
		        jpnView.repaint();
				
		    }
			
				 public void setEvent() {
					btnAdd.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							QLTMFrame frame =new QLTMFrame(new TheMuon());
							frame.setVisible(true);
							frame.setLocationRelativeTo(null);
							frame.setResizable(false);
							
						
						}
						@Override
						public void mouseEntered(MouseEvent e) {
							btnAdd.setBackground(new Color(200,125,30));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							btnAdd.setBackground(new Color(176,224,230));
							super.mouseExited(e);
						}
						
					});
				
		        btnrefresh.addMouseListener(new MouseAdapter() {
				   @Override
				public void mouseClicked(MouseEvent e) {
					
					   setDataToTable();
					super.mouseClicked(e);
				}
				   @Override
					public void mouseEntered(MouseEvent e) {
					
					   btnrefresh.setBackground(new Color(200,125,30));
						
					}
				   @Override
					public void mouseExited(MouseEvent e) {
					   btnrefresh.setBackground(new Color(176,224,230));
					}
		        });		
		        		
			}



    public static Date convertStringToDate(String dateString, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            java.util.Date utilDate = dateFormat.parse(dateString);
            return new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the ParseException appropriately
            return null;
        }
    }

    public static java.sql.Date convertDateToDateSql(java.util.Date utilDate) {
        if (utilDate != null) {
            return new java.sql.Date(utilDate.getTime());
        } else {
            return null;
        }
    }
}
	
