package cn.classroom.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class RegisterForm {
	private String username;
	private String password;
	private String password2;
	private String checkcode;
	private Map<String, String> errors = new HashMap<String, String>();
	private String s_checkcode;

	public String getS_checkcode() {
		return s_checkcode;
	}

	public void setS_checkcode(String s_checkcode) {
		this.s_checkcode = s_checkcode;
	}

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

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
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

		if (this.checkcode == null || this.checkcode.trim().equals("")) {
			isOK = false;
			errors.put("checkcode", "��֤�벻��Ϊ�գ�");
		} else {
			if (!this.checkcode.equals(this.s_checkcode)) {
				isOK = false;
				errors.put("checkcode", "��֤�����");
			}
		}

		return isOK;
	}
}
