package com.tianwen.yuntianyi;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 后台发送指令清除pad密码，数据
 * @author Administrator
 *
 */
public class Security {

    public static final int ACTION_CLEAR_LOCKSCREEN_CODE = 3;
    public static final int ACTION_DELETE_FILES = 4;
    
	public static void main(String[] args) {
		try {
			JSONObject suoping = new JSONObject();
			suoping.put("action", ACTION_CLEAR_LOCKSCREEN_CODE);
			
			System.out.println(suoping.toString());
			
			JSONObject deleteFiles = new JSONObject();
			deleteFiles.put("action", ACTION_DELETE_FILES);
			System.out.println(deleteFiles.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
}
