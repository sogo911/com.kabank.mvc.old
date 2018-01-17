package com.kabank.mvc.serviceImpl;


import java.util.List;

import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	public static MemberService getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {}
	
	List<MemberBean> list;
	@Override
	public MemberBean findById(MemberBean m) {
		System.out.println("======서비스임플 접근======");
		System.out.println("받은 아이디 : "+m.getId());
		System.out.println("받은 비번 : "+m.getPass());
		/*memberdao = new MemberDAOImpl();*/
		return MemberDAOImpl.getInstance().selectMemberById(m);
	}
/*		
		boolean flag = false;
		for(int i = 0; i < list.size(); i++ ) {
			if(m.getId().equals(list.get(i).getId()) && m.getPass().equals(list.get(i).getPass())) {
				flag = true;
				break;
			}
		}
		return flag;*/
		//DAO한태 멤버스 전체리스트를 달라고 한다. List<> d = dao.selectMembers();
		//컨트롤러에서 받은 ID,PW를 멤버DAO와 멤버DAO임플을 이용하여 회원목록과 비교한다.
	@Override
	public MemberBean login() {
		return MemberDAOImpl.getInstance().login();
	}
	@Override
	public void changePass(MemberBean member) {
		MemberDAOImpl.getInstance().updatePass(member);
	}
	@Override
	public void delete(MemberBean member) {
		MemberDAOImpl.getInstance().deleteMember(member);
	}
	@Override
	public void make() {
		MemberDAOImpl.getInstance().makeMember();
	}
}