package com.kabank.mvc.dao;

import java.util.List;

import com.kabank.mvc.domain.MemberBean;

public interface MemberDAO {
	public List<MemberBean> selectMembers();


	public MemberBean selectMemberById(MemberBean m);

	public MemberBean login();

	public void updatePass(MemberBean member);

	public void deleteMember(MemberBean member);


	public void makeMember();
}
