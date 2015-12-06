package com.france.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

@Controller("userAction")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 3423411L;

	/**
	 * Constructor of the object.
	 */
	@Resource
	private UserService userService;
	List<BaseApplication> submitList;
	List<BaseApplication> noSubmitList;
	private String filename;
	private String flen;
	public String userlist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User u=(User)session.getAttribute(Config.SESSION_USER);
		submitList=new ArrayList<>();
		noSubmitList=new ArrayList<>();
		submitList=userService.getMyApplicationListByIsSubmit(u.getUser_id(),1);
		noSubmitList=userService.getMyApplicationListByIsSubmit(u.getUser_id(),0);
		System.out.println("try to list.jsp");
		return "user_list_success";
	}
	public String apply(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
//		PrintWriter pw = response.getWriter();  
		User loginUser=(User) session.getAttribute(Config.SESSION_USER);
		String type=request.getParameter("type");
		int aid=Integer.valueOf(request.getParameter("aid"));
		if("edit".endsWith(type)){
			//申请判断
			if(userService.judgeApplicationSubmit(aid)){
				//已经提交 不能再编辑 非法操作
			}
			else{
				//把数据放入response
				BaseApplication baseApplication=userService.getSingleApplicationByUID(loginUser.getUser_id(),aid);
//				request.setAttribute("baseApplication", baseApplication);
				//进入step.jsp
//				request.getRequestDispatcher("/step.jsp").forward(request, response);
			}
		}
		else if("view".endsWith(type)){
			//获取数据
			BaseApplication baseApplication=userService.getSingleApplicationByUID(loginUser.getUser_id(),aid);
			request.setAttribute("baseApplication", baseApplication);
			//转向finished-view.jsp
//			request.getRequestDispatcher("/finished-view.jsp").forward(request, response);
		}
		return SUCCESS;
	}
	public String download(){
		try {
			getDownloadFile().toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "download_success";
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
	public InputStream getDownloadFile() throws Exception  {   
		//注意这个地方ServletActionContext.getServletContext().getRealPath("/Excels")+ "/"+name; 路径错误
		File file = new File(ServletActionContext.getServletContext().getRealPath("/WEB-INF/file/" + filename));
		        this.setFlen(String.valueOf(file.length()));
		return ServletActionContext.getServletContext().getResourceAsStream ("/WEB-INF/file/"+filename);
	}
	public List<BaseApplication> getSubmitList() {
		return submitList;
	}
	public void setSubmitList(List<BaseApplication> submitList) {
		this.submitList = submitList;
	}
	public List<BaseApplication> getNoSubmitList() {
		return noSubmitList;
	}
	public void setNoSubmitList(List<BaseApplication> noSubmitList) {
		this.noSubmitList = noSubmitList;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFlen() {
		return flen;
	}
	public void setFlen(String flen) {
		this.flen = flen;
	}

}
