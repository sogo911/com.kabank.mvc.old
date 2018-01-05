package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.service.CommonService;
import com.kabank.mvc.serviceImpl.CommonServiceImpl;

@WebServlet("/common/jdbc_test.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CommonService service;
	public CommonController() {
		service = new CommonServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==========서블릿===========");
		request.setAttribute("count", service.countTable());
		
		request
		.getRequestDispatcher("/WEB-INF/view/common/jdbc_test.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
