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
import cn.qlu.util.Page;
import cn.qlu.util.PageUtil;

public class CategoryList implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override          //过滤类别显示的页面
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//类别列表
		/*
		* 
		*/
		//分页信息
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		HttpSession session=request.getSession();
		Type_Dao dao=new Type_Dao_Impl();
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		//根据当前页数，来调用daoimpl中的分页方法 ，得到当前页要显示的数据
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr == null || "".equals(currentPageStr)){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		
		Page page = PageUtil.createPage(10, dao.findAllCount(), currentPage);
		List<NRC_TYPE> list=dao.queryAllByPage(page);;
		//将得到的list和page存储到session中
		session.setAttribute("list", list);
		session.setAttribute("page", page);
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
