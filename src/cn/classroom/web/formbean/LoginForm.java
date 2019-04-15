package cn.classroom.web.formbean;

import cn.classroom.dao.UserDao;
import cn.classroom.dao.impl.UserDaoImpl;
import cn.classroom.utils.WebUtils;

public class LoginForm {
	private String username;
	private String password;
	private String type;
	private String error;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public boolean validate() {
		UserDao dao = new UserDaoImpl();
		boolean isOK = true;

		if (this.username == null || this.username.trim().equals("")) {
			isOK = false;
			error = "�û�������Ϊ�գ�";
		} else if (this.password == null || this.password.trim().equals("")) {
			isOK = false;
			error = " ���벻��Ϊ�գ�";
		} else if (this.type == null) {
			isOK = false;
			error = "��ѡ���û����ͣ�";
		} else if (!dao.findUser(username, type)) {
			isOK = false;
			error = " �û��������ڣ�";
		} else if ((dao.findUser(username, WebUtils.md5(password), type)) == null) {
			isOK = false;
			error = "  �������";
		}
		return isOK;
	}
}
