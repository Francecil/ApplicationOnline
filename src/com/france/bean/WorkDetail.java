package com.france.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="WORKDETAIL")
public class WorkDetail implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6416541922650629282L;
	/**
	 * 
	 */
	private int wdetailID;
	private String startTime;
	private String endTime;
	private String company;
	private String job;
	private WorkInfoApplication workinfoApplication;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getWdetailID() {
		return wdetailID;
	}
	public void setWdetailID(int wdetailID) {
		this.wdetailID = wdetailID;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@ManyToOne(optional = false) //left join true 为inner join()
	@JoinColumn(name="pkwinfoID")
	public WorkInfoApplication getWorkinfoApplication() {
		return workinfoApplication;
	}
	public void setWorkinfoApplication(WorkInfoApplication workinfoApplication) {
		this.workinfoApplication = workinfoApplication;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
