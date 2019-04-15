package cn.classroom.web.formbean;

import java.util.HashMap;
import java.util.Map;

import cn.classroom.dao.ClassroomDao;
import cn.classroom.dao.impl.ClassroomDaoImpl;

public class AddClassroomForm {
	private String room_no;
	private String location;
	private Map<String, String> errors = new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

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

	public boolean validate() {
		boolean isOK = true;

		if (this.room_no == null || this.room_no.trim().equals("")) {
			isOK = false;
			errors.put("room_no", "���ҺŲ���Ϊ�գ�");
		} else {
			if (!this.room_no.matches("[A-Za-z0-9]{1,4}")) {
				isOK = false;
				errors.put("room_no", "���Һ�̫����");
			} else {
				ClassroomDao dao = new ClassroomDaoImpl();
				if(dao.findClassroom(room_no)){
					isOK = false;
					errors.put("room_no", "�ý����Ѵ��ڣ�");
				}
			}
		}

		if (this.location == null || this.location.trim().equals("")) {
			isOK = false;
			errors.put("location", "����λ�ò���Ϊ�գ�");
		} else {
			String s = this.location.replace(" ", "");
			if (!s.matches("^.{1,40}$")) {
				isOK = false;
				errors.put("location", "����̫����");
			}
		}

		return isOK;
	}
}