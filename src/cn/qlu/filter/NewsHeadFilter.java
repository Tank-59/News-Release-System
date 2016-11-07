package cn.qlu.filter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import cn.qlu.dao.News_Head_Dao;
import cn.qlu.dao.impl.News_Head_Dao_Impl;

public class NewsHeadFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override    //头条新闻的过滤器，用于显示时间最靠前的新闻
	public void doFilter(ServletRequest serrequest, ServletResponse serresponse,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)serrequest;
		HttpServletResponse response=(HttpServletResponse)serresponse;
		HttpSession session = request.getSession();
		News_Head_Dao nhd=new News_Head_Dao_Impl();
		List<NRC_NEWS> list=new ArrayList<NRC_NEWS>();
		
		list = nhd.select();
		
		session.setAttribute("list1", list);
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
