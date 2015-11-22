package com.france.dto;

import java.util.ArrayList;
import java.util.List;

import com.france.bean.WorkDetail;

public class WorkForm {
	private List<WorkDetail> lists = new ArrayList<>(0);
	private String haveApplied;
	private String step;

	public List<WorkDetail> getLists() {
		return lists;
	}
	public void setLists(List<WorkDetail> lists) {
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
