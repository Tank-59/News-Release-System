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

import cn.qlu.bean.NRC_TYPE;
import cn.qlu.dao.Type_Dao;
import cn.qlu.dao.impl.Type_Dao_Impl;

public class NewsAdd implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override       //添加新闻时，给下拉框赋值，将类别添加到下拉框中
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Type_Dao dao=new Type_Dao_Impl();
		List<NRC_TYPE> list=dao.findAllType();
		//返回session
		session.setAttribute("list", list);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
