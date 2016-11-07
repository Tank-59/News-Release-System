package cn.qlu.bean;
/**
 * 
 * 新闻评论表
 *
 */
public class NRC_REVIEW {
	private int rid;		//评论id
	private String rcontent;	//评论内容
	private String ruserName;  //评论者昵称
	private String rrevTime;	//评论时间
	private int nid;		//新闻id
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRuserName() {
		return ruserName;
	}
	public void setRuserName(String ruserName) {
		this.ruserName = ruserName;
	}
	public String getRrevTime() {
		return rrevTime;
	}
	public void setRrevTime(String rrevTime) {
		this.rrevTime = rrevTime;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	
	
}
