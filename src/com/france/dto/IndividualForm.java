package com.france.dto;

import com.france.bean.IndividualResumeApplication;

public class IndividualForm {
	private IndividualResumeApplication individualResumeApplication;
	private String haveApplied;
	private String step;

	public IndividualResumeApplication getIndividualResumeApplication() {
		return individualResumeApplication;
	}
	public void setIndividualResumeApplication(
			IndividualResumeApplication individualResumeApplication) {
		this.individualResumeApplication = individualResumeApplication;
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
