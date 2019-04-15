package cn.classroom.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class AddUserForm {
	private String username;
	private String password;
	private String password2;
	private String type;
	private Map<String, String> errors = new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// �û�������Ϊ��,����ҪΪ3-8λ���ֻ���ĸ
	// ���벻��Ϊ��,����ҪΪ3-8λ���ֻ���ĸ
	// ȷ�����벻��Ϊ��,����Ҫ������һ��
	public boolean validate() {
		boolean isOK = true;

		if (this.username == null || this.username.trim().equals("")) {
			isOK = false;
			errors.put("username", "�û�������Ϊ�գ�");
		} else {
			if (!this.username.matches("[\u4e00-\u9fa5A-Za-z0-9]{3,8}")) {
				isOK = false;
				errors.put("username", "�û���������3-8λ�ַ�!");
			}
		}

		if (this.password == null || this.password.trim().equals("")) {
			isOK = false;
			errors.put("password", "���벻��Ϊ�գ�");
		} else {
			if (!this.password.matches("[A-Za-z0-9]{3,8}")) {
				isOK = false;
				errors.put("password", "���������3-8λ���ֻ���ĸ!");
			}
		}

		if (this.password2 == null || this.password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "ȷ�����벻��Ϊ�գ�");
		} else {
			if (!this.password.equals(this.password2)) {
				isOK = false;
				errors.put("password2", "�����������һ��!");
			}
		}

		return isOK;
	}
}