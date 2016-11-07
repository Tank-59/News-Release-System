package cn.qlu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.qlu.dao.Login_Dao;
import cn.qlu.util.DbConnect;

public class Login_Dao_Impl implements Login_Dao{

	@Override
	public int CheckUser(String username ,String password ) {
		
		//鏍规嵁浼犺繘鏉ョ殑name鍜宲wd鏉ヨ繘琛屾暟鎹簱鏌ヨ
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        conn = DbConnect.getDBconnection();
        String sql = "Select * from NRS_USER where U_USERNAME=? and U_USERPWD=? ";
        try {
			pstmt = conn.prepareStatement(sql);  //杩涜鏁版嵁搴撲腑鐨勬煡璇�
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()){	
				count = 1;    //鏈夊�灏辩粰count璁惧�涓�锛屾棤鍊煎氨鏄垵濮嬪�0
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
