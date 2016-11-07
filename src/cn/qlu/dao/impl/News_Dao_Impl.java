package cn.qlu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.qlu.bean.NRC_NEWS;
import cn.qlu.dao.News_Dao;
import cn.qlu.util.DbConnect;
import cn.qlu.util.Page;

public class News_Dao_Impl implements News_Dao{

	Connection conn = null;          //杩炴帴鏁版嵁搴撲腑鐢ㄥ埌璇ュ璞�
    Statement stm = null;            //瀵圭洿鎺ュ啓姝荤殑sql璇彞杩涜鎿嶄綔
    PreparedStatement pst = null;    //鍙互瀵圭敤鍗犱綅绗︼紵鐨剆ql璇彞杩涜鎿嶄綔
    ResultSet rs = null;             //杩斿洖鏁版嵁搴撲腑鏌ュ埌
    boolean flag=false;
    String sql=null;
    
	@Override    //新闻增加
	public boolean News_Add(NRC_NEWS news) {
  
	  try {
	    	conn=DbConnect.getDBconnection();
		    sql="insert into NRS_NEW (N_TITLE,N_CONTENT,T_ID,N_PUBLISHTIME) value (?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, news.getNtitle());
		    pst.setString(2, news.getNcontent());
		    pst.setInt(3, news.getTid());
		    pst.setString(4, news.getNpublishTime());
		    pst.executeUpdate(); 
		    flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }finally{
			DbConnect.closeDB(conn, pst, rs);
			}  
	    return flag;
	}

	@Override   //新闻修改
	public boolean News_Update(NRC_NEWS news) {
		
		conn=DbConnect.getDBconnection();
		String sql="update NRS_NEW set N_TITLE=?,N_CONTENT=?,T_ID=?,N_PUBLISHTIME=? where N_ID=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, news.getNtitle());
	        pst.setString(2, news.getNcontent());
	        pst.setInt(3, news.getTid());
	        pst.setString(4, news.getNpublishTime());
	        pst.setInt(5, news.getNid());
	        pst.executeUpdate(); 
	        flag=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbConnect.closeDB(conn, pst, rs);
			}      
		return flag;
	}

	@Override      //新闻删除
	public boolean News_Delete(int id) {
	    
	    try {
	    	conn=DbConnect.getDBconnection();
		    sql="delete from NRS_NEW where N_ID=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
	        pst.executeUpdate();
	        flag=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbConnect.closeDB(conn, pst, rs);
			} 
	    return flag;
	}

	@Override                //新闻查询
	public NRC_NEWS News_Select(int id) {
		NRC_NEWS news=null;
		try {
        	conn = DbConnect.getDBconnection(); 
            sql= "select * from NRS_NEW where N_ID = ? ";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, id);
		    rs=pst.executeQuery();
            while(rs.next()){
            	news=new NRC_NEWS();
                news.setNid(rs.getInt(1));
                news.setNtitle(rs.getString(2));
                news.setNcontent(rs.getString(3));
                news.setTid(rs.getInt(4));
                news.setNpublishTime(rs.getString(5));
            }
		} catch (SQLException e) {             
			// TODO Auto-generated catch block   
			e.printStackTrace();
		}finally {
          DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
    }
		
		return news;
	}

	@Override         //鏌ヨ鎵�湁鏂伴椈琛ㄤ腑鐨勫唴瀹�
	public List<NRC_NEWS> findAllNews() {

	    List<NRC_NEWS> list = new ArrayList<NRC_NEWS>();
	    try {
        	conn = DbConnect.getDBconnection(); 
            String sql = "select * from NRS_NEW";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);                 //鎵ц涓�紑濮嬪畾涔夌殑sql璇彞锛屽苟杩斿洖鏁版嵁闆�
		
            while (rs.next()) {                        //璋冪敤杩斿洖闆�
            	NRC_NEWS news=new NRC_NEWS();
                news.setNid(rs.getInt(1));
                news.setNtitle(rs.getString(2));
                news.setNcontent(rs.getString(3));
                news.setTid(rs.getInt(4));
                news.setNpublishTime(rs.getString(5));
                list.add(news);  
                
            }
		} catch (SQLException e) {             
			// TODO Auto-generated catch block   
			e.printStackTrace();
		}finally {
          DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
    }
		return list;
	}
	
	@Override           //鍒嗛〉鏌ヨ鏁版嵁鐨勫唴瀹�
	public List<NRC_NEWS> queryAllByPage(Page page) {
		List<NRC_NEWS> list = new ArrayList<NRC_NEWS>();
		//mysql鍒嗛〉鏌ヨ璇彞
		sql = "select * from NRS_NEW order by N_ID asc limit ?,?";
		try {
			conn = DbConnect.getDBconnection();
			pst = conn.prepareStatement(sql);		//鑾峰緱棰勫鐞嗗璞″苟璧嬪�
			pst.setInt(1, page.getBeginIndex());		//鏌ヨ璧峰鐐�
			pst.setInt(2, page.getEveryPage());		//鏌ヨ璁板綍鏁�
			rs = pst.executeQuery();				//鎵ц鏌ヨ
			while(rs.next()) {
				NRC_NEWS news=new NRC_NEWS();
                news.setNid(rs.getInt(1));
                news.setNtitle(rs.getString(2));
                news.setNcontent(rs.getString(3));
                news.setTid(rs.getInt(4));
                news.setNpublishTime(rs.getString(5));
				//娣诲姞鍒伴泦鍚�
                list.add(news); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			 DbConnect.closeDB(conn, pst, rs);			//鍏抽棴杩炴帴瀵硅薄
		}
		return list;
	}

	@Override         //鏌ヨ琛ㄤ腑鏈夊灏戜釜璁板綍
	public int findAllCount() {
		sql= "select count(*) from NRS_NEW";	
		int count = 0;
		try {
			conn = DbConnect.getDBconnection();
			pst = conn.prepareStatement(sql);		//鑾峰緱棰勫鐞嗗璞″苟璧嬪�
			rs = pst.executeQuery();					//鎵ц鏌ヨ
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbConnect.closeDB(conn, pst, rs);			//鍏抽棴杩炴帴瀵硅薄
		}
		return count;
	}
}
