package cn.qlu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlu.bean.NRC_TYPE;
import cn.qlu.dao.Type_Dao;
import cn.qlu.dao.impl.Type_Dao_Impl;
/**
 * 
 * 类别修改servlet
 *
 */
public class Back_Type_Update extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("tid"));
		String name=request.getParameter("tname");
		NRC_TYPE type=new NRC_TYPE();
		Type_Dao dao=new Type_Dao_Impl();
		type.setTid(id);
		type.setTname(name);
		boolean flag=dao.Type_Update(type);
		
		response.sendRedirect("Manager/News/CategoryList.jsp");
	}

}
