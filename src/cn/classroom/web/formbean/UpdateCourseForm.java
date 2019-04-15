package cn.classroom.web.formbean;

import java.util.HashMap;
import java.util.Map;

import cn.classroom.dao.CourseDao;
import cn.classroom.dao.UserDao;
import cn.classroom.dao.impl.CourseDaoImpl;
import cn.classroom.dao.impl.UserDaoImpl;

public class UpdateCourseForm {
	private String course_id;
	private String name;
	private String teacher;
	private Map<String, String> errors = new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public boolean validate() {
		boolean isOK = true;

		if (this.course_id == null || this.course_id.trim().equals("")) {
			isOK = false;
			errors.put("course_id", "�γ̺Ų���Ϊ�գ�");
		} else {
			if (!this.course_id.matches("[A-Za-z0-9]{1,4}")) {
				isOK = false;
				errors.put("course_id", "�γ̺�̫����");
			} else {
				CourseDao dao = new CourseDaoImpl();
				if (!dao.findCourse(course_id)) {
					isOK = false;
					errors.put("course_id", "�ÿγ̲����ڣ��������ƿγ���Ϣ��");
				}
			}
		}

		if (this.name == null || this.name.trim().equals("")) {
			isOK = false;
			errors.put("name", "�γ�������Ϊ�գ�");
		} else {
			String s = this.name.replace(" ", "");
			if (!s.matches("^.{1,20}$")) {
				isOK = false;
				errors.put("name", "�γ���̫����");
			}
		}

		if (this.teacher == null || this.teacher.trim().equals("")) {
			isOK = false;
			errors.put("teacher", "���ν�ʦ����Ϊ�գ�");
		} else {
			String s = this.teacher.replace(" ", "");
			if (!s.matches("^.{1,20}$")) {
				isOK = false;
				errors.put("teacher", "����̫����");
			} else {
				UserDao dao = new UserDaoImpl();
				if (!dao.findUser(this.teacher, "teacher")) {
					isOK = false;
					errors.put("teacher", "�ý�ʦ�����ڣ�");
				}
			}
		}

		return isOK;
	}
}
