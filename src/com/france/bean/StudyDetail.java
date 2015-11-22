package com.france.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDYDETAIL")
public class StudyDetail implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sdetailID;
	private String startTime;
	private String endTime;
	private String school;
	private String level;
	private StudyInfoApplication studyinfoApplication;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getSdetailID() {
		return sdetailID;
	}
	public void setSdetailID(int sdetailID) {
		this.sdetailID = sdetailID;
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@ManyToOne(optional = false,cascade = CascadeType.PERSIST) //left join true 为inner join()
	@JoinColumn(name="pksinfoID")
	public StudyInfoApplication getStudyinfoApplication() {
		return studyinfoApplication;
	}
	public void setStudyinfoApplication(StudyInfoApplication studyinfoApplication) {
		this.studyinfoApplication = studyinfoApplication;
	}

//	public StudyInfoApplication getStudyinfo() {
//		return studyinfo;
//	}
//	public void setStudyinfo(StudyInfoApplication studyinfo) {
//		this.studyinfo = studyinfo;
//	}
}
