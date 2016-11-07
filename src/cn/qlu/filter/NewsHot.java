package cn.qlu.filter;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
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

import cn.qlu.bean.NewsReview;
import cn.qlu.dao.News_Hot_Dao;
import cn.qlu.dao.impl.News_Hot_Dao_Impl;

public class NewsHot implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override   //热点新闻的过滤器，用于让主页根据评论量来新闻显示
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		HttpSession session=request.getSession();
		
		News_Hot_Dao nhd = new News_Hot_Dao_Impl();
		List<NewsReview> list = nhd.find_hot();
		
		session.setAttribute("HotList", list);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
