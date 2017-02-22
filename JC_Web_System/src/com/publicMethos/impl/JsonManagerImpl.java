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


/**json������
 * @author Administrator
 *
 */
public class JsonManagerImpl implements IJsonManager {

	/**���ã���list<?>����תΪjson�ַ���
	 * ����1��List<?> objects
	 * ����ֵ��String
	 * ����ʱ�䣺11:58:03 PM  �����ߣ�wulm
	 */
	public String Object2Json(List<?> objects){  
		List<Map> listMap= getFieldVlaueList(objects);
		JSONArray json = JSONArray.fromObject(listMap);//��java����ת��Ϊjson����  
        String str = json.toString();//��json����ת��Ϊ�ַ���  
        return str;  
    }
	
	
	/* 
     * ��objectת��ΪMap��������object�̳����� 
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
     * ��List<object>ת��ΪList<Map> 
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
