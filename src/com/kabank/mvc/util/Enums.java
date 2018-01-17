package com.kabank.mvc.util;

public class Enums {
	public enum MemberColumn {
		ID,PASS,NAME	// 이넘에는 ;로 마무리를 하면안된다.
	}
	public enum AttendColumn{
		ID,PASS,NAME,SSN,PHONE,PROFILE,EMAIL,ADDR
	}
	public enum Table{
	MEMBER, ATTEND, ADMIN
	}
	public enum DML{
		SELECT, INSERT, INTO, UPDATE, DELETE,FROM
	}
	public static String getBlanks(int count) {
		String blanks = "";
		for(int i=0; i<count; i++) {
			blanks += "'%s'";
		}
		return blanks;
	}
}
