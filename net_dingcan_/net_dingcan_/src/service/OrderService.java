package service;

import java.util.List;

import entity.Order;




public interface OrderService {
	public boolean save(int user_id,String cartlist,String beizhu);
	public boolean save(Order order);
	public String list(int user_id);
	public List<Order> list();
	public Order load(int id);
	public boolean confirm(Order order);
	public boolean checkisbuy(String goods_name, int userid);
	public boolean update_table(int orderid, String table_name);
	public boolean update_comment(int orderid, String comment);
	public boolean update_shangcai(int orderid);
}
