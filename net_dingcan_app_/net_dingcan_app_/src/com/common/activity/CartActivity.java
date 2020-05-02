/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.ui.cart
 * FileNmae:CartActivity.java
 */
package com.common.activity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import com.common.adapter.CartListViewAdapter;
import com.common.bean.CartList2;
import com.common.util.HttpUtil;
import com.common.util.MyApp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author KingKong路HE
 * @Time 2014-1-6 涓嬪崍4:32:58
 */
public class CartActivity extends Activity{
	private MyApp myApp;
	private ListView listViewShopCart;
	private CartListViewAdapter adapter;
	public static TextView textCartGoodsAllPrice;
	public TextView textCartGoodsAllPoints;
	private RelativeLayout relativeLayoutNoGoods;
	private LinearLayout linearLayoutCartList;
	private Button buttonVisitThe;
	private Button buttonSendCart;
	private EditText editBeizhu;
	public HashMap<String, Boolean> selectedMap = new HashMap<String, Boolean>();
	public double sumPrice = 0.00;
	public ArrayList<String> cartIDList = new ArrayList<String>();
	public static ArrayList<CartList2> addressList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cart_view);
		myApp = (MyApp) CartActivity.this.getApplicationContext();
		listViewShopCart = (ListView) findViewById(R.id.listViewShopCart);
		textCartGoodsAllPrice = (TextView) findViewById(R.id.textCartGoodsAllPrice);
		textCartGoodsAllPoints = (TextView) findViewById(R.id.textCartGoodsAllPoints);
		editBeizhu = (EditText) findViewById(R.id.editBeizhu);
		relativeLayoutNoGoods = (RelativeLayout) findViewById(R.id.relativeLayoutNoGoods);
		linearLayoutCartList = (LinearLayout) findViewById(R.id.linearLayoutCartList);
		buttonVisitThe = (Button) findViewById(R.id.buttonVisitThe);
		buttonSendCart = (Button) findViewById(R.id.buttonSendCart);
		adapter = new CartListViewAdapter(CartActivity.this,CartActivity.this);
		listViewShopCart.setCacheColorHint(Color.TRANSPARENT);
		listViewShopCart.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		loadingCartListData();
		
		buttonVisitThe.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(CartActivity.this,GoodsList.class);
				CartActivity.this.startActivity(i);
			}
		});
		buttonSendCart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String cartID = "";
				cartIDList.clear();
				for(int i = 0 ; i< addressList.size() ;i ++){
					cartIDList.add(","+addressList.get(i).getCart_id()+"|"+addressList.get(i).getGoods_num()+"|"+addressList.get(i).getTable_name());
				}
				for(int i = 0 ; i<cartIDList.size() ; i++){
					cartID += cartIDList.get(i);
				}
				if(cartIDList.size()>0){
					cartID = cartID.substring(1, cartID.length());
					System.out.println("cartID-->"+cartID);
//					Toast.makeText(CartActivity.this, editBeizhu.getText().toString(), Toast.LENGTH_SHORT).show();;
				String beizhu = editBeizhu.getText().toString();
					ordersubmmit(cartID,beizhu);
					
				}else{
					Toast.makeText(CartActivity.this, "您还没有勾选菜单", Toast.LENGTH_SHORT).show();;
				}
			}
		});
	/*	listViewShopCart.setOnItemClickListener(new OnItemClickListener(){    
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
            	CartList2 bean =(CartList2) listViewShopCart.getItemAtPosition(position);
            	CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBoxCart);
    			checkBox.toggle();//鍒囨崲閫夋嫨鐘舵??
    			selectedMap.put(bean.getCart_id(), checkBox.isChecked());
    			if(checkBox.isChecked()){
    				sumPrice += Double.parseDouble(bean.getGoods_price())*Integer.parseInt(bean.getGoods_num());
    				cartIDList.add(","+bean.getCart_id()+"|"+bean.getGoods_num());
    			}else{
    				sumPrice -= Double.parseDouble(bean.getGoods_price())*Integer.parseInt(bean.getGoods_num());
    				cartIDList.remove(","+bean.getCart_id()+"|"+bean.getGoods_num());
    			}
    			textCartGoodsAllPrice.setText(""+sumPrice);
            }    
        });*/
	}
	
	public static void calculatePrice(ArrayList<CartList2> addressList){
		double sumPrice_ =0;
		for(int i = 0 ; i< addressList.size() ;i ++){
			sumPrice_ += Double.parseDouble(addressList.get(i).getGoods_price())*Integer.parseInt(addressList.get(i).getGoods_num());
		}
		
		textCartGoodsAllPrice.setText(sumPrice_+"");
	}
	
	
	public void loadingCartListData(){
		String url = HttpUtil.URL_SHOPCART;
		url =url+ "user_id="+myApp.getLoginKey();
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 鑾峰緱鍝嶅簲瀵硅薄
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 鍒ゆ柇鏄惁璇锋眰鎴愬姛
			if(response.getStatusLine().getStatusCode()==200){
				// 鑾峰緱鍝嶅簲
				result = EntityUtils.toString(response.getEntity());
				
				try {
					JSONObject obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
//					JSONObject obj = new JSONObject(json);
					if(arrlist!="" && !arrlist.equals("arrlist") && arrlist!=null && !arrlist.equals("[]")){
					
						linearLayoutCartList.setVisibility(View.VISIBLE);
						relativeLayoutNoGoods.setVisibility(View.GONE);
						
						
					}else{
						linearLayoutCartList.setVisibility(View.GONE);
						relativeLayoutNoGoods.setVisibility(View.VISIBLE);
					}
					
					cartIDList.clear();
					addressList=CartList2.newInstanceList(arrlist);
					sumPrice =0;
					for(int i = 0 ; i< addressList.size() ;i ++){
						selectedMap.put(addressList.get(i).getCart_id(), true);
						sumPrice += Double.parseDouble(addressList.get(i).getGoods_price())*Integer.parseInt(addressList.get(i).getGoods_num());
						cartIDList.add(","+addressList.get(i).getCart_id()+"|"+addressList.get(i).getGoods_num()+"|"+addressList.get(i).getTable_name());
//						cartIDList.add(","+addressList.get(i).getCart_id()+"|"+addressList.get(i).getGoods_num());
					}
					
					textCartGoodsAllPrice.setText(sumPrice+"");
					textCartGoodsAllPoints.setVisibility(View.GONE);
					System.out.println("sumPrice:"+sumPrice);
					adapter.setCartLists(addressList);
					adapter.notifyDataSetChanged();
					
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
	
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(CartActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(CartActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
	}
	
	public void cartDetele(String cart_id ){
		String url = HttpUtil.URL_CARTDEL;
		url =url+ "user_id="+myApp.getLoginKey()+"&"
		+ "cart_id="+cart_id;
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 鑾峰緱鍝嶅簲瀵硅薄
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 鍒ゆ柇鏄惁璇锋眰鎴愬姛
			if(response.getStatusLine().getStatusCode()==200){
				// 鑾峰緱鍝嶅簲
				result = EntityUtils.toString(response.getEntity());
				
				try {
					JSONObject obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
					if(arrlist.equals("1")){
						Toast.makeText(CartActivity.this, "操作成功", Toast.LENGTH_SHORT).show();;
						loadingCartListData();
					}else{
						Toast.makeText(CartActivity.this, "操作失败", Toast.LENGTH_SHORT).show();;
					}
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
	
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(CartActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(CartActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
		
	}
	
/*	public void ordersubmmit2(String cartlist){
		String url = HttpUtil.URL_CARTORDER2;;//
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("user_id", myApp.getLoginKey());
		params.put("cartlist", cartlist);
		RemoteDataHandler.asyncPost2(url, params, new Callback() {
			@Override
			public void dataLoaded(ResponseData data) {
				if(data.getCode() == HttpStatus.SC_OK){
//					String json = data.getJson();
					Toast.makeText(CartActivity.this, "鏁版嵁鎻愪氦鎴愬姛", Toast.LENGTH_SHORT).show();;
					loadingCartListData();
					
				}else{
					Toast.makeText(CartActivity.this, "鏁版嵁鍔犺浇澶辫触锛岃绋嶅悗閲嶈瘯", Toast.LENGTH_SHORT).show();;
				}
			}
		});
	}*/
	public void ordersubmmit(String cartlist,String beizhu ){
		String[] arr = cartlist.split(",");
		
		String url = HttpUtil.URL_CARTORDER;
		try {
			url =url+ "user_id="+myApp.getLoginKey()+"&"
			+ "cartlist="+URLEncoder.encode(cartlist,"UTF-8")+"&"
			+ "beizhu="+URLEncoder.encode(beizhu,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if(response.getStatusLine().getStatusCode()==200){
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				
				try {
					JSONObject obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
					if(arrlist.equals("1")){
						Toast.makeText(CartActivity.this, "提交成功", Toast.LENGTH_SHORT).show();;
						loadingCartListData();
						finish();
					/*	String url1 = "https://mobile.alipay.com/index.htm"; // web address
						Intent intent = new Intent(Intent.ACTION_VIEW);
						intent.setData(Uri.parse(url1));
						startActivity(intent);*/
						
					}else{
						Toast.makeText(CartActivity.this, "提交失败", Toast.LENGTH_SHORT).show();;
					}
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
	
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(CartActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(CartActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
		
	}
	@Override
	protected void onResume() {
		super.onResume();
		cartIDList.clear();
		sumPrice = 0.00;
		if(myApp.getLoginKey() ==null || myApp.getLoginKey().equals("") || myApp.getLoginKey().equals("null")){
			linearLayoutCartList.setVisibility(View.GONE);
			relativeLayoutNoGoods.setVisibility(View.VISIBLE);
		}else{
			linearLayoutCartList.setVisibility(View.VISIBLE);
			relativeLayoutNoGoods.setVisibility(View.GONE);
			loadingCartListData();
		}
	}
/*	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			myApp.getTabHost().setCurrentTab(0);
			myApp.getHomeButton().setChecked(true);
				return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}*/
}
