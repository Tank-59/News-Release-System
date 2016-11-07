package cn.qlu.dao;

/**
 * 
 * 登陆验证接口
 *
 */
public interface Login_Dao {
	//查询数据库数据，检查返回值
	public int CheckUser(String username,String password);
}
