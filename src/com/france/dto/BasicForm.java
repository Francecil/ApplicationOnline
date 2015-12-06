package com.france.dto;


import com.france.bean.BasicInfoApplication;

public class BasicForm {
	private BasicInfoApplication basicInfoApplication;
	private String haveApplied;
	private String step;
	private String[] scholarshipType;
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
	
	public String[] getScholarshipType() {
		return scholarshipType;
	}
	public void setScholarshipType(String[] scholarshipType) {
		this.scholarshipType = scholarshipType;
	}
	public String getApplicationType(){
		String app="";
		if(scholarshipType==null)return null;
		for(int i=0;i<this.scholarshipType.length;i++){
			app+=this.scholarshipType[i];
			if(i!=this.scholarshipType.length-1)app+="#";
		}
		System.out.println("重新组合申请类别 ");
		return app;
	}
}
