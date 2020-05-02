package com.common.util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;



import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.widget.Toast;

public class BasicFuns {
	
	public static  void showDialog(Context currentActivitycontext,String msg){
		AlertDialog.Builder builder = new AlertDialog.Builder(currentActivitycontext);
		builder.setMessage(msg)
		       .setCancelable(false)
		       .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	   return;
		           }
		       });
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	
	public static  void showDialogConfirmExit(final Context currentActivitycontext){
		AlertDialog.Builder builder = new AlertDialog.Builder(currentActivitycontext);
		builder.setMessage("ȷ���˳�ϵͳ��?")
		       .setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	   return;
		           }
		       })
		       .setNeutralButton("����", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	   Intent i= new Intent(Intent.ACTION_MAIN);

//		        	   i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //android123��ʾ����Ƿ�������ã��������new task��ʶ
		        	   i.addCategory(Intent.CATEGORY_HOME);
		        	   currentActivitycontext.startActivity(i);
		           }
		       })
		       .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
//		        	   BasicFuns.exitSystem(currentActivitycontext);
		        	  // return;
		           }
		       });
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	public static  void showDialogWithTitle(Context currentActivitycontext,String msg,String title){
		AlertDialog.Builder builder = new AlertDialog.Builder(currentActivitycontext);
		builder.setTitle(title).setMessage(msg)
		       .setCancelable(false)
		       .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	   return;
		           }
		       });
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	
	
	public static  void showDialogWithTitle_check(Context currentActivitycontext,String msg,String title){
	
	}
	
	public static  void toast(Context currentActivitycontext,String text) {
        Toast.makeText(currentActivitycontext, text, Toast.LENGTH_LONG).show();
    }
	
/*	
	public static void exitSystem(Context _context){
		//
		NotificationManager manager = (NotificationManager) _context
		.getSystemService(Context.NOTIFICATION_SERVICE);
		manager.cancelAll();
		//
		 AlarmManager alarmManager = (AlarmManager) _context.getSystemService(Context.ALARM_SERVICE);
			Intent intent = new Intent(_context, AlarmReceiver.class);
			//������װBroadcastReceiver ��pendingIntent����
			PendingIntent pendingIntent = PendingIntent.getBroadcast(_context, 0,intent, 0);
			alarmManager.cancel(pendingIntent);
		
		//manager.
		  ExitApplication.getInstance().exit(_context);
	}*/
	
	
	
	/* �ϴ��ļ���Server�ķ��� */
    public static void uploadFile(Context _context,String picPath,String actionUrl,String planId)
    {
    			try {
    				// ������ͨ��Ϣ
    				Map<String, String> params = new HashMap<String, String>();
    				// params.put("filename", "����");
    				params.put("user.id", planId);
    				File imageFile = new File(picPath);
    	    		FormFile formfile = new FormFile(imageFile.getName(), imageFile,
    	    						"user.file", "application/octet-stream");
    	    		SocketHttpRequester.post(actionUrl, params, formfile);
    				Toast.makeText(_context, "ͼƬ�ϴ��ɹ�!", Toast.LENGTH_LONG).show();
    				
    				
    			} catch (Exception e) {
    				Toast.makeText(_context, "ͼƬ�ϴ�ʧ��!", Toast.LENGTH_LONG).show();
    				e.printStackTrace();
    			}
    }
    public static void uploadFile2_0(Context _context,String picPath,String actionUrl,String title,String conent,String author)
    {
    	try {
    		// ������ͨ��Ϣ
    		Map<String, String> params = new HashMap<String, String>();
    		// params.put("filename", "����");
    		params.put("goods.goods_name", title);
    		params.put("goods.goods_marketprice", conent);
    		params.put("goods.goods_price", author);
    		File imageFile = new File(picPath);
    		FormFile formfile = new FormFile(imageFile.getName(), imageFile,
    				"goods.file", "application/octet-stream");
    		SocketHttpRequester.post(actionUrl, params, formfile);
    		Toast.makeText(_context, "�����ɹ�!", Toast.LENGTH_LONG).show();
    		
    		
    	} catch (Exception e) {
    		Toast.makeText(_context, "ͼƬ�ϴ�ʧ��!", Toast.LENGTH_LONG).show();
    		e.printStackTrace();
    	}
    }
    /**
     * 	String name = proj_name.getText().toString();
		String group = pro_group.getText().toString();
		String user = proj_user.getText().toString();
		String content = proj_content.getText().toString();
     * @param _context
 	query += "biotech.proj_name=" + proj_name + "&";
		query += "biotech.proj_group=" + pro_group + "&";
		query += "biotech.proj_user=" + proj_user + "&";
		query += "biotech.proj_content=" + proj_content;
     */
    public static void uploadFile2_1(Context _context,String picPath,String actionUrl,String name,String group,String user,String content)
    {
    	try {
    		// ������ͨ��Ϣ
    		Map<String, String> params = new HashMap<String, String>();
    		// params.put("filename", "����");
    		params.put("biotech.proj_name", name);
    		params.put("biotech.proj_group", group);
    		params.put("biotech.proj_user", user);
    		params.put("biotech.proj_content", content);
    		File imageFile = new File(picPath);
    		FormFile formfile = new FormFile(imageFile.getName(), imageFile,
    				"biotech.file", "application/octet-stream");
    		SocketHttpRequester.post(actionUrl, params, formfile);
    		Toast.makeText(_context, "�����ɹ�!", Toast.LENGTH_LONG).show();
    		
    		
    	} catch (Exception e) {
    		Toast.makeText(_context, "ͼƬ�ϴ�ʧ��!", Toast.LENGTH_LONG).show();
    		e.printStackTrace();
    	}
    }
    
    
    
    
    public static void uploadVideoFile(Context _context,String videoName,String actionUrl,String planId)
    {

    	

    			

    			
    			try {
    				// ������ͨ��Ϣ
    				Map<String, String> params = new HashMap<String, String>();
    				// params.put("filename", "����");
    				params.put("planId", planId);
    				// �ϴ��ļ�
    				File videoFile = new File(Environment.getExternalStorageDirectory(),videoName);
    				/*FormFile formfile = new FormFile(videoFile.getName(), videoFile,
    						"video", "application/octet-stream");
    				
    				SocketHttpRequester.post(actionUrl, params, formfile);*/
    				Toast.makeText(_context, "��Ƶ�ϴ��ɹ�!", Toast.LENGTH_LONG).show();
    				
    				
    			} catch (Exception e) {
    				Toast.makeText(_context, "��Ƶ�ϴ�ʧ��!", Toast.LENGTH_LONG).show();
    				e.printStackTrace();
    			}

    
    	
    	
    }
	

}
