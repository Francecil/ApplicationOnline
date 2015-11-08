package com.france.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.france.bean.BaseApplication;
import com.france.bean.BasicInfoApplication;
import com.france.bean.StudyDetail;
import com.france.bean.User;
import com.france.dao.UserDao;
import com.france.db.CloseDateBase;
import com.france.db.ConnectionFactory;
import com.france.db.JdbcUtils;
import com.france.util.ConvertUtil;
import com.mysql.jdbc.Statement;
@Repository("userDao")
@SuppressWarnings("all")
public class UserDaoImpl implements UserDao {
	/*---初始化数据库变量---*/
	ResultSet rs = null;
	Connection con = null;
	PreparedStatement ps=null;
	JdbcUtils jdbcUtils = new JdbcUtils();  
	//ok
	@Override
	public User checkUser(String email,String password){
		
        jdbcUtils.getConnection();
		password=new ConvertUtil().MD5(password);//加密 
		if(password==null)return null;//防止md5出错
		String sql="select * from user where email = ? and password= ?";
		User user = null;
		try {
			List<Object> params=new ArrayList<>();
			params.add(email);
			params.add(password);
			user=jdbcUtils.findSimpleRefResult(sql, params, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			jdbcUtils.releaseConn();
		}
		return user;
	}
	//ok
	@Override
	public boolean isAdmin(int USER_ID)  {
		// TODO Auto-generated method stub
		String sql=" select * from user,user_role,role where user.user_id=user_role.user_id and role.role_id = user_role.role_id and ( role.role_name ='admin' or role.role_name ='superadmin' ) and user.user_id= ? ";
		System.out.println(sql);
		try {
			jdbcUtils.getConnection();
			if(jdbcUtils.judgeResultExist(sql, USER_ID))return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally{
			jdbcUtils.releaseConn();
		}
		return false;
	}
	//ok
	@Override
	public int addApplication(int uid) {
		int applyID=-1;
		// TODO Auto-generated method stub
		String sql[]={"insert into BASICINFO() values() ",
		"insert into STUDYINFO() values() ",
		"insert into WORKINFO() values() ",
		"insert into INDIVIDUALRESUME() values() "
		};
		String sql2[]={"update BASICINFO set  baseApplication_applyId = ? where basicinfoid = ?",
				"update STUDYINFO set  baseApplication_applyId = ? where studyinfoid = ?",
				"update WORKINFO set  baseApplication_applyId = ? where workinfoid = ?",
				"update INDIVIDUALRESUME set  baseApplication_applyId = ? where individualresumeid = ?"
		};
//		int GeneratedID[] = null;
		List<Integer> GeneratedIDs = new ArrayList<>();
		try {
			jdbcUtils.getConnection();
			for(int i=0;i<sql.length;i++){
				GeneratedIDs.add(jdbcUtils.executeGetInsertLineID(sql[i]));
			}
			GeneratedIDs.add(uid);
			System.out.println("GeneratedIDs:"+GeneratedIDs.toString());
			String ApplySQL="insert into BASEAPPLICATION(pkbasic,pkstudy,pkwork,pkindividual,pkUserApplication,issubmitted) values("+GeneratedIDs.get(0)+","+GeneratedIDs.get(1)+","+GeneratedIDs.get(2)+","+GeneratedIDs.get(3)+","+uid+",0)";
			
			System.out.println("applySql:"+ApplySQL);
			applyID=jdbcUtils.executeGetInsertLineID(ApplySQL);
			for(int i=0;i<sql2.length;i++){
				jdbcUtils.updateByPreparedStatement(sql2[i], applyID,GeneratedIDs.get(i));
			}
//			String ApplySQL2="insert into USER_APPLICATION(BASEAPPLICATION_ID,USER_ID) values(?,?)";
//			jdbcUtils.updateByPreparedStatement(ApplySQL2, applyID,uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			jdbcUtils.releaseConn();
		}
		return applyID;
	}
	//ok
	@Override
	public boolean existApplicationAndNOSubmit(int uid, int aid) {
		// TODO Auto-generated method stub
		String sql="select IS_SUBMIT from BaseAPPLICATION where USER_ID = ? and BASEAPPLICATION_ID = ? ";
		try {
			jdbcUtils.getConnection();
			if(jdbcUtils.judgeResultExist(sql, uid,aid))return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();//return后finally还是会执行的
		}
		
		return false;
	}
	//ok
	@Override
	public boolean isChildApplicationFull(String sql,Object... o) {
		try {
			jdbcUtils.getConnection();
			return jdbcUtils.isChildApplicationNotNULL(sql, o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();//return后finally还是会执行的
		}
		
		return false;
	}
	@Override
	public int addStudyDetail(StudyDetail s) {
		// TODO Auto-generated method stub
		int sid=-1;
		// TODO Auto-generated method stub
		String sql="insert into studydetail(startTime,endTime,school,level,pksinfoID) values('"+s.getStartTime()+"','"+s.getEndTime()+"','"+s.getSchool()+"','"+s.getLevel()+"',"+s.getStudyinfoApplication().getStudyInfoID()+")";
		try {
			jdbcUtils.getConnection();
		    sid=jdbcUtils.executeGetInsertLineID(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			jdbcUtils.releaseConn();
		}
		return sid;
	}
}
