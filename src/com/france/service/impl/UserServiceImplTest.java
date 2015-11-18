package com.france.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.france.bean.BaseApplication;
import com.france.bean.Role;
import com.france.bean.StudyDetail;
import com.france.bean.StudyInfoApplication;
import com.france.bean.User;
import com.france.bean.UserRole;
import com.france.service.UserService;
import com.france.util.ConvertUtil;

public class UserServiceImplTest {
	private static UserService service; 
	private static SessionFactory sessionFactory ;
	 @BeforeClass 
	 public static void init() { 
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		 service = (UserService)context.getBean("userService"); 
		  sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	 } 
	@Test
	public void test() {
		User u=new User();
		u.setUser_id(1);
		u.setEmail("user@qq.com");
		u.setUname("user");
		u.setPassword(ConvertUtil.MD5("123456"));
		Role r=new Role();
		r.setRole_id(1);
		r.setRname("user");
		service.saveUser(u);
		service.saveRole(r);
		UserRole ur=new UserRole();
		ur.setUser(u);
		ur.setRole(r);
		service.saveUserRole(ur);
	}
	@Test
	public void testLazy(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User u=(User) session.get(User.class, 1);
//		service.deleteUser(u);
		System.out.println("hehe:"+u.getUser_id());
		System.out.println(u.getBaseApplications());//延迟加载，先输出hehe 再输出sql语句
		Set<UserRole> us=u.getUserRoles();
		Role r=new Role();
		r.setRname("admin");
		session.save(r);
		UserRole sb=new UserRole();
		sb.setRole(r);
		sb.setUser(u);
		session.save(sb);
		session.update(u);
		//注u.getUserRole()一直报错
		//http://www.blogjava.net/yzzh9/archive/2008/10/07/233002.html
		tx.commit();
		session.close();
//		service.deleteUser(u);
//		u.getBaseApplications();
//		System.out.println("haha");
	}
	@Test
	public void testBase(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		BaseApplication application=new BaseApplication();
		StudyInfoApplication study=new StudyInfoApplication();
		
		User u=(User) session.get(User.class, 1);
		application.setUser(u);
		session.save(application); //必须先保存
		study.setBaseApplication(application);
		System.out.println("baseID:"+application.getApplyId());
		session.save(study);
		tx.commit();
		session.close();
	}
	@Test
	public void testStringSub(){
		String names[]="sample.pdf".split("\\.");
        for(int i=0;i<names.length;i++){
            ///storage/emulated/0/360Download/sample.pdf
        System.out.println(names[i]);
        }
	}
	@Test
	public void testStudy(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		StudyInfoApplication study=new StudyInfoApplication();
		User u=(User) session.get(User.class, 1);
		Set<BaseApplication> bases=u.getBaseApplications();
		System.out.println(bases.toString());
		study=(StudyInfoApplication) session.get(StudyInfoApplication.class, 1);
		StudyDetail detail=new StudyDetail();
		detail.setSchool("sch");
		detail.setStudyinfoApplication(study);
//		List<StudyDetail> details=new ArrayList();
//		details.add(detail);
//		study.setDetails(details);
		session.save(detail);
		tx.commit();
		session.close();
	}
	@Test
	public void testSDetail(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		StudyInfoApplication study=new StudyInfoApplication();
		User u=(User) session.get(User.class, 1);
		StudyDetail s=(StudyDetail) session.get(StudyDetail.class, 1);
		System.out.println(s.getSchool());
		session.delete(s);
		tx.commit();
		session.close();
	}
	@Test
	public void testUR(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
//		User u=(User) session.get(User.class, 1);
		Role ur=(Role) session.get(Role.class, 1);
		System.out.println(ur.getUserRoles().size());
		tx.commit();
		session.close();
	}
	@Test
	public void testBaseToStudy(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User u=(User) session.get(User.class, 1);
		BaseApplication application=new BaseApplication();
		application.setUser(u);
		session.save(application);
		StudyInfoApplication s=new StudyInfoApplication();
		s.setBaseApplication(application);
		session.save(s);
//		BaseApplication b=(BaseApplication) session.get(BaseApplication.class, 3);
		System.out.println("hehe");
		System.out.println(application.getStudyInfoApplication().getStudyInfoID());//无法获取?数据没有刷新
		tx.commit();
		session.close();
	}
}
