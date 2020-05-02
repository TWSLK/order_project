package com.common.activity;

import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Map;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.blueberry.activity.R;
import com.common.util.BasicFuns;
import com.common.util.HttpUtil;
import com.common.util.IAsynTask;
import com.common.util.MyApp;
import com.common.util.SendGETRequest;
import com.common.util.Util;
import com.common.util.Web;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class AddOrderComments extends Activity {
	@ViewInject(R.id.gamecontext)
	private TextView gamecontext;
	private MyApp myApp;

	private String id;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		myApp = (MyApp) AddOrderComments.this.getApplication();
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
				.penaltyLog().penaltyDeath().build());
		setContentView(R.layout.add_order_comments);
		id = getIntent().getStringExtra("id");
		ViewUtils.inject(this);
	}

	@OnClick({ R.id.add_new, R.id.top_back })
	public void onclick(View view) {
		switch (view.getId()) {
		case R.id.add_new:
			if (TextUtils.isEmpty(gamecontext.getText().toString().trim())) {
				Util.Toast(this, "请输入内容");
				return;
			}
			addXD(gamecontext.getText().toString().trim());
			break;

		case R.id.top_back:
			finish();
			break;
		}
	}

	/**
	 * 添加新的游戏心得
	 */
	public void addXD(String content) {
		String url = HttpUtil.URL_COMMENTSADD1;
		String query ="";
		query+="comment="+content+"&";
		query+="orderid="+id;
		
		url+=query;
		
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if(response.getStatusLine().getStatusCode()==200){
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				
				JSONObject obj;
				try {
					obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
//					JSONObject obj = new JSONObject(json);
					if(arrlist!="" && !arrlist.equals("arrlist") && arrlist!=null && !arrlist.equals("[]")){
						
						if(arrlist.equals("1")){
							Toast.makeText(AddOrderComments.this, "恭喜，评论成功", Toast.LENGTH_SHORT).show();;
							AddOrderComments.this.finish();
						}else{
							Toast.makeText(AddOrderComments.this, "抱歉，评论失败", Toast.LENGTH_SHORT).show();;
						}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(AddOrderComments.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(AddOrderComments.this, result, Toast.LENGTH_SHORT).show();;
		}
		
	}

}
