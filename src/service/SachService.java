package service;

import java.util.List;

import Model.Sach;

public interface SachService {
	 public List<Sach> getList();
	  
	  public int createOrUpdate(Sach sach);
	  
	  public int delete (Sach sach);
}
