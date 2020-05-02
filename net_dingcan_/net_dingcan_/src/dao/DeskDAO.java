package dao;


import java.util.List;

import entity.Desk;




public interface DeskDAO {

	public boolean save(Desk desk);
	public boolean del(Desk desk);
	public Desk load(int id);
	public boolean update(Desk desk);
	public boolean update0(String name);
	public boolean update1(String name);
	public List<Desk> list();
}
