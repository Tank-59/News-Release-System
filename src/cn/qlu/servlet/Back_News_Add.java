package cn.qlu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlu.bean.NRC_NEWS;
import cn.qlu.dao.News_Dao;
import cn.qlu.dao.impl.News_Dao_Impl;
/**
 * 
 * 新闻添加servlet
 *
 */
public class Back_News_Add extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		boolean flag=false;
		String str=request.getParameter("content1");
		String tit=request.getParameter("header");
		int id=Integer.parseInt(request.getParameter("column"));
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String day=df.format(new Date());// new Date()为获取当前系统时间
		
		NRC_NEWS news=new NRC_NEWS();
		News_Dao dao=new News_Dao_Impl();
		news.setNtitle(tit);
		news.setNcontent(str);
		news.setTid(id);
		news.setNpublishTime(day);
		
		flag=dao.News_Add(news);
		response.sendRedirect("Manager/News/NewsList.jsp");
	}

}
