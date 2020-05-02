package dao.impl;

import java.util.List;

import dao.ShopCartDAO;
import entity.ShopCart;


public class ShopCartDaoImpl extends BaseDAO implements ShopCartDAO {

	@Override
	public boolean save(ShopCart cart) {
		// TODO Auto-generated method stub
		return saveOrUpdate(cart);
	}

	@Override
	public List<ShopCart> list(int userid) {
		StringBuffer sb = null;
		if(userid >0){
			 sb = new StringBuffer("FROM ShopCart WHERE user_id =")
			.append(userid);
		}
		
		List<ShopCart> lst = findByHQL(sb.toString());
		
		
		 return lst;
	}

	@Override
	public boolean del(ShopCart cart) {
		// TODO Auto-generated method stub
		this.delete(cart);
		return true;
	}

	@Override
	public ShopCart load(int cartid) {
		StringBuffer sb = new StringBuffer("FROM ShopCart WHERE id = ")
		.append(cartid);
		
		List<ShopCart> lst = findByHQL(sb.toString());
		if(lst.size()>0){
			return lst.get(0);
		}else{
			return null;
		}
	}

}
