package cn.classroom.domain;

//封装教室的JavaBean
public class Classroom {
	private String room_no;
	private String location;

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
