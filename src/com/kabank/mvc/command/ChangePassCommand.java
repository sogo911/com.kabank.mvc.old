package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.iterator.ParamsIterator;

public class ChangePassCommand implements IOrder{
	Map<?, ?> map;
	public ChangePassCommand(HttpServletRequest request) {
		map = ParamsIterator.execute(request);
	}
	@Override
	public void execute() {
		String changePass = String.valueOf(map.get("changePass"));
		InitCommand.cmd.setData(changePass);
	}
}
