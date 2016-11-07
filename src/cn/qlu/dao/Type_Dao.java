package cn.qlu.dao;

import java.util.List;

import cn.qlu.bean.NRC_TYPE;
import cn.qlu.util.Page;

/**
 * 
 * 后台新闻类别接口
 *
 */
public interface Type_Dao {
	//类别添加
	public boolean Type_Add(NRC_TYPE type);
	//类别修改
	public boolean Type_Update(NRC_TYPE type);
	//类别删除
	public boolean Type_Delete(int id);
	//根据id查询类别的内容
	public NRC_TYPE Type_Select(int id);
	//查询所有类别
	public List<NRC_TYPE> findAllType();
	//分页查询内容
	public List<NRC_TYPE> queryAllByPage(Page page);
	//查询分页中的所有内容
	public int findAllCount();
}
