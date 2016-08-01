package csdept;

import java.sql.Blob;

public class Course {
private String cname;
private String cid;
private String semester;
private String profEmail;
private String OfficeHours;
private String OfficeLoc;
private String ta;
private Blob syllabus;


public Blob getSyllabus() {
	return syllabus;
}
public void setSyllabus(java.sql.Blob blob) {
	this.syllabus = blob;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getSemester() {
	return semester;
}
public void setSemester(String semester) {
	this.semester = semester;
}
public String getProfEmail() {
	return profEmail;
}
public void setProfEmail(String profEmail) {
	this.profEmail = profEmail;
}
public String getOfficeHours() {
	return OfficeHours;
}
public void setOfficeHours(String officeHours) {
	OfficeHours = officeHours;
}
public String getOfficeLoc() {
	return OfficeLoc;
}
public void setOfficeLoc(String officeLoc) {
	OfficeLoc = officeLoc;
}
public String getTa() {
	return ta;
}
public void setTa(String ta) {
	this.ta = ta;
}



}
