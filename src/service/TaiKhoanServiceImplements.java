package service;

import Dao.TaiKhoanDao.TaiKhoanDAO;
import Dao.TaiKhoanDaoImplement;
import Model.TaiKhoan;

public class TaiKhoanServiceImplements implements TaiKhoanService {

	private TaiKhoanDaoImplement taiKhoanDAO =null;
	
	public TaiKhoanServiceImplements() {
		taiKhoanDAO = new TaiKhoanDaoImplement();
	}

	@Override
	public TaiKhoan login(String tenDangNhap, String matKhau) {
        return taiKhoanDAO.login(tenDangNhap, matKhau);

	}

}
