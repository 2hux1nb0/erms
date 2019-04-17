package cn.classroom.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.domain.User;
import cn.classroom.exception.UserExistException;
import cn.classroom.service.impl.BusinessServiceImpl;
import cn.classroom.utils.WebUtils;
import cn.classroom.web.formbean.RegisterForm;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		Boolean b = form.validate();
		
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateID());
		user.setType("student");
		BusinessServiceImpl servicve = new BusinessServiceImpl();
		try {
			servicve.register(user);
			request.setAttribute("message", "注册成功!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			form.getErrors().put("username", "用户名已存在!");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}catch(Exception e){
			request.setAttribute("message", "注册失败,请稍后再试!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			e.printStackTrace();
			return;
		}		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
