package com.kabank.mvc.iterator;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

public class ParamsIterator {
	public static Map<?,?> execute(HttpServletRequest request){
		Map<String,String> result = new HashMap<>();
		Map<String,String[]> map = request.getParameterMap();
		Set<Entry<String,String[]>> set=map.entrySet();
		Iterator<Map.Entry<String, String[]>> it = set.iterator();
		String params[]=new String[set.size()];
		int i = 0;
		while(it.hasNext()) {
			Map.Entry<String, String[]> e = it.next();
			params[i]=e.getKey();
			i++;
		}
		for(i=0;i<params.length;i++) {
			if(map.get(params[i]).length==1) {
				result.put(params[i],map.get(params[i])[0]); // 벨류가 한개 - 체크박스를 제외한 모든것
			}else {
				String temp="";
				for(int j=0;j<map.get(params[i]).length;j++) { // 벨류가 여러개 - 체크박스
					temp+=map.get(params[i])[j]+",";
				}
				result.put(params[i], temp);
			}
		}
		System.out.println("cmd 존재 여부 : "+map.containsKey("cmd"));
		return result;
	}
}
