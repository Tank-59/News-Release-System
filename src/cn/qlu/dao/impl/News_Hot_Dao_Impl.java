package cn.qlu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qlu.bean.NRC_NEWS;
import cn.qlu.bean.NewsReview;
import cn.qlu.dao.News_Hot_Dao;
import cn.qlu.util.DbConnect;

public class News_Hot_Dao_Impl implements News_Hot_Dao {
	
	//鏍规嵁璇勮閲忕殑鏁伴噺鏉ユ煡璇㈡柊闂�
	public List<NewsReview> find_hot() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NewsReview ns = null;
		List<NewsReview> list = new ArrayList<NewsReview>();
		try {
			conn = DbConnect.getDBconnection();
			String sql = "select nn.N_ID,nt.T_NAME,nn.N_TITLE,nn.N_PUBLISHTIME,count(nr.N_ID) from NRS_REVIEW nr " +
					"inner join (select * from NRS_NEW) nn " +
					"on nr.N_ID = nn.N_ID " +
					"inner join (select * from NRS_TYPE) nt " +
					"on nt.T_ID = nn.T_ID " +
					"group by nr.N_ID order by count(nr.N_ID) desc";  //瀵逛笁涓〃杩涜鎿嶄綔鍒嗚〃鏌ヨ鍑鸿瘎璁洪噺锛岀劧鍚庢煡璇㈠嚭鏂伴椈id鐒跺悗鍐嶆煡璇㈠嚭绫诲埆
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ns = new NewsReview();
				ns.setNid(rs.getInt(1));
				ns.setTname(rs.getString(2));
				ns.setNtitle(rs.getString(3));
				ns.setNpublishTime(rs.getString(4));
				list.add(ns);       //灏嗘煡璇㈠埌鐨勭粨鏋滄斁鍒伴摼琛ㄤ腑
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return list;
	}

	
}
