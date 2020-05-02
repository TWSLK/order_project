package dao.impl;

import java.util.List;

import dao.OrderDAO;
import entity.Order;

public class OrderCartDaoImpl extends BaseDAO implements OrderDAO {

	@Override
	public boolean save(Order order) {
		// TODO Auto-generated method stub
		return this.saveOrUpdate(order);
	}

	@Override
	public List<Order> list(int user_id) {
		StringBuffer sb;
		sb = new StringBuffer("FROM Order WHERE user_id = ").append(user_id);

		List<Order> lst = findByHQL(sb.toString());
		return lst;
	}

	@Override
	public List<Order> list() {
		StringBuffer sb;
		sb = new StringBuffer("FROM Order").append(" order by id desc");

		List<Order> lst = findByHQL(sb.toString());
		return lst;
	}

	@Override
	public Order load(int id) {
		StringBuffer sb;
		sb = new StringBuffer("FROM Order WHERE id = ").append(id);

		List<Order> lst = findByHQL(sb.toString());
		return lst.get(0);
	}

	@Override
	public boolean checkisbuy(String goods_name, int userid) {
		StringBuffer sb;
		sb = new StringBuffer("FROM Order WHERE goods_name = '").append(goods_name).append("' and user_id=").append(userid);

		List<Order> lst = findByHQL(sb.toString());
		if(lst.size()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean update_table(int orderid, String table_name) {
		// TODO Auto-generated method stub
		StringBuffer sb;
		sb = new StringBuffer("update Order set table_name ='").append(table_name).append("' WHERE id = ").append(orderid);
		try {
			this.executeHql(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update_comments(int orderid, String comment) {
		StringBuffer sb;
		sb = new StringBuffer("update Order set comment ='").append(comment).append("' WHERE id = ").append(orderid);
		try {
			this.executeHql(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update_shangcai(int orderid) {
		StringBuffer sb;
		sb = new StringBuffer("update Order set status =1").append(" WHERE id = ").append(orderid);
		try {
			this.executeHql(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
