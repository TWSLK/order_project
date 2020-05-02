package com.common.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	public static final String URL_BASE = "http://10.0.2.2:8080/net_dingcan_/";
	public static final String URL_CARTORDER=URL_BASE+"order_save.action?";
	public static final String URL_LOGIN = URL_BASE + "user_login.action?";
	public static final String URL_REGISTER = URL_BASE + "user_reg.action?";
	public static final String URL_SAVEPROJ = URL_BASE + "biotech_saveproj.action?";
	public static final String URL_SAVECK = URL_BASE + "biotech_saveck.action?";
	public static final String URL_DUANZILIST = URL_BASE + "biotech_listjson0.action";
	public static final String URL_XINWENLIST = URL_BASE + "biotech_listjson1.action";
	public static final String URL_GOODSLIST = URL_BASE + "goodsjson.action";
	public static final String URL_GOODSLIST1 = URL_BASE + "list_tuijian.action";
	public static final String URL_DESKLIST = URL_BASE + "desk_listjson.action";
	public static final String URL_UPDATETABLE = URL_BASE + "order_update_table.action?";
	public static final String URL_GOODSDETAIL = URL_BASE + "detailjson.action?goods_id=";
	public static final String URL_PROJLIST = URL_BASE + "biotech_listjson2.action";
	public static final String URL_ADD_CART=URL_BASE+"shopcart_save.action?";
	public static final String URL_CHECKISBUY=URL_BASE+"order_checkisbuy.action?";
	public static final String URL_CKLIST = URL_BASE + "biotech_listjson3.action";
	public static final String URL_MESSAGELIST = URL_BASE + "comments_listmsgjson?userid=";
	public static final String URL_FAXIANLIST = URL_BASE + "biotech_listjson1.action";
	public static final String URL_FRIENDSLIST = URL_BASE + "user_listjson.action";
	public static final String URL_DUANZILISTUSER = URL_BASE + "biotech_listjsonbyuser.action?";
	public static final String URL_DUANZILISTUSERFOLDER = URL_BASE + "biotech_listjsonbyfolder.action?userid=";
	public static final String URL_BASEUPLOAD = URL_BASE + "upload/";
	public static final String URL_SHOPCART=URL_BASE+"shopcart_list.action?";
	public static final String URL_CARTDEL=URL_BASE+"shopcart_del.action?";
	public static final String URL_ORDERCONFIRM=URL_BASE+"confirmjson.action?";
	public static final String URL_ORDERLIST=URL_BASE+"order_listjson.action?";
	public static final String URL_BIO_ADD = URL_BASE
			+ "biotech_uploadarticle.action?";
	public static final String URL_GOOD_ADD = URL_BASE
			+ "goods_saveclient.action?";
	public static final String URL_BIODETAIL = URL_BASE
			+ "biotech_detailjson.action?id=";
	public static final String URL_ZANDIAN = URL_BASE
			+ "biotech_dianzan.action?biotech.id=";
	public static final String URL_SHOUCANG = URL_BASE
			+ "biotech_addfolder.action?";
	public static final String URL_COMMENTSADD = URL_BASE
			+ "comments_save.action?";
	public static final String URL_COMMENTSADD1 = URL_BASE
			+ "order_update_comment.action?";
	public static final String URL_MESSAGESADD = URL_BASE
			+ "comments_savemsg.action?";
	public static final String URL_DUANZICOMMENTS = URL_BASE
			+ "comments_listjson.action?luxianid=";
	public static final String URL_LOAD = URL_BASE + "user_load.action?";
	// public static final String BASE_URL="http://192.168.0.164:8080/kycheck/";
	// 获得Get请求对象request
	public static HttpGet getHttpGet(String url) {
		HttpGet request = new HttpGet(url);
		return request;
	}

	// 获得Post请求对象request
	public static HttpPost getHttpPost(String url) {
		HttpPost request = new HttpPost(url);
		return request;
	}

	// 根据请求获得响应对象response
	public static HttpResponse getHttpResponse(HttpGet request)
			throws ClientProtocolException, IOException {
		HttpResponse response = new DefaultHttpClient().execute(request);
		return response;
	}

	// 根据请求获得响应对象response
	public static HttpResponse getHttpResponse(HttpPost request)
			throws ClientProtocolException, IOException {
		HttpResponse response = new DefaultHttpClient().execute(request);
		return response;
	}

	// 发送Post请求，获得响应查询结果
	public static String queryStringForPost(String url) {
		// 根据url获得HttpPost对象
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if (response.getStatusLine().getStatusCode() == 200) {
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				return result;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			return result;
		}
		return null;
	}

	// 获得响应查询结果
	public static String queryStringForPost(HttpPost request) {
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if (response.getStatusLine().getStatusCode() == 200) {
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				return result;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			return result;
		}
		return null;
	}

	// 发送Get请求，获得响应查询结果
	public static String queryStringForGet(String url) {
		// 获得HttpGet对象
		HttpGet request = HttpUtil.getHttpGet(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if (response.getStatusLine().getStatusCode() == 200) {
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				return result;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			return result;
		}
		return null;
	}
}
