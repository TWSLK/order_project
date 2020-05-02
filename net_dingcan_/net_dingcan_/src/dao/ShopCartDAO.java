package dao;


import java.util.List;

import entity.ShopCart;




public interface ShopCartDAO {

	public boolean save(ShopCart cart);
	public List<ShopCart> list(int userid);
	public ShopCart load(int cartid);
	public boolean del(ShopCart cart);
}
