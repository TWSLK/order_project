/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:Login.java
 */
package com.common.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author KingKong·HE
 * @Time 2014年1月17日 下午4:44:35
 */
public class LoginBean {
		public static class Attr{
			public static final String KEY = "key";
			public static final String USERNAME = "username";
		}
		
		private String key;
		private String username;
		
		public LoginBean() {
		}


		public LoginBean(String key, String username) {
			super();
			this.key = key;
			this.username = username;
		}


		public static LoginBean  newInstanceList(String json){
			LoginBean bean = null;
			try {
				JSONObject obj = new JSONObject(json);
				String userstr = obj.optString("jsonString");
				JSONObject user = new JSONObject(userstr);
				
				
//				System.out.println(obj.optString("username"));
				if(obj.length()> 0){
					String username = user.optString("username");
					String key = user.optString("id");
					 bean = new LoginBean(key, username);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return bean;
		}


		public String getKey() {
			return key;
		}


		public void setKey(String key) {
			this.key = key;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		@Override
		public String toString() {
			return "Login [key=" + key + ", username=" + username + "]";
		}
		
}
