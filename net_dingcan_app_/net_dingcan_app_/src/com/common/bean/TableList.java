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
public class TableList {
		public static class Attr{
			public static final String GOODS_ID = "id";
			public static final String GOODS_NAME = "name";
			public static final String GOODS_STATUS = "status";
		}
		private String id;
		private String name;
		private String status;

		
		public TableList() {
		}
		



		public TableList(String id, String name,String status) {
			super();
			this.id = id;
			this.name = name;
			this.status=status;
		}




		public static ArrayList<TableList> newInstanceList(String jsonDatas){
			ArrayList<TableList> AdvertDatas = new ArrayList<TableList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String goods_id = obj.optString(Attr.GOODS_ID);
					String good_name = obj.optString(Attr.GOODS_NAME);
					String status = obj.optString(Attr.GOODS_STATUS);
			
					TableList bean =new TableList(goods_id, good_name,status);
					//System.out.println("goodlist-->" + bean.toString());
					AdvertDatas.add(bean);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}




		public String getId() {
			return id;
		}




		public void setId(String id) {
			this.id = id;
		}




		public String getName() {
			return name;
		}




		public void setName(String name) {
			this.name = name;
		}




		public String getStatus() {
			return status;
		}




		public void setStatus(String status) {
			this.status = status;
		}


		

}
