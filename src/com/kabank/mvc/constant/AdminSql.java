package com.kabank.mvc.constant;

public class AdminSql {
	public static final String CREATE_MEMBER=
			"CREATE TABLE Member("
					+"id VARCHAR2(20) PRIMARY KEY,"
					+"pass VARCHAR2(20),"
					+"name VARCHAR2(20),"
					+"ssn VARCHAR2(20),"
					+"phone VARCHAR2(20),"
					+"email VARCHAR2(20),"
					+"profile VARCHAR2(20),"
					+"addr VARCHAR2(20)"
								+")";
	
	public static final String CREATE_ATTEND=
			"CREATE TABLE Attend("
					+"sql NUMBER PRIMARY KEY,"
					+"id VARCHAR2(20),"
					+"week VARCHAR2(20),"
					+"status VARCHAR2(20)"
					+")";
}
