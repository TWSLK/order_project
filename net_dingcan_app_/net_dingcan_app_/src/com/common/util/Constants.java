package com.common.util;

import android.os.Environment;

/**
 * ������
 * @author hjgang
 */
public final class Constants {
	/** ϵͳ��ʼ�������ļ��� */
	public static final String SYSTEM_INIT_FILE_NAME = "sysini";
	/** ���ػ���Ŀ¼ */
	public static final String CACHE_DIR;
	
	public static final int PAGESIZE=10;
	/** ���黺��Ŀ¼ */
	public static final String CACHE_DIR_SMILEY;
	/** ͼƬ����Ŀ¼ */
	public static final String CACHE_DIR_IMAGE;
	/** ���ϴ�ͼƬ����Ŀ¼ */
	public static final String CACHE_DIR_UPLOADING_IMG;
	
	
	
	
	//sdcard dir
	public static final String SD_DIR = "cangshengwangsystemapk";
	
	public static final String SD_DIR_TMP = "cangshengwang/tmp";
    
	//dialog
	public static final int DIALOG_YES_NO_MESSAGE = 1;
	public static final int DIALOG_APK_UPDATE = 2;
	public static final int PROGRESSBAR_WAIT = 3;
	public static final int IMAGE_UPLOAD = 8;
	public static final int VIDEO_UPLOAD = 10;
	public static final int IMAGE_LOAD = 9;
	public static final int CHOOSE_FX = 4;
	public static final int URL_WAIT = 5;
	public static final int DIALOG_IR_UPDATE = 6;
	
	public static final int TIMEOUT_10 = 10000;  
	public static final int TIMEOUT_15 = 15000; 
	
	public static final String APP_BORADCASTRECEIVER="www.cangshengwang.net";
	public static final String APP_BORADCASTRECEIVER2="www.cangshengwang.net2";

	static {
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			CACHE_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CangShengWang/";
		} else {
			CACHE_DIR = Environment.getRootDirectory().getAbsolutePath() + "/CangShengWang/";
		}
		
