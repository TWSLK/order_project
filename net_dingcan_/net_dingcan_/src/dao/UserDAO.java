package dao;



import java.util.List;

import entity.Admin;
import entity.User;



public interface UserDAO {

	public User login(String username,String password);
	public User load(int id);
	public boolean reg(User user);
	public boolean del(User user);
	public List<User> list();
	public User findUserById(int id);
}
