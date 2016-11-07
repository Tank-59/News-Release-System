package cn.qlu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.qlu.bean.NewSheet;
import cn.qlu.dao.News_Search_Dao;
import cn.qlu.util.DbConnect;

public class News_Search_Dao_Impl implements News_Search_Dao{
	
	Connection conn = null;          //杩炴帴鏁版嵁搴撲腑鐢ㄥ埌璇ュ璞�
    Statement stm = null;            //瀵圭洿鎺ュ啓姝荤殑sql璇彞杩涜鎿嶄綔
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<NewSheet> list = null;
    //鏍囬妯＄硦鏌ヨ锛岀劧鍚庤繑鍥炴煡璇㈠嚭鐨勪釜鏁�
    public int NewCount_title(String txt){
    	String txt1 = '%'+txt+'%';
    	String sql = "select count(*) from NRS_NEW where N_TITLE like ? ";
		int count = 0;
		try {
			conn = DbConnect.getDBconnection(); 
			pst = conn.prepareStatement(sql);
			pst.setString(1, txt1);
			rs = pst.executeQuery(); 
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
		}
		return count;
    }
    //鍐呭妯＄硦 鏌ヨ锛岀劧鍚庤繑鍥炴煡璇㈠嚭缁撴灉鐨勪釜鏁�
    public int NewCount_txt(String txt){
    	String txt1 = '%'+txt+'%';
    	String sql = "select count(*) from NRS_NEW where N_CONTENT like ? ";
		int count = 0;
		try {
			conn = DbConnect.getDBconnection(); 
			pst = conn.prepareStatement(sql);
			pst.setString(1, txt1);
			rs = pst.executeQuery(); 
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
		}
		return count;
    }
    
  //妯＄硦鎼滅储鏂伴椈-鍐呭
    public List<NewSheet> SearchNewstxt(String txt){
    	try {
			String txt1 = '%'+txt+'%';
			conn = DbConnect.getDBconnection(); 
			//妯＄硦鎼滅储
			String sql = "select a.N_TITLE, b.T_NAME , a.N_PUBLISHTIME from NRS_NEW as a , NRS_TYPE as b where a.T_ID = b.T_ID and a.N_CONTENT like ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,txt1);
			rs = pst.executeQuery(); 
			list = new ArrayList<NewSheet>();
			while(rs.next()){
				NewSheet n = new NewSheet();
				n.setTitle(rs.getString(1));
				n.setTname(rs.getString(2));
				n.setTime(rs.getString(3));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
	      }
		return list;
	}
 
    //妯＄硦鎼滅储鏂伴椈-鏍囬
	public List<NewSheet> SearchNews(String txt){
		try {
			String txt1 = '%'+txt+'%';
			conn = DbConnect.getDBconnection(); 
			String sql = "select a.N_TITLE, b.T_NAME , a.N_PUBLISHTIME from NRS_NEW as a , NRS_TYPE as b where a.T_ID = b.T_ID and a.N_TITLE like ?";
//			String sql = "select * from nrc_news where N_TITLE like '%?%'";
			pst = conn.prepareStatement(sql);
			pst.setString(1,txt1);
			rs = pst.executeQuery(); 
			list = new ArrayList<NewSheet>();
			while(rs.next()){
				NewSheet n = new NewSheet();
				n.setTitle(rs.getString(1));
				n.setTname(rs.getString(2));
				n.setTime(rs.getString(3));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
	      }
		return list;
	}
}
