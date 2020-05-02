/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:CartList.java
 */
package com.common.bean;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author KingKong¬∑HE
 * @Time 2014Âπ?1Êú?17Êó? ‰∏ãÂçà4:44:35
 */
public class CartList2 {
		public static class Attr{
			public static final String USER_ID = "user_id";
			public static final String GOODS_PRICE = "goods_price";
			public static final String CART_ID = "id";
			public static final String GOODS_NUM = "goods_num";
			public static final String GOODS_ID = "goods_id";
			public static final String GOODS_NAME = "goods_name";
			public static final String GOODS_IMAGE = "goods_image";
			public static final String GOODS_TABLE = "table_name";
		}
		private String user_id;
		private String goods_price;
		private String cart_id;
		private String goods_num;
		private String goods_id;
		private String goods_name;
		private String goods_image;
		private String table_name;


		private boolean Selected =false;
		
		public CartList2() {
		}
		






		public CartList2(String user_id, String goods_price, String cart_id,
				String goods_num, String goods_id, String goods_name,
				String goods_image,String table_name) {
			super();
			this.user_id = user_id;
			this.goods_price = goods_price;
			this.cart_id = cart_id;
			this.goods_num = goods_num;
			this.goods_id = goods_id;
			this.goods_name = goods_name;
			this.goods_image = goods_image;
			this.table_name = table_name;
		}







		public static ArrayList<CartList2> newInstanceList(String jsonDatas){
			ArrayList<CartList2> AdvertDatas = new ArrayList<CartList2>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String user_id = obj.optString(Attr.USER_ID);
					String goods_price = obj.optString(Attr.GOODS_PRICE);
					String cart_id = obj.optString(Attr.CART_ID);
					String goods_num = obj.optString(Attr.GOODS_NUM);
					String goods_id = obj.optString(Attr.GOODS_ID);
					String goods_name = obj.optString(Attr.GOODS_NAME);
					String goods_image = obj.optString(Attr.GOODS_IMAGE);
					String table_name = obj.optString(Attr.GOODS_TABLE);
					CartList2 cartlist = new CartList2(user_id, goods_price, cart_id, goods_num, goods_id, goods_name, goods_image,table_name);
					System.out.println("cartlist11-->" + cartlist.toString());
					AdvertDatas.add(cartlist);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}


		public boolean isSelected() {
			return Selected;
		}


		public void setSelected(boolean selected) {
			Selected = selected;
		}




		public String getGoods_price() {
			return goods_price;
		}


		public void setGoods_price(String goods_price) {
			this.goods_price = goods_price;
		}


		public String getCart_id() {
			return cart_id;
		}


		public void setCart_id(String cart_id) {
			this.cart_id = cart_id;
		}


		public String getGoods_num() {
			return goods_num;
		}


		public void setGoods_num(String goods_num) {
			this.goods_num = goods_num;
		}


		public String getGoods_id() {
			return goods_id;
		}


		public void setGoods_id(String goods_id) {
			this.goods_id = goods_id;
		}




		public String getGoods_name() {
			return goods_name;
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







		public String getUser_id() {
			return user_id;
		}







		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}







		@Override
		public String toString() {
			return "CartList2 [user_id=" + user_id + ", goods_price="
					+ goods_price + ", cart_id=" + cart_id + ", goods_num="
					+ goods_num + ", goods_id=" + goods_id + ", goods_name="
					+ goods_name + ", goods_image=" + goods_image + "]";
		}







		public String getTable_name() {
			return table_name;
		}







		public void setTable_name(String table_name) {
			this.table_name = table_name;
		}






	

}
