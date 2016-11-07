package cn.qlu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qlu.bean.NRC_NEWS;
import cn.qlu.dao.News_Head_Dao;
import cn.qlu.util.DbConnect;


public class News_Head_Dao_Impl implements  News_Head_Dao{
	
	@Override           //鏍规嵁鏃堕棿鏌ヨ鏂伴椈
	public List<NRC_NEWS> select() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<NRC_NEWS> list=new ArrayList<NRC_NEWS>();
		NRC_NEWS nns=null;
		try {
			conn=DbConnect.getDBconnection();  //鏍规嵁鏃堕棿鏌ヨ鏂伴椈鍐呭骞舵煡璇㈢被鍒〃涓殑鍝绫�
			String sql="select nn.N_ID,nt.T_NAME,nn.N_TITLE,nn.N_PUBLISHTIME from NRS_NEW nn " +
					"inner join (select * from NRS_TYPE) nt " +
					"where nn.T_ID=nt.T_ID " +
					"order by nn.N_PUBLISHTIME desc";
			pstmt= conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				
				nns=new NRC_NEWS();
				nns.setNid(rs.getInt(1));
				nns.setNcontent(rs.getString(2));
				nns.setNtitle(rs.getString(3));
				nns.setNpublishTime(rs.getString(4));
				list.add(nns);        //娣诲姞鍒伴摼琛ㄤ腑
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

}
