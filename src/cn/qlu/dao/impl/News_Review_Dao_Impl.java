package cn.qlu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.qlu.bean.NRC_REVIEW;
import cn.qlu.dao.News_Review_Dao;
import cn.qlu.util.DbConnect;
import cn.qlu.util.Page;

public class News_Review_Dao_Impl implements News_Review_Dao {

	Connection conn = null;          //杩炴帴鏁版嵁搴撲腑鐢ㄥ埌璇ュ璞�
    Statement stm = null;            //瀵圭洿鎺ュ啓姝荤殑sql璇彞杩涜鎿嶄綔
    PreparedStatement pst = null;    //鍙互瀵圭敤鍗犱綅绗︼紵鐨剆ql璇彞杩涜鎿嶄綔
    ResultSet rs = null;             //杩斿洖鏁版嵁搴撲腑鏌ュ埌
    boolean flag=false;
    String sql=null;
    
	@Override        //璇勮鐨勬坊鍔�
	public boolean Review_Add(NRC_REVIEW review) {
		conn=DbConnect.getDBconnection();
		sql="insert into NRS_REVIEW (R_CONTENT,R_USERNAME,R_REVTIME,N_ID) value (?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, review.getRcontent());
			pst.setString(2, review.getRuserName());
			pst.setString(3, review.getRrevTime());
			pst.setInt(4, review.getNid());
			pst.executeUpdate();         //鏍规嵁浼犺繘鏉ョ殑瀵硅薄锛岀劧鍚庡皢瀵硅薄涓殑鏁版嵁瀛樺偍鍒版暟鎹簱涓�
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbConnect.closeDB(conn, pst, rs);
		}
		return false;
	}

	@Override   //鍒嗛〉鏌ヨ鏁版嵁搴撲腑鐨勮瘎璁猴紝杩斿洖
	public List<NRC_REVIEW> queryAllByPage(Page page, int nid) {
		conn=DbConnect.getDBconnection();
		List<NRC_REVIEW> list=new ArrayList<NRC_REVIEW>();
		sql="select * from NRS_REVIEW where N_ID=? limit ?,?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, nid);
			pst.setInt(2, page.getBeginIndex());		//鏌ヨ璧峰鐐�
			pst.setInt(3, page.getEveryPage());		//鏌ヨ璁板綍鏁�
			rs=pst.executeQuery();
			while(rs.next()){
				NRC_REVIEW review=new NRC_REVIEW();
				review.setRcontent(rs.getString(2));
				review.setRuserName(rs.getString(3));
				review.setRrevTime(rs.getString(4));
				review.setNid(rs.getInt(5));
				list.add(review);        //灏嗘煡璇㈠埌鐨勬暟鎹瓨鍌ㄥ埌閾捐〃涓苟杩斿洖
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbConnect.closeDB(conn, pst, rs);
		}
		return list;
	}

	@Override          //鏌ヨ璇勮琛ㄤ腑涓�叡鏈夊灏戜釜鏁版嵁
	public int findAllCount() {
		sql= "select count(*) from NRS_REVIEW";
		int count = 0;
		conn=DbConnect.getDBconnection();
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
			   count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbConnect.closeDB(conn, pst, rs);
		}
		return count;        //杩斿洖璁板綍涓暟
	}

}
