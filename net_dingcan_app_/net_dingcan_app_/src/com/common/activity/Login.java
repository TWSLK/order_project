package com.common.activity;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.blueberry.activity.R;
import com.common.bean.LoginBean;
import com.common.util.HttpUtil;
import com.common.util.IAsynTask;
import com.common.util.MyApp;
import com.common.util.SendGETRequest;
import com.common.util.Util;
import com.common.util.Web;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class Login extends Activity {
	@ViewInject(R.id.name)
	private EditText name;
	@ViewInject(R.id.pwd)
	private EditText pwd;
	private String state;
	private MyApp myApp;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		myApp = (MyApp) Login.this.getApplication();
		ViewUtils.inject(this);
		SharedPreferences sp = getSharedPreferences("user",
				Context.MODE_PRIVATE);
		name.setText(sp.getString("username", null));
		pwd.setText(sp.getString("password", null));

		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
				.penaltyLog().penaltyDeath().build());
	}

	@OnClick({ R.id.topback, R.id.loginButton, R.id.tozhuce })
	public void onclick(View view) {
		switch (view.getId()) {
		case R.id.tozhuce:
			Util.toIntent(this, UserRegisterActivity.class);
			break;
		case R.id.topback:
			finish();
			break;
		case R.id.loginButton:
			if (TextUtils.isEmpty(name.getText().toString().trim())) {
				Util.Toast(this, "请输入用户名");
				return;
			}
			if (TextUtils.isEmpty(pwd.getText().toString().trim())) {
				Util.Toast(this, "请输入登录密码");
				return;
			}
			login(name.getText().toString().trim(), pwd.getText().toString()
					.trim());
			break;
		}
	}

	public void login(String loginName, String loginPassword) {
		String url = HttpUtil.URL_LOGIN;
		String query = "";
		query += "user.username=" + loginName + "&";
		query += "user.password=" + loginPassword;

		url += query;

		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if (response.getStatusLine().getStatusCode() == 200) {
				// 获得响应
				result = EntityUtils.toString(response.getEntity());

				LoginBean login = LoginBean.newInstanceList(result);
				if (login != null) {
					myApp.setLoginKey(login.getKey());
					myApp.setLoginName(login.getUsername());
					Toast.makeText(Login.this, "登陆成功", Toast.LENGTH_SHORT)
							.show();
					;
					InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
							InputMethodManager.HIDE_NOT_ALWAYS);
					Intent intent = new Intent(Login.this, MainActivity.class);
					Login.this.startActivity(intent);
				} else {
					Toast.makeText(Login.this, "用户名或者密码错误", Toast.LENGTH_SHORT)
							.show();
					;
				}

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(Login.this, result, Toast.LENGTH_SHORT).show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(Login.this, result, Toast.LENGTH_SHORT).show();
			;
		}

	}
}
