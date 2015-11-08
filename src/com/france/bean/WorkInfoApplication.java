package com.france.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String workInfo;
	private BaseApplication baseApplication;
	public String getWorkInfo() {
		return workInfo;
	}

	public void setWorkInfo(String workInfo) {
		this.workInfo = workInfo;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "workInfoID", unique = true, nullable = false)
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
}
