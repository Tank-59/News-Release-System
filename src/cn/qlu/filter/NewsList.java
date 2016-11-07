package cn.qlu.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qlu.bean.NRC_NEWS;
import cn.qlu.dao.News_Dao;
import cn.qlu.dao.impl.News_Dao_Impl;
import cn.qlu.util.Page;
import cn.qlu.util.PageUtil;

public class NewsList implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override     //新闻页面加载时，过滤器的作用是加载页面时 直接显示数据库中新闻表中的所有记录，并分页显示
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//新闻列表
		/*List<NRC_NEWS> list=new News_Dao_Impl().findAllNews();
		* 
		*/
		//分页信息
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		HttpSession session=request.getSession();
		News_Dao dao=new News_Dao_Impl();
		
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr == null || "".equals(currentPageStr)){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		//分页显示新闻列表中的内容
		Page page = PageUtil.createPage(10, dao.findAllCount(), currentPage);
		List<NRC_NEWS> list=dao.queryAllByPage(page);;
		//返回session
		session.setAttribute("list", list);
		session.setAttribute("page", page);
        chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
