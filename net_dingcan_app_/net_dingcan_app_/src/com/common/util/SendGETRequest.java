package com.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import android.util.Log;

public class SendGETRequest {
	/**
	 * �ύ���ݵ������� ���ҷ���ȡ����ֵ
	 * 
	 * @param path
	 * @param params
	 * @param encode
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> sendGETRequest(String path, String params)
			throws Exception {
		Map<String, String> tempMap = null;

		boolean b = false;
		Log.v("url", path + params);
		//params=URLEncoder.encode(params,"UTF-8");
		HttpURLConnection conn = (HttpURLConnection) new URL(path + params)
				.openConnection();
		// conn.setConnectTimeout(5000);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "text/xml");
		conn.setRequestProperty("Charset", "UTF-8");
		// conn.setRequestProperty("Cookie", Constant.youxinCookie);
		conn.setConnectTimeout(20000);
		// ���������Ӧ����200�����ʾ�ɹ�
		if (conn.getResponseCode() == 200) {
			System.out.println(conn.getResponseCode());
			// ��÷�������Ӧ������
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			// ����
			String retData = null;
			String responseData = "";
			while ((retData = in.readLine()) != null) {
				responseData += retData;
			}
			in.close();
			System.out.println(responseData.toString());
			tempMap = JsonUtil.getJosn(responseData);
			return tempMap;
		}
		// tempMap.put("innerEorr", "��������Ӧ��ʱ");
		return tempMap;
	}
	
	/**
	 * �ύ���ݵ������� ���ҷ���ȡ����ֵ
	 * 
	 * @param path
	 * @param params
	 * @param encode
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> sendGETRequest(String path)
			throws Exception {
		Map<String, String> tempMap = null;

		boolean b = false;
		HttpURLConnection conn = (HttpURLConnection) new URL(path)
				.openConnection();
		// conn.setConnectTimeout(5000);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "text/xml");
		conn.setRequestProperty("Charset", "UTF-8");
		// conn.setRequestProperty("Cookie", Constant.youxinCookie);
		conn.setConnectTimeout(20000);
		// ���������Ӧ����200�����ʾ�ɹ�
		if (conn.getResponseCode() == 200) {
			System.out.println(conn.getResponseCode());
			// ��÷�������Ӧ������
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			// ����
			String retData = null;
			String responseData = "";
			while ((retData = in.readLine()) != null) {
				responseData += retData;
			}
			in.close();
			System.out.println(responseData.toString());
			tempMap = JsonUtil.getJosn(responseData);
			return tempMap;
		}
		// tempMap.put("innerEorr", "��������Ӧ��ʱ");
		return tempMap;
	}
	
}
