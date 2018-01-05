package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.constant.AdminSql;
import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.daoImpl.AdminDAOImpl;
import com.kabank.mvc.service.AdminService;

public class AdminServiceImpl implements AdminService{
	AdminDAO dao;
	public AdminServiceImpl() {
		 dao = new AdminDAOImpl();
	}
	@Override
	public void adminTable(String tname) {
		System.out.println("어드민 티네임 : "+tname);
		String sql = "";
		switch (tname) {
		case "member":
			sql = AdminSql.CREATE_MEMBER;
			break;
		case "attend":
			sql = AdminSql.CREATE_ATTEND;
			break;
		default:
			break;
		}
		dao.selectAdminTable(sql);
	}

}
