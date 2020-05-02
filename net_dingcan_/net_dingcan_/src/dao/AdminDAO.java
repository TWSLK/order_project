package dao;



import entity.Admin;



public interface AdminDAO {

	public Admin load(String username,String password);
}
