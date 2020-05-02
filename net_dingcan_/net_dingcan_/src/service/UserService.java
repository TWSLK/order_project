package service;

import java.util.List;

import entity.User;


public interface UserService {
	public User login(String username,String password);
	public boolean reg(User user);
	public List<User> list();
	public void del(User user); 
	public User load(int userid);
	public String listjson();
	
}
