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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "lanmu")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Lanmu implements java.io.Serializable {
	/**
	 * 栏目 自关联一对多
	 */
	private static final long serialVersionUID = 862821212669955478L;
	private Integer id;
	private String name;
	private String description;
	private Lanmu parentLanmu;
	private Integer level;
	private List<Lanmu> children = new ArrayList<Lanmu>(0);
	public Lanmu() {

	}
	
	public Lanmu(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lanmu_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentLanmu", nullable = true)
	public Lanmu getParentLanmu() {
		return parentLanmu;
	}
	public void setParentLanmu(Lanmu parentLanmu) {
		this.parentLanmu = parentLanmu;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	@OneToMany(targetEntity=Lanmu.class, mappedBy="parentLanmu", cascade=CascadeType.ALL, fetch = FetchType.EAGER)  
	@OrderBy("id")
	public List<Lanmu> getChildren() {
		return children;
	}

	public void setChildren(List<Lanmu> children) {
		this.children = children;
	}
	

}
