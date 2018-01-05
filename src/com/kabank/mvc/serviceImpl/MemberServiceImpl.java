package com.kabank.mvc.serviceImpl;


import java.util.List;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberDAO memberdao;
	@Override
	public boolean login(MemberBean m) {
		System.out.println("받은 아이디 : "+m.getId());
		memberdao = new MemberDAOImpl();
		List<MemberBean> list = memberdao.selectMembers();
		boolean flag = false;
		for(int i = 0; i < list.size(); i++ ) {
			if(m.getId().equals(list.get(i).getId()) && m.getPass().equals(list.get(i).getPass())) {
				flag = true;
				break;
			}
			
		}
		
		return flag;
	}

	//DAO한태 멤버스 전체리스트를 달라고 한다. List<> d = dao.selectMembers();
	//컨트롤러에서 받은 ID,PW를 멤버DAO와 멤버DAO임플을 이용하여 회원목록과 비교한다.
}
