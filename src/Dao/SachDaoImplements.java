package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Sach;
import Model.TheMuon;

public class SachDaoImplements  implements SachDao{

	@Override
	public List<Sach> getList() {
		 List<Sach> list = new ArrayList<>();

	        try (Connection connection = DBconnection.getConnection()) {
	            String sql = "SELECT * FROM cuoiky1.qlsach";
	            try (PreparedStatement ps = connection.prepareStatement(sql);
	                 ResultSet rs = ps.executeQuery()) {

	                while (rs.next()) {
	                	Sach sach = new Sach();
	                	sach.setID(rs.getInt("ID"));
	                	sach.setMaSach(rs.getString("MaSach"));
	                	sach.setTenSach(rs.getString("TenSach"));
	                	sach.setTenTacGia(rs.getString("TenTacGia"));
	                	
	                	sach.setNgayXuatBan(rs.getDate("NgayXuatBan"));
	                	sach.setSoLuong(rs.getInt("SoLuong"));
	                	sach.setGiaTien(rs.getDouble("GiaTien"));
	                    list.add(sach);
	                }
	            }

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }

	        return list;
		
	}


	@Override
	public int createOrUpdate(Sach sach) {
	    try {
	        Connection connection = DBconnection.getConnection();

	        String sql = "INSERT INTO `cuoiky1`.`qlsach` (`MaSach`, `TenSach`, `TenTacGia`, `NgayXuatBan`, `SoLuong`, `GiaTien`, `ID`)"
	                    + "VALUES (?,?,?,?,?,?,?) "
	                    + "ON DUPLICATE KEY UPDATE MaSach =VALUES(MaSach), TenSach =VALUES(TenSach), TenTacGia =VALUES(TenTacGia), NgayXuatBan =VALUES(NgayXuatBan), SoLuong =VALUES(SoLuong), GiaTien =VALUES(GiaTien), ID =VALUES(ID)";

	        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	        ps.setString(1, sach.getMaSach());
	        ps.setString(2, sach.getTenSach());
	        ps.setString(3, sach.getTenTacGia());
	        ps.setDate(4, new java.sql.Date(sach.getNgayXuatBan().getTime()));
	        ps.setInt(5, sach.getSoLuong());
	        ps.setDouble(6, sach.getGiaTien());
	        ps.setInt(7, sach.getID());

	        ps.execute();

	        ResultSet rs = ps.getGeneratedKeys();
	        int generatedKey = 0;

	        if (rs.next()) {
	            generatedKey = rs.getInt(1);
	        }

	        rs.close();
	        ps.close();
	        connection.close();

	        return generatedKey;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return 0;
	}

	
	 

	@Override
	public int delete(Sach sach) {
		// TODO Auto-generated method stubtry {
        Connection connection = DBconnection.getConnection();
        String sql = "DELETE FROM `cuoiky1`.`qlsach` WHERE (`MaSach` = ?)";

        System.out.println(sql);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, sach.getMaSach());  // Assuming MaThe is a string, adjust accordingly
            int rowsAffected = ps.executeUpdate();
            System.out.println("Số hàng bị ảnh hưởng: " + rowsAffected);
            return rowsAffected;
        }
   catch ( SQLException e) {
	// TODO: handle exception
	   e.printStackTrace();
}
		return 0;
	}



}
