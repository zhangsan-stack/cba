package com.shop.entity;

import lombok.Data;
import org.aspectj.lang.annotation.DeclareAnnotation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Msg implements Serializable {
	static final long serialVersionUID =1L;

	private String  msg;
	private Integer code;
	private Map<String ,Object> extend = new HashMap<String, Object>();

	public static Msg Success(){
		Msg  result = new Msg();
		result.setCode(100);
		result.setMsg("处理成功");
		return result;

	}
	public static Msg fail(){
		Msg  result = new Msg();
		result.setCode(200);
		result.setMsg("处理失败");
		return result;

	}

	public Msg add(String key, Object value){
		this.getExtend().put(key, value);
		return this;
	}
}
