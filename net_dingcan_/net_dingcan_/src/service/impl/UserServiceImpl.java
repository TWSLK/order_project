package service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import service.UserService;


import dao.UserDAO;
import entity.User;


public class UserServiceImpl implements UserService {
	private UserDAO userdao;
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = userdao.login(username, password);
		if(user == null){
			return null;
		}else{
			return user;
		}
	}
	@Override
	public boolean reg(User user) {
		// TODO Auto-generated method stub
		return userdao.reg(user);
	}
	public UserDAO getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userdao.list();
	}
	@Override
	public void del(User user) {
		userdao.del(user);
		
	}
	@Override
	public User load(int userid) {
		// TODO Auto-generated method stub
		return userdao.load(userid);
	}
	@Override
	public String listjson() {
		List<User> list = userdao.list();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}
	
	
	
	
	
}
