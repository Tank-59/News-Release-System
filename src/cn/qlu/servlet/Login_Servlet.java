package cn.qlu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qlu.dao.Login_Dao;
import cn.qlu.dao.impl.Login_Dao_Impl;


/**
 * 
 * 登陆验证servlet
 *
 */
public class Login_Servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//获取页面中的name和pwd
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			HttpSession session = request.getSession();
			//存到session
			session.setAttribute("username", username);
			
			Login_Dao ldi=new Login_Dao_Impl();
			int count=ldi.CheckUser(username, password);
			//不为0跳转到主界面
			if(count!=0){
				response.sendRedirect("Manager/Index.jsp");
				
			}else{
		     //为0跳转到原页面
				
				response.sendRedirect("Manager/LoginFail.jsp");
			
			}
			
		}
		
	
		
	}

