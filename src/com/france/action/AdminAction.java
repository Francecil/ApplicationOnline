package com.france.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.mail.Session;
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
import com.france.service.LoginService;
import com.france.service.UserService;
import com.france.util.Config;
import com.opensymphony.xwork2.ActionSupport;

@Controller("adminAction")
public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 4232341L;
	@Resource
	private UserService userService;
	List<BaseApplication> allApplications;
	public String showlist(){
		allApplications=new ArrayList<>();
		allApplications=userService.getAllUserApplicationList();//已提交的
		return "adminlist_success";
	}
	public String articleManage(){
		return "articleManage";
	}
	public String admin(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		//进入此页面将先进行权限的判断
		User loginUser=(User) session.getAttribute(Config.SESSION_USER);
		String type=request.getParameter("type");
		int aid=Integer.valueOf(request.getParameter("aid"));
		int uid=Integer.valueOf(request.getParameter("uid"));
		if("edit".endsWith(type)){
			//判断是否是超级管理员才能执行 先不做
			
			//把数据放入response
			
			//进入step.jsp(按照提交情况，currentPage should be the last page)
			
		}
		else if("view".endsWith(type)){
			//无需权限判断
			//获取数据
			BaseApplication baseApplication=userService.getSingleApplicationByUID(uid,aid);
			request.setAttribute("baseApplication", baseApplication);
			//转向finished-view.jsp
//			request.getRequestDispatcher("/finished-view.jsp").forward(request, response);
		}
		return SUCCESS;
	}
	//利用正则表达式判断是否为数字
	public boolean isNumeric(String str)
    {
          Pattern pattern = Pattern.compile("[0-9]*");
          Matcher isNum = pattern.matcher(str);
          if( !isNum.matches() )
          {
                return false;
          }
          return true;
    }
	public List<BaseApplication> getAllApplications() {
		return allApplications;
	}
	public void setAllApplications(List<BaseApplication> allApplications) {
		this.allApplications = allApplications;
	}

}
