package com.publicMethos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bean.PageBean;

public interface IJsonManager {
	
	public String Object2Json(List<?> objects);
	
	public Map<String, String> getFieldVlaue(Object obj) throws Exception;
	
	public List<Map> getFieldVlaueList(List<?> objects);
}
