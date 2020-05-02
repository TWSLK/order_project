/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.ui.type
 * FileNmae:themesListViewActivity.java
 */
package com.common.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.blueberry.activity.R;
import com.common.adapter.MyOrderListViewAdapter;
import com.common.bean.MyOrderList;
import com.common.util.HttpUtil;
import com.common.util.MyApp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyOrderListViewActivity extends Activity implements
		OnScrollListener {

	private ListView themesListView;
	private MyApp myApp;
	private MyOrderListViewAdapter adapter;
	private ArrayList<MyOrderList> orderlist;
	private ImageView imageBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wish_theme_list);
		myApp = (MyApp) MyOrderListViewActivity.this.getApplicationContext();
		themesListView = (ListView) findViewById(R.id.themesListView);
		// imageBack = (ImageView) findViewById(R.id.imageBack);
		adapter = new MyOrderListViewAdapter(MyOrderListViewActivity.this,
				MyOrderListViewActivity.this);
		themesListView.setAdapter(adapter);
		// themesListView.setSelection(0);

		loadingWishListData();

		/*
		 * imageBack.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * WishListViewActivity.this.finish(); } });
		 */
		themesListView.setOnScrollListener(MyOrderListViewActivity.this);

		themesListView
				.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> arg0,
							View arg1, final int arg2, long arg3) {
						// TODO Auto-generated method stub

						new AlertDialog.Builder(MyOrderListViewActivity.this)
								.setTitle("提示?")
								.setMessage("是否要进行评价?")
								.setNegativeButton("取消",
										new DialogInterface.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												// TODO Auto-generated method
												// stub
												dialog.dismiss();

											}
										})
								.setPositiveButton("确定",
										new DialogInterface.OnClickListener() {
											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												// TODO Auto-generated method
												// stub
												Intent intent = new Intent(MyOrderListViewActivity.this,AddOrderComments.class);
												Bundle b = new Bundle();
												b.putString("id", orderlist.get(arg2).getId()+"");
												intent.putExtras(b);
												startActivity(intent);
											}
										}).show();
						return false;
					}
				});
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
	}

	public void confirm(String order_id) {
		String url = HttpUtil.URL_ORDERCONFIRM;
		if (order_id != null && order_id != "") {
			url += "order.id=" + order_id;
		}

		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if (response.getStatusLine().getStatusCode() == 200) {
				// 获得响应
				result = EntityUtils.toString(response.getEntity());

				try {
					JSONObject obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
					//
					if (arrlist.equals("1")) {
						Toast.makeText(MyOrderListViewActivity.this, "操作成功",
								Toast.LENGTH_SHORT).show();
						;
						loadingWishListData();
					} else {
						Toast.makeText(MyOrderListViewActivity.this, "操作失败",
								Toast.LENGTH_SHORT).show();
						;
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MyOrderListViewActivity.this, result,
					Toast.LENGTH_SHORT).show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MyOrderListViewActivity.this, result,
					Toast.LENGTH_SHORT).show();
			;
		}
	}

	public void loadingWishListData() {
		String url = HttpUtil.URL_ORDERLIST;
		if (myApp.getLoginKey() != null && myApp.getLoginKey() != "") {
			url += "user_id=" + myApp.getLoginKey();
		}

		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if (response.getStatusLine().getStatusCode() == 200) {
				// 获得响应
				result = EntityUtils.toString(response.getEntity());

				try {
					JSONObject obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
					// JSONObject obj = new JSONObject(json);
					if (arrlist != "" && !arrlist.equals("arrlist")
							&& arrlist != null && arrlist != "null"
							&& !arrlist.equals("[]")) {

						orderlist = MyOrderList
								.newInstanceList(arrlist);
						adapter.setOrderlist(orderlist);
						adapter.notifyDataSetChanged();
					} else {
						Toast.makeText(MyOrderListViewActivity.this, "无订单显示",
								Toast.LENGTH_SHORT).show();
						;
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MyOrderListViewActivity.this, result,
					Toast.LENGTH_SHORT).show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MyOrderListViewActivity.this, result,
					Toast.LENGTH_SHORT).show();
			;
		}
	}

	/*
	 * @Override protected void onStart() { super.onStart();
	 * registerBoradcastReceiver(); }
	 * 
	 * @Override protected void onDestroy() { super.onDestroy();
	 * unregisterReceiver(mBroadcastReceiver); }
	 */
	/*	
	*//** 广播事件 */
	/*
	 * private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
	 * 
	 * @Override public void onReceive(Context context, Intent intent) { String
	 * action = intent.getAction(); if (action.equals(Constants.HOST)) {
	 * themesListView.smoothScrollToPosition(0); loadingWishListData(); } } };
	 * 
	 * public void registerBoradcastReceiver() { IntentFilter intentFilter = new
	 * IntentFilter(); intentFilter.addAction(Constants.HOST); // 注册广播
	 * registerReceiver(mBroadcastReceiver, intentFilter); }
	 */

	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {

	}

}
