package com.france.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 字符集过滤函数，设置req & res 的字符集为UTF-8
 * @author France
 *
 */
public class EncodeFilter implements Filter{
	
	//存init-param
	String encodeCoding="";
	 // 实现初始化方法 
	public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
         
    }
    // 实现销毁方法 
    public void destroy() { 
    } 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain fc) throws IOException, ServletException {
        // TODO Auto-generated method stub
    	System.out.println(request.getServerName());
    	HttpServletRequest httpRequest = (HttpServletRequest) request;  
    	System.out.println("进行编码前路径:"+httpRequest.getServletPath());
    	httpRequest.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");   
         response.setCharacterEncoding("utf-8");   
         System.out.println("进行编码前路径:"+httpRequest.getServletPath());
         fc.doFilter(request,response);   
         
    }

}
