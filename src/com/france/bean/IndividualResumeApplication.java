package com.france.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="INDIVIDUALRESUME")
public class IndividualResumeApplication implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5386032297690523306L;
	private int individualResumeID;
	private String individualResume;
	private BaseApplication baseApplication;
	public boolean checkForAllNotNull(){
		if(individualResume!=null)return true;
		else return false;
	}
	public String getIndividualResume() {
		return individualResume;
	}
	public void setIndividualResume(String individualResume) {
		this.individualResume = individualResume;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "individualResumeID", unique = true, nullable = false)
	public int getIndividualResumeID() {
		return individualResumeID;
	}
	public void setIndividualResumeID(int individualResumeID) {
		this.individualResumeID = individualResumeID;
	}
	@OneToOne
	public BaseApplication getBaseApplication() {
		return baseApplication;
	}
	public void setBaseApplication(BaseApplication baseApplication) {
		this.baseApplication = baseApplication;
	}
}
