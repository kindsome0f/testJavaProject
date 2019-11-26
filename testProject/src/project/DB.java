package project;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB {
	public static Connection dbConn() {
		Connection conn= null;
		try {
			FileInputStream fis = new FileInputStream("f:\\db.prop");
			//key와 value를 셋트로 저장
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			//MySQL에 접속
			conn=DriverManager.getConnection(url,id,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	//오라클 접속용 
	public static Connection hrConn() {
		Connection conn = null;
		try {
			FileInputStream fis = new FileInputStream("f:\\hr.prop");
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			conn=DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//오라클(java계정) 접속용
	public static Connection oraConn() {
		Connection conn = null;
		try {
			FileInputStream fis = new FileInputStream("f:\\oracle.prop");
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			conn=DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
