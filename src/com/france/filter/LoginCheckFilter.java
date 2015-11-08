package com.france.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.france.bean.User;
import com.france.util.Config;

public class LoginCheckFilter extends BaseFilter{
	
	private FilterConfig config=null;
	private String Webroot =null;
	 // 实现初始化方法 
	@Override
    public void init()throws ServletException { 
        this.config = getConfig();
        ServletContext ctx=config.getServletContext();
		Webroot=ctx.getContextPath();
    }
    // 实现销毁方法 
    public void destroy() { 
        this.config = null; 
    } 

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)  
            throws IOException, ServletException {  
    	HttpSession session=request.getSession(false);
    	if(session==null){
    		//不存在session 返回error
    		response.sendRedirect(Webroot+"/error/noSession.jsp");
    	}
    	else{
    		User user=(User) session.getAttribute(Config.SESSION_USER);
    		if(user==null){
    			//不存在用户 返回error
    			response.sendRedirect(Webroot+"/error/noSession.jsp");
    		}
    		else{
    			//到下一个过滤
    			chain.doFilter(request, response);
    		}
    	}
    	
    } 


}
