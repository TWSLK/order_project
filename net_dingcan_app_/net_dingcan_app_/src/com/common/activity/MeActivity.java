package com.common.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.blueberry.activity.R;
import com.common.util.CircleImageView;
import com.common.util.CircleLayout;
import com.common.util.Util;
import com.common.util.CircleLayout.OnItemClickListener;
import com.common.util.CircleLayout.OnItemSelectedListener;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MeActivity extends Activity{
	private TextView shouye,faxian,haoyou,wo,top_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setView();
		initView();
	}

	public void setView() {
		setContentView(R.layout.activity_me);
		ViewUtils.inject(this);

	}
	@OnClick({ R.id.top_back })
	public void onclick(View view) {
		switch (view.getId()) {

		case R.id.top_back:
			finish();
			break;
		}
	}
	

	public void initView() {
		shouye =(TextView) findViewById(R.id.shouye);
		faxian =(TextView) findViewById(R.id.faxian);
		haoyou =(TextView) findViewById(R.id.haoyou);
		wo =(TextView) findViewById(R.id.wo);
		top_back =(TextView) findViewById(R.id.top_back);
		
		shouye.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MeActivity.this,UserProfileActivity.class);
				startActivity(intent);
				
				
			}
		});
		faxian.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*Intent intent = new Intent(MeActivity.this,MyDuanziList.class);
				startActivity(intent);*/
			}
		});
		haoyou.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			/*	Intent intent = new Intent(MeActivity.this,MyFolderDuanziList.class);
				startActivity(intent);*/
			}
		});
		wo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MeActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});

	}

/*	@Override
	public void onItemSelected(View view, int position, long id, String name) {
		selectedTextView.setText(name);
	}

	@Override
	public void onItemClick(View view, int position, long id, String name) {
		switch (position) {
		case 0:
			Util.toIntent(this, InformationAvtivity.class);
			break;
		case 1:
			Util.toIntent(this, ExchangeList.class);
			break;
		case 2:
			Util.toIntent(this, GamePCList.class);
			break;
		case 3:
			Util.toIntent(this, GameXDList.class);
			break;
		case 4:
			Util.toIntent(this, PictureList.class);
			break;
		case 5:
			Util.toIntent(this, Foundingfriends.class);
			break;
		}
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		Util.setUsersBean(null);
		return super.onKeyDown(keyCode, event);
	}*/

}
