package com.kabank.mvc.enums;

public enum Action {
	MOVE,ADD,LOGIN,JOIN,SEARCH,COLUMN,CHANGE_PASS,DELETE_MEMBER,MAKE_KAKAO,
	VIEW{
		@Override
		public String toString() {
			return "WEB-INF/view/";
		}
	},
	EXTENSION{
		@Override
		public String toString() {
			return ".jsp";
		}
	},
	SEPARATOR{
		@Override
		public String toString() {
			return "/";
		}
	}
}
