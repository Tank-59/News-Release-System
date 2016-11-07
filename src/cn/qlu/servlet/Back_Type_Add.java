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
 * 类别添加servlet
 *
 */
public class Back_Type_Add extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		String type=request.getParameter("type");
		NRC_TYPE ty=new NRC_TYPE();
		ty.setTname(type);
		Type_Dao dao=new Type_Dao_Impl();
		boolean flag=dao.Type_Add(ty);
		
		response.sendRedirect("Manager/News/CategoryList.jsp");

	}

}
