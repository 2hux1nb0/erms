package cn.classroom.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.CourseDao;
import cn.classroom.dao.impl.CourseDaoImpl;
import cn.classroom.domain.Course;
import cn.classroom.domain.QueryResult;
import cn.classroom.service.BusinessService;
import cn.classroom.service.impl.BusinessServiceImpl;
import cn.classroom.utils.WebUtils;
import cn.classroom.web.formbean.AddCourseForm;
import cn.classroom.web.formbean.UpdateCourseForm;

public class UpdateCourseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.У���ύ�����ֶν��кϷ���У��(�ѱ����ݷ�װ��formbean)
		UpdateCourseForm form = WebUtils.request2Bean(request,
				UpdateCourseForm.class);
		Boolean b = form.validate();

		// 2.���У��ʧ��,���ص���ҳ��,����У��ʧ����Ϣ
		if (!b) {
			request.setAttribute("form", form);
			request.setAttribute("course_id", form.getCourse_id());
			request.setAttribute("name", form.getName());
			request.getRequestDispatcher("/WEB-INF/jsp/addcourse.jsp").forward(
					request, response);
			return;
		}

		// 3.���У��ɹ�,�����service����ע������
		Course c = new Course();
		WebUtils.copyBean(form, c);
		CourseDao dao = new CourseDaoImpl();
		try {
			dao.updateCourse(c);
			// 6.���service����ɹ�,�����û��������
			BusinessService service = new BusinessServiceImpl();
			QueryResult qr = service.queryCourse();
			request.setAttribute("queryresult", qr);
			request.setAttribute("alert", "��ӿγ̳ɹ���");
			request.getRequestDispatcher("/WEB-INF/jsp/course-mana-main.jsp")
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
