package cn.qlu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qlu.bean.NRC_NEWS;
import cn.qlu.bean.NRC_REVIEW;
import cn.qlu.bean.NRC_TYPE;
import cn.qlu.dao.News_Dao;
import cn.qlu.dao.News_Review_Dao;
import cn.qlu.dao.impl.News_Dao_Impl;
import cn.qlu.dao.impl.News_Review_Dao_Impl;
import cn.qlu.util.DbConnect;
import cn.qlu.util.Page;
import cn.qlu.util.PageUtil;
/**
 * 
 * 新闻查看
 *
 */
public class News_Select extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
		//当添加评论时，获取是否是info页面跳转过来的
		int pa=0;
		 String times=request.getParameter("times");
		 if(times==null||times.equals(""))
			 pa=0;
		 else
			 pa=1;
		 //当info页面跳转过来的，进行评论的添加
		if(pa==1){
			//获取页面中评论的内容和昵称
			String name=request.getParameter("username");
			String txt=request.getParameter("textarea");
			//获取新闻的id
			int nid=Integer.parseInt(request.getParameter("hidden"));
			//获取当前的时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String day=df.format(new Date());// new Date()为获取当前系统时间
			//将获得的数据存储到对象中
			NRC_REVIEW rev=new NRC_REVIEW();
			rev.setNid(nid);
			rev.setRcontent(txt);
			rev.setRuserName(name);
			rev.setRrevTime(day);
			
			News_Review_Dao dao=new News_Review_Dao_Impl();
			dao.Review_Add(rev);
		}
		
	    //主页根据新闻的id跳转到要显示新闻的页面
	    int nid=Integer.parseInt(request.getParameter("nid"));
	    HttpSession session=request.getSession();
		News_Review_Dao dao=new News_Review_Dao_Impl();
		News_Dao  newdao=new News_Dao_Impl();
	    //根据该新闻的id获取该新闻的评论
	    NRC_NEWS  news=newdao.News_Select(nid);
		//分页显示新闻的评论
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr == null || "".equals(currentPageStr)){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		Page page = PageUtil.createPage(10, dao.findAllCount(), currentPage);
		List<NRC_REVIEW> list=dao.queryAllByPage(page,nid);
		//返回session
		session.setAttribute("news", news);
		session.setAttribute("list", list);
		session.setAttribute("page", page);
		
		response.sendRedirect("Info.jsp");
	}

}
