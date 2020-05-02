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
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.blueberry.activity.R;
import com.common.util.HttpUtil;
import com.common.util.IAsynTask;
import com.common.util.SendGETRequest;
import com.common.util.Util;
import com.common.util.Web;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class UserRegisterActivity extends Activity {
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
	private Handler handler;
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userregister);
		ViewUtils.inject(this);
		username.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					// �˴�Ϊ�õ�����ʱ�Ĵ�������
				} else {
					if (TextUtils.isEmpty(username.getText().toString().trim())) {
						Toast.makeText(UserRegisterActivity.this, "�û�������Ϊ��", 0)
								.show();
					} else if (username.getText().toString().trim().length() < 4
							|| username.getText().toString().trim().length() > 20) {
						Toast.makeText(UserRegisterActivity.this,
								"�û����ĳ���Ӧ��4-20���ַ�֮��", Toast.LENGTH_SHORT).show();
					} else {
						Pattern pattern = Pattern.compile("[0-9]*");
						Matcher matcher = pattern.matcher(username.getText()
								.toString().trim());
						Pattern pattern2 = Pattern.compile("\\W+");
						Matcher matcher2 = pattern2.matcher(username.getText()
								.toString().trim());
						if (matcher.matches()) {
							Toast.makeText(UserRegisterActivity.this,
									"�û�������ȫ��������", 0).show();
							return;
						}
						if (matcher2.find()) {
							Toast.makeText(UserRegisterActivity.this,
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

	@OnClick({ R.id.register, R.id.userlogin })
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
		}
	}
	public void SendData(String username , String password ,String qq,String phone,String name,String address){
		String url = HttpUtil.URL_REGISTER;
		String query ="";
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
							Toast.makeText(UserRegisterActivity.this, "��ϲ��ע��ɹ�", Toast.LENGTH_SHORT).show();;
			            	Intent intent = new Intent(UserRegisterActivity.this,Login.class);
			            	UserRegisterActivity.this.startActivity(intent);
						}else{
							Toast.makeText(UserRegisterActivity.this, "��Ǹ��ע��ʧ��", Toast.LENGTH_SHORT).show();;
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "�����쳣��";
			Toast.makeText(UserRegisterActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "�����쳣��";
			Toast.makeText(UserRegisterActivity.this, result, Toast.LENGTH_SHORT).show();;
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
						Util.Toast(UserRegisterActivity.this, "�û����Ѿ����ڡ�");
						username.setText("");
					}
				} else {
					Util.Toast(UserRegisterActivity.this, "�������Ӵ���");
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
