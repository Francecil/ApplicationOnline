package com.france.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.france.bean.Lanmu;
import com.france.service.NewsService;

public class NewsServiceImplTest {
	private static NewsService service;
	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void init() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		service = (NewsService) context.getBean("newsService");
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}
/*
 * 结论：通过从session去添加 或者是 service去添加，发现m1.getChildren().add(m12); 
 * 然后update m1 不能使m12的parent设置为m1
 *  所以一般通过
 *  m11.setParentLanmu(m1);
	service.saveLanmu(m11);
	or session.save(m11);
	去实现
 */
	@Test
	public void testSaveLanmu() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Lanmu m1=new Lanmu();
		m1.setName("lanmuA");
		m1.setLevel(1);
		session.save(m1);
//		service.saveLanmu(m1);
		System.out.println("保存m1 success");
		//保存m1 success
		Lanmu m2=new Lanmu();
		m2.setName("lanmuB");
		m2.setLevel(1);
//		service.saveLanmu(m2);	
		session.save(m2);
		System.out.println("保存m2 success");
		//保存m2 success
		Lanmu m11=new Lanmu();
		m11.setName("lanmuAA");
		m11.setLevel(2);
		m11.setParentLanmu(m1);
//		service.saveLanmu(m11);
		session.save(m11);
		System.out.println("保存m11 success");
		//保存m11 success
		Lanmu m12=new Lanmu();
		m12.setName("lanmuAB");
		m12.setLevel(2);
		m1.getChildren().add(m12);
		session.saveOrUpdate(m1);//m12的数据 没有成功设置parent
		System.out.println("保存m12 success");
		//保存m12 success
		tx.commit();
		session.close();
	}
	/*
	 * 得到自身及子孙list
	 */
	@Test
	public void testFindAllChildrenLanmu() {
		Lanmu root=service.findAllChildrenLanmu(1);
		System.out.println(root.getParentLanmu());//得到null
		System.out.println("get root ok");
		List<Lanmu> c1=root.getChildren();
		Iterator iter=c1.iterator();
		while(iter.hasNext()){
			Lanmu l= (Lanmu)iter.next();
			System.out.printf("lanmu_id:%d,lanmu_name:%s,pid:%d\n",l.getId(),l.getName(),l.getParentLanmu().getId());
		}
	}

}
