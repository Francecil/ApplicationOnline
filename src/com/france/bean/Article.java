package com.france.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "article")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Article implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7471923774376034652L;
	private Integer id;
	private String title;
	private String content;
	private String author;//发布者
	private Integer topicID;
	private String publishTime;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(length = 10000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getTopicID() {
		return topicID;
	}
	public void setTopicID(Integer topicID) {
		this.topicID = topicID;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public Article(String title, String publishTime) {
		super();
		this.title = title;
		this.publishTime = publishTime;
	}
	
	public Article(Integer id, String title, String publishTime) {
		super();
		this.id = id;
		this.title = title;
		this.publishTime = publishTime;
	}
	public Article() {
	}
	public Article(Integer id, String title,String author,String publishTime,Integer topicID) {
		super();
		this.id = id;
		this.title = title;
		this.author=author;
		this.publishTime = publishTime;
		this.topicID=topicID;
	}
}
