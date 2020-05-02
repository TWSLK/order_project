/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:MyAsynaTask.java
 */
package com.common.util;

import com.blueberry.activity.R;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * �첽����ͼƬ��Background��
 * @author KingKong��HE
 * @Time 2014��1��17�� ����4:44:35
 */
public class MyBackAsynaTask extends AsyncTask<String,Void,String>{
	private String themb;
	private ImageView iv;

	public MyBackAsynaTask(String themb,ImageView iv){
		this.themb=themb;
		this.iv=iv;
	}
	@Override
	protected String doInBackground(String... params) {
		if(themb!=null){
			return themb;
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if(result!=null && !"".equals(result)&& !"null".equals(result)){
//			//����Զ��ͼƬ
			ImageLoader.getInstance().asyncLoadBitmap(result, new ImageLoader.ImageCallback() {
				@Override
				public void imageLoaded(Bitmap bmp, String url) {
					if(bmp!=null){
						//Bitmap bitmap=getBitmap(bmp, bmp.getWidth());
						iv.setBackgroundDrawable(new BitmapDrawable(bmp));
					}else{
						iv.setBackgroundResource(R.drawable.main_banner);
					}
				}
			});
		}else{
			iv.setBackgroundResource(R.drawable.main_banner);
		}
	}
	/***
	 * ��ͼƬ����
	 * @author zhangjia
	 */
	public Bitmap getBitmap(Bitmap bitmap, int width) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		Matrix matrix = new Matrix();
		float scale = (float) width / w;
		System.out.println("scale-->" + scale);
		// ��֤ͼƬ������.
		matrix.postScale(scale, scale);
		// w,h��ԭͼ������.
		return Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
	}
	@Override
	protected void onCancelled() {
		super.onCancelled();
	}
	}