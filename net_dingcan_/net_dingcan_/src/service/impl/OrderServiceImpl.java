package service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import dao.DeskDAO;
import dao.GoodsDAO;
import dao.OrderDAO;
import dao.ShopCartDAO;
import dao.UserDAO;
import entity.Goods;
import entity.Order;
import entity.ShopCart;
import entity.User;

import service.OrderService;

import net.sf.json.JSONArray;


public class OrderServiceImpl implements OrderService{
	private OrderDAO orderdao;
	private UserDAO userdao;
	private ShopCartDAO shopcartdao;
	private GoodsDAO goodsdao;
	private DeskDAO deskdao;
	@Override
	public boolean save(int userId, String cartlist,String  beizhu) {
		// TODO Auto-generated method stub
		User user  = userdao.findUserById(userId);
//		cartlist = cartlist.substring(1,cartlist.length()-1);
		String[] cartlst = cartlist.split(",");
		Integer crtid=0;
		String name="";
		float total=0f;
		String table_name="";
		for(int i=0;i<cartlst.length;i++){
			String cartid = cartlst[i].split("\\|")[0];
			 table_name = cartlst[i].split("\\|")[2];
			String num = cartlst[i].split("\\|")[1];
		
			 crtid = Integer.parseInt(cartid);
			Integer num_ = Integer.parseInt(num);
			ShopCart cart = shopcartdao.load(crtid);
			cart.setStatus(1);
			shopcartdao.save(cart);
			int goods_id = cart.getGoods_id();
			Goods good = goodsdao.load(goods_id);
//			order.setAddress(user.getCity());
			total+=good.getGoods_price()*num_;
			name+=good.getGoods_name()+"*"+num_+"\n";
			deskdao.update1(table_name);
			
			
			
		}
		
		Order order = new Order();
		order.setCart_id(crtid);
		order.setUser_id(userId);
		order.setGoods_image("");
		order.setGoods_name(name);
		order.setTable_name(table_name);
		order.setPrice(total);
//		order.setUsername(user.getNickname());
		order.setStatus(0);
		order.setBeizhu(beizhu);
		order.setOrderdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		orderdao.save(order);
		return true;
	}
	public OrderDAO getOrderdao() {
		return orderdao;
	}
	public void setOrderdao(OrderDAO orderdao) {
		this.orderdao = orderdao;
	}
	public UserDAO getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
	public ShopCartDAO getShopcartdao() {
		return shopcartdao;
	}
	public void setShopcartdao(ShopCartDAO shopcartdao) {
		this.shopcartdao = shopcartdao;
	}
	public GoodsDAO getGoodsdao() {
		return goodsdao;
	}
	public void setGoodsdao(GoodsDAO goodsdao) {
		this.goodsdao = goodsdao;
	}
	@Override
	public String list(int user_id) {
		List<Order> list = orderdao.list(user_id);
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}
	@Override
	public List<Order> list() {
		List<Order> list = orderdao.list();
		List<Order> list2 = new ArrayList<Order>();
		for(Order o:list){
			User user = userdao.load(o.getUser_id());
			if(user != null){
				o.setAddress(user.getAddress());
				o.setUsername(user.getUsername());
			}
			
			list2.add(o);
		}
		return list2;
	}
	@Override
	public boolean save(Order order) {
		// TODO Auto-generated method stub
		return orderdao.save(order);
	}
	@Override
	public Order load(int id) {
		// TODO Auto-generated method stub
		return orderdao.load(id);
	}
	@Override
	public boolean confirm(Order order) {
		// TODO Auto-generated method stub
		Order o = load(order.getId());
		o.setStatus(3);
		deskdao.update0(o.getTable_name());
		return save(o);
	}
	@Override
	public boolean checkisbuy(String goods_name, int userid) {
		// TODO Auto-generated method stub
		return orderdao.checkisbuy(goods_name, userid);
	}
	public DeskDAO getDeskdao() {
		return deskdao;
	}
	public void setDeskdao(DeskDAO deskdao) {
		this.deskdao = deskdao;
	}
	@Override
	public boolean update_table(int orderid, String table_name) {
		// TODO Auto-generated method stub
		return orderdao.update_table(orderid, table_name);
	}
	@Override
	public boolean update_comment(int orderid, String comment) {
		// TODO Auto-generated method stub
		return orderdao.update_comments(orderid, comment);
	}
	@Override
	public boolean update_shangcai(int orderid) {
		// TODO Auto-generated method stub
		return orderdao.update_shangcai(orderid);
	}
	
	

}
