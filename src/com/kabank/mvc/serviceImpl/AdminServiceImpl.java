package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.daoImpl.AdminDAOImpl;
import com.kabank.mvc.enums.DDLEnum;
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
			sql = DDLEnum.CREATE_TABLE_MEMBER.toString();
			break;
		case "attend":
			sql = DDLEnum.CREATE_TABLE_ATTEND.toString();
			break;
		case "kakao_bank":
			sql = DDLEnum.CREATE_TABLE_KAKAOBANK.toString();
			break;
		default:
			break;
		}
		dao.selectAdminTable(sql);
	}

}
