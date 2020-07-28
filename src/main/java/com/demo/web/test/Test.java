package com.demo.web.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.demo.web.common.ResponseVo;
import com.demo.web.model.User;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

/**
*@author:liuhao
*@version:2020年4月19日下午1:53:09
*@description:
*/
public class Test {

	@org.junit.Test
	public void date() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(formatter.format(date));
	}
	
	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("a", "a");
		map.put("b", "b");
		map.put("c", "c");
		
		User user = new User("小花","女","吃");
		String st = JSONObject.fromObject(map).toString();
		try {
			String str = URLEncoder.encode(st, "UTF-8");
			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResponseVo vo = new ResponseVo();
        vo.setStatus("200");
        vo.setInfo("success");
        Gson gson = new Gson();
        String result = gson.toJson(vo);
        System.out.println(result);
//        requestContext.setResponseBody(result);
		
	}

}
