package com.kabank.mvc.enums;

public enum MemberEnum {
	ID, PASS, NAME, SSN, PHONE, PROFILE, EMAIL, ADDR, 
	PROPERTIES{
		@Override
		public String toString() {
			return ID+","+PASS+","+NAME+","+SSN
					+","+PHONE+","+PROFILE+","+EMAIL+","+ADDR;
		}
	},
	LOGIN{
		@Override
		public String toString() {
			return "SELECT ID, PASS, NAME, SSN, PHONE, EMAIL, ADDR, PROFILE FROM Member"
					+" WHERE id LIKE '$' AND pass LIKE '@'";
		}
	}
}
