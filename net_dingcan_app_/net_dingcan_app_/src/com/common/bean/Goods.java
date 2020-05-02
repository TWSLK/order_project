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

/**
 * @author KingKong¬∑HE
 * @Time 2014Âπ?1Êú?17Êó? ‰∏ãÂçà4:44:35
 */
public class Goods {
		public static class Attr{
			public static final String GOODS_ID = "goods_id";
			public static final String GOODS_PRICE = "goods_price";
			public static final String GOODS_MARKETPRICE = "goods_marketprice";
			public static final String GOODS_NAME = "goods_name";
			public static final String GOODS_IMAGE = "goods_image";
			public static final String GOODS_SALENUM = "goods_salenum";
			public static final String EVAUATION_GOOD_STAR = "evaluation_good_star";
			public static final String EVALUATION_COUNT = "evaluation_count";
			public static final String GROUP_FLAG = "group_flag";
			public static final String XIANSHI_FLAG = "xianshi_flag";
			public static final String GOODS_IMAGES_URL = "goods_image_url";
		}
		private String goods_id;
		private String goods_price;
		private String goods_marketprice;
		private String goods_image;
		private String goods_salenum;
		private String evaluation_good_star;
		private String evaluation_count;
		private String group_flag;
		private String xianshi_flag;
		private String goods_image_url;
		private String goods_name;
		
		public Goods() {
		}
		

		public Goods(String goods_id, String goods_price,
				String goods_marketprice, String goods_image,
				String goods_salenum, String evaluation_good_star,
				String evaluation_count, String group_flag,
				String xianshi_flag, String goods_image_url, String goods_name) {
			super();
			this.goods_id = goods_id;
			this.goods_price = goods_price;
			this.goods_marketprice = goods_marketprice;
			this.goods_image = goods_image;
			this.goods_salenum = goods_salenum;
			this.evaluation_good_star = evaluation_good_star;
			this.evaluation_count = evaluation_count;
			this.group_flag = group_flag;
			this.xianshi_flag = xianshi_flag;
			this.goods_image_url = goods_image_url;
			this.goods_name = goods_name;
		}


		public static ArrayList<Goods> newInstanceList(String jsonDatas){
			ArrayList<Goods> AdvertDatas = new ArrayList<Goods>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String goods_id = obj.optString(Attr.GOODS_ID);
					String goods_price = obj.optString(Attr.GOODS_PRICE);
					String goods_marketprice = obj.optString(Attr.GOODS_MARKETPRICE);
					String goods_image = obj.optString(Attr.GOODS_IMAGE);
					String goods_salenum = obj.optString(Attr.GOODS_SALENUM);
					String evaluation_good_star = obj.optString(Attr.EVAUATION_GOOD_STAR);
					String evaluation_count = obj.optString(Attr.EVALUATION_COUNT);
					String group_flag = obj.optString(Attr.GROUP_FLAG);
					String xianshi_flag = obj.optString(Attr.XIANSHI_FLAG);
					String goods_image_url = obj.optString(Attr.GOODS_IMAGES_URL);
					String goods_name = obj.optString(Attr.GOODS_NAME);
					Goods bean =new Goods(goods_id, goods_price, goods_marketprice, goods_image, goods_salenum, evaluation_good_star, evaluation_count, group_flag, xianshi_flag, goods_image_url, goods_name);
					//System.out.println("goodlist-->" + bean.toString());
					AdvertDatas.add(bean);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}


		public String getGoods_id() {
			return goods_id;
		}


		public void setGoods_id(String goods_id) {
			this.goods_id = goods_id;
		}


		public String getGoods_price() {
			return goods_price;
		}


		public void setGoods_price(String goods_price) {
			this.goods_price = goods_price;
		}


		public String getGoods_marketprice() {
			return goods_marketprice;
		}


		public void setGoods_marketprice(String goods_marketprice) {
			this.goods_marketprice = goods_marketprice;
		}


		public String getGoods_image() {
			return goods_image;
		}


		public void setGoods_image(String goods_image) {
			this.goods_image = goods_image;
		}


		public String getGoods_salenum() {
			return goods_salenum;
		}


		public void setGoods_salenum(String goods_salenum) {
			this.goods_salenum = goods_salenum;
		}


		public String getEvaluation_good_star() {
			return evaluation_good_star;
		}


		public void setEvaluation_good_star(String evaluation_good_star) {
			this.evaluation_good_star = evaluation_good_star;
		}


		public String getEvaluation_count() {
			return evaluation_count;
		}


		public void setEvaluation_count(String evaluation_count) {
			this.evaluation_count = evaluation_count;
		}


		public String getGroup_flag() {
			return group_flag;
		}


		public void setGroup_flag(String group_flag) {
			this.group_flag = group_flag;
		}


		public String getXianshi_flag() {
			return xianshi_flag;
		}


		public void setXianshi_flag(String xianshi_flag) {
			this.xianshi_flag = xianshi_flag;
		}


		public String getGoods_image_url() {
			return goods_image_url;
		}


		public void setGoods_image_url(String goods_image_url) {
			this.goods_image_url = goods_image_url;
		}


		public String getGoods_name() {
			return goods_name;
		}


		public void setGoods_name(String goods_name) {
			this.goods_name = goods_name;
		}


		@Override
		public String toString() {
			return "GoodsList [goods_id=" + goods_id + ", goods_price="
					+ goods_price + ", goods_marketprice=" + goods_marketprice
					+ ", goods_image=" + goods_image + ", goods_salenum="
					+ goods_salenum + ", evaluation_good_star="
					+ evaluation_good_star + ", evaluation_count="
					+ evaluation_count + ", group_flag=" + group_flag
					+ ", xianshi_flag=" + xianshi_flag + ", goods_image_url="
					+ goods_image_url + ", goods_name=" + goods_name+ "]";
		}
		

}
