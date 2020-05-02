/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:GoodsList.java
 */
package com.common.bean;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyOrderList {

	/**
	 * private String orderdate; private String username; private float price;
	 * private String goods_name; private String goods_image; private String
	 * address; private int status;
	 *
	 */
	public static class Attr {
		public static final String ORDER_ID = "id";
		public static final String ORDER_DATE = "orderdate";
		public static final String ORDER_USER = "username";
		public static final String ORDER_PRICE = "price";
		public static final String ORDER_GOODS = "goods_name";
		public static final String ORDER_GOODSIMAGE = "goods_image";
		public static final String ORDER_ADDRESS = "address";
		public static final String ORDER_STATUS = "status";
		public static final String ORDER_KUAIDI = "kuaidi";
		public static final String ORDER_TABLE = "table_name";

		@Override
		public String toString() {
			return "Attr [getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}

	}

	private String orderdate; // 发布日期
	private int id;
	private String username; // 心愿类型
	private double price; // 心愿标题
	private String goods_name; // 心愿内容
	private String goods_image; // 是否已完�?
	private String address; // 是否已完�?
	private int status; // 是否已评�?
	private String  kuaidi; //快�??
	private String  table_name; //快�??

	public MyOrderList(String orderdate, String username, double price,
			String goods_name, String goods_image, String address, int status,int id,String kuaidi,String table_name) {
		super();
		this.orderdate = orderdate;
		this.username = username;
		this.price = price;
		this.goods_name = goods_name;
		this.goods_image = goods_image;
		this.address = address;
		this.status = status;
		this.id=id;
		this.kuaidi = kuaidi;
		this.table_name = table_name;
	}

	public MyOrderList() {
	}


	public static ArrayList<MyOrderList> newInstanceList(String jsonDatas) {
		ArrayList<MyOrderList> AdvertDatas = new ArrayList<MyOrderList>();

		try {
			JSONArray arr = new JSONArray(jsonDatas);
			int size = null == arr ? 0 : arr.length();
			System.out.println("size-->" + size);
			for (int i = 0; i < size; i++) {
				JSONObject obj = arr.getJSONObject(i);
				int id =obj.optInt("id");
				String orderdate = obj.optString(Attr.ORDER_DATE); // 发布日期
				String username = obj.optString(Attr.ORDER_USER); // 心愿类型
				Double price = obj.optDouble(Attr.ORDER_PRICE);
				; // 心愿标题
				String goods_name = obj.optString(Attr.ORDER_GOODS); // 心愿内容
				String goods_image = obj.optString(Attr.ORDER_GOODSIMAGE); // 是否已完�?
				String address = obj.optString(Attr.ORDER_ADDRESS); // 是否已完�?
				int status = obj.optInt(Attr.ORDER_STATUS); // 是否已评�?
				String kuaidi =obj.optString(Attr.ORDER_KUAIDI);
				String table_name =obj.optString(Attr.ORDER_TABLE);

				MyOrderList bean = new MyOrderList(orderdate, username, price,
						goods_name, goods_image, address, status,id,kuaidi,table_name);
				AdvertDatas.add(bean);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return AdvertDatas;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public String getKuaidi() {
		return kuaidi;
	}

	public void setKuaidi(String kuaidi) {
		this.kuaidi = kuaidi;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_image() {
		return goods_image;
	}

	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	
}
