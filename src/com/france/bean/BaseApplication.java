package com.france.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/*
 * 用户创建申请
 * 4个关联的子申请也自动创建好
 * 数据库中母申请保存着四个子申请的ID
 * 当保存的时候指的是子申请保存
 * 提交的时候就检查对应的四个子申请是否都符合条件(不存在为null)
 * */
@Entity
@Table(name="BaseApplication")
@DynamicUpdate(true)
@DynamicInsert(true)
public class BaseApplication implements java.io.Serializable
{
	private static final long serialVersionUID = 3091368199L;
	private int applyId;
	
	private BasicInfoApplication basicInfoApplication;
	private StudyInfoApplication studyInfoApplication;
	private WorkInfoApplication workInfoApplication;
	private IndividualResumeApplication individualResumeApplication;
	private User user;
	private int isSubmitted;
	private String applyTime;
	public int getIsSubmitted() {
		return isSubmitted;
	}
	public void setIsSubmitted(int isSubmitted) {
		this.isSubmitted = isSubmitted;
	}

	@Id
	@GeneratedValue
	@Column(name = "applyId", unique = true, nullable = true)
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	@OneToOne(mappedBy = "baseApplication",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	public BasicInfoApplication getBasicInfoApplication() {
		return basicInfoApplication;
	}
	public void setBasicInfoApplication(BasicInfoApplication basicInfoApplication) {
		this.basicInfoApplication = basicInfoApplication;
	}
	@OneToOne(mappedBy = "baseApplication",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	public StudyInfoApplication getStudyInfoApplication() {
		return studyInfoApplication;
	}
	public void setStudyInfoApplication(StudyInfoApplication studyInfoApplication) {
		this.studyInfoApplication = studyInfoApplication;
	}
	@OneToOne(mappedBy = "baseApplication",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	public WorkInfoApplication getWorkInfoApplication() {
		return workInfoApplication;
	}
	public void setWorkInfoApplication(WorkInfoApplication workInfoApplication) {
		this.workInfoApplication = workInfoApplication;
	}
	@OneToOne(mappedBy = "baseApplication",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	public IndividualResumeApplication getIndividualResumeApplication() {
		return individualResumeApplication;
	}
	public void setIndividualResumeApplication(
			IndividualResumeApplication individualResumeApplication) {
		this.individualResumeApplication = individualResumeApplication;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
