package com.kabank.mvc.enums;

public enum PathEnum {
			VIEW("/WEB-INF/view/"),
			SEPARATOR("/"),
			DOT("\\."),
			EXTENSION(".jsp");

	public final String value;
	
	private PathEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

