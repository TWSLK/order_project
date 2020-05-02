package com.common.activity;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.blueberry.activity.R;
import com.common.bean.BasemarkBean;
import com.common.bean.DuanziBean;
import com.common.bean.Goods;
import com.common.bean.TableList;
import com.common.util.HttpUtil;
import com.common.util.IAsynTask;
import com.common.util.MyApp;
import com.common.util.MyBackAsynaTask;
import com.common.util.SendGETRequest;
import com.common.util.Util;
import com.common.util.Web;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

public class DeskList1 extends Activity {
	@ViewInject(R.id.listView1)
	private GridView listView1;
	private List<TableList> basemarkBeans = new ArrayList<TableList>();
	@ViewInject(R.id.add_new_xd)
	private TextView add_new_xd;
	private MyApp myApp;
	private GameAdapter adapter;
	private String orderid;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		myApp = (MyApp) DeskList1.this.getApplication();
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
				.penaltyLog().penaltyDeath().build());
		setContentView(R.layout.desk_xd_list1);
		ViewUtils.inject(this);
		if (TextUtils.isEmpty(myApp.getLoginName())) {
			add_new_xd.setVisibility(View.INVISIBLE);
		}
		orderid = getIntent().getExtras().getString("orderid");
		adapter = new GameAdapter();
		listView1.setAdapter(adapter);
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				final String table_name = basemarkBeans.get(arg2).getName();
				new AlertDialog.Builder(DeskList1.this).setTitle("提示")  
		        .setMessage("确认要转台到餐桌"+table_name+"吗?").setNegativeButton("取消", new DialogInterface.OnClickListener() {  
		              
		            @Override  
		            public void onClick(DialogInterface dialog, int which) {  
		                // TODO Auto-generated method stub  
		            	dialog.dismiss();
		                  
		            }  
		        }).setPositiveButton("确定", new DialogInterface.OnClickListener(){  
		            @Override  
		            public void onClick(DialogInterface dialog, int which) {  
		                // TODO Auto-generated method stub  
		            	update_table(table_name, orderid);
		                finish();  
		            }  
		        }).show();  
			
			}
		});
		getGameXD();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}

	@OnClick(R.id.top_back)
	public void back(View view) {
		finish();
	}

	@OnClick(R.id.add_new_xd)
	public void addNew(View view) {
	}

	public void getGameXD() {
		String url = HttpUtil.URL_DESKLIST;

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
							&& arrlist != null && !arrlist.equals("[]")) {

						ArrayList<TableList> goods_list = TableList
								.newInstanceList(arrlist);
						basemarkBeans.addAll(goods_list);
						adapter.notifyDataSetChanged();
					} else {
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(DeskList1.this, result, Toast.LENGTH_SHORT).show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(DeskList1.this, result, Toast.LENGTH_SHORT).show();
			;
		}
	}
	public void update_table(String table_name,String orderid) {
		String url = HttpUtil.URL_UPDATETABLE+"table_name="+table_name+"&orderid="+orderid;
		
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
							&& arrlist != null && !arrlist.equals("[]")) {
						
						if(arrlist.equals("1")){
							Toast.makeText(DeskList1.this, "操作成功", Toast.LENGTH_SHORT).show();
							finish();
						}else{
							Toast.makeText(DeskList1.this, "操作失败", Toast.LENGTH_SHORT).show();
							finish();
						}
					} else {
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(DeskList1.this, result, Toast.LENGTH_SHORT).show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(DeskList1.this, result, Toast.LENGTH_SHORT).show();
			;
		}
	}

	private class GameAdapter extends BaseAdapter {
		private LayoutInflater inflater;
		private ArrayList<Goods> duanziList;

		private GameAdapter() {
			inflater = LayoutInflater.from(DeskList1.this);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return basemarkBeans.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return basemarkBeans.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Holder holder;
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.listivew_table_item,
						null);
				holder = new Holder();
				holder.textTable = (TextView) convertView.findViewById(R.id.textTable);
				holder.textTableStatus = (TextView) convertView.findViewById(R.id.textTableStatus);
				convertView.setTag(holder);
			} else {
				holder = (Holder) convertView.getTag();
			}
			/*
			 * holder.time.setText("发布时间:" +
			 * basemarkBeans.get(position).getUpdatetime());
			 */

			holder.textTable.setText(basemarkBeans.get(position).getName());
			if(basemarkBeans.get(position).getStatus().equals("0")){
				holder.textTableStatus.setText("空闲中");
				holder.textTableStatus.setTextColor(Color.rgb(0, 100, 0));
			}else{
				holder.textTableStatus.setText("占用中");
				holder.textTableStatus.setTextColor(Color.rgb(255, 0, 0));
			}

			return convertView;
		}

		public ArrayList<Goods> getDuanziList() {
			return duanziList;
		}

		public void setDuanziList(ArrayList<Goods> duanziList) {
			this.duanziList = duanziList;
		}

	}

	private class Holder {
		TextView textTable;
		TextView textTableStatus;
	}

	@OnItemClick(R.id.listView1)
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
			if(basemarkBeans.get(position).getStatus().equals("1")){
				Toast.makeText(DeskList1.this, "该餐桌已被占用", Toast.LENGTH_SHORT).show();;
			}else{
				Intent intent =new Intent(DeskList1.this,GoodsList.class);
				intent.putExtra("table_name", basemarkBeans.get(position).getName());
				DeskList1.this.startActivity(intent);
			}
			
		
		
	}
}
