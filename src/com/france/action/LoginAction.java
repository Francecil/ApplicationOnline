package com.france.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.france.bean.BaseApplication;
import com.france.bean.User;
import com.france.service.UserService;
import com.france.service.impl.UserServiceImpl;
import com.france.util.Config;
import com.france.util.ConvertUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("loginAction")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	@Resource
	private UserService userService;
	private User u;
	public String register(){
		System.out.println(u.getUname());
		u.setPassword(ConvertUtil.MD5(u.getPassword()));
		userService.saveUser(u);
		return "register_success";
	}
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email!=null&&!"".equals(email)&&password!=null&&!"".equals(password)){
			try {
				password=ConvertUtil.MD5(password);
				User user=userService.checkUser(email, password);
				if(user!=null){
					System.out.println("登录成功");
					session.setAttribute(Config.SESSION_USER, user);
					if(userService.isAdmin(user)){
						System.out.println("admin login success");
//						allApplications=new ArrayList<>();
//						allApplications=userService.getAllUserApplicationList();
//						request.setAttribute("userApplication", userApplication);
						//跳转到
//						request.getRequestDispatcher("listadmin.jsp").forward(request, response);
						return "admin_success";
					}
					else{
						System.out.println("user login success");
						
//						request.setAttribute("submitList", submitList);
//						request.setAttribute("noSubmitList", noSubmitList);
//						response.sendRedirect(request.getContextPath()+"/list.jsp"); //直接重定向，不转发
						return "user_success";
					}
				}
//				else response.sendRedirect(request.getContextPath()+"/login.html");
				return "fail";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return "fail";
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}

}
