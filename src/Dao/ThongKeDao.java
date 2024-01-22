package Dao;

import java.util.List;

import Model.Sach;
import Model.TheMuon;


public interface ThongKeDao {

	public List<TheMuon> getList();
	public List<Sach> getListSach();
}
