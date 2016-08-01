package csdept;

import java.util.Date;

public class DicsoInfo {
private int postid;
private int pid;
private String ptitle;
private String pcontent;
private Date time;
private String usermail;

public String getUsermail() {
	return usermail;
}
public void setUsermail(String usermail) {
	this.usermail = usermail;
}
public int getPostid() {
	return postid;
}
public void setPostid(int postid) {
	this.postid = postid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPtitle() {
	return ptitle;
}
public void setPtitle(String ptitle) {
	this.ptitle = ptitle;
}
public String getPcontent() {
	return pcontent;
}
public void setPcontent(String pcontent) {
	this.pcontent = pcontent;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}



}
