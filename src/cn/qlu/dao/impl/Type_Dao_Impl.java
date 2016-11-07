package cn.qlu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.qlu.bean.NRC_TYPE;
import cn.qlu.dao.Type_Dao;
import cn.qlu.util.DbConnect;
import cn.qlu.util.Page;

public class Type_Dao_Impl implements Type_Dao {

	Connection conn = null;          //杩炴帴鏁版嵁搴撲腑鐢ㄥ埌璇ュ璞�
    Statement stm = null;            //瀵圭洿鎺ュ啓姝荤殑sql璇彞杩涜鎿嶄綔
    PreparedStatement pst = null;    //鍙互瀵圭敤鍗犱綅绗︼紵鐨剆ql璇彞杩涜鎿嶄綔
    ResultSet rs = null;             //杩斿洖鏁版嵁搴撲腑鏌ュ埌
    boolean flag=false;
    String sql=null;
    
	@Override      //类别增加
	public boolean Type_Add(NRC_TYPE type) {
		
	    try {
	    	conn=DbConnect.getDBconnection();
		    sql="insert into NRS_TYPE (T_NAME ) value (?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1,type.getTname());
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

	@Override       //类别修改
	public boolean Type_Update(NRC_TYPE type) {
		 try {
		    	conn=DbConnect.getDBconnection();
			    sql="update NRS_TYPE set T_NAME=? where T_ID=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1,type.getTname());
				pst.setInt(2,type.getTid());
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

	@Override         //类别删除
	public boolean Type_Delete(int id) {
		try {
	    	conn=DbConnect.getDBconnection();
		    sql="delete from NRS_TYPE where T_ID=?";
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
	
	@Override     //类别查询
	public NRC_TYPE Type_Select(int id) {
		NRC_TYPE type=new NRC_TYPE();
        try {
        	conn = DbConnect.getDBconnection(); 
            sql= "select * from NRS_TYPE where T_ID=? ";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()){
				type.setTid(rs.getInt(1));
				type.setTname(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}

	@Override               //鏌ヨ鎵�湁鐨勭被鍒�
	public List<NRC_TYPE> findAllType() {

	    NRC_TYPE type=null;
		List<NRC_TYPE> list = new ArrayList<NRC_TYPE>();
           
         try {
            	conn = DbConnect.getDBconnection(); 
                String sql = "select * from NRS_TYPE";
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);                 //鎵ц涓�紑濮嬪畾涔夌殑sql璇彞锛屽苟杩斿洖鏁版嵁闆�
			
	            while (rs.next()) {                        //璋冪敤杩斿洖闆�
	            	type=new NRC_TYPE();
	                type.setTid(rs.getInt(1));               //灏嗗緱鍒扮殑杩斿洖鍊艰祴鍊肩粰瀹炰綋绫讳腑
	            	type.setTname(rs.getString(2));
	                list.add(type);   
	            }
			} catch (SQLException e) {             
				// TODO Auto-generated catch block   
				e.printStackTrace();
			}finally {
              DbConnect.closeDB(conn, pst, rs);      //閲婃斁璧勬簮
        }
		return list;
	}

	@Override            //鍒嗛〉鏌ヨ绫诲埆
	public List<NRC_TYPE> queryAllByPage(Page page) {
		NRC_TYPE type=null;
		List<NRC_TYPE> list = new ArrayList<NRC_TYPE>();
		//mysql鍒嗛〉鏌ヨ璇彞
		sql = "select * from NRS_TYPE order by T_ID asc limit ?,?";
		try {
			conn = DbConnect.getDBconnection();
			pst = conn.prepareStatement(sql);		//鑾峰緱棰勫鐞嗗璞″苟璧嬪�
			pst.setInt(1, page.getBeginIndex());		//鏌ヨ璧峰鐐�
			pst.setInt(2, page.getEveryPage());		//鏌ヨ璁板綍鏁�
			rs = pst.executeQuery();				//鎵ц鏌ヨ
			while(rs.next()) {
				type=new NRC_TYPE();
                type.setTid(rs.getInt(1));               //灏嗗緱鍒扮殑杩斿洖鍊艰祴鍊肩粰瀹炰綋绫讳腑
            	type.setTname(rs.getString(2));
				//娣诲姞鍒伴泦鍚�
            	list.add(type); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			 DbConnect.closeDB(conn, pst, rs);			//鍏抽棴杩炴帴瀵硅薄
		}
		return list;
	}
 
	@Override         //鏌ヨ绫诲埆涓墍鏈夌殑璁板綍涓暟
	public int findAllCount() {
		sql= "select count(*) from NRS_TYPE";	
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
