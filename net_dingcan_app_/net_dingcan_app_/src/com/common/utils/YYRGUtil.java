package com.common.utils;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

public class YYRGUtil {
	 public static Bitmap compressImageFromFile(String srcPath) {
			BitmapFactory.Options newOpts = new BitmapFactory.Options();
			newOpts.inJustDecodeBounds = true;//ֻ����,��������
			Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);

			newOpts.inJustDecodeBounds = false;
			int w = newOpts.outWidth;
			int h = newOpts.outHeight;
			float hh = 800f;//
			float ww = 480f;//
			int be = 1;
			if (w > h && w > ww) {
				be = (int) (newOpts.outWidth / ww);
			} else if (w < h && h > hh) {
				be = (int) (newOpts.outHeight / hh);
			}
			if (be <= 0)
				be = 1;
			newOpts.inSampleSize = be;//���ò�����
			
			newOpts.inPreferredConfig = Config.ARGB_8888;//��ģʽ��Ĭ�ϵ�,�ɲ���
			newOpts.inPurgeable = true;// ͬʱ���òŻ���Ч
			newOpts.inInputShareable = true;//����ϵͳ�ڴ治��ʱ��ͼƬ�Զ�������
			
			bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
//			return compressBmpFromBmp(bitmap);//ԭ���ķ������������������ͼ���ж���ѹ��
										//��ʵ����Ч��,��Ҿ��ܳ���
			return bitmap;
		}
    /** 
     * ����ԭͼ�ͱ䳤����Բ��ͼƬ 
     *  
     * @param source 
     * @param min 
     * @return 
     */  
    public static Bitmap createCircleImage(Bitmap source, int min)  
    {  
        final Paint paint = new Paint();  
        paint.setAntiAlias(true);  
        Bitmap target = Bitmap.createBitmap(min, min, Config.ARGB_8888);  
        /** 
         * ����һ��ͬ����С�Ļ��� 
         */  
        Canvas canvas = new Canvas(target);  
        /** 
         * ���Ȼ���Բ�� 
         */  
        canvas.drawCircle(min / 2, min / 2, min / 2, paint);  
        /** 
         * ʹ��SRC_IN 
         */  
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));  
        /** 
         * ����ͼƬ 
         */  
        canvas.drawBitmap(source, 0, 0, paint);  
        return target;  
    }  
}
