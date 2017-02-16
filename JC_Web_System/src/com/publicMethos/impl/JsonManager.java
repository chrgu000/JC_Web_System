package com.publicMethos.impl;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;

public  final class JsonManager {

	//从json中, 读取属性名为str的数据, 到一维数组Data中  
	public static int[] readOneDimensionDataInt(JSONObject json, String str)  
	{  
	    int[] Data = null;  
	    try   
	    {  
	        boolean b = json.has(str);  
	        if(json.has(str))  
	        {  
	            JSONArray Array1 = json.getJSONArray(str);  //获取属性名对应的一维数组  
	            Data = new int[Array1.length()];            //创建数组  
	              
	            for(int j = 0; j < Array1.length(); j ++)  
	                Data[j] = Array1.getInt(j);             //获取一维数组中的数据  
	        }  
	    }   
	    catch (JSONException e)   
	    {  
	        e.printStackTrace();  
	    }  
	    return Data;  
	}  
	
	
	
	
}
