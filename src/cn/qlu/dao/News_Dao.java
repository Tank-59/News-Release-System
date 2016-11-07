package cn.qlu.dao;

import java.util.List;

import cn.qlu.bean.NRC_NEWS;
import cn.qlu.util.Page;

/**
 * 
 * 新闻操作接口
 *
 */
public interface News_Dao {

	// 新闻添加
	public boolean News_Add(NRC_NEWS news);

	// 新闻修改
	public boolean News_Update(NRC_NEWS news);

	// 新闻删除
	public boolean News_Delete(int id);

	// 根据id查询新闻
	public NRC_NEWS News_Select(int id);
	
	//查询所有新闻
	public List<NRC_NEWS> findAllNews();
	
	//分页查询新闻
	public List<NRC_NEWS> queryAllByPage(Page page);
	
	//查询一共多少记录
	public int findAllCount();

}
