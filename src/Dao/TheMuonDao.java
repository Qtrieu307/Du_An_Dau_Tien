package Dao;

import java.util.List;

import Model.TheMuon;

public interface TheMuonDao {

	public List<TheMuon> getList();
    public int createOrUpdate(TheMuon theMuon);
	public int delete(TheMuon theMuon);
	
}
