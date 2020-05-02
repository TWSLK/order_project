/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.adapter
 * FileNmae:GoodsListViewAdapter.java
 */
package com.common.adapter;

import java.util.ArrayList;

import com.blueberry.activity.R;
import com.common.activity.MyOrderListViewActivity;
import com.common.activity.MyOrderListViewActivity0;
import com.common.bean.MyOrderList;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author KingKong·HE
 * @Time 2014-1-6 下午12:06:09
 */
public class MyOrderListViewAdapter1 extends BaseAdapter{
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<MyOrderList> orderlist;
	private MyOrderListViewActivity0 activiy;
	public MyOrderListViewAdapter1(Context context,MyOrderListViewActivity0 activiy) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		this.activiy = activiy;
	}
	public MyOrderListViewAdapter1(Context context) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return orderlist == null ? 0 : orderlist.size();
	}

	@Override
	public Object getItem(int position) {
		return orderlist.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}


	

	public ArrayList<MyOrderList> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(ArrayList<MyOrderList> orderlist) {
		this.orderlist = orderlist;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		final MyOrderList bean= orderlist.get(position);
		if (null == convertView) {
			convertView = inflater.inflate(R.layout.listivew_new_wish_item1, null);
			holder = new ViewHolder();
			holder.orderprice = (Button) convertView.findViewById(R.id.orderprice);
			holder.confirm = (Button) convertView.findViewById(R.id.confirm);
			holder.order_name = (TextView) convertView.findViewById(R.id.order_name);
			holder.orderstatus = (Button) convertView.findViewById(R.id.orderstatus);
			holder.order_date = (TextView) convertView.findViewById(R.id.order_date);
			holder.ordertext = (TextView) convertView.findViewById(R.id.ordertext);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
	
		 
		if(bean.getStatus() == 0){
			holder.orderstatus.setText("订单状态：正在处理");
		}else if(bean.getStatus() == 1){
			holder.orderstatus.setText("订单状态：正在派送");
		}else{
			holder.orderstatus.setText("订单状态：已完成派送");
		}
		
		holder.orderprice.setText("订单金额："+bean.getPrice()+"￥");
		holder.order_name.setText(bean.getGoods_name());
		holder.order_date.setText("下单时间:"+bean.getOrderdate());
		holder.ordertext.setText("所在桌号："+bean.getTable_name());
		
		
		/*holder.confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				activiy.confirm(bean.getId()+"");
			}
		});*/
		
//
		
		return convertView;
	}
	class ViewHolder {
	
		Button orderprice;
		TextView order_name;
		Button orderstatus;
		Button confirm;
		TextView order_date;
		TextView ordertext;
	
	}
}
