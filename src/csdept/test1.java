package csdept;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

public class test1 extends TestCase {
public void test_getAnncInfo()
{
	AnncDAO dao=new AnncDAO();
	Announcement a=dao.getAnncInfo("14");
	int id=a.getId();
	assertEquals(id,14);
}

public void test_insertAnnc()
{
	AnncDAO dao=new AnncDAO();
	boolean a=dao.insertAnnouncement("job", "Job 2", "Summer", "google.com", "varun@mail.com");
	assertEquals(a,false);
}

public void test_updateAnnc()
{
	AnncDAO dao=new AnncDAO();
	boolean a=dao.updateAnnouncement(2, "Job", "Summer 15", "google.com");
	assertEquals(a,false);
}

public void test_deleteAnnc()
{
	AnncDAO dao=new AnncDAO();
	boolean a=dao.deleteAnnc("15");
	assertEquals(a,false);
	
}

public void test_getAnncDetails()
{
	AnncDAO dao=new AnncDAO();
	ArrayList<Announcement> a=dao.getAnncDetails();
	int id=a.get(0).getId();
	assertEquals(id,3);
}

public void test_insertAlumni()
{
	AlumniDAO dao=new AlumniDAO();
	boolean a=dao.insertAlumni("Alumni 12", "google.com", "Alumni det");
	assertEquals(a,false);
}

public void test_UpdateAlumniInfo ()
{
	AlumniDAO dao=new AlumniDAO();
	boolean a=dao.UpdateAlumniInfo(10, "google.com", "Alumn details", "Alumni 221");
	assertEquals(a,false);
}

public void test_getAlumniInfo ()
{
	AlumniDAO dao=new AlumniDAO();
	ArrayList<Alumni> a=dao.getAlumniDetails();
	int id=a.get(0).getId();
	assertEquals(id,1);
}

public void test_getPhdDetails()
{
	PhdDAO dao=new PhdDAO();
	ArrayList<Phd> phd=dao.getPhdDetails();
	String id=phd.get(0).getEmail();
	
	assertEquals(id,"dskk@mail.com");
}

public void test_UpdatePhdStatus ()
{
	PhdDAO dao=new PhdDAO();
	boolean a=dao.UpdatePhdStatus("dskk@mail.com", "No");
	assertEquals(a,false);
}

public void test_getSlotDetails()
{
ReserveDAO dao=new ReserveDAO();
ArrayList<Reservation> a=dao.getSlotDetails("04/04/2016", "conferenceRoom");
assertEquals(a.get(0).getRtype(),"conferenceRoom");
}

public void test_getApointment()
{
ReserveDAO dao=new ReserveDAO();
ArrayList<ResReserved> a=dao.getAppointment("vnarayanan@albany.edu");
assertEquals(a.get(0).getEmail(),"vnarayanan@albany.edu");
}

public void test_cancelReservation()
{
	ReserveDAO dao=new ReserveDAO();
	boolean s=dao.cancelReservation("slot1", "Projector1", "04/04/2016", "vnarayanan@albany.edu");
	assertEquals(s,false);
			
}

public void test_AddResource()
{
	ReserveDAO dao=new ReserveDAO();
	boolean s=dao.AddResource("test", "test", "test");
	assertEquals(s, false);
}

public void test_isReserved()
{
	ReserveDAO dao=new ReserveDAO();
	boolean s=dao.checkReserve("04/04/2016", "slot9", "Projector");
	assertEquals(s, false);
}

public void test_InsetPost()
{
	DiscoDAO dao=new DiscoDAO();
	Date d=new Date();
	boolean v=dao.insertPost("What", "hello", "vnarayanan@albany.edu", d, 0);
	assertEquals(v,false);
}

public void test_discoInfo()
{
	DiscoDAO dao=new DiscoDAO();
	ArrayList<DicsoInfo> a=dao.discoInfo();
	assertEquals(dao.getParentid(0),0);
}

public void test_postInfo()
{
DiscoDAO dao=new DiscoDAO();
DicsoInfo c=dao.getPostInfo(3);
assertEquals(dao.getParentid(0),0);
}

public void test_getReplies()
{
	DiscoDAO dao=new DiscoDAO();
	ArrayList<DicsoInfo> a=dao.getReplies(0);
	assertEquals(a.get(0).getPid(),0);

}

public void test_getCourseDetails()
{
	CourseDAO dao=new CourseDAO();
	Course a=dao.getCourseInfo("asd");
	assertEquals(a.getCid(),"asd");
}

public void test_getAllCourseDetails()
{
	CourseDAO dao=new CourseDAO();
	ArrayList<Course> a=dao.getAllCourseDetails();
	assertEquals(a.get(0).getCid(),"asd");
	
}

public void test_getCourseInfo()
{
	CourseDAO dao=new CourseDAO();
	Course c=dao.getCourseInfo("asd");
	assertEquals(c.getCid(),"asd");
}

public void test_getEmailFromNetId()
{
	CourseDAO dao=new CourseDAO();
	String s=dao.getEmailFromNetId("PA957737");
	assertEquals(s,"shan@mail");
}

public void test26()
{CourseDAO dao=new CourseDAO();
	boolean d=dao.deleteCourseInfo("hello");
	assertEquals(d,false);
}

public void test_getExam()
{
	ExamDAO dao=new ExamDAO();
	ArrayList<ExamInfo> a=dao.getExamList();
	int ap=a.get(0).getEid();
	assertEquals(ap,2);
}

public void test_Exm()
{
	ExamDAO dao=new ExamDAO();
	ExamInfo ap=dao.getExam(2);
	assertEquals(ap.getEid(),2);
}


public void test_Exam()
{
	LoginDAO dao=new LoginDAO();
	user u=dao.getUserDetails("PA957737");
	assertEquals(u.getEmail(),"PA957737");
}

}
