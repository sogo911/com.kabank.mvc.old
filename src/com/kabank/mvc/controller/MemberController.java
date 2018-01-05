package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.constant.Path;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;

@WebServlet({"/user/login.do","/user/join.do","/user/auth.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("========서블릿 접근========");
		String dir = request.getServletPath().split(Path.SEPARATOR)[1];
		String action = request.getServletPath().split(Path.SEPARATOR)[2].split(Path.DOT)[0];
		String dest = "";
		System.out.println("액션 : "+action);
		switch (action) {
		case "auth":
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			System.out.println("아이디:"+id);
			System.out.println("비번:"+pass);
			MemberBean m = new MemberBean();
			m.setId(id);
			m.setPass(pass);
			//멤버빈을 통해 셋터로 보낸다.
			MemberService service = new MemberServiceImpl();
			boolean flag = service.login(m);
			System.out.println("결과 : " + flag);
			//멤버서비스와 멤버서비스임플을 통해 받아온다.
			//불린 플레그 펄스를 이용해서 이프엘즈로 로그인성공 실패를 만든다.
			if(flag) {
				dir = "bitcamp";
				dest = "main";
			}else {
				dir = "user";
				dest = "login";
			}
			break;
		case "login":
			dest = action;
			break;
		case "join":
			dest = action;
			break;
		default:
			break;
		}
		request
		.getRequestDispatcher(Path.VIEW+dir+Path.SEPARATOR+dest+Path.EXTENSION)
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
