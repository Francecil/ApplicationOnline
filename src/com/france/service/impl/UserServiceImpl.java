package com.france.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.france.bean.BaseApplication;
import com.france.bean.BasicInfoApplication;
import com.france.bean.IndividualResumeApplication;
import com.france.bean.Role;
import com.france.bean.StudyDetail;
import com.france.bean.StudyInfoApplication;
import com.france.bean.User;
import com.france.bean.UserRole;
import com.france.bean.WorkDetail;
import com.france.bean.WorkInfoApplication;
import com.france.dao.BaseDAO;
import com.france.dao.UserDao;
import com.france.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private BaseDAO<User> baseDAO;
	@Resource
	private BaseDAO<Role> roleDAO;
	@Resource
	private BaseDAO<UserRole> userRoleDAO;
	@Resource
	private BaseDAO<BasicInfoApplication> basicDAO;
	@Resource
	private BaseDAO<StudyInfoApplication> studyDAO;
	@Resource
	private BaseDAO<WorkInfoApplication> workDAO;
	@Resource
	private BaseDAO<IndividualResumeApplication> individualDAO;
	@Resource
	private BaseDAO<BaseApplication> baseApplicationDAO;
	@Resource
	private BaseDAO<StudyDetail> studyDetailDAO;
	@Resource
	private BaseDAO<WorkDetail> workDetailDAO;
	@Resource
	private BaseDAO<StudyInfoApplication> studyInfoDAO;
	@Resource
	private BaseDAO<WorkInfoApplication> workInfoDAO;
	@Resource
	private UserDao userDao;


	@Override
	public void saveUser(User user) {
		baseDAO.save(user);
	}

	@Override
	public void updateUser(User user) {
		baseDAO.update(user);
	}

	@Override
	public User findUserById(int id) {
		return baseDAO.get(User.class, id);
	}

	@Override
	public void deleteUser(User user) {
		baseDAO.delete(user);
	}

	@Override
	public List<User> findAllList() {
		return baseDAO.find(" from User u order by u.createTime");
	}


	@Override
	public User checkUser(String email, String password) {
		// TODO Auto-generated method stub
		return baseDAO.get(" from User u where u.email = ? and u.password = ? ", new Object[] { email, password });

	}

	@Override
	public boolean isAdmin(User u) {
		// TODO Auto-generated method stub
		String sql=" select count(*) from UserRole ur,Role r where r.role_id = ur.role.role_id and ( r.rname ='admin' or r.rname ='superadmin' ) and ur.user.user_id= ? ";
		return baseDAO.count(sql,new Object[]{u.getUser_id()})>0;
	}

	@Override
	public int addApplication(BaseApplication base) {
		// TODO Auto-generated method stub
		
		
		BasicInfoApplication basic=new BasicInfoApplication();
		basic.setBaseApplication(base);
		StudyInfoApplication study=new StudyInfoApplication();
		study.setBaseApplication(base);
		WorkInfoApplication work=new WorkInfoApplication();
		work.setBaseApplication(base);
		IndividualResumeApplication individual =new IndividualResumeApplication();
		individual.setBaseApplication(base);
		basicDAO.save(basic);
		studyDAO.save(study);
		workDAO.save(work);
		individualDAO.save(individual);
		baseApplicationDAO.save(base);
		return 0;
	}

	@Override
	public boolean existApplicationAndNOSubmitByIsAdmin(int uid, int aid,boolean isAdmin) {
		// TODO Auto-generated method stub
		if(isAdmin)
		return baseApplicationDAO.find("from BaseApplication b where b.applyId = ? ",new Object[]{aid}).size()>0;
		else{
		return baseApplicationDAO.find("from BaseApplication b where b.applyId = ? and b.user.user_id = ? and b.isSubmitted = ?",new Object[]{aid,uid,0}).size()>0;
		}
	}


	@Override
	public boolean isChildApplicationFull(int childType, int aid) {
		
//		BaseApplication baseApplication=baseApplicationDAO.get(BaseApplication.class, aid);
		switch(childType){
		case 1: {
			String hql="select * from BASICINFO where baseApplication_applyId = ? ";
			return userDao.isChildApplicationFull(hql,aid);
		}
		case 2:{
			String hql=" select count(*) from StudyInfoApplication s1,StudyDetail s2 where s2.studyinfoApplication.studyInfoID = s1.studyInfoID and s1.baseApplication.applyId = ?";
			return baseDAO.count(hql,new Object[]{aid})>0;
		}
		case 3:{
			String hql=" select count(*) from WorkInfoApplication w1,WorkDetail w2 where w2.workinfoApplication.workInfoID = w1.workInfoID and w1.baseApplication.applyId = ?";
			return baseDAO.count(hql,new Object[]{aid})>0;
		}
		case 4:{
			String hql="select * from INDIVIDUALRESUME where baseApplication_applyId = ?  ";
			return userDao.isChildApplicationFull(hql,aid);
		}
		}
		return false;
	}
	

	@Override
	public void submitApplication(int aid) {
		// TODO Auto-generated method stub
		BaseApplication baseApplication=baseApplicationDAO.get(BaseApplication.class, aid);
		baseApplication.setIsSubmitted(1);
		baseApplicationDAO.update(baseApplication);
	}

	@Override
	public boolean judgeApplicationSubmit(int aid) {
		// TODO Auto-generated method stub
		BaseApplication baseApplication=baseApplicationDAO.get(BaseApplication.class, aid);
		if(baseApplication.getIsSubmitted()==1)return true;
		else return false;
	}

	@Override
	public List<BaseApplication> getAllUserApplicationList() {
		// TODO Auto-generated method stub
//		return userApplicationDAO.find(" from UserApplication");
//		return userDao.getAllUserApplicationList();
		return baseApplicationDAO.find("from BaseApplication b where b.isSubmitted = 1");
	}

	@Override
	public List<BaseApplication> getMyApplicationListByIsSubmit(int uid, int isSubmit) {
//		return userDao.getMyApplicationListByIsSubmit(uid, isSubmit);
		return baseApplicationDAO.find("from BaseApplication b where b.user.user_id = ? and b.isSubmitted = ? ",new Object[]{uid,isSubmit});
	}

	@Override
	public BaseApplication getSingleApplicationByUID(int uid, int aid) {
		// TODO Auto-generated method stub
		return baseApplicationDAO.get(BaseApplication.class, aid);
	}

	@Override
	public boolean updateBasicApplication(BasicInfoApplication o) {
		// TODO Auto-generated method stub
		return basicDAO.update(o);
	}

	@Override
	public boolean updateStudyApplication(StudyInfoApplication o) {
		// TODO Auto-generated method stub
		return studyDAO.update(o);
	}

	@Override
	public boolean updateWorkApplication(WorkInfoApplication o) {
		// TODO Auto-generated method stub
		return workDAO.update(o);
	}

	@Override
	public boolean updateIndividualApplication(IndividualResumeApplication o) {
		// TODO Auto-generated method stub
		return individualDAO.update(o);
	}

	@Override
	public boolean updateApplication(BaseApplication a) {
		// TODO Auto-generated method stub
		return baseApplicationDAO.update(a);
	}

	@Override
	public boolean isEmailUse(String email) {
		// TODO Auto-generated method stub
		List<User> users= baseDAO.find("from User u where u.email = ? ", new Object[]{email});
		if(users!=null&&users.size()>0)return true;
		return false;
	}

	@Override
	public void saveStudyDetail(StudyDetail studyDetail) {
		// TODO Auto-generated method stub
		 studyDetailDAO.save(studyDetail);
	}

	@Override
	public void deleteStudyDetail(int sid) {
		// TODO Auto-generated method stub
		StudyDetail s=studyDetailDAO.get(StudyDetail.class, sid);
		studyDetailDAO.delete(s);
	}

	@Override
	public void deleteUser(String email) {
		// TODO Auto-generated method stub
		User u=baseDAO.find("from User u where u.email = ?",new Object[]{email}).get(0);
		baseDAO.delete(u);
	}

	@Override
	public void saveRole(Role r) {
		// TODO Auto-generated method stub
		roleDAO.save(r);
	}

	@Override
	public void saveUserRole(UserRole ur) {
		// TODO Auto-generated method stub
		userRoleDAO.save(ur);
	}

	@Override
	public StudyDetail getStudyDetailBySID(int sid) {
		// TODO Auto-generated method stub
		return studyDetailDAO.get(StudyDetail.class, sid);
	}

	@Override
	public void updateStudyDetail(StudyDetail s) {
		// TODO Auto-generated method stub
		studyDetailDAO.update(s);
	}

	@Override
	public void saveWorkDetail(WorkDetail workDetail) {
		// TODO Auto-generated method stub
		workDetailDAO.save(workDetail);
	}

	@Override
	public WorkDetail getWorkDetailByWID(int wid) {
		// TODO Auto-generated method stub
		return workDetailDAO.get(WorkDetail.class, wid);
	}

	@Override
	public void deleteWorkDetail(int wid) {
		// TODO Auto-generated method stub
		WorkDetail w=workDetailDAO.get(WorkDetail.class, wid);
		workDetailDAO.delete(w);
	}

	@Override
	public void updateworkDetail(WorkDetail w) {
		// TODO Auto-generated method stub
		workDetailDAO.update(w);
	}

	@Override
	public void saveStudyInfo(StudyInfoApplication s) {
		// TODO Auto-generated method stub
		studyInfoDAO.save(s);
	}

	@Override
	public void updateUserToAddApply(User user, BaseApplication baseTemp) {
		// TODO Auto-generated method stub
		baseTemp.setUser(user);
		BasicInfoApplication basic=new BasicInfoApplication();
		baseTemp.setBasicInfoApplication(basic);
		basic.setBaseApplication(baseTemp);
		StudyInfoApplication study=new StudyInfoApplication();
		baseTemp.setStudyInfoApplication(study);
		study.setBaseApplication(baseTemp);
		WorkInfoApplication work=new WorkInfoApplication();
		baseTemp.setWorkInfoApplication(work);
		work.setBaseApplication(baseTemp);
		IndividualResumeApplication ind=new IndividualResumeApplication();
		baseTemp.setIndividualResumeApplication(ind);
		ind.setBaseApplication(baseTemp);//不添加这句话的话不会insert
//		user.getBaseApplications().add(baseTemp);//不去更新user 
		baseApplicationDAO.save(baseTemp);//而是去保存apply
		
	}


}
