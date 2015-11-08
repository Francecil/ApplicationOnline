package com.france.filter;

import java.io.IOException;

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

public class LogFilter extends BaseFilter{
	
	private FilterConfig config=null;
	private String Webroot =null;
	 // 实现初始化方法 
	@Override
    public void init()throws ServletException { 
        this.config = getConfig();
    }
    // 实现销毁方法 
    public void destroy() { 
        this.config = null; 
    } 
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)  
            throws IOException, ServletException {  
        // 获取ServletContext 对象，用于记录日志 
        ServletContext context = this.config.getServletContext(); 
        long before = System.currentTimeMillis(); 
        System.out.println("开始过滤... "); 
        // 将请求转换成HttpServletRequest 请求 
        // 记录日志 
        context.log("Filter已经截获到用户的请求的地址: " + request.getServletPath()); 
        try { 
            // Filter 只是链式处理，请求依然转发到目的地址。 
            chain.doFilter(request, response); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        long after = System.currentTimeMillis(); 
        // 记录日志 
        context.log("过滤结束"); 
        // 再次记录日志 
        context.log(" 请求被定位到" + ((HttpServletRequest) request).getRequestURI() 
                + "所花的时间为: " + (after - before)); 
    } 


}
