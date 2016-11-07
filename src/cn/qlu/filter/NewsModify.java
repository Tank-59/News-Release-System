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
import cn.qlu.bean.NRC_TYPE;
import cn.qlu.dao.News_Dao;
import cn.qlu.dao.Type_Dao;
import cn.qlu.dao.impl.News_Dao_Impl;
import cn.qlu.dao.impl.Type_Dao_Impl;

public class NewsModify implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override    //新闻修改时，让要修改的内容传到，修改页面
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		HttpSession session=request.getSession();
		//获取新闻id
		int id=Integer.parseInt(request.getParameter("id"));
		
		Type_Dao type=new Type_Dao_Impl();
		News_Dao ne=new News_Dao_Impl();
		List<NRC_TYPE> list=type.findAllType();
		NRC_NEWS news=ne.News_Select(id);
		//返回session
		session.setAttribute("list", list);
		session.setAttribute("nid", news.getNid());
        session.setAttribute("title",news.getNtitle());
        session.setAttribute("txt", news.getNcontent());
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
