package com.common.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends Activity{
	private TextView shouye,faxian,haoyou,wo,dianping,yidian,geren;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setView();
		initView();
	}

	public void setView() {
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);

	}

	

	public void initView() {
		shouye =(TextView) findViewById(R.id.shouye);
		faxian =(TextView) findViewById(R.id.faxian);
		haoyou =(TextView) findViewById(R.id.haoyou);
		geren =(TextView) findViewById(R.id.geren);
		wo =(TextView) findViewById(R.id.wo);
		dianping =(TextView) findViewById(R.id.dianping);
		yidian =(TextView) findViewById(R.id.yidian);
		
		
		shouye.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,DeskList.class);
				startActivity(intent);
				
				
			}
		});
		yidian.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,CartActivity.class);
				startActivity(intent);
				
				
			}
		});
		geren.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,MeActivity.class);
				startActivity(intent);
				
				
			}
		});
		faxian.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,GoodsList1.class);
				startActivity(intent);
			}
		});
		haoyou.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,MyOrderListViewActivity1.class);
				startActivity(intent);
			}
		});
		wo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,MyOrderListViewActivity.class);
				startActivity(intent);
			}
		});
		dianping.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,AddDuanziComments2.class);
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
