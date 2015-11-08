package com.france.dto;

import com.france.bean.BasicInfoApplication;

public class BasicForm {
	private BasicInfoApplication basicInfoApplication;
	private String haveApplied;
	private String step;
	public BasicInfoApplication getBasicInfoApplication() {
		return basicInfoApplication;
	}
	public void setBasicInfoApplication(BasicInfoApplication basicInfoApplication) {
		this.basicInfoApplication = basicInfoApplication;
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
