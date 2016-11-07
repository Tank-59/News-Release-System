package cn.qlu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbConnect {
	private static String driverName="com.mysql.jdbc.Driver";
	private static String userName="root";
	private static String userPwd="123456";
	private static String dbName="nrc";
	public static Connection getDBconnection(){
	   String url1="jdbc:mysql://localhost:3306/"+dbName;
	   String url2="?user="+userName+"&password="+userPwd;
	   String url3="&useUnicode=true&characterEncoding=UTF-8";
	   String url=url1+url2+url3;
	   try{
	     Class.forName(driverName);
	     Connection conn=DriverManager.getConnection(url);
	    return conn;
	    
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	   
	   return null;
	}
	public static void closeDB(Connection conn,PreparedStatement pstmt,ResultSet rs){
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
