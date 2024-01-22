package service;

import java.util.List;

import Model.TheMuon;

public interface TheMuonService {
	  
	  public List<TheMuon> getList();
	  
	  public int createOrUpdate(TheMuon theMuon);
	  
	  public int delete (TheMuon theMuon);
}
