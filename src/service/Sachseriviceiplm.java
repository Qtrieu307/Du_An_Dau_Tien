package service;

import java.util.List;
import Dao.SachDao;
import Dao.SachDaoImplements;
import Model.Sach;

public class Sachseriviceiplm implements SachService{

	private SachDao sachDao =null;
	public Sachseriviceiplm () {
		sachDao =new SachDaoImplements();
	}
	@Override
	public List<Sach> getList() {
		// TODO Auto-generated method stub
		return sachDao.getList();
	}

	@Override
	public int createOrUpdate(Sach sach) {
		// TODO Auto-generated method stub
		return sachDao.createOrUpdate(sach);
	}

	@Override
	public int delete(Sach sach) {
		return sachDao.delete(sach);
	}

}
