package com.france.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="BasicInfo")
public class BasicInfoApplication implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6758297495451199907L;
	private int basicInfoID;
	private String name;
	private String sex;
	private String email;
	private String address;
	private BaseApplication baseApplication;
	private String applicationType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "basicInfoID", unique = true, nullable = true)
	public int getBasicInfoID() {
		return basicInfoID;
	}
	public void setBasicInfoID(int basicInfoID) {
		this.basicInfoID = basicInfoID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@OneToOne
	public BaseApplication getBaseApplication() {
		return baseApplication;
	}
	public void setBaseApplication(BaseApplication baseApplication) {
		this.baseApplication = baseApplication;
	}
	public String getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	
}
