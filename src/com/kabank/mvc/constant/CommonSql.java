package com.kabank.mvc.constant;

public class CommonSql {
	public static String getCommonSQL(String tname) {
		return "SELECT COUNT (*) AS count FROM "+tname;
	}
}

//멤버를 스트링잡아주고 파라미터 들어가는것을 리턴해주면 된다.
