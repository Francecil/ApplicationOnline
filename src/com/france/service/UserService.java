package com.france.service;

import java.util.List;

import com.france.bean.BaseApplication;
import com.france.bean.BasicInfoApplication;
import com.france.bean.IndividualResumeApplication;
import com.france.bean.Role;
import com.france.bean.StudyDetail;
import com.france.bean.StudyInfoApplication;
import com.france.bean.User;
import com.france.bean.UserRole;
import com.france.bean.WorkInfoApplication;


public interface UserService {
	public User checkUser(String email,String password);//判读用户是否存在
	public boolean isAdmin(User u);//判断是否是管理员
	public boolean isEmailUse(String email);//email是否已经用过
	public int addApplication(BaseApplication base);//添加一份
	public boolean existApplicationAndNOSubmitByIsAdmin(int uid,int aid,boolean isAdmin);//判断申请用户的申请是否没有提交
	//更新子申请 及 父申请的currentPage
	public boolean updateApplication(BaseApplication a);
	public boolean updateBasicApplication(BasicInfoApplication o);
	public boolean updateStudyApplication(StudyInfoApplication o);
	public boolean updateWorkApplication(WorkInfoApplication o);
	public boolean updateIndividualApplication(IndividualResumeApplication o);
	
	public boolean isChildApplicationFull(int childType,int aid);//子申请全填
	public void submitApplication(int aid);//提交申请
	public boolean judgeApplicationSubmit(int aid);//判断申请是否提交
	public List<BaseApplication> getAllUserApplicationList();//得到所有的申请(已提交,管理员用)
	public List<BaseApplication> getMyApplicationListByIsSubmit(int uid,int isSubmit);//用户得到申请(提交与否)
	public BaseApplication getSingleApplicationByUID(int uid,int aid);//得到具体的申请
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public User findUserById(int id);
	
	public void deleteUser(User user);
	
	public void saveStudyDetail(StudyDetail studyDetail);
	public void deleteStudyDetail(int sid);
	public StudyDetail getStudyDetailBySID(int sid);
	public void updateStudyDetail(StudyDetail s);
	public List<User> findAllList();
	public void deleteUser(String email);
	public void saveRole(Role r);
	public void saveUserRole(UserRole ur);
}
