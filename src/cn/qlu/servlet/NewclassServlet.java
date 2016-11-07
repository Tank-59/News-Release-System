package cn.qlu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlu.bean.NRC_REVIEW;
import cn.qlu.bean.NewSheet;
import cn.qlu.dao.impl.NewsheetDaoImpl;
import cn.qlu.util.Page;
import cn.qlu.util.PageUtil;

public class NewclassServlet extends HttpServlet {

	Connection conn = null;          //连接数据库中用到该对象
    PreparedStatement pst = null;
    ResultSet rs = null;

    private  NewsheetDaoImpl nn = new NewsheetDaoImpl();
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	    List<NewSheet> list = null;
	    int tid = Integer.parseInt(request.getParameter("id"));
	    
	    Page page = null;
	    int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		//获取当前页数
		if(currentPageStr == null || "".equals(currentPageStr)){ 
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
	    page = PageUtil.createPage(4, nn.findClass(tid), currentPage);
	    list = nn.queryAllByPage(page,tid);
	    
	    request.setAttribute("tid", tid);
	    request.setAttribute("page", page);
	    request.setAttribute("List2", list);
	    
	    request.getRequestDispatcher("List.jsp").forward(request, response);
	    
	}

}
