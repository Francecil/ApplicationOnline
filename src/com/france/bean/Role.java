package com.france.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;




@Entity
@Table(name = "role")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Role implements java.io.Serializable {
/**
	 * 
	 */
private static final long serialVersionUID = -1815380332662994275L;
private Integer role_id;
private String rname;
private Set<UserRole> userRoles = new HashSet<UserRole>(0);
public Role(){
	
}
@Id
@GeneratedValue
@Column(name = "ROLE_ID", unique = true, nullable = false)
public Integer getRole_id() {
	return role_id;
}
public void setRole_id(Integer role_id) {
	this.role_id = role_id;
}
@Column(name = "ROLE_NAME")
public String getRname() {
	return rname;
}

public void setRname(String rname) {
	this.rname = rname;
}
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
public Set<UserRole> getUserRoles() {
	return this.userRoles;
}

public void setUserRoles(Set<UserRole> userRoles) {
	this.userRoles = userRoles;
}

}
