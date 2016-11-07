package cn.qlu.dao;

import java.util.List;

import cn.qlu.bean.NewSheet;
import cn.qlu.util.Page;

public interface NewsheetDao {
	//根据类别id查询新闻个数
    public int findClass(int tid);
    
  //查询所有新闻
  	public int findAll();
  	
  //根据新闻类别id，分页查询
  	public List<NewSheet> queryAllByPage(Page page , int tid);
  	
  //根据新闻标题，模糊分页查询
  	public List<NewSheet> queryAllByPage_title(Page page , String txt);
  	
  //根据新闻内容，模糊分页查询
  	public List<NewSheet> queryAllByPage_txt(Page page , String txt);
  	
  	
}
