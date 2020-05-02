package service;

import java.util.List;

import entity.Desk;




public interface DeskService {
	
	public boolean save(Desk desk);
	public void del(Desk desk);
	public List<Desk> list();
	public Desk load(int goods_id);
	public String loadAllJson();
	
	

}
