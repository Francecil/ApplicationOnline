package com.france.dto;

import com.france.bean.WorkInfoApplication;

public class WorkForm {
	private WorkInfoApplication workInfoApplication;
	private String haveApplied;
	private String step;

	public WorkInfoApplication getWorkInfoApplication() {
		return workInfoApplication;
	}
	public void setWorkInfoApplication(WorkInfoApplication workInfoApplication) {
		this.workInfoApplication = workInfoApplication;
	}
	public String getHaveApplied() {
		return haveApplied;
	}
	public void setHaveApplied(String haveApplied) {
		this.haveApplied = haveApplied;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	
}
