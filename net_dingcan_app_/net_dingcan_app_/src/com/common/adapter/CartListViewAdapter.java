package com.common.adapter;

/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.adapter
 * FileNmae:CommendGridViewAdapter.java
 */

import java.util.ArrayList;
import java.util.HashMap;

import com.blueberry.activity.R;
import com.common.activity.CartActivity;
import com.common.bean.CartList2;
import com.common.util.HttpUtil;
import com.common.util.MyApp;
import com.common.util.MyBackAsynaTask;

import android.content.Context;
import android.nfc.cardemulation.CardEmulation;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author KingKong·HE
 * @Time 2014-1-6 下午12:06:09
 */
public class CartListViewAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater inflater;
	public ArrayList<CartList2> cartLists;
	private MyApp myApp;
	public ViewHolder holder;
	private CartActivity cartActivity;
	
	private int index = -1;// 当前获取焦点的位置
	private HashMap<Integer, String> contentMap = new HashMap<Integer, String>();// 保存holder.textCartNumber的数据,避免软键盘弹出和隐藏对数据的影响

	public CartListViewAdapter(Context context, CartActivity cartActivity) {
		this.context = context;
		this.cartActivity = cartActivity;
		this.inflater = LayoutInflater.from(context);
		myApp = (MyApp) context.getApplicationContext();
	}

	@Override
	public int getCount() {
		return cartLists == null ? 0 : cartLists.size();
	}

	@Override
	public Object getItem(int position) {
		return cartLists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public ArrayList<CartList2> getCartLists() {
		return cartLists;
	}

	public void setCartLists(ArrayList<CartList2> cartLists) {
		this.cartLists = cartLists;
	}


	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (null == convertView) {
			convertView = inflater.inflate(R.layout.listivew_cart_item, null);
			holder = new ViewHolder();
			// holder.textCartStoreName = (TextView)
			// convertView.findViewById(R.id.textCartStoreName);
			holder.textCartGoodsName = (TextView) convertView
					.findViewById(R.id.textCartGoodsName);
			holder.textCartGoodsPrice = (TextView) convertView
					.findViewById(R.id.textCartGoodsPrice);
			holder.textCartNumber = (EditText) convertView
					.findViewById(R.id.textCartNumber);
			holder.imageCartPic = (ImageView) convertView
					.findViewById(R.id.imageCartPic);
			holder.imageCartDetele = (ImageView) convertView
					.findViewById(R.id.imageCartDetele);
			holder.textCartStoreName = (TextView) convertView
					.findViewById(R.id.textCartStoreName);
			holder.checkBoxCart = (CheckBox) convertView
					.findViewById(R.id.checkBoxCart);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		final CartList2 bean = cartLists.get(position);
		holder.textCartGoodsName.setText(bean.getGoods_name());
		holder.textCartStoreName.setText("餐桌编号:"+bean.getTable_name());

		holder.textCartGoodsPrice.setText(bean.getGoods_price());
		TextWatcher textWatcher = new TextWatcher() {  
			  
			@Override  
			public void onTextChanged(CharSequence s, int start, int before,  
			int count) {  
			//    
			}  
			  
			@Override  
			public void beforeTextChanged(CharSequence s, int start, int count,  
			int after) {  
			//    
			  
			}  
			  
			@Override  
			public void afterTextChanged(Editable s) {  
			//    
				if(!s.toString().equals("")){
					CartActivity.addressList.get(position).setGoods_num(s.toString());
					CartActivity.calculatePrice(CartActivity.addressList);
				}
			
			  
			}  
			};  
		// holder.textCartNumber.setText("1");
		holder.textCartNumber.addTextChangedListener(textWatcher);  
		boolean selected = false;
		if (cartActivity.selectedMap.get(bean.getGoods_id()) != null) {
			selected = cartActivity.selectedMap.get(bean.getGoods_id());
		} else {
		}
		holder.checkBoxCart.setChecked(selected);

		System.out.println("good 名称-->" + bean.getGoods_name());

		MyBackAsynaTask asynaTask = new MyBackAsynaTask(HttpUtil.URL_BASEUPLOAD
				+ bean.getGoods_image(), holder.imageCartPic);
		asynaTask.execute();

		holder.imageCartDetele.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				cartActivity.cartDetele(bean.getCart_id());
			}
		});
		



		return convertView;
	}

	public class ViewHolder {
		TextView textCartStoreName;
		TextView textCartGoodsName;
		TextView textCartGoodsPrice;
		EditText textCartNumber;
		ImageView imageCartPic;
		public CheckBox checkBoxCart;
		ImageView imageCartDetele;

	}
}