		CACHE_DIR_SMILEY = CACHE_DIR + "/smiley";
		CACHE_DIR_IMAGE = CACHE_DIR + "/pic";
		CACHE_DIR_UPLOADING_IMG = CACHE_DIR + "/uploading_img";
	}
	private Constants(){}
	
	/**************************************************************************/
	/** ���ݿ�汾�� */
	public static final int DB_VERSION = 2;
	
	//log tag
	public static final String TAG = "System.out";
	
	public static final int BYTE_SIZE_INT = 1024;
	/** ���ݿ��� */
	public static final String DB_NAME = "cangshengwang_shop.db";
	
	/** ������������ӵ�Э���� */
	public static final String PROTOCOL = "http://";
	/** ������IP */
	public static final String HOST = "192.168.9.45";//www.multibuy.cn//www.shopnctest.com/b2b2c/2014/test1/mobile/
	/** �������˿ں� */
	public static final String PORT = ":8080";
	/** Ӧ���������� */
	public static final String APP = "/wishbottle/";//
	public static final String APP_NAME = "WishBottleApp.apk";
	/** Ӧ������������·�� */
	public static final String URL_CONTEXTPATH = "http://www.cangshengwang.com/mobile/index.php?";
	public static final String URL_CONTEXTPATH_WISHBOTTLE = PROTOCOL + HOST +PORT+ APP ;
	public static final String URL_NEW_VERSION = PROTOCOL + HOST + "/app/" +APP_NAME;
	
	/**
	 * ��ҳ�����ַ
	 * 
	 * */
	public static final String URL_HOME=URL_CONTEXTPATH+"act=index";
	/**
	 * һ�����������ַ
	 * 
	 * */
	public static final String URL_GOODSCLASS=URL_CONTEXTPATH+"act=goods_class";
	
	/**
	 * ��Ʒ�б������ַ
	 * 
	 * */
	public static final String URL_GOODSLIST=URL_CONTEXTPATH+"act=goods&op=goods_list";
	
	/**
	 * IC����ֵAPI
	 * 
	 * */
	public static final String URL_ICCARDCHARGE=URL_CONTEXTPATH+"act=app_server&op=iccard_add";
	/**
	 * ������ҳ����
	 * 
	 * */
	public static final String URL_TOP_THEME=URL_CONTEXTPATH+"act=circle&op=top_theme";
	/*
	 * ����Ȧ�����б�
	 */
	public static final String URL_CIRCLE_THEMES_LIST=URL_CONTEXTPATH+"act=circle";
	/*
	 * 
	 * ����
	 */
	
	public static final String URL_CIRCLE_THEMES_LIKE_CLICK=URL_CONTEXTPATH+"act=circle&op=theme_likeyes";
	
	/*
	 * 
	 * 
	 */
	public static final String URL_CIRCLE_CHECK_MEMBER=URL_CONTEXTPATH+"act=circle&op=check_member";
	/*
	 *������������
	 */
	public static final String URL_CIRCLE_THEMES_DETAIL=URL_CONTEXTPATH+"act=circle&op=theme_detail";
	/*
	 *����֪ͨ����
	 */
	public static final String URL_NOTIFICATION_DETAIL=URL_CONTEXTPATH+"act=circle&op=article_detail";
	
	/*
	 * ���ӻظ�
	 */
	public static final String URL_CIRCLE_THEMES_REPLY=URL_CONTEXTPATH+"act=circle&op=reply";
	
	/*
	 * ��ȡ�汾��
	 */
	
	//http://www.cangshengwang.com/mobile/index.php?act=app_server&op=iccard_add
	//http://www.cangshengwang.com/mobile/index.php?act=app_server&op=get_version
	public static final String URL_NEW_VERSION_NO = URL_CONTEXTPATH+"act=app_server&op=get_version";
	/**
	 * �һ����� 
	 */
	public static final String URL_FIND_PWD = URL_CONTEXTPATH+"act=app_server&op=find_password";
	/**
	 * �������۵�ַ
	 * */
	//http://www.cangshengwang.com/mobile/index.php?act=member_evaluate&op=add_evaluate
	public static final String URL_ORDER_COMMENT_SUBMIT=URL_CONTEXTPATH+"act=member_evaluate&op=add_evaluate";
	
	/**
	 * ��Ʒ���������ַ
	 * */
	
	
	public static final String URL_GOODSDETAILS=URL_CONTEXTPATH+"act=goods&op=goods_detail";
	
	
	/**
	 * ��Ʒ�������������ַ
	 * 
	http://cangshengwang.com/mobile/index.php?act=goods&op=comments&goods_id=4343

	 * */
	public static final String URL_GOODSDETAIL_COMMENTS=URL_CONTEXTPATH+"act=goods&op=comments";
	/**
	 * ��¼�����ַ
	 * */
	public static final String URL_LOGIN=URL_CONTEXTPATH+"act=login";
	/**
	 * �ҵ��̳������ַ
	 * */
	public static final String URL_MYSTOIRE=URL_CONTEXTPATH+"act=member_index";
	/*
	 * ǩ����ַ
	 */
	public static final String URL_SIGN=URL_CONTEXTPATH+"act=login&op=sign";
	
	/**
	 * �ҵ��̳������ַ
	 * */
	public static final String URL_GOODS_DETAILS_WEB=URL_CONTEXTPATH+"act=goods&op=goods_body";
	/**
	 * ����ղ������ַ
	 * */
	public static final String URL_ADD_FAVORITES=URL_CONTEXTPATH+"act=member_favorites&op=favorites_add";
	/**
	 * �ղ��б������ַ
	 * */
	public static final String URL_FAVORITES_LIST=URL_CONTEXTPATH+"act=member_favorites&op=favorites_list";
	/**
	 * ɾ���ղ������ַ
	 * */
	public static final String URL_FAVORITES_DELETE=URL_CONTEXTPATH+"act=member_favorites&op=favorites_del";
	/**
	 * ��ַ�б������ַ
	 * */
	public static final String URL_ADDRESS_LIST=URL_CONTEXTPATH+"act=member_address&op=address_list";
	/**
	 * �����б������ַ
	 * */
	public static final String URL_ORDER_LIST=URL_CONTEXTPATH+"act=member_order&op=order_list";
	/**
	 * ���������ַ
	 * */
	//http://www.cangshengwang.com/mobile/index.php?act=member_evaluate&op=add&order_id=
	//http://www.cangshengwang.com/mobile/index.php?act=member_evaluate&op=show_evaluate
	public static final String URL_ORDER=URL_CONTEXTPATH+"act=member_evaluate&op=show_evaluate";
	/**
	 * ��ӹ��ﳵ�����ַ
	 * */
	public static final String URL_ADD_CART=URL_CONTEXTPATH+"act=member_cart&op=cart_add";
	/**
	 * ��ȡ��½�û�����
	 */
	
	public static final String URL_MEMBER_POINTS=URL_CONTEXTPATH+"act=member_cart&op=get_member_points";
	/**
	 * ���ﳵ�б������ַ
	 * */
	public static final String URL_CART_LIST=URL_CONTEXTPATH+"act=member_cart&op=cart_list";
	/**
	 * ���ﳵɾ�������ַ
	 * */
	public static final String URL_CART_DETELE=URL_CONTEXTPATH+"act=member_cart&op=cart_del";
	/**
	 * ע���ǳ������ַ
	 * */
	public static final String URL_LOGIN_OUT=URL_CONTEXTPATH+"act=logout";
	/**
	 * ��ַ��ϸ��Ϣ�����ַ
	 * */
	public static final String URL_ADDRESS_DETAILS=URL_CONTEXTPATH+"act=member_address&op=address_info";
	/**
	 * �����б������ַ
	 * */
	public static final String URL_GET_CITY=URL_CONTEXTPATH+"act=member_address&op=area_list";
	/**
	 * ��ַ�༭�����ַ
	 * */
	public static final String URL_ADDRESS_EDIT=URL_CONTEXTPATH+"act=member_address&op=address_edit";
	/**
	 * ��ַɾ�������ַ
	 * */
	public static final String URL_ADDRESS_DETELE=URL_CONTEXTPATH+"act=member_address&op=address_del";
	/**
	 * ��ַ��������ַ
	 * */
	public static final String URL_ADDRESS_ADD=URL_CONTEXTPATH+"act=member_address&op=address_add";
	/**
	 * ���߰��������ַ
	 * */
	public static final String URL_HELP=PROTOCOL + HOST + APP+"/help.html";
	/**
	 * ������1�����ַ
	 * */
	public static final String URL_BUY_STEP1=URL_CONTEXTPATH+"act=member_buy&op=buy_step1";
	/**
	 * ������2�����ַ
	 * */
	public static final String URL_BUY_STEP2=URL_CONTEXTPATH+"act=member_buy&op=buy_step2";
	/**
	 * ��Ʊ�б������ַ
	 * */
	public static final String URL_INVOICE_LIST=URL_CONTEXTPATH+"act=member_invoice&op=invoice_list";
	/**
	 * ��Ʊ�����б������ַ
	 * */
	public static final String URL_INVOICE_CONTEXT_LIST=URL_CONTEXTPATH+"act=member_invoice&op=invoice_content_list";
	/**
	 * ��ӷ�Ʊ�����ַ
	 * */
	public static final String URL_INVOICE_ADD=URL_CONTEXTPATH+"act=member_invoice&op=invoice_add";
	/**
	 * �����ջ���ַ�����ַ
	 * */
	public static final String URL_UPDATE_ADDRESS=URL_CONTEXTPATH+"act=member_buy&op=change_address";
	/**
	 * ��֤���������ַ
	 * */
	public static final String URL_CHECK_PASSWORD=URL_CONTEXTPATH+"act=member_buy&op=check_password";
	/**
	 * ����ȡ��(δ����)�����ַ
	 * */
	public static final String URL_ORDER_CANCEL=URL_CONTEXTPATH+"act=member_order&op=order_cancel";
	/**
	 * ����ȷ���ջ������ַ
	 * */
	public static final String URL_ORDER_RECEIVE=URL_CONTEXTPATH+"act=member_order&op=order_receive";
	/**
	 * �������������ַ
	 * */
	public static final String URL_ORDER_PAYMENT=URL_CONTEXTPATH+"act=member_payment&op=pay";
	/**
	 *ע��
	 * */
	public static final String URL_REGISTER=URL_CONTEXTPATH_WISHBOTTLE+"user_reguser.action";
	
	/*
	 * 
	 * �������Ȧ��
	 */
	public static final String URL_CIRCLE_APPLY=URL_CONTEXTPATH+"act=circle&op=apply";
	/**
	 *�ֻ�ע��
	 * */
	public static final String URL_PHONE_REGISTER=URL_CONTEXTPATH+"act=app_server&op=register";
	/**
	 *������֤��
	 * */
	public static final String URL_PHONE_REG_SEND_VALIDCODE=URL_CONTEXTPATH+"act=app_server&op=send_msg_code";
}
