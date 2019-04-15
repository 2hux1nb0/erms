package cn.classroom.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.ActivityDao;
import cn.classroom.dao.impl.ActivityDaoImpl;
import cn.classroom.domain.Activity;
import cn.classroom.utils.WebUtils;
import cn.classroom.web.formbean.AddActivityForm;

public class AddActivityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.У���ύ�����ֶν��кϷ���У��(�ѱ����ݷ�װ��formbean)
		AddActivityForm form = WebUtils.request2Bean(request,
				AddActivityForm.class);
		Boolean b = form.validate();

		// 2.���У��ʧ��,���ص���ҳ��,����У��ʧ����Ϣ
		if (!b) {
			request.setAttribute("form", form);
			request.setAttribute("username", form.getUsername());
			request.getRequestDispatcher("/WEB-INF/jsp/addactivity.jsp")
					.forward(request, response);
			return;
		}

		// 3.���У��ɹ�,�����service����ע������
		Activity a = new Activity();
		WebUtils.copyBean(form, a);
		a.setAid(WebUtils.generateID());
		ActivityDao dao = new ActivityDaoImpl();
		try {
			dao.addActivity(a);
			// 6.���service����ɹ�,�����û��������
			String username = request.getParameter("username");
			request.setAttribute("alert", "ԤԼ���ύ,��ȴ�����Ա��ˣ�");
			List a_list = dao.findActivityByUsername(username);
			request.setAttribute("a_list", a_list);
			request.getRequestDispatcher("/WEB-INF/jsp/myactivity.jsp")
					.forward(request, response);
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
