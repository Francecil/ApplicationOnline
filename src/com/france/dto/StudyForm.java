package com.france.dto;

import java.util.ArrayList;
import java.util.List;

import com.france.bean.StudyDetail;
import com.france.bean.StudyInfoApplication;

public class StudyForm {
	private List<StudyDetail> lists = new ArrayList<>(0);
	private String haveApplied;
	private String step;


	public List<StudyDetail> getLists() {
		return lists;
	}
	public void setLists(List<StudyDetail> lists) {
		this.lists = lists;
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
