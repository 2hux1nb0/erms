package cn.classroom.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.domain.User;
import cn.classroom.service.impl.BusinessServiceImpl;
import cn.classroom.utils.WebUtils;
import cn.classroom.web.formbean.LoginForm;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginForm form = WebUtils.request2Bean(request, LoginForm.class);
		boolean b = form.validate();
		if (!b) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.login(username, password, type);
		if (user != null) {
			request.setAttribute("id", user.getId());
			request.setAttribute("username", user.getUsername());
			request.getSession().setAttribute("user", user);
			if (type.equals("student")) {
				request.getRequestDispatcher("/WEB-INF/jsp/student.jsp")
						.forward(request, response);
			} else if (type.equals("teacher")) {
				request.getRequestDispatcher("/WEB-INF/jsp/teacher.jsp")
						.forward(request, response);
			} else if (type.equals("admin")) {
				request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp")
				.forward(request, response);
			} else {
				request.setAttribute("message", "请正确选择用户类型!");
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
			}
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
