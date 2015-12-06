package com.france.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.france.bean.Article;
import com.france.bean.Lanmu;
import com.france.bean.Photo;
import com.france.bean.User;
import com.france.service.NewsService;
import com.france.util.Config;
import com.france.util.ConvertUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("newsAction")
public class NewsAction extends ActionSupport {

	private static final long serialVersionUID = 4231231232341L;
	//根栏目
	private Lanmu rootLanmu;
	//当前点击的栏目
	private Lanmu currentLanmu;
	private List<Lanmu> brotherLanmu;
	//展示栏目列表
	private List<Article> articleList;
	//显示具体文章
	private Article detaileArticle;
	//上传所需
	private static final int BUFFER_SIZE = 2 * 1024;
	private File upload;
	private String name;
	private List<String> names;
	private List<Article> articles;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;
	private int chunk;
	private int chunks;
	private Map<String,Object> dataMap;
	//
	@Resource
	private NewsService newsService;
	//显示首页1、2级栏目 
	public String showRootLanmu(){
		rootLanmu=newsService.findAllChildrenLanmu(1);//先采用EAGER 后期
//		System.out.println("由于是延迟加载/json输出的话 用sessionInView 也不行，故要去取一遍");
//		rootLanmu.setChildren(rootLanmu.getChildren());
//		System.out.println("获取完毕");
		return "showLanmu_success";
	}
	public String showDetailListByLanmuID(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int lanmuID=Integer.valueOf(request.getParameter("lmid"));
		articleList=new ArrayList<>();
		Lanmu lanmu=newsService.findAllChildrenLanmu(lanmuID);
		articleList=newsService.getAllChildLanmuArticleInIndex(lanmu, 8);
//		System.out.println("由于是延迟加载/json输出的话 用sessionInView 也不行，故要去取一遍");
//		rootLanmu.setChildren(rootLanmu.getChildren());
//		System.out.println("获取完毕");
		return "showIndexList_success";
	}
	//显示文章列表 (标题、时间)
	public String showArticleList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//进入此页面将先进行权限的判断
		int lanmuID=Integer.valueOf(request.getParameter("lmid"));
		currentLanmu=newsService.findAllChildrenLanmu(lanmuID);
		brotherLanmu=new ArrayList<>();
		brotherLanmu=newsService.findBrotherLanmu(currentLanmu);
		System.out.println("寻找成功");
		articleList=new ArrayList<Article>();
		articleList=newsService.getAllChildLanmuArticleByPage(currentLanmu,1);
		return "showArticleList_success";
	}
	public String updateArticlesByPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer pageNum=Integer.valueOf(request.getParameter("pageNum"));
		articleList=new ArrayList<Article>();
		articleList=newsService.getAllChildLanmuArticleByPage(currentLanmu,pageNum);
		return "updateArticlesByPage_success";
	}
	public String showArticleDetail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//进入此页面将先进行权限的判断
		int articleID=Integer.valueOf(request.getParameter("articleID"));
		detaileArticle=newsService.findArticleByID(articleID);
		if(detaileArticle==null){
			System.out.println("没有找到文章");
			return "showArticleDetail_nofind";
		}
		else{
			System.out.println("找到文章了");
			request.setAttribute("content", detaileArticle.getContent());
		}
		return "showArticleDetail_success";
	}
	//将文件片段整合到一起
	private void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			if (dst.exists()) {
				out = new BufferedOutputStream(new FileOutputStream(dst, true),
						BUFFER_SIZE);
			} else {
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
			}
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);

			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String upload() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
	    HttpServletRequest request = (HttpServletRequest)actionContext.get(ServletActionContext.HTTP_REQUEST); 
		String dstPath = ServletActionContext.getServletContext().getRealPath(
				this.getSavePath())
				+ "\\" + this.getName();
		System.out.println("dst:"+dstPath);
		File dstFile = new File(dstPath);
		
		// 文件已存在（上传了同名的文件）
		if (chunk == 0 && dstFile.exists()) {
			dstFile.delete();
			dstFile = new File(dstPath);
		}
		copy(this.upload, dstFile);
		if (chunk == chunks - 1) {
			// 完成一整个文件;
		}

		return SUCCESS;
	}

	public String articleSubmit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User loginUser=(User)session.getAttribute(Config.SESSION_USER);
//		Integer articleID=(Integer)session.getAttribute(Config.SESSION_ARTICLE);
//		if(articleID==null){
//			//新建文章，存入session
//			
//		}
		String title=request.getParameter("title").trim();
		String content=request.getParameter("content").trim();
		System.out.println("content:"+content);
		//3级列表框
		int topic=Integer.parseInt(request.getParameter("lanmuid"));
		Article acticle=new Article();
		acticle.setContent(content);
		acticle.setTitle(title);
		acticle.setAuthor(loginUser.getUname());
		acticle.setTopicID(topic);
		acticle.setPublishTime(ConvertUtil.getTime());
//		for (int i = 0; i < count; i++) {
//			uploadFileName = request.getParameter("uploader_" + i + "_name");
//			name = request.getParameter("uploader_" + i + "_tmpname");
//			System.out.println(uploadFileName + " " + name);
//			Photo p=new Photo();
//			p.setSavename(name);
//			newsService.savePhoto(p);
//			acticle.getPhotos().add(p);
//		}
		newsService.saveArticle(acticle);
		dataMap=new HashMap<String,Object>();
		dataMap.put("articleID", acticle.getId());
		//一系列操作用一个service实现，可回滚;
//		try {
//			newsService.updateLanmuByAddArticle(lanmu, acticle);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("出错，检查事务是否回滚");
//		}
//		Set<Article> articles=lanmu.getArticles();
//		articles.add(acticle);
//		lanmu.setArticles(articles);
////		lanmu.getArticles().add(acticle);//will error:failed to lazily initialize a collection of role:
//		newsService.updateLanmu(lanmu);
		return "articleSubmitSuccess";
	}
	//得到根栏目的ID
	public int getTopicID(int one,int tow,int three){
		if(three!=-1)return three;
		else if(tow!=-1)return tow;
		else if(one!=-1)return one;
		return -1;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public int getChunk() {
		return chunk;
	}
	public void setChunk(int chunk) {
		this.chunk = chunk;
	}
	public int getChunks() {
		return chunks;
	}
	public void setChunks(int chunks) {
		this.chunks = chunks;
	}
	public NewsService getNewsService() {
		return newsService;
	}
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	public Lanmu getRootLanmu() {
		return rootLanmu;
	}
	public void setRootLanmu(Lanmu rootLanmu) {
		this.rootLanmu = rootLanmu;
	}
	public Lanmu getCurrentLanmu() {
		return currentLanmu;
	}
	public void setCurrentLanmu(Lanmu currentLanmu) {
		this.currentLanmu = currentLanmu;
	}
	public List<Lanmu> getBrotherLanmu() {
		return brotherLanmu;
	}
	public void setBrotherLanmu(List<Lanmu> brotherLanmu) {
		this.brotherLanmu = brotherLanmu;
	}
	public List<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	public Article getDetaileArticle() {
		return detaileArticle;
	}
	public void setDetaileArticle(Article detaileArticle) {
		this.detaileArticle = detaileArticle;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
}
