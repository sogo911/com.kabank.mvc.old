package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.MakeKakaoCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.serviceImpl.KakaoBankServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet({"/kakao.do"})
public class KakaoBankController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws  ServletException, IOException  {
		System.out.println("==========카카오 컨트롤러 접근=========");
		new InitCommand(request).execute();
		
		switch (InitCommand.cmd.getAction()) {
		case MOVE:
			System.out.println("=========KAKAO-C: MOVE IN===========");
			move(request);
			System.out.println("=========KAKAO-C: MOVE OUT===========");
			DispatcherServlet.send(request, response);
			break;
		case MAKE_KAKAO:
			System.out.println("=========KAKAO-C: MAKE IN===========");
			new MakeKakaoCommand().execute();
			System.out.println("증설된 커스텀번호 :"+InitCommand.cmd.getData());
			System.out.println("증설된 계좌번호 :"+InitCommand.cmd.getColumn());
			KakaoBankServiceImpl.getInstance().makeAccount();
			move(request);
			System.out.println("=========KAKAO-C: MAKE OUT===========");
			DispatcherServlet.send(request, response);
			break;
		default:
			break;
		}
	}
	private void move(HttpServletRequest request) {
		new MoveCommand(request).execute();
	}
	
}
