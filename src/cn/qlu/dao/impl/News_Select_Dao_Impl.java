package cn.qlu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.qlu.bean.NRC_TYPE;
import cn.qlu.dao.News_Select_Dao;
import cn.qlu.util.DbConnect;

public class News_Select_Dao_Impl implements News_Select_Dao{
	Connection conn = null;          //杩炴帴鏁版嵁搴撲腑鐢ㄥ埌璇ュ璞�
    Statement stm = null;            //瀵圭洿鎺ュ啓姝荤殑sql璇彞杩涜鎿嶄綔
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<NRC_TYPE> list = null;
    //鏌ヨ鎵�湁绫诲埆锛屽苟閫氳繃閾捐〃杩斿洖
	public List<NRC_TYPE> News_classAll() {
		try {
			conn = DbConnect.getDBconnection(); 
			String sql = "select * from NRS_TYPE";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(); 
			list = new ArrayList<NRC_TYPE>();
			while (rs.next()) { 
				NRC_TYPE n = new NRC_TYPE();
				n.setTid(rs.getInt(1));
				n.setTname(rs.getString(2));
				n.setTmemo(rs.getString(3));
				list.add(n);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
	      }
        return list;		
	}

}
