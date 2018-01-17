package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.iterator.ParamsIterator;

public class DeleteMember implements IOrder{
	Map<?,?> map;
	public DeleteMember(HttpServletRequest request) {
		map = ParamsIterator.execute(request);
	}
	@Override
	public void execute() {
		String deleteMeber = String.valueOf(map.get("id"));
		InitCommand.cmd.setData(deleteMeber);
	}
	
}
