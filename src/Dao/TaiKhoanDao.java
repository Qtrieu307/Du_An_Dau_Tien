package Dao;

import Model.TaiKhoan;

public class TaiKhoanDao {
	

	public interface TaiKhoanDAO {
	    
	    public TaiKhoan login(String tenDangNhap, String matKhau);
	    
	}
}
