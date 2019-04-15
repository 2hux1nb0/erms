package cn.classroom.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.domain.QueryResult;
import cn.classroom.domain.User;
import cn.classroom.exception.UserExistException;
import cn.classroom.service.BusinessService;
import cn.classroom.service.impl.BusinessServiceImpl;
import cn.classroom.utils.WebUtils;
import cn.classroom.web.formbean.AddUserForm;

public class AddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.У���ύ�����ֶν��кϷ���У��(�ѱ����ݷ�װ��formbean)
		AddUserForm form = WebUtils.request2Bean(request, AddUserForm.class);
		Boolean b = form.validate();

		// 2.���У��ʧ��,���ص���ҳ��,����У��ʧ����Ϣ
		if (!b) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/adduser.jsp").forward(
					request, response);
			return;
		}

		// 3.���У��ɹ�,�����service����ע������
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateID());
		BusinessServiceImpl servicve = new BusinessServiceImpl();
		try {
			servicve.register(user);
			// 6.���service����ɹ�,�����û��������
			BusinessService service = new BusinessServiceImpl();
			QueryResult qr = service.queryUser();
			request.setAttribute("queryresult", qr);
		    request.setAttribute("alert", "����û��ɹ���");
			request.getRequestDispatcher("/WEB-INF/jsp/user-mana-main.jsp")
			.forward(request, response);
			return;
		} catch (UserExistException e) {
			// 4.���service�����ɹ�,���Ҳ��ɹ���ԭ�����û��Ѵ���,�����ص�ע��ҳ��,��ʾע���û��Ѵ���
			form.getErrors().put("username", "ע����û����Ѿ����ڣ�");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/adduser.jsp").forward(
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
