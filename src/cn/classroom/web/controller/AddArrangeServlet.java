package cn.classroom.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.ActivityDao;
import cn.classroom.dao.CourseArrangementDao;
import cn.classroom.dao.impl.ActivityDaoImpl;
import cn.classroom.dao.impl.CourseArrangementDaoImpl;
import cn.classroom.domain.CourseArrangement;
import cn.classroom.utils.WebUtils;
import cn.classroom.web.formbean.AddArrangeForm;

public class AddArrangeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.У���ύ�����ֶν��кϷ���У��(�ѱ����ݷ�װ��formbean)
		AddArrangeForm form = WebUtils.request2Bean(request,
				AddArrangeForm.class);
		Boolean b = form.validate();
		String select = request.getParameter("select");

		// 2.���У��ʧ��,���ص���ҳ��,����У��ʧ����Ϣ
		if (!b) {
			request.setAttribute("form", form);
			if (select.equals("room_no")) {
				request.setAttribute("room_no", form.getRoom_no());
				request.getRequestDispatcher("/WEB-INF/jsp/addarrange.jsp")
						.forward(request, response);
			} else if (select.equals("name")) {
				request.setAttribute("name", form.getName());
				request.getRequestDispatcher("/WEB-INF/jsp/addarrange.jsp")
						.forward(request, response);
			}
			return;
		}

		// 3.���У��ɹ�,�����service����ע������
		CourseArrangement ca = new CourseArrangement();
		WebUtils.copyBean(form, ca);
		ca.setId(WebUtils.generateID());
		CourseArrangementDao dao = new CourseArrangementDaoImpl();
		try {
			dao.addArrange(ca);
			// 6.���service����ɹ�,�����û��������
			CourseArrangementDao dao2 = new CourseArrangementDaoImpl();
			ActivityDao dao3 = new ActivityDaoImpl();
			request.setAttribute("alert", "��ӿγ̰��ųɹ���");
			if (select.equals("room_no")) {
				List c_list = dao2.findArrangeByClassroom(form.getRoom_no());
				List a_list = dao3.findActivityByClassroom(form.getRoom_no());
				request.setAttribute("room_no", form.getRoom_no());
				request.setAttribute("c_list", c_list);
				request.setAttribute("a_list", a_list);
				request.getRequestDispatcher("/WEB-INF/jsp/room-arrange.jsp")
						.forward(request, response);
			} else if (select.equals("name")) {
				List c_list = dao2.findArrangeByCourse(form.getName());
				request.setAttribute("name", form.getName());
				request.setAttribute("c_list", c_list);
				request.getRequestDispatcher("/WEB-INF/jsp/room-arrange.jsp")
						.forward(request, response);
			}
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
