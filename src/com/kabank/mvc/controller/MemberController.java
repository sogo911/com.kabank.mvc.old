package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.ChangePassCommand;
import com.kabank.mvc.command.DeleteMember;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.JoinCommand;
import com.kabank.mvc.command.LoginCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet({"/user.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("========멤버컨트롤러 접근========");
		HttpSession session = request.getSession();
		InitCommand init = new InitCommand(request);
		init.execute();
		MemberBean member = null;
		switch (InitCommand.cmd.getAction()) {
		case MOVE:
			System.out.println("=========MEMBER-C: MOVE IN===========");
			move(request);
			System.out.println("도착지 : "+InitCommand.cmd.getView());
			System.out.println("=========MEMBER-C: MOVE OUT===========");
			DispatcherServlet.send(request, response);
			break;
		case ADD:
			System.out.println("=========MEMBER-C: ADD IN===========");
			System.out.println("=========MEMBER-C: ADD OUT===========");
			break;
		case LOGIN:
			System.out.println("==========MEMBER-C LOGIN IN========");
			login(request,session);
			System.out.println("도착지 : "+InitCommand.cmd.getView());
			System.out.println("==========MEMBER-C LOGIN OUT========");
			DispatcherServlet.send(request, response);
			break;
		case JOIN:
			System.out.println("=========MEMBER-C: JOIN IN===========");
			new JoinCommand(request).execute();
			System.out.println("회원가입 정보 : "+InitCommand.cmd.getData());
			MemberServiceImpl.getInstance().make();
			move(request);
			System.out.println("=========MEMBER-C: JOIN OUT===========");
			DispatcherServlet.send(request, response);
			break;
		case CHANGE_PASS:
			System.out.println("==========MEMBER-C CHANGE_PASS IN========");
			member = (MemberBean) session.getAttribute("user");
			new ChangePassCommand(request).execute();
			System.out.println("변경할 비밀번호"+InitCommand.cmd.getData());
			String id = member.getId();
			member.setId(id);
			member.setPass(InitCommand.cmd.getData());
			MemberServiceImpl.getInstance().changePass(member);
			session.setAttribute("user", member);
			System.out.println("변경확인");
			System.out.println(member.toString());
			move(request);
			System.out.println("도착지 : "+InitCommand.cmd.getView());
			System.out.println("==========MEMBER-C CHANGE_PASS OUT========");
			DispatcherServlet.send(request, response);
			break;
		case DELETE_MEMBER:
			System.out.println("==========MEMBER-C DELETE_MEMBER IN========");
			member =(MemberBean) session.getAttribute("user");
			new DeleteMember(request).execute();
			String id1 = ((MemberBean) session.getAttribute("user")).getId();
			member.setId(id1);
			MemberServiceImpl.getInstance().delete(member);
			session.setAttribute("user", member);
			System.out.println("삭제확인");
			System.out.println(member.toString());
			session.invalidate(); // 로그아웃
			move(request);
			System.out.println("도착지 : "+InitCommand.cmd.getView());
			System.out.println("==========MEMBER-C DELETE_MEMBER OUT========");
			DispatcherServlet.send(request, response);
			break;
		default:
			break;
			
		}
		
	}

	private void move(HttpServletRequest request) {
		new MoveCommand(request).execute();
	}

	private void login(HttpServletRequest request,
			HttpSession session) {
		
		new LoginCommand(request).execute();
		MemberBean member = MemberServiceImpl.getInstance().login();
		if(member==null) {
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("login");
		}else {
			session.setAttribute("user", member);
			InitCommand.cmd.setDir("bitcamp");
			InitCommand.cmd.setPage("main");
		}
		move(request);
	}
	
}
