package com.france.dao;

import com.france.bean.BaseApplication;
import com.france.bean.StudyDetail;
import com.france.bean.User;

public interface UserDao {
	public User checkUser(String email,String password);
	public boolean isAdmin(int USER_ID);
	public int addApplication(int uid);
	public boolean existApplicationAndNOSubmit(int uid,int aid);
	public boolean isChildApplicationFull(String sql,Object... o);
	public int addStudyDetail(StudyDetail s);
	
}
