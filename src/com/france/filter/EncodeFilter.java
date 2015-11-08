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
public class EncodeFilter extends BaseFilter{
	
	//存init-param
	String encodeCoding="";
	 // 实现初始化方法 
	@Override
    public void init()throws ServletException { 
        encodeCoding =getConfig().getInitParameter("EncodeCoding");
    }
    // 实现销毁方法 
    public void destroy() { 
    } 

    @Override  
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)  
        throws IOException, ServletException {  
        System.out.println("==============");
    	request.setCharacterEncoding(encodeCoding);
    	response.setCharacterEncoding(encodeCoding);
    	 System.out.println("EncodeFilter doFilter");
        chain.doFilter(request, response);
       
    } 

}
