package cn.qlu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.qlu.bean.NewSheet;
import cn.qlu.dao.NewsheetDao;
import cn.qlu.util.DbConnect;
import cn.qlu.util.Page;

public class NewsheetDaoImpl implements NewsheetDao{
	Connection conn = null;          //杩炴帴鏁版嵁搴撲腑鐢ㄥ埌璇ュ璞�
    Statement stm = null;            
    PreparedStatement pst = null;
    ResultSet rs = null;
    NewSheet n = null;
    //鏍规嵁绫诲埆id鏌ヨ鏂伴椈涓暟
    public int findClass(int tid){
    	String sql = "select count(*) from NRS_NEW where T_ID = ?";
		int count = 0;
		try {
			conn = DbConnect.getDBconnection(); 
			pst = conn.prepareStatement(sql);
			pst.setInt(1, tid);
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
    //鏌ヨ鎵�湁鏂伴椈
	public int findAll(){
		String sql = "select count(*) from NRS_NEW";
		int count = 0;
		try {
			conn = DbConnect.getDBconnection(); 
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(); 
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
		}
		return count;
	}
	//鏍规嵁鏂伴椈绫诲埆id锛屽垎椤垫煡璇�
	public List<NewSheet> queryAllByPage(Page page , int tid) {
		Connection conn = null;	//杩炴帴瀵硅薄
		PreparedStatement pstmt = null;					//澹版槑棰勫鐞嗗璞�
		ResultSet rs = null;
		List<NewSheet> list = new ArrayList<NewSheet>();
		//mysql鍒嗛〉鏌ヨ璇彞
		String sql = "select a.N_TITLE, b.T_NAME , a.N_PUBLISHTIME,a.N_ID from NRS_NEW as a , NRS_TYPE as b where a.T_ID = b.T_ID and b.T_ID =? limit ?,?";
		try {
			conn = DbConnect.getDBconnection(); 
			pstmt = conn.prepareStatement(sql);		//鑾峰緱棰勫鐞嗗璞″苟璧嬪�
			pstmt.setInt(1, tid);
			pstmt.setInt(2, page.getBeginIndex());		//鏌ヨ璧峰鐐�
			pstmt.setInt(3, page.getEveryPage());		//鏌ヨ璁板綍鏁�
			rs = pstmt.executeQuery();				//鎵ц鏌ヨ
			while(rs.next()) {
				NewSheet ns = new NewSheet();
				ns.setTitle(rs.getString(1));
				ns.setTname(rs.getString(2));
				ns.setTime(rs.getString(3));
				ns.setNid(rs.getInt(4));
				list.add(ns);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
		}
		return list;
	}
	//鏍规嵁鏂伴椈鏍囬锛屾ā绯婂垎椤垫煡璇�
	public List<NewSheet> queryAllByPage_title(Page page , String txt) {
		Connection conn = null;	//杩炴帴瀵硅薄
		PreparedStatement pstmt = null;					//澹版槑棰勫鐞嗗璞�
		ResultSet rs = null;
		List<NewSheet> list = new ArrayList<NewSheet>();
		//mysql鍒嗛〉鏌ヨ璇彞
		String sql = "select a.N_TITLE, b.T_NAME , a.N_PUBLISHTIME,a.N_ID from NRS_NEW as a , NRS_TYPE as b where a.T_ID = b.T_ID and a.N_TITLE like ? limit ?,?";
		try {
			String txt1 = '%'+txt+'%';
			conn = DbConnect.getDBconnection(); 
			pstmt = conn.prepareStatement(sql);	//鑾峰緱棰勫鐞嗗璞″苟璧嬪�
			pstmt.setString(1, txt1);
			pstmt.setInt(2, page.getBeginIndex());		//鏌ヨ璧峰鐐�
			pstmt.setInt(3, page.getEveryPage());		//鏌ヨ璁板綍鏁�
			rs = pstmt.executeQuery();				//鎵ц鏌ヨ
			while(rs.next()) {
				NewSheet ns = new NewSheet();
				ns.setTitle(rs.getString(1));
				ns.setTname(rs.getString(2));
				ns.setTime(rs.getString(3));
				ns.setNid(rs.getInt(4));
				list.add(ns);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
		}
		return list;
	}
	//鏍规嵁鏂伴椈鍐呭锛屾ā绯婂垎椤垫煡璇�
	public List<NewSheet> queryAllByPage_txt(Page page , String txt) {
		Connection conn = null;	//杩炴帴瀵硅薄
		PreparedStatement pstmt = null;					//澹版槑棰勫鐞嗗璞�
		ResultSet rs = null;
		List<NewSheet> list = new ArrayList<NewSheet>();
		//mysql鍒嗛〉鏌ヨ璇彞
		String sql = "select a.N_TITLE, b.T_NAME , a.N_PUBLISHTIME,a.N_ID  from NRS_NEW as a , NRS_TYPE as b where a.T_ID = b.T_ID and b.T_ID and a.N_CONTENT like ? limit ?,?";
		try {
			String txt1 = '%'+txt+'%';
			conn = DbConnect.getDBconnection(); 
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, txt1);
			pstmt.setInt(2, page.getBeginIndex());		//鏌ヨ璧峰鐐�
			pstmt.setInt(3, page.getEveryPage());		//鏌ヨ璁板綍鏁�
			rs = pstmt.executeQuery();				//鎵ц鏌ヨ
			while(rs.next()) {
				NewSheet ns = new NewSheet();
				ns.setTitle(rs.getString(1));
				ns.setTname(rs.getString(2));
				ns.setTime(rs.getString(3));
				ns.setNid(rs.getInt(4));
				list.add(ns);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
		}
		return list;
	}
}
