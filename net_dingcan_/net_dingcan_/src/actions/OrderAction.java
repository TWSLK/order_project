package actions;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import service.OrderService;

import entity.Order;


public class OrderAction extends BaseAction {
	private String user_id;
	private String goods_name;
	private int userid;
	private String cartlist;
	private Order order;
	private String jsonString;
	private OrderService orderservice;
	private List<Order> list ;
	private String beizhu;
	private String table_name;
	private String comment;
	private int orderid;

	public String save() {
		
		try {
			cartlist =URLDecoder.decode(cartlist, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag=orderservice.save(Integer.parseInt(user_id), cartlist,beizhu);
		if(flag){
			jsonString="1";
		}else{
			jsonString="0";
		}
		return SUCCESS;
	}
	
	public String confirm() {
		boolean flag=orderservice.confirm(order);
		if(flag){
			jsonString="1";
		}else{
			jsonString="0";
		}
		return SUCCESS;
	}
	
	public String update_table() {
		boolean flag=orderservice.update_table(orderid, table_name);
		if(flag){
			jsonString="1";
		}else{
			jsonString="0";
		}
		return SUCCESS;
	}
	public String update_comment() {
		boolean flag=orderservice.update_comment(orderid, comment);
		if(flag){
			jsonString="1";
		}else{
			jsonString="0";
		}
		return SUCCESS;
	}
	
	public String checkisbuy() {
		String goods_name_ = null;
		try {
			 goods_name_=URLDecoder.decode(goods_name, "utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag=orderservice.checkisbuy(goods_name_, userid);
		if(flag){
			jsonString="1";
		}else{
			jsonString="0";
		}
		return SUCCESS;
	}
	
	public String fahuo() {
		String kuaidi = order.getKuaidi();
		order = orderservice.load(order.getId());
		order.setStatus(1);
		order.setKuaidi(kuaidi);
		boolean flag=orderservice.save(order);
		if(flag){
			jsonString="1";
		}else{
			jsonString="0";
		}
		return SUCCESS;
	}
	public String fahuoin() {
//		order = orderservice.load(order.getId());
		orderservice.update_shangcai(order.getId());
		return SUCCESS;
	}
	
	public String listJson() {
		jsonString = orderservice.list(Integer.parseInt(user_id));
	
		return SUCCESS;
	}
	public String list() {
		list = orderservice.list();
		
		return SUCCESS;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getCartlist() {
		return cartlist;
	}

	public void setCartlist(String cartlist) {
		this.cartlist = cartlist;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public OrderService getOrderservice() {
		return orderservice;
	}

	public void setOrderservice(OrderService orderservice) {
		this.orderservice = orderservice;
	}

	public List<Order> getList() {
		return list;
	}

	public void setList(List<Order> list) {
		this.list = list;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	


}
