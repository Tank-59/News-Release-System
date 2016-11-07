package cn.qlu.bean;
/**
 * 
 * 新闻类别表
 *
 */
public class NRC_TYPE {

	private int tid;		//新闻类别id
	private String tname;	//类别名
	private String tmemo;	//类别备注
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTmemo() {
		return tmemo;
	}
	public void setTmemo(String tmemo) {
		this.tmemo = tmemo;
	}
	
	
	
}
