package cn.qlu.dao;

import java.util.List;

import cn.qlu.bean.NRC_NEWS;

public interface News_Head_Dao {
	//根据时间查询新闻
	public List<NRC_NEWS> select();
}
