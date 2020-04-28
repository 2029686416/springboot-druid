package com.demo.web.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSONObject;
import com.demo.web.tool.ResponseWrapper;


/**
*@author:liuhao
*@version:2020年4月27日下午3:27:32
*@description:
*/
@Component
public class AuthorizationTokenFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		ResponseWrapper mResp = new ResponseWrapper(response); // 包装响应对象 resp 并缓存响应数据
//		final String requestHeader = request.getHeader(this.tokenHeader);
		byte[] bytes = mResp.getBytes();
			if(bytes.length<1024) {
				logger.info("responseData："+new String(bytes,"utf-8"));
			}
		}

}
