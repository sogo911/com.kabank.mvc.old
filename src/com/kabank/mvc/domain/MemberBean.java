package com.kabank.mvc.domain;

import lombok.Data;

@Data

public class MemberBean {
	private String name, id, pass, ssn, 
					phone, email, profile, addr, account;

	@Override
	public String toString() {
		return "MemberBean [이름:" + name + ", ID:" + id + ", 비밀번호:" + pass + ", "
				+ "주민번호(생년월일-첫번째 번호):" + ssn + ", 핸드폰 번호:" + phone
				+ ", 이메일:" + email + ", 프로필사진:" + profile + ", 주소:" + addr +"]";
	}
	
}
