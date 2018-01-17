package com.kabank.mvc.command;

import com.kabank.mvc.enums.Action;

import lombok.Data;
@Data

public class Command{
	protected String dir,page,search,column,view,data;

	protected Action action;

	public void setPage(String page) {
			this.page = (page==null) ? "login": page;
	}

}
