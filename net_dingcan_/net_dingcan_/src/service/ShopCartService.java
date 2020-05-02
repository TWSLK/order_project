package service;

import java.util.List;

import entity.ShopCart;


public interface ShopCartService {
	public boolean save(ShopCart cart);
	public boolean del(ShopCart cart);
	public String list(int userid);
}
