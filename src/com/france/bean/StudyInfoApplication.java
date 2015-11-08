package com.france.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="STUDYINFO")
public class StudyInfoApplication implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1972398387444088450L;
	private int studyInfoID;
	private BaseApplication baseApplication;
	private List<StudyDetail> details = new ArrayList<StudyDetail>(0);
	@Id
	@Column(name = "studyInfoID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getStudyInfoID() {
		return studyInfoID;
	}

	public void setStudyInfoID(int studyInfoID) {
		this.studyInfoID = studyInfoID;
	}
	@OneToOne(cascade=CascadeType.MERGE)
	public BaseApplication getBaseApplication() {
		return baseApplication;
	}
	public void setBaseApplication(BaseApplication baseApplication) {
		this.baseApplication = baseApplication;
	}
	@OneToMany( fetch = FetchType.EAGER, mappedBy = "studyinfoApplication")
	public List<StudyDetail> getDetails() {
		return details;
	}

	public void setDetails(List<StudyDetail> details) {
		this.details = details;
	}
	
	
}
