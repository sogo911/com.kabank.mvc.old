package com.kabank.mvc.service;

import com.kabank.mvc.domain.MemberBean;

public interface MemberService {

	public MemberBean findById(MemberBean m);

	public MemberBean login();

	public void changePass(MemberBean member);

	public void delete(MemberBean member);

	public void make();

}
