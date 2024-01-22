package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dao.TaiKhoanDao.TaiKhoanDAO;
import Model.TaiKhoan;

public class TaiKhoanDaoImplement implements TaiKhoanDAO{

	@Override
	public TaiKhoan login(String tenDangNhap, String matKhau) {
		Connection connection =DBconnection.getConnection();
		 String sql = "SELECT * FROM cuoiky1.tai_khoan1 WHERE ten_dang_nhap LIKE ? AND mat_khau LIKE ?";
	        TaiKhoan taiKhoan = null;
	        try {
	            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
	            ps.setString(1, tenDangNhap);
	            ps.setString(2, matKhau);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                taiKhoan = new TaiKhoan();
	                
	                taiKhoan.setTen_dang_nhap(rs.getString("ten_dang_nhap"));
	                taiKhoan.setMat_khau(rs.getString("mat_khau"));
	                taiKhoan.setTinh_trang(rs.getBoolean("tinh_trang"));
	            }
	            ps.close();
	            connection.close();
	            return taiKhoan;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return null;
	}

	

}
