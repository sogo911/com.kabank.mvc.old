package com.kabank.mvc.enums;

public enum TnameEnum {
	MEMBER, ATTEND, KAKAOBANK,
	TNAMES{
		@Override
		public String toString() {
			return MEMBER+","+ATTEND+","+KAKAOBANK;
		}
	}
}
