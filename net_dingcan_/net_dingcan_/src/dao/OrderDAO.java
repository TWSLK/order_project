package dao;


import java.util.List;

import entity.Order;




public interface OrderDAO {

	public boolean save(Order order);
	public boolean update_table(int orderid,String table_name);
	public boolean update_shangcai(int orderid);
	public boolean update_comments(int orderid,String comment);
	public List<Order> list(int user_id);
	public List<Order> list();
	public Order load(int id);
	public boolean checkisbuy(String goods_name,int userid);
}
