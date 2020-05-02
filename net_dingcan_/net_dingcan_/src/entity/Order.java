package entity;

import java.util.Date;

public class Order {
	private int id;
	private int cart_id;
	private int user_id;
	private String orderdate;
	private String username;
	private float price;
	private String goods_name;
	private String kuaidi;
	private String goods_image;
	private String address;
	private String beizhu;
	private int status;
	private String table_name;
	private String comment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cartId) {
		cart_id = cartId;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goodsName) {
		goods_name = goodsName;
	}
	public String getGoods_image() {
		return goods_image;
	}
	public void setGoods_image(String goodsImage) {
		goods_image = goodsImage;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getKuaidi() {
		return kuaidi;
	}
	public void setKuaidi(String kuaidi) {
		this.kuaidi = kuaidi;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	
	

}
