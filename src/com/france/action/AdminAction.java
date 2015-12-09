package com.france.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.france.bean.Article;
import com.france.bean.BaseApplication;
import com.france.bean.Lanmu;
import com.france.bean.User;
import com.france.dto.ArticleDTO;
import com.france.service.NewsService;
import com.france.service.UserService;
import com.france.util.Config;
import com.france.util.ConvertUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("adminAction")
public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 4232341L;
	@Resource
	private UserService userService;
	@Resource
	private NewsService newsService;
	List<BaseApplication> allApplications;
	String lanmuSplit;
	private Map<String,Object> dataMap;
	Article editArticle;
	List<ArticleDTO> articleDTOs;
	public String showlist(){
		allApplications=new ArrayList<>();
		allApplications=userService.getAllUserApplicationList();//已提交的
		return "adminlist_success";
	}
	public String articleManage(){
		List<Article> articles=newsService.findAllArticlesTOManage();
		articleDTOs=new ArrayList<>();
		for(Article article:articles){
			ArticleDTO articleDTO=new ArticleDTO();
			articleDTO.setArticle(article);
			articleDTO.setLanmuName(newsService.getLanmuByID(article.getTopicID()).getName());
			
			articleDTOs.add(articleDTO);
		}
		System.out.println("重新组装后的文章列表大小:"+articleDTOs.size());
		return "articleManageSuccess";
	}
	public String deleteArticle(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer articleId = Integer.valueOf(request.getParameter("articleId"));
		newsService.deleteArticle(articleId);
		return "deleteArticle_success";
		
	}
	public String editArticle(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String temp=request.getParameter("articleID");
		if("".equals(temp)||temp==null){
			
		}else{
			Integer articleId = Integer.valueOf(temp);
			System.out.println("articleId:"+articleId);
			editArticle=newsService.findArticleByID(articleId);
			System.out.println("editArticle title:"+editArticle.getTitle());
			lanmuSplit="";
			lanmuSplit=newsService.getParAndCurSplitArticleID(editArticle.getTopicID());
			
			System.out.println("lanmuSplit"+lanmuSplit);
			
		}
		return "editArticleSuccess";
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
	public String articleSubmit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User loginUser=(User)session.getAttribute(Config.SESSION_USER);
		int topic=Integer.parseInt(request.getParameter("lanmuid"));
		System.out.println("topic:"+topic);
		String title=request.getParameter("title").trim();
		String content=request.getParameter("content").trim();
		if(editArticle!=null){
			System.out.println("修改文章");
			editArticle.setContent(content);
			editArticle.setTitle(title);
			editArticle.setAuthor(loginUser.getUname());
			editArticle.setTopicID(topic);
//			editArticle.setPublishTime(ConvertUtil.getTime());
			newsService.updateArticle(editArticle);
			dataMap=new HashMap<String,Object>();
			dataMap.put("articleID", editArticle.getId());
			editArticle=null;//使得再次发表的时候还是从该方法出去，，
			return "articleSubmitSuccess";
		}
		System.out.println("新增文章");
		Article acticle=new Article();
		acticle.setContent(content);
		acticle.setTitle(title);
		acticle.setAuthor(loginUser.getUname());
		acticle.setTopicID(topic);
		acticle.setPublishTime(ConvertUtil.getTime());
		newsService.saveArticle(acticle);
		dataMap=new HashMap<String,Object>();
		dataMap.put("articleID", acticle.getId());
		editArticle=null;//使得再次发表的时候还是从该方法出去，，
		return "articleSubmitSuccess";
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
	public List<ArticleDTO> getArticleDTOs() {
		return articleDTOs;
	}
	public void setArticleDTOs(List<ArticleDTO> articleDTOs) {
		this.articleDTOs = articleDTOs;
	}
	public Article getEditArticle() {
		return editArticle;
	}
	public void setEditArticle(Article editArticle) {
		this.editArticle = editArticle;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public String getLanmuSplit() {
		return lanmuSplit;
	}
	public void setLanmuSplit(String lanmuSplit) {
		this.lanmuSplit = lanmuSplit;
	}

}
