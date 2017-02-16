package com.publicMethos.impl;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;

public  final class JsonManager {

	//��json��, ��ȡ������Ϊstr������, ��һά����Data��  
	public static int[] readOneDimensionDataInt(JSONObject json, String str)  
	{  
	    int[] Data = null;  
	    try   
	    {  
	        boolean b = json.has(str);  
	        if(json.has(str))  
	        {  
	            JSONArray Array1 = json.getJSONArray(str);  //��ȡ��������Ӧ��һά����  
	            Data = new int[Array1.length()];            //��������  
	              
	            for(int j = 0; j < Array1.length(); j ++)  
	                Data[j] = Array1.getInt(j);             //��ȡһά�����е�����  
	        }  
	    }   
	    catch (JSONException e)   
	    {  
	        e.printStackTrace();  
	    }  
	    return Data;  
	}  
	
	
	
	
}
