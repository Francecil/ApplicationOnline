package com.france.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.france.bean.BaseApplication;
import com.france.bean.BasicInfoApplication;
import com.france.bean.IndividualResumeApplication;
import com.france.bean.StudyDetail;
import com.france.bean.StudyInfoApplication;
import com.france.bean.User;
import com.france.bean.WorkDetail;
import com.france.bean.WorkInfoApplication;
import com.france.dao.impl.UserDaoImpl;
import com.france.dto.BasicForm;
import com.france.dto.IndividualForm;
import com.france.dto.StudyForm;
import com.france.dto.WorkForm;
import com.france.service.UserService;
import com.france.util.Config;
import com.france.util.ConvertUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("applyAction")
public class ApplyAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	@Resource
	private UserService userService;
//	private BasicInfoApplication basic;
	private BasicForm basic=null;
	private StudyForm study=null;
	private WorkForm work=null;
	private IndividualForm individual=null;
//	private int applicationID;
	private Map<String,Object> dataMap;
	private BaseApplication baseApplication;
	public String study(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User loginUser=(User) session.getAttribute(Config.SESSION_USER);
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String school=request.getParameter("school");
		String level=request.getParameter("level");
		String aid=request.getParameter("aid");
		System.out.println("startTime:"+startTime);
		int aidI=-1;
		BaseApplication baseTemp=new BaseApplication();
		dataMap=new HashMap<String,Object>();
		if(aid==""||aid==null||!isNumeric(aid)){
			System.out.println("未存在aid");
			//不存在申请，创建
			System.out.println("不存在申请，创建");
			
			userService.updateUserToAddApply(loginUser,baseTemp);//一次service操作
			aidI=baseTemp.getApplyId();
			System.out.println("创建后aid:"+aidI);
			dataMap.put("aid", aidI);
		}
		else{
			aidI=Integer.valueOf(aid);
			baseTemp=userService.getSingleApplicationByUID(-1, aidI);//重新获取
		}
		//添加 更新数据
		StudyInfoApplication studySave =baseTemp.getStudyInfoApplication();
		StudyDetail detail=new StudyDetail();//先建一个detail
		detail.setEndTime(endTime);
		detail.setStartTime(startTime);
		detail.setLevel(level);
		detail.setSchool(school);
		detail.setStudyinfoApplication(studySave);
//		int studydetailID=userService.saveStudyDetail(detail);//返回id标记 下面自动保存
		
//		List<StudyDetail> list= new ArrayList<>();
//		list.add(detail);
//		studySave.setDetails(list);//保存完在下面的update的时候就会insert studydetail;
//		app.setStudyInfoApplication(studySave);
		userService.saveStudyDetail(detail);
		int studydetailID=detail.getSdetailID();//hibernate的持久 能够得到该id?
		System.out.println("studydetailID:"+studydetailID);
		dataMap.put("studydetailID", studydetailID);
		//ok
		System.out.println("更新数据成功");
		return "study_success";
	}
	public String work(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User loginUser=(User) session.getAttribute(Config.SESSION_USER);
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String company=request.getParameter("company");
		String job=request.getParameter("job");
		String aid=request.getParameter("aid");
		System.out.println("startTime:"+startTime);
		BaseApplication base = new BaseApplication();
		int aidI=-1;
		BaseApplication baseTemp=new BaseApplication();
		dataMap=new HashMap<String,Object>();
		if(aid==""||aid==null||!isNumeric(aid)){
			System.out.println("未存在aid");
			//不存在申请，创建
			System.out.println("不存在申请，创建");
			userService.updateUserToAddApply(loginUser,baseTemp);//一次service操作
			aidI=baseTemp.getApplyId();
			System.out.println("创建后aid:"+aidI);
			dataMap.put("aid", aidI);
		}
		else{
			aidI=Integer.valueOf(aid);
			baseTemp=userService.getSingleApplicationByUID(-1, aidI);//重新获取
		}
		
		//添加 更新数据
		WorkInfoApplication workSave = baseTemp.getWorkInfoApplication();
		WorkDetail detail = new WorkDetail();
		detail.setEndTime(endTime);
		detail.setStartTime(startTime);
		detail.setCompany(company);
		detail.setJob(job);
		detail.setWorkinfoApplication(workSave);
		userService.saveWorkDetail(detail);
		int workdetailID=detail.getWdetailID();//hibernate的持久 能够得到该id?
		System.out.println("workdetailID:"+workdetailID);
		dataMap.put("workdetailID", workdetailID);
		//ok
		System.out.println("更新数据成功");
		return "work_success";
	}
	public String studyUpdate(){
		HttpServletRequest request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
	    int sid =Integer.valueOf(request.getParameter("sid"));
	    String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String school=request.getParameter("school");
		String level=request.getParameter("level");
	    StudyDetail study=userService.getStudyDetailBySID(sid);
	    study.setStartTime(startTime);
	    study.setEndTime(endTime);
	    study.setSchool(school);
	    study.setLevel(level);
	    userService.updateStudyDetail(study);
	    dataMap=new HashMap<String,Object>();
		dataMap.put("status", "success");
	    return "studyUpdate_success";
	}
	public String studyDelete(){
		HttpServletRequest request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
		User loginUser=(User) session.getAttribute(Config.SESSION_USER);
		int sid =Integer.valueOf(request.getParameter("sid"));
		System.out.println("要删除的sid是"+sid);
		userService.deleteStudyDetail(sid);
		dataMap=new HashMap<String,Object>();
		dataMap.put("status", "success");
		return "studyDelete_success";
	}
	public String workUpdate(){
		HttpServletRequest request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
	    int wid =Integer.valueOf(request.getParameter("wid"));
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String company=request.getParameter("company");
		String job=request.getParameter("job");
	    WorkDetail work=userService.getWorkDetailByWID(wid);
	    work.setStartTime(startTime);
	    work.setEndTime(endTime);
	    work.setCompany(company);
	    work.setJob(job);
	    userService.updateworkDetail(work);
	    dataMap=new HashMap<String,Object>();
		dataMap.put("status", "success");
	    return "workUpdate_success";
	}
	public String workDelete(){
		HttpServletRequest request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
		User loginUser=(User) session.getAttribute(Config.SESSION_USER);
		int wid =Integer.valueOf(request.getParameter("wid"));
		System.out.println("要删除的sid是"+wid);
		userService.deleteWorkDetail(wid);
		dataMap=new HashMap<String,Object>();
		dataMap.put("status", "success");
		return "workDelete_success";
	}
	public String view(){
		HttpServletRequest request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
		User loginUser=(User) session.getAttribute(Config.SESSION_USER);
		int aid =Integer.valueOf(request.getParameter("aid"));
		baseApplication=userService.getSingleApplicationByUID(loginUser.getUser_id(), aid);
//		System.out.println("view address"+baseApplication.getBasicInfoApplication().getAddress());
		System.out.println("view address"+baseApplication.getBasicInfoApplication().getName());
		return "tryview_success";
	}
	public String edit(){
		HttpServletRequest request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
		User loginUser=(User) session.getAttribute(Config.SESSION_USER);
		int aid =Integer.valueOf(request.getParameter("aid"));
		baseApplication=userService.getSingleApplicationByUID(loginUser.getUser_id(), aid);
		
		return "tryedit_success";
	}
	public String finish(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User loginUser=(User) session.getAttribute(Config.SESSION_USER);
		String aidS=request.getParameter("aid");
		System.out.println("aid:"+aidS);
		if(aidS==""||aidS==null||!isNumeric(aidS)){
			dataMap.put("status", "error");
			dataMap.put("child",1);
			return "finish_success";
		}
		
		int aid=Integer.valueOf(aidS);
		boolean isfull=true;
		dataMap=new HashMap<String,Object>();
		for(int i=1;i<=4;i++){
			if(!userService.isChildApplicationFull(i, aid))
			{	
				System.out.println("break due:"+i);
				dataMap.put("status", "error");
				dataMap.put("child", i);
				isfull=false;
				break;
			}
		}
		System.out.println("finishActionStart");
		if(isfull){
			BaseApplication baseApplication=userService.getSingleApplicationByUID(loginUser.getUser_id(), aid);
			baseApplication.setIsSubmitted(1);
			baseApplication.setApplyTime(ConvertUtil.getTime());
			userService.updateApplication(baseApplication);
			dataMap.put("status", "success");
		}
		return "finish_success";
	}
	public String save() {
		HttpServletRequest request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
		User loginUser=(User) session.getAttribute(Config.SESSION_USER);
		 
		 String haveApplied="";
//		String[] formData=request.getParameterValues("formvalue");
//		int stepInt=getReturnChildApplication();
		int stepInt=Integer.valueOf(request.getParameter("step"));
		System.out.println("step..."+stepInt);
		if(stepInt<1||stepInt>4){
			System.out.println("未上传任何数据，非ajax表单提交");
			return "error";
		}
		System.out.println("stepInt:"+stepInt);
		switch(stepInt){
		case 1:haveApplied=basic.getHaveApplied();break;
		case 2:haveApplied=study.getHaveApplied();break;
		case 3:haveApplied=work.getHaveApplied();break;
		case 4:haveApplied=individual.getHaveApplied();break;
		}
		if(!"".equals(haveApplied)&&haveApplied!=null){
				if(isNumeric(haveApplied)){
					//如果是数字的话
					int aid=Integer.valueOf(haveApplied);
					//检查是否存在且未提交 yes对相应页面保存
					boolean isAdmin =userService.isAdmin(loginUser);
					System.out.println("isAdmin?"+isAdmin);
					if(userService.existApplicationAndNOSubmitByIsAdmin(loginUser.getUser_id(), aid,isAdmin)){
//							if(1<=newStep&&newStep<=4){
//								userService.updateChildApplication(newStep, applicationID, formData);
						BaseApplication app=userService.getSingleApplicationByUID(-1, aid);
						switch(stepInt){
						case 1:{BasicInfoApplication basicSave = app.getBasicInfoApplication();
								BasicInfoApplication basicTemp= basic.getBasicInfoApplication();
								//NonUniqueObjectException: 
								// A different object with the same identifier value was already associated with the session 
								//之前采取的是把数据库对象的id放给Temp 其实应该是把Temp数据换给数据库查询对象
//								basicTemp.setBasicInfoID(basicSave.getBasicInfoID());
//								basicTemp.setBaseApplication(basicSave.getBaseApplication());
//								basicSave.setAddress(basicTemp.getAddress());
								basicSave.setApplicationType(basicTemp.getApplicationType());
								basicSave.setName(basicTemp.getName());
								basicSave.setSex(basicTemp.getSex());
								basicSave.setEmail(basicTemp.getEmail());
								userService.updateBasicApplication(basicSave);
								basic=null;
								break;
								}
						case 2:{
						study=null;
						break;
						}
						case 3:{
								work=null;
								break;
								}
						case 4:{
							    IndividualResumeApplication indiSave =app.getIndividualResumeApplication();
								IndividualResumeApplication indiTemp =individual.getIndividualResumeApplication();
								indiSave.setIndividualResume(indiTemp.getIndividualResume());
								System.out.println("indiTemp.getIndividualResume():"+indiTemp.getIndividualResume());
//								indiTemp.setIndividualResumeID(indiSave.getIndividualResumeID());
//								indiTemp.setBaseApplication(indiSave.getBaseApplication());
								userService.updateIndividualApplication(indiSave);
								individual=null;
								break;}
						}
						System.out.println("更新数据");
						return "save_success";
//							}
//							else{
////								pw.print("非法操作");
//								return "save_success";
//							}
						}
//						else{
////							pw.print("非法操作");
//							return "save_success";
//						}
//					}
					else{
						//非法操作
//						pw.print("非法操作");
						return "save_success";
					}
				
				}
				else{
					//非法操作
//					pw.print("非法操作");
					return "save_success";
				}
				
			}
			else{
				//不存在申请，创建
				System.out.println("不存在申请，创建");
				BaseApplication base=new BaseApplication();
				userService.updateUserToAddApply(loginUser,base);//一次service操作
//				base.setUser(loginUser);
//				userService.addApplication(base);
				int aid=base.getApplyId();
				System.out.println("创建后aid:"+aid);
				dataMap=new HashMap<String,Object>();
				dataMap.put("aid", aid);
//				if(isNumeric(step)){
//					int newStep2=Integer.valueOf(step);
//					if(1<=newStep2&&newStep2<=4){
						System.out.println("更新数据");
//						userService.updateChildApplication(newStep2, newApplicationID, formData);
//						BaseApplication app=userService.getSingleApplicationByUID(loginUser.getUser_id(), aid);
						switch(stepInt){
						case 1:{BasicInfoApplication basicSave = base.getBasicInfoApplication();
								BasicInfoApplication basicTemp= basic.getBasicInfoApplication();
								//NonUniqueObjectException: 
								// A different object with the same identifier value was already associated with the session 
								//之前采取的是把数据库对象的id放给Temp 其实应该是把Temp数据换给数据库查询对象
//								basicTemp.setBasicInfoID(basicSave.getBasicInfoID());
//								basicTemp.setBaseApplication(basicSave.getBaseApplication());
//								basicSave.setAddress(basicTemp.getAddress());
								basicSave.setApplicationType(basicTemp.getApplicationType());
								basicSave.setName(basicTemp.getName());
								basicSave.setSex(basicTemp.getSex());
								basicSave.setEmail(basicTemp.getEmail());
								userService.updateBasicApplication(basicSave);
								basic=null;
								break;
								}
						case 2:{
						study=null;
						break;
						}
						case 3:{
								work=null;
								break;
								}
						case 4:{
							    IndividualResumeApplication indiSave =base.getIndividualResumeApplication();
								IndividualResumeApplication indiTemp =individual.getIndividualResumeApplication();
								indiSave.setIndividualResume(indiTemp.getIndividualResume());
//								indiTemp.setIndividualResumeID(indiSave.getIndividualResumeID());
//								indiTemp.setBaseApplication(indiSave.getBaseApplication());
								userService.updateIndividualApplication(indiSave);
								individual=null;
								break;}
						}
						return "save_success";
//					}
//					else{
//						pw.print("非法操作");
//						return "save_success";
//					}
//				}
//				else{
////					pw.print("非法操作");
//					return "save_success";
//				}
			}
	}
	//利用正则表达式判断是否为数字
	public boolean isNumeric(String str)
    {
          Pattern pattern = Pattern.compile("[0-9]*");
          Matcher isNum = pattern.matcher(str);
          if( !isNum.matches() )
          {
                return false;
          }
          return true;
    }
	public int getReturnChildApplication(){
		if(basic!=null&&!"".equals(basic.getStep())&&basic.getStep()!=null)return 1;
		if(study!=null&&!"".equals(study.getStep())&&study.getStep()!=null)return 2;
		if(work!=null&&!"".equals(work.getStep())&&work.getStep()!=null)return 3;
		if(individual!=null&&!"".equals(individual.getStep())&&individual.getStep()!=null)return 4;
		return 0;
	}
	public BasicForm getBasic() {
		return basic;
	}
	public void setBasic(BasicForm basic) {
		this.basic = basic;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public StudyForm getStudy() {
		return study;
	}
	public void setStudy(StudyForm study) {
		this.study = study;
	}
	public WorkForm getWork() {
		return work;
	}
	public void setWork(WorkForm work) {
		this.work = work;
	}
	public IndividualForm getIndividual() {
		return individual;
	}
	public void setIndividual(IndividualForm individual) {
		this.individual = individual;
	}
	public BaseApplication getBaseApplication() {
		return baseApplication;
	}
	public void setBaseApplication(BaseApplication baseApplication) {
		this.baseApplication = baseApplication;
	}

}
