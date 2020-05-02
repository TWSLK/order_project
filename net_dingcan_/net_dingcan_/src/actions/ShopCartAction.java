package actions;

import service.ShopCartService;
import entity.ShopCart;

public class ShopCartAction extends BaseAction {
	private ShopCart shopcart;
	private String goods_id;
	private String user_id;
	private String cart_id;
	private String goods_num; 
	private ShopCartService shopcartservice;
	private String jsonString;
	private String cartlist;
	private String table_name;

	public String save() {
		shopcart = new ShopCart(Integer.parseInt(goods_id), Integer
				.parseInt(user_id), Integer.parseInt(goods_num), 0,table_name);
		boolean flag=shopcartservice.save(shopcart);
		if(flag){
			jsonString ="1";
		}else{
			jsonString ="0";
		}
		return SUCCESS;
	}
	
	public String list(){
		int userid = Integer.parseInt(user_id);
		jsonString = shopcartservice.list(userid);
		return SUCCESS;
	}
	public String del() {
		shopcart = new ShopCart();
		shopcart.setId(Integer.parseInt(cart_id));
		boolean flag=shopcartservice.del(shopcart);
		if(flag){
			jsonString ="1";
		}else{
			jsonString ="0";
		}
		return SUCCESS;
	}
	public String order() {
		System.out.println(user_id);
		System.out.println(cartlist);
		return SUCCESS;
	}
	public ShopCart getShopcart() {
		return shopcart;
	}

	public void setShopcart(ShopCart shopcart) {
		this.shopcart = shopcart;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goodsId) {
		goods_id = goodsId;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(String goodsNum) {
		goods_num = goodsNum;
	}

	public ShopCartService getShopcartservice() {
		return shopcartservice;
	}

	public void setShopcartservice(ShopCartService shopcartservice) {
		this.shopcartservice = shopcartservice;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cartId) {
		cart_id = cartId;
	}

	public String getCartlist() {
		return cartlist;
	}

	public void setCartlist(String cartlist) {
		this.cartlist = cartlist;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

}
