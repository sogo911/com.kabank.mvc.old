package com.kabank.mvc.enums;

public enum DMLEnum {
	COUNT{
		@Override
		public String toString() {
			return "SELECT COUNT (*) AS count FROM ";
		}
	},
	SELECT{
		@Override
		public String toString() {
			return "SELECT FROM ";
		}
	},
	INSERT{
		@Override
		public String toString() {
			return "INSERT INTO ";
		}
	},
	WHERE{
		@Override
		public String toString() {
			return "SELECT * FROM WHERE ";
		}
	},
	CHANGE_PASS{
		@Override
		public String toString() {
			return "UPDATE MEMBER SET pass = '%s' WHERE id = '%s'";
		}
	},
	DELETE_MEMBER{
		@Override
		public String toString() {
			return "DELETE FROM Member WHERE id = '%s'";
		}
	},
	INSERT_MEMBER{
		@Override
		public String toString() {
			return "INSERT INTO Member(id,pass,name,ssn,phone,email,profile,addr)"
					+ " VALUES('%s','%s','%s','%s','%s','%s','%s','%s')";
		}
	},INSERT_ACCOUNTNUM{
		@Override
		public String toString() {
			return "INSERT INTO KAKAOBANK(customNum,accountNum)"
					+ " VALUES('%s','%s')";
		}
	}
	
}
