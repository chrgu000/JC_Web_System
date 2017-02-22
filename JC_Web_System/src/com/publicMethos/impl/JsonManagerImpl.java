package com.publicMethos.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Field; 
import java.lang.reflect.Method;

import com.publicMethos.IJsonManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**json操作类
 * @author Administrator
 *
 */
public class JsonManagerImpl implements IJsonManager {

	/**作用：将list<?>对象转为json字符串
	 * 参数1：List<?> objects
	 * 返回值：String
	 * 创建时间：11:58:03 PM  创建者：wulm
	 */
	public String Object2Json(List<?> objects){  
		List<Map> listMap= getFieldVlaueList(objects);
		JSONArray json = JSONArray.fromObject(listMap);//将java对象转换为json对象  
        String str = json.toString();//将json对象转换为字符串  
        return str;  
    }
	
	
	/* 
     * 将object转换为Map，不包含object继承属性 
     */  
    public Map<String, String> getFieldVlaue(Object obj) throws Exception {    
        Map<String, String> mapValue = new HashMap<String, String>();    
        Class<?> cls = obj.getClass();    
        Field[] fields = cls.getDeclaredFields();    
        for (Field field : fields) {    
            String name = field.getName();    
            String strGet = "get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());    
            Method methodGet = cls.getDeclaredMethod(strGet);    
            Object object = methodGet.invoke(obj);    
            String value = object != null ? object.toString() : "";    
            mapValue.put(name, value);    
        }    
        return mapValue;    
    }    
	
	/* 
     * 将List<object>转换为List<Map> 
     */  
	public List<Map> getFieldVlaueList(List<?> objects) {
		List<Map> mapList = new ArrayList<Map>();
		try {
			for (Object obj : objects) {
				mapList.add(getFieldVlaue(obj));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapList;
	}
}
