package cn.qlu.bean;

public class NewsReview {
	private String tname;   //类别名字
	private String ntitle;  //新闻标题
	private String npublishTime;  //新闻时间
	private int nid;       //新闻id
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNpublishTime() {
		return npublishTime;
	}
	public void setNpublishTime(String npublishTime) {
		this.npublishTime = npublishTime;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	
}
