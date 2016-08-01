package csdept;

public class ResReserved {

	private String email;
	private int Id;
	private String date;
	private String slot;
	private String resName;
	private String time;
	
	public String getTime() {
		return time;
	}
	public void setTime(String slot) {
		
		System.out.println("SLOT : "+slot);
		if(slot.equals("slot1"))
			this.time="08AM-09AM";
		else if(slot.equals("slot2"))
			this.time="09AM-10AM";
		else if(slot.equals("slot3"))
			this.time="10AM-11AM";
		else if(slot.equals("slot4"))
			this.time="11AM-12PM";
		else if(slot.equals("slot5"))
			this.time="12PM-01PM";
		else if(slot.equals("slot6"))
			this.time="01PM-02PM";
		else if(slot.equals("slot7"))
			this.time="02PM-03PM";
		else if(slot.equals("slot8"))
			this.time="03PM-04PM";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	
	
	
	
}
