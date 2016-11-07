package cn.qlu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlu.dao.News_Dao;
import cn.qlu.dao.impl.News_Dao_Impl;
/**
 * 
 * 新闻删除servlet
 *
 */
public class Back_News_Delete extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		boolean flag=false;
		int id=Integer.parseInt(request.getParameter("id"));
		
		News_Dao dao=new News_Dao_Impl(); 
		flag=dao.News_Delete(id);
		response.sendRedirect("Manager/News/NewsList.jsp");
	}

}
