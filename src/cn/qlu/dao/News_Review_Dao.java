package cn.qlu.dao;

import java.util.List;

import cn.qlu.bean.NRC_REVIEW;
import cn.qlu.util.Page;

public interface News_Review_Dao {

	// 评论添加
    public boolean Review_Add(NRC_REVIEW review);
 	//分页查询评论
 	public List<NRC_REVIEW> queryAllByPage(Page page,int nid);	
 	//查询一共多少记录
 	public int findAllCount();
}
