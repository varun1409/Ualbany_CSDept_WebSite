package csdept;

public class ExamInfo {


private int eid;
private String ename;
private String econtent;
private String email;
private String esemester;
private String edate;


public String getEdate() {
	return edate;
}
public void setEdate(String edate) {
	this.edate = edate;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEcontent() {
	return econtent;
}
public void setEcontent(String econtent) {
	this.econtent = econtent;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getEsemester() {
	return esemester;
}
public void setEsemester(String esemester) {
	this.esemester = esemester;
}



}