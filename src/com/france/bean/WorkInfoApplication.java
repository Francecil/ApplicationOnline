package com.france.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="WorkInfo")
public class WorkInfoApplication implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6599740529160478673L;
	private int workInfoID;
	private BaseApplication baseApplication;
	private List<WorkDetail> details = new ArrayList<WorkDetail>(0);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "workInfoID", unique = true, nullable = true)
	public int getWorkInfoID() {
		return workInfoID;
	}

	public void setWorkInfoID(int workInfoID) {
		this.workInfoID = workInfoID;
	}
	@OneToOne
	public BaseApplication getBaseApplication() {
		return baseApplication;
	}
	public void setBaseApplication(BaseApplication baseApplication) {
		this.baseApplication = baseApplication;
	}
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "workinfoApplication")
	public List<WorkDetail> getDetails() {
		return details;
	}

	public void setDetails(List<WorkDetail> details) {
		this.details = details;
	}
	
}
