package cn.qlu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlu.dao.Type_Dao;
import cn.qlu.dao.impl.Type_Dao_Impl;
/**
 * 
 * 类别删除
 *
 */
public class Back_Type_Delete extends HttpServlet {

	
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
		Type_Dao dao=new Type_Dao_Impl();
		flag=dao.Type_Delete(id);
		
		response.sendRedirect("Manager/News/CategoryList.jsp");
	}

}
