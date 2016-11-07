package cn.qlu.filter;

import java.io.IOException;

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

public class CategoryModify implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override   //修改类别的过滤器，作用是获得要修改的内容，并返回到修改页面中
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//得到要修改类别的id
		int id=Integer.parseInt(request.getParameter("id"));
		Type_Dao dao=new Type_Dao_Impl();
		//调用修改的方法，并返回
		NRC_TYPE type=dao.Type_Select(id);
		//将得到的类别内容返回到界面
		session.setAttribute("tid",type.getTid() );
		session.setAttribute("tname", type.getTname());
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
