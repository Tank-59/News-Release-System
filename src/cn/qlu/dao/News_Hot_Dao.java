package cn.qlu.dao;

import java.util.List;

import cn.qlu.bean.NewsReview;

public interface News_Hot_Dao {
	//根据评论量来查询新闻
	public List<NewsReview> find_hot();
}
