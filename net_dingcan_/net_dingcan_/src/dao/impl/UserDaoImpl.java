package dao.impl;

import java.util.List;


import dao.AdminDAO;
import dao.UserDAO;
import entity.Admin;
import entity.User;

public class UserDaoImpl extends BaseDAO implements UserDAO {


	@Override
	public User login(String username, String password) {
		StringBuffer sb = new StringBuffer("FROM User WHERE username = '")
		.append(username).append("' and password = '").append(password).append("'");
		
		List<User> lst = findByHQL(sb.toString());
		if(lst.size()>0){
			return lst.get(0);
		}else{
			return null;
		}
	}

	@Override
	public boolean reg(User user) {
		// TODO Auto-generated method stub
		return this.saveOrUpdate(user);
	}

	@Override
	public List<User> list() {
		StringBuffer sb = new StringBuffer("FROM User");
		
		List<User> lst = findByHQL(sb.toString());
		
		return lst;
	}

	@Override
	public boolean del(User user) {
		// TODO Auto-generated method stub
		return deleteById(User.class, user.getId());
	}

	@Override
	public User load(int id) {
		// TODO Auto-generated method stub
		return get(User.class, id);
	}

	@Override
	public User findUserById(int id) {
		StringBuffer sb = new StringBuffer("FROM User WHERE id = ");
		sb.append(id);
			
		List<User> users = findByHQL(sb.toString());
		if(users.size() > 0){
		return users.get(0);
		}else{
		return null;
		}
	}

}
