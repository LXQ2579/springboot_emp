package com.lxq.springboot_emp.utils;


import com.lxq.springboot_emp.common.JsonBean;

public class JsonUtils {

	public static JsonBean createJsonBean(int code, Object info){
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setInfo(info);
		
		return bean;
	}
}
