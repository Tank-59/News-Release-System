package cn.qlu.bean;
/**
 * 
 * 新闻表
 *
 */
public class NRC_NEWS {
	private int nid;		        //新闻编号
	private String ntitle;	        //新闻标题
	private String ncontent;		//新闻内容
	private int tid;				//类别ID
	private String npublishTime;	//新闻发布时间
	
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getNpublishTime() {
		return npublishTime;
	}
	public void setNpublishTime(String npublishTime) {
		this.npublishTime = npublishTime;
	}
	
}
