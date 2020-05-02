package com.common.activity;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.blueberry.activity.R;
import com.common.util.HttpUtil;
import com.common.util.IAsynTask;
import com.common.util.MyApp;
import com.common.util.SendGETRequest;
import com.common.util.Util;
import com.common.util.Web;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class UserProfileActivity extends Activity {
	@ViewInject(R.id.username)
	private EditText username;
	@ViewInject(R.id.userpasswords)
	private EditText userpasswords;
	@ViewInject(R.id.editText1)
	private EditText editText1;
	@ViewInject(R.id.editQQ)
	private EditText editQQ;
	@ViewInject(R.id.editPhone)
	private EditText editPhone;
	@ViewInject(R.id.editName)
	private EditText editName;
	@ViewInject(R.id.editAddress)
	private EditText editAddress;
	@ViewInject(R.id.top_back)
	private TextView top_back;
	private Handler handler;
	private ProgressDialog dialog;
	private MyApp myApp;

	@Override  
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		myApp = (MyApp) UserProfileActivity.this.getApplication();
		setContentView(R.layout.userprofile);
		ViewUtils.inject(this);
		
		
		loaddata();
		username.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					// �˴�Ϊ�õ�����ʱ�Ĵ�������
				} else {
					if (TextUtils.isEmpty(username.getText().toString().trim())) {
						Toast.makeText(UserProfileActivity.this, "�û�������Ϊ��", 0)
								.show();
					} else if (username.getText().toString().trim().length() < 4
							|| username.getText().toString().trim().length() > 20) {
						Toast.makeText(UserProfileActivity.this,
								"�û����ĳ���Ӧ��4-20���ַ�֮��", Toast.LENGTH_SHORT).show();
					} else {
						Pattern pattern = Pattern.compile("[0-9]*");
						Matcher matcher = pattern.matcher(username.getText()
								.toString().trim());
						Pattern pattern2 = Pattern.compile("\\W+");
						Matcher matcher2 = pattern2.matcher(username.getText()
								.toString().trim());
						if (matcher.matches()) {
							Toast.makeText(UserProfileActivity.this,
									"�û�������ȫ��������", 0).show();
							return;
						}
						if (matcher2.find()) {
							Toast.makeText(UserProfileActivity.this,
									"�û������ܺ��������ַ���ֻ�����ɺ��֡����֡�Ӣ����ĸ�Լ��»������", 0)
									.show();
							return;
						}
//						checkUser(username.getText().toString().trim());
					}
				}
			}
		});
	}

	@OnClick({ R.id.register, R.id.userlogin , R.id.top_back })
	public void onclick(View view) {
		switch (view.getId()) {
		case R.id.register:
			if (TextUtils.isEmpty(username.getText().toString().trim())) {
				Util.showToast(this, "�����û�����");
				return;
			}
			if (TextUtils.isEmpty(userpasswords.getText().toString().trim())) {
				Util.showToast(this, "�������룡");
				return;
			}
			if (TextUtils.isEmpty(editText1.getText().toString().trim())) {
				Util.showToast(this, "����ȷ�����룡");
				return;
			}
			if (!userpasswords.getText().toString().trim()
					.equals(editText1.getText().toString().trim())) {
				Util.showToast(this, "����ȷ�����룡");
				return;
			}
			String user_name = username.getText().toString().trim();
			String password = userpasswords.getText().toString().trim();
			String qq = editQQ.getText().toString().trim();
			String phone = editPhone.getText().toString().trim();
			String name = editName.getText().toString().trim();
			String address = editAddress.getText().toString().trim();
			SendData(user_name, password, qq, phone,name,address);
			break;

		case R.id.userlogin:
			finish();
			Intent intent = new Intent(this, Login.class);
			startActivity(intent);
			break;
		case R.id.top_back:
			finish();
			break;
		}
	}
	
	
	public void loaddata(){
		String url = HttpUtil.URL_LOAD;
		String query ="";
		query+="user.id="+myApp.getLoginKey();
		url+=query;
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// �����Ӧ����
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// �ж��Ƿ�����ɹ�
			if(response.getStatusLine().getStatusCode()==200){
				// �����Ӧ
				result = EntityUtils.toString(response.getEntity());
				
				JSONObject obj;
				try {
					obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
					JSONObject user = new JSONObject(arrlist);
					if(obj.length()> 0){
						String username1 = user.optString("username");
						String password1 = user.optString("password");
						String qqnum1= user.optString("qqnum");
						String phone1 = user.optString("phone");
						String realname1 = user.optString("name");
						String address1 = user.optString("address");
						
						username.setText(username1);
						editName.setText(realname1);
						userpasswords.setText(password1);
						editText1.setText(password1);
						editQQ.setText(qqnum1);
						editPhone.setText(phone1);
						editName.setText(realname1);
						editAddress.setText(address1);
						
						
						
						
						
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "�����쳣��";
			Toast.makeText(UserProfileActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "�����쳣��";
			Toast.makeText(UserProfileActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
		
		
		
		
	}
	public void SendData(String username , String password ,String qq,String phone,String name,String address){
		String url = HttpUtil.URL_REGISTER;
		String query ="";
		query+="user.id="+myApp.getLoginKey()+"&";
		query+="user.username="+username+"&";
		query+="user.password="+password+"&";
		query+="user.qqnum="+qq+"&";
		query+="user.name="+name+"&";
		query+="user.address="+address+"&";
		query+="user.phone="+phone;
		url+=query;
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// �����Ӧ����
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// �ж��Ƿ�����ɹ�
			if(response.getStatusLine().getStatusCode()==200){
				// �����Ӧ
				result = EntityUtils.toString(response.getEntity());
				
				JSONObject obj;
				try {
					obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
					if(arrlist!="" && !arrlist.equals("arrlist") && arrlist!=null && !arrlist.equals("[]")){
						if(arrlist.equals("1")){
							Toast.makeText(UserProfileActivity.this, "��ϲ����Ϣ����ɹ�", Toast.LENGTH_SHORT).show();;
			            	Intent intent = new Intent(UserProfileActivity.this,MeActivity.class);
			            	UserProfileActivity.this.startActivity(intent);
						}else{
							Toast.makeText(UserProfileActivity.this, "��Ǹ������ʧ��", Toast.LENGTH_SHORT).show();;
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "�����쳣��";
			Toast.makeText(UserProfileActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "�����쳣��";
			Toast.makeText(UserProfileActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
	}

	private void checkUser(final String login) {
		Util.asynTask(this, "��֤�û���", new IAsynTask() {

			@Override
			public void updateUI(Serializable runData) {
				// TODO Auto-generated method stub
				if (runData != null) {
					Map<String, String> map = (Map<String, String>) runData;
					if (map.get("type").equals("success")) {

					} else {
						Util.Toast(UserProfileActivity.this, "�û����Ѿ����ڡ�");
						username.setText("");
					}
				} else {
					Util.Toast(UserProfileActivity.this, "�������Ӵ���");
				}
			}

			@Override
			public Serializable run() {
				Map<String, String> map = null;
				try {
					map = SendGETRequest.sendGETRequest(Web.checkUserLogin,
							"?users.userlogin=" + login);
				} catch (Exception e) {
					// TODO: handle exception
				}
				// TODO Auto-generated method stub
				return (Serializable) map;
			}
		});
	}
}
