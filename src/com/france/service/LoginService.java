package com.france.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.france.db.CloseDateBase;
import com.france.db.ConnectionFactory;
import com.france.util.ConvertUtil;


public class LoginService {
	public boolean checkUser(String username,String password) throws Exception{
		boolean temp=false;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement ps=null;
		password=new ConvertUtil().MD5(password);//加密 并且直接防止sql注入
		String sql="select * from user where email ='"+username+"' and password='"+password+"'";
		System.out.println(sql);
		try {
		con = ConnectionFactory.getConnection();
		ps=con.prepareStatement(sql);
		
		rs = ps.executeQuery(sql);
		while (rs.next()) {
			temp=true;
		}
		} catch (Exception e) {
			throw e;
		} finally {
			CloseDateBase.closeObject(rs, ps, con);
		}
		System.out.println(temp);
		return temp;
	}
}
