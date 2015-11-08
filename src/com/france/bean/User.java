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
@Table(name="user")
@DynamicUpdate(true)
@DynamicInsert(true)
public class User implements java.io.Serializable
{
	private static final long serialVersionUID = 3091722681204768199L;
private Integer user_id;
private String uname;
private String email;
private String password;
private Set<UserRole> userRoles  = new HashSet<UserRole>(0);
private Set<BaseApplication> baseApplications  = new HashSet<BaseApplication>(0);
public User(){
	
}
@Column(name = "name")
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
@Column
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Column
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Id
@GeneratedValue
@Column(name="User_id", unique = true, nullable = false)
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
public Set<BaseApplication> getBaseApplications() {
	return baseApplications;
}

@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
public Set<UserRole> getUserRoles() {
	return userRoles;
}
public void setUserRoles(Set<UserRole> userRoles) {
	this.userRoles = userRoles;
}
public void setBaseApplications(Set<BaseApplication> baseApplications) {
	this.baseApplications = baseApplications;
}

}
