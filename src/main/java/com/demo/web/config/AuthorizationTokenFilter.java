package com.demo.web.config;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
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
		filterChain.doFilter(request, mResp);//客户端-（请求）>过滤器->服务器
		byte[] bytes = mResp.getBytes();
			if(bytes.length<1024) {
				logger.info("responseData："+new String(bytes,"utf-8"));
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				bout.write(bytes);
				
				//把返回值输出到客户端
	            ServletOutputStream out = response.getOutputStream();
	            out.write(bytes);
	            out.flush();
			}
		}

}
