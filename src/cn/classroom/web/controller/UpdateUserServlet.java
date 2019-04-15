package cn.classroom.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.UserDao;
import cn.classroom.dao.impl.UserDaoImpl;
import cn.classroom.domain.User;
import cn.classroom.utils.WebUtils;
import cn.classroom.web.formbean.UpdateUserForm;

public class UpdateUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.У���ύ�����ֶν��кϷ���У��(�ѱ����ݷ�װ��formbean)
		UpdateUserForm form = WebUtils.request2Bean(request,
				UpdateUserForm.class);
		Boolean b = form.validate();

		// 2.���У��ʧ��,���ص���ҳ��,����У��ʧ����Ϣ
		if (!b) {
			request.setAttribute("form", form);
			User user = new User();
			user.setId(form.getId());
			user.setUsername(form.getUsername());
			user.setType(form.getType());
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/jsp/updateuser.jsp")
					.forward(request, response);
			return;
		}

		// 3.���У��ɹ�,�����service����ע������
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setPassword(WebUtils.md5(user.getPassword()));
		UserDao dao = new UserDaoImpl();
		try {
			dao.updateUser(user);
			// 6.���service����ɹ�,�����û��������
			user = dao.findUser(user.getId(), true);
			request.setAttribute("user", user);
			request.setAttribute("alert", "�޸�����ɹ���");
			request.getRequestDispatcher("/WEB-INF/jsp/myinfo.jsp").forward(
					request, response);
			return;
		} catch (Exception e) {
			// 5.���service�����ɹ�,���Ҳ��ɹ���ԭ������������Ļ�,����ת����վ��ȫ����Ϣ��ʾҳ��,Ϊ�û���ʾ�Ѻô�����Ϣ
			request.setAttribute("message", "���������ִ���");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			e.printStackTrace();
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
