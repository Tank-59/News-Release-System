package cn.qlu.dao;

import java.util.List;

import cn.qlu.bean.NewSheet;

public interface News_Search_Dao {
	//模糊搜索新闻-内容
    public List<NewSheet> SearchNewstxt(String txt);
    //模糊搜索新闻-标题
  	public List<NewSheet> SearchNews(String txt);
}
