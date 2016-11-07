package cn.qlu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlu.bean.NRC_REVIEW;
import cn.qlu.dao.News_Review_Dao;
import cn.qlu.dao.impl.News_Review_Dao_Impl;
/**
 * 
 * 发表评论servlet
 *
 */
public class News_Review extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取文本框中的内容和用户昵称
		String name=request.getParameter("username");
		String txt=request.getParameter("textarea");
		//获取当前时间
		int nid=Integer.parseInt(request.getParameter("hidden"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String day=df.format(new Date());// new Date()为获取当前系统时间
		
		NRC_REVIEW rev=new NRC_REVIEW();
		rev.setNid(nid);
		rev.setRcontent(txt);
		rev.setRuserName(name);
		rev.setRrevTime(day);
		
		News_Review_Dao dao=new News_Review_Dao_Impl();
		boolean flag=dao.Review_Add(rev);
		
	}

}
