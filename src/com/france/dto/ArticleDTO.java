package com.france.dto;

import com.france.bean.Article;



public class ArticleDTO {
	private Article article;
	private String lanmuName;
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public String getLanmuName() {
		return lanmuName;
	}
	public void setLanmuName(String lanmuName) {
		this.lanmuName = lanmuName;
	}
	
}
