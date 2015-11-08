package com.france.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectionFactory {
	public static String driver;
	public static  String dburl;
	public static  String dbuser;
	public static  String password;
	public static  ConnectionFactory factory = null;
	public ConnectionFactory(){
		this.getproperties();
	}
	public  void getproperties() {
		Properties prop = new Properties();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
		try {
			prop.load(inputStream);
			this.driver = prop.getProperty("db.driverClassName");
			this.dburl = prop.getProperty("db.url");
			this.dbuser = prop.getProperty("db.username");
			this.password = prop.getProperty("db.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection conn = null;
		new ConnectionFactory();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(dburl,dbuser,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
}
