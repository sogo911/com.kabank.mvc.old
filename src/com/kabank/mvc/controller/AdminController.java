package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.enums.PathEnum;
import com.kabank.mvc.service.AdminService;
import com.kabank.mvc.serviceImpl.AdminServiceImpl;

@WebServlet({"/admin/main.do","/admin/create_table.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("=======관리자 서블릿 접근=======");
		String dir = request.getServletPath().split(PathEnum.SEPARATOR.getValue())[1];
		String action = request.getServletPath().split(PathEnum.SEPARATOR.getValue())[2].split(PathEnum.DOT.getValue())[0];
		String dest = "";
		System.out.println("dir: "+dir);
		System.out.println("액션: "+action);
		switch (action) {
		case "main":
			dest = action;
			break;
		case "create_table":
			String tname = request.getParameter("table_name");
			AdminService service = new AdminServiceImpl();
			service.adminTable(tname);
			dest = "main";
			break;
		default:
			break;
		}
		request
		.getRequestDispatcher(PathEnum.VIEW.getValue()+dir+PathEnum.SEPARATOR.getValue()+dest+PathEnum.EXTENSION.getValue())
		.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
