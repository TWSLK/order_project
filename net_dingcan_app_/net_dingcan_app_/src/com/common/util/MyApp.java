package com.common.util;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.Toast;


/**
 * ȫ�ֱ�����
 * @author hjgang
 */
public class MyApp extends Application {
	/** ϵͳ��ʼ�������ļ������� */
	private SharedPreferences sysInitSharedPreferences;
	
	/** ��¼�û���¼���KEY*/
	private String loginKey;
	/** ��¼�û���¼����û���*/
	private String loginName;
	
	private boolean IsCheckLogin;
	
	private TabHost tabHost;
	private RadioButton MyStoreButton;
	private RadioButton searchButton;
	private RadioButton cartButton;
	private RadioButton HomeButton;
    public boolean m_bKeyRight = true;
    private static MyApp mInstance = null;
	
	private List<Activity> activityList = new LinkedList();
	
	@Override
	public void onCreate() {
		super.onCreate();
//		CrashHandler crashHandler = CrashHandler.getInstance();
//		crashHandler.init(this);
		sysInitSharedPreferences = getSharedPreferences(Constants.SYSTEM_INIT_FILE_NAME, MODE_PRIVATE);
		loginKey = sysInitSharedPreferences.getString("loginKey", "");
		IsCheckLogin = sysInitSharedPreferences.getBoolean("IsCheckLogin", false);
		createCacheDir();
	}

	
	
	public static MyApp getInstance() {
		return mInstance;
	}
	
	public RadioButton getHomeButton() {
		return HomeButton;
	}

	public void setHomeButton(RadioButton homeButton) {
		HomeButton = homeButton;
	}

	public RadioButton getCartButton() {
		return cartButton;
	}

	public void setCartButton(RadioButton cartButton) {
		this.cartButton = cartButton;
	}



	public RadioButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(RadioButton searchButton) {
		this.searchButton = searchButton;
	}

	public RadioButton getMyStoreButton() {
		return MyStoreButton;
	}

	public void setMyStoreButton(RadioButton myStoreButton) {
		MyStoreButton = myStoreButton;
	}

	public TabHost getTabHost() {
		return tabHost;
	}

	public void setTabHost(TabHost tabHost) {
		this.tabHost = tabHost;
	}

	public SharedPreferences getSysInitSharedPreferences() {
		return sysInitSharedPreferences;
	}

	public void setSysInitSharedPreferences(
			SharedPreferences sysInitSharedPreferences) {
		this.sysInitSharedPreferences = sysInitSharedPreferences;
	}

	public String getLoginKey() {
		String loginKey = sysInitSharedPreferences.getString("loginKey", "");
		return loginKey;
	}

	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
		sysInitSharedPreferences.edit().putString("loginKey", this.loginKey).commit();
	}

	public String getLoginName() {
		String loginName = sysInitSharedPreferences.getString("loginName", "");
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
		sysInitSharedPreferences.edit().putString("loginName", this.loginName).commit();
	}

	public boolean isIsCheckLogin() {
		/*boolean IsCheckLogin = sysInitSharedPreferences.getBoolean("IsCheckLogin", false);
		return IsCheckLogin;*/
	    return IsCheckLogin;
	}

	public void setIsCheckLogin(boolean isCheckLogin) {
		IsCheckLogin = isCheckLogin;
		sysInitSharedPreferences.edit().putBoolean("IsCheckLogin", this.IsCheckLogin).commit();
	}
	
	
	public String getVersionName() throws Exception
	   {
	           // ��ȡpackagemanager��ʵ��
	           PackageManager packageManager = getPackageManager();
	           // getPackageName()���㵱ǰ��İ�����0�����ǻ�ȡ�汾��Ϣ
	           PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(),0);
	           String version = packInfo.versionName;
	           return version;
	   }
	
	public int checkVersion() throws NumberFormatException, Exception{
	
		
		float currentVersion = Float.parseFloat(getVersionName() );
		
		if(currentVersion < 1.7f){
			return 1;
		}else{
			return 0;
		}
		
	}
	
	// ����SD������Ŀ¼
	private void createCacheDir() {
	
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			File f = new File(Constants.CACHE_DIR);
			if (f.exists()) {
				System.out.println("SD������Ŀ¼:�Ѵ���!");
			} else {
				if (f.mkdirs()) {
					System.out.println("SD������Ŀ¼:" + f.getAbsolutePath()
							+ "�Ѵ���!");
				} else {
					System.out.println("SD������Ŀ¼:����ʧ��!");
				}
			}
	
			File ff = new File(Constants.CACHE_DIR_IMAGE);
			if (ff.exists()) {
				System.out.println("SD����Ƭ����Ŀ¼:�Ѵ���!");
			} else {
				if (ff.mkdirs()) {
					System.out.println("SD����Ƭ����Ŀ¼:" + ff.getAbsolutePath()
							+ "�Ѵ���!");
				} else {
					System.out.println("SD����Ƭ����Ŀ¼:����ʧ��!");
				}
			}
		}
	}
	
	
	// ���Activity��������
	public void addActivity(Activity activity) {
		activityList.add(activity);
	}
	// ��������Activity��finish

		public void exit(Context context) {

			for (Activity activity : activityList) {
				activity.finish();
			}
			
			ActivityManager activityMgr= (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE );

	        activityMgr.restartPackage(context.getPackageName());

			System.exit(0);

		}
}
