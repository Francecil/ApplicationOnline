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
import com.france.dao.UserDao;
import com.france.dao.impl.UserDaoImpl;
import com.france.util.Config;

public class RoleCheckFilter extends BaseFilter{
	
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
    	User user=(User) session.getAttribute(Config.SESSION_USER);
    	UserDao userDao=new UserDaoImpl();
    	if(userDao.isAdmin(user.getUser_id())){
    		//下一个过滤
    		chain.doFilter(request, response);
    	}
    	else{
    		//没有权限 返回error
    		response.sendRedirect(Webroot+"/error/noAuth.jsp");
    	}
    } 
}
