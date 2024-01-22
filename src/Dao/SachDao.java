package Dao;

import java.util.List;

import Model.Sach;

public interface SachDao {
	 public List<Sach> getList();
	  
	  public int createOrUpdate(Sach sach);
	  
	  public int delete (Sach sach);
}
