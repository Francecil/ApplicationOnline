package com.france.service;

import java.util.List;

import com.france.bean.Article;
import com.france.bean.Lanmu;
import com.france.bean.Photo;

public interface NewsService {
	public void saveLanmu(Lanmu m);
	/*
	 * 根据id
	 * 包括自身 及 所有子孙栏目
	 * 返回一个带有大量数据的Lanmu
	 */
	public Lanmu findAllChildrenLanmu(int lanmu_id);
	public List<Lanmu> findBrotherLanmu(Lanmu currentLanmu);
	public void savePhoto(Photo p);
	public void saveArticle(Article article);
	public void updateLanmu(Lanmu lm);
	public List<Article> getAllChildLanmuArticleByPage(Lanmu parentLanmu,Integer pageNum);
	public List<Article> getAllChildLanmuArticleInIndex(Lanmu parentLanmu,Integer pageCount);
	public List<Article> findAllArticlesTOManage();
	public Article findArticleByID(Integer id);
	public Lanmu getLanmuByID(Integer id);
	public String getParAndCurSplitArticleID(Integer id);
	public void deleteArticle(Integer id);
	public void updateArticle(Article a);
}