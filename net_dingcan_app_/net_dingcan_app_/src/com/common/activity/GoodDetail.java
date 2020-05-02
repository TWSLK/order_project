package com.common.activity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;





import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.blueberry.activity.R;
import com.common.adapter.GoodsDetailCommentsListViewAdapter;
import com.common.bean.CommentsList;
import com.common.custom.MyListView;
import com.common.util.HttpUtil;
import com.common.util.MyApp;
import com.common.util.MyBackAsynaTask;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GoodDetail extends Activity {
	@ViewInject(R.id.title)
	private TextView title;
	@ViewInject(R.id.title1)
	private TextView title11;
	@ViewInject(R.id.zan)
	private TextView zan;
	@ViewInject(R.id.time)
	private TextView time;
	@ViewInject(R.id.content)
	private TextView content;
	@ViewInject(R.id.username)
	private TextView username;
	@ViewInject(R.id.imageView1)
	private ImageView imageView1;
	@ViewInject(R.id.dianzan)
	private ImageView dianzan;
	@ViewInject(R.id.goodsCommentsListView)
	private MyListView goodsCommentsListView;
	private String id;
	private String tag;
	private String goods_name;
	private MyApp myApp;
	private String table_name;
	private GoodsDetailCommentsListViewAdapter gooddetailcommentsAdapter;
	private ArrayList<CommentsList> lists = new ArrayList<CommentsList>();
	

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
				.penaltyLog().penaltyDeath().build());
		setContentView(R.layout.good_detail);
		myApp = (MyApp) GoodDetail.this.getApplication();
		ViewUtils.inject(this);
		id = getIntent().getStringExtra("id");
		tag = getIntent().getStringExtra("tag");
		title.setText("菜谱详情");
		table_name = GoodDetail.this.getIntent().getStringExtra("table_name");
		gooddetailcommentsAdapter = new GoodsDetailCommentsListViewAdapter(GoodDetail.this);
		goodsCommentsListView.setAdapter(gooddetailcommentsAdapter);
		loadingGoodsDetailData(id);
		loadingCommentsData(id);

	}

	@OnClick(R.id.top_back)
	public void back(View view) {
		finish();
	}
	@OnClick(R.id.dianzan)
	public void dianzan(View view) {
		
		shopAddCart(id);
	}
	@OnClick(R.id.shoucang)
	public void shoucang(View view) {
		
		shoucang(id);
	}
	@OnClick(R.id.pinglun)
	public void pinglun(View view) {
		String flag = order_checkisbuy(goods_name);
		
//		if(flag.equals("1")){
			Intent intent = new Intent(GoodDetail.this,AddDuanziComments.class);
			intent.putExtra("id", id);
			startActivity(intent);
		/*}else{
			Toast.makeText(GoodDetail.this, "抱歉，您没购买过此产品，不能进行评价", Toast.LENGTH_SHORT).show();;
		}*/
		
		
	}
	
	public void shopAddCart(String goods_id){
	
		
		String url = HttpUtil.URL_ADD_CART;
		String query ="";
		query+="goods_id="+goods_id+"&";
		query+="user_id="+myApp.getLoginKey()+"&";
		query+="table_name="+table_name+"&";
		query+="goods_num="+1;
		url+=query;
		
		
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if(response.getStatusLine().getStatusCode()==200){
				// 获得响应
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				JSONObject obj;
				try {
					obj = new JSONObject(result);
					String jsonStr = obj.optString("jsonString");
					if(jsonStr.equals("1")){
						Toast.makeText(GoodDetail.this, "已添加", Toast.LENGTH_SHORT).show();;
					}else{
						
						Toast.makeText(GoodDetail.this, "添加失败", Toast.LENGTH_SHORT).show();;
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result, Toast.LENGTH_SHORT).show();;
		}

	}
	public String  order_checkisbuy(String goods_name){
		
		
		String url = HttpUtil.URL_CHECKISBUY;
		String query ="";
		try {
			query+="goods_name="+URLEncoder.encode(goods_name, "utf8")+"&";
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		query+="userid="+myApp.getLoginKey();
		url+=query;
		
		
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if(response.getStatusLine().getStatusCode()==200){
				// 获得响应
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				JSONObject obj;
				try {
					obj = new JSONObject(result);
					String jsonStr = obj.optString("jsonString");
					if(jsonStr.equals("1")){
						return "1";
					}else{
						
						return "0";
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result, Toast.LENGTH_SHORT).show();;
		}
		return "0";
		
	}
	public void loadingCommentsData(String id) {
		lists =new ArrayList<CommentsList>();
		String url = HttpUtil.URL_DUANZICOMMENTS + id;
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

						ArrayList<CommentsList> goods_list = CommentsList
								.newInstanceList(arrlist);
						lists.addAll(goods_list);

						gooddetailcommentsAdapter.setGoodsDatas(lists);
						gooddetailcommentsAdapter.notifyDataSetChanged();
					} else {
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result,
					Toast.LENGTH_SHORT).show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result,
					Toast.LENGTH_SHORT).show();
			;
		}
	}
	public void dianzan(String goods_id) {
		String url = HttpUtil.URL_ZANDIAN + goods_id;
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
					String jsonStr = obj.optString("jsonString");
					if(jsonStr.equals("1")){
						Toast.makeText(GoodDetail.this, "点赞成功", Toast.LENGTH_SHORT)
						.show();
						loadingGoodsDetailData(id);
					}else{
						Toast.makeText(GoodDetail.this, "点赞失败", Toast.LENGTH_SHORT)
						.show();
					}

				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result, Toast.LENGTH_SHORT)
					.show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result, Toast.LENGTH_SHORT)
					.show();
			;
		}
	}
	public void shoucang(String goods_id) {
		String url = HttpUtil.URL_SHOUCANG +"folder.duanziid="+goods_id+"&folder.userid="+myApp.getLoginKey();
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
					String jsonStr = obj.optString("jsonString");
					if(jsonStr.equals("1")){
						Toast.makeText(GoodDetail.this, "收藏成功", Toast.LENGTH_SHORT)
						.show();
						loadingGoodsDetailData(id);
					}else{
						Toast.makeText(GoodDetail.this, "收藏失败", Toast.LENGTH_SHORT)
						.show();
					}
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result, Toast.LENGTH_SHORT)
			.show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result, Toast.LENGTH_SHORT)
			.show();
			;
		}
	}
	
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		loadingCommentsData(id);
	}

	public void loadingGoodsDetailData(String goods_id) {
		String url = HttpUtil.URL_GOODSDETAIL + goods_id;
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
					String jsonStr = obj.optString("jsonString");
					System.out.println(jsonStr);
					JSONObject goods = new JSONObject(jsonStr);
					String price = goods.optString("goods_price");
					if(price.length() >3){
						price = price.substring(0, 3);
					}
					title11.setText("商品:" + goods.optString("goods_name"));
					content.setText("价格:"+price+"元");
					goods_name=goods.optString("goods_name");
//					zan.setText("赞(+"+goods.optString("zan")+")");
//					username.setText("作者:" + goods.optString("author"));
					
				
					
					MyBackAsynaTask asynaTask = new MyBackAsynaTask(HttpUtil.URL_BASEUPLOAD+goods.optString("goods_image"), imageView1);
					asynaTask.execute();
					
//					time.setText("发布日期：" + goods.optString("pubdate"));
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result, Toast.LENGTH_SHORT)
			.show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(GoodDetail.this, result, Toast.LENGTH_SHORT)
			.show();
			;
		}
	}
}
