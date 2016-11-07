package cn.qlu.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import cn.qlu.bean.NewSheet;
import cn.qlu.util.DbConnect;


public class Index implements Filter {
	
	Connection conn = null;          //杩炴帴鏁版嵁搴撲腑鐢ㄥ埌璇ュ璞�
    Statement stm = null;            //瀵圭洿鎺ュ啓姝荤殑sql璇彞杩涜鎿嶄綔
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    List<NewSheet> list = null;
    List<NRC_TYPE> list1 = null;
	@Override
	public void destroy() {

	}

	@Override   //涓婚〉闈㈠姞杞芥椂鐨勮繃婊ゅ櫒锛岀敤浜庢樉绀鸿鏄剧ず鐨勫唴瀹癸紝绫诲埆锛屾柊闂�
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		HttpSession session=req.getSession();
		
		try {
			list = new ArrayList<NewSheet>();
			list1 = new ArrayList<NRC_TYPE>();
			conn = DbConnect.getDBconnection(); 
			String sql = "select a.N_TITLE, b.T_NAME , a.N_PUBLISHTIME,a.N_ID from NRS_NEW as a , NRS_TYPE as b where a.T_ID = b.T_ID";
			String sql1 = "select * from NRS_TYPE";
			
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(); 
			while (rs.next()) { 
				NewSheet n = new NewSheet();
				n.setTitle(rs.getString(1));
				n.setTname(rs.getString(2));
				n.setTime(rs.getString(3));
				n.setNid(rs.getInt(4));
				list.add(n);
			}
			
			pst = conn.prepareStatement(sql1);
			rs = pst.executeQuery(); 
			while(rs.next()){
				NRC_TYPE c = new NRC_TYPE();
				c.setTid(rs.getInt(1));
				c.setTname(rs.getString(2));
				c.setTmemo(rs.getString(3));  //鍒嗗埆鏌ヨ涓嶅悓鐨勮〃
				list1.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
		}
		//杩斿洖涓や釜閾捐〃
		session.setAttribute("List", list);
		session.setAttribute("List1", list1);
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
