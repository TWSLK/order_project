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
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.blueberry.activity.R;
import com.common.bean.BasemarkBean;
import com.common.bean.DuanziBean;
import com.common.bean.Goods;
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

public class GoodsList1 extends Activity {
	@ViewInject(R.id.listView1)
	private ListView listView1;
	private List<Goods> basemarkBeans = new ArrayList<Goods>();
	@ViewInject(R.id.add_new_xd)
	private TextView add_new_xd;
	private MyApp myApp;
	private GameAdapter adapter;
//	private String table_name;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		myApp = (MyApp) GoodsList1.this.getApplication();
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
				.penaltyLog().penaltyDeath().build());
		setContentView(R.layout.goods_xd_list1);
//		table_name = GoodsList1.this.getIntent().getStringExtra("table_name");
		ViewUtils.inject(this);
		if (TextUtils.isEmpty(myApp.getLoginName())) {
			add_new_xd.setVisibility(View.INVISIBLE);
		}

		adapter = new GameAdapter();
		listView1.setAdapter(adapter);
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
		Intent intent = new Intent(GoodsList1.this,CartActivity.class);
		startActivity(intent);
	}

	public void getGameXD() {
		String url = HttpUtil.URL_GOODSLIST1;

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

						ArrayList<Goods> goods_list = Goods
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
			Toast.makeText(GoodsList1.this, result, Toast.LENGTH_SHORT).show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodsList1.this, result, Toast.LENGTH_SHORT).show();
			;
		}
	}

	private class GameAdapter extends BaseAdapter {
		private LayoutInflater inflater;
		private ArrayList<Goods> duanziList;

		private GameAdapter() {
			inflater = LayoutInflater.from(GoodsList1.this);
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
				convertView = inflater.inflate(R.layout.goods_xd_list_item,
						null);
				holder = new Holder();
				holder.image_view = (ImageView) convertView
						.findViewById(R.id.image_view);
				holder.title = (TextView) convertView.findViewById(R.id.title);
				holder.time = (TextView) convertView.findViewById(R.id.times);
				holder.username = (TextView) convertView
						.findViewById(R.id.username);
				convertView.setTag(holder);
			} else {
				holder = (Holder) convertView.getTag();
			}
			/*
			 * holder.time.setText("发布时间:" +
			 * basemarkBeans.get(position).getUpdatetime());
			 */
			String price = basemarkBeans.get(position).getGoods_price();
			if (price.length() > 3) {
				price = price.substring(0, 3);
			}

			holder.username.setText("价格:" + price + "元");
			holder.title.setText("商品:"
					+ basemarkBeans.get(position).getGoods_name());

			MyBackAsynaTask asynaTask = new MyBackAsynaTask(
					HttpUtil.URL_BASEUPLOAD
							+ basemarkBeans.get(position).getGoods_image(),
					holder.image_view);
			asynaTask.execute();

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
		ImageView image_view;
		TextView title;
		TextView time;
		TextView username;
	}

	@OnItemClick(R.id.listView1)
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, GoodDetail.class);
		intent.putExtra("id", basemarkBeans.get(position).getGoods_id());
		intent.putExtra("table_name","1号");
		intent.putExtra("tag", "商品详情");
		startActivity(intent);
	}
}
