package cn.qlu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlu.bean.NewSheet;
import cn.qlu.dao.impl.News_Search_Dao_Impl;
import cn.qlu.dao.impl.NewsheetDaoImpl;
import cn.qlu.util.Page;
import cn.qlu.util.PageUtil;
/**
 * 
 * 新闻搜索servlet
 *
 */
public class News_Search extends HttpServlet {
	
	private  NewsheetDaoImpl n = new NewsheetDaoImpl();
	private News_Search_Dao_Impl nn = new News_Search_Dao_Impl();
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
		String tt = request.getParameter("select");
		String txt = request.getParameter("textfield");
		
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");	
		
		//获取当前页数
		if(currentPageStr == null || "".equals(currentPageStr)){ 
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		Page page = null;
		if(tt.equals("标题")){
			page = PageUtil.createPage(4, nn.NewCount_title(txt), currentPage);
			list = n.queryAllByPage_title(page , txt);
		}
		else{
			page = PageUtil.createPage(4, nn.NewCount_txt(txt), currentPage);
			list = n.queryAllByPage_txt(page , txt);
		}
		request.setAttribute("txt", txt);
		request.setAttribute("tt", tt);
		request.setAttribute("page", page);
		request.setAttribute("list2", list);
		request.getRequestDispatcher("Search.jsp").forward(request, response);

	}

}
