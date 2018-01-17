package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.iterator.ParamsIterator;

public class JoinCommand implements IOrder{
	Map<?,?> map;
	public JoinCommand(HttpServletRequest request) {
		map = ParamsIterator.execute(request);
	}
	@Override
	public void execute() {
		String id = String.valueOf(map.get("id"));
		String pass = String.valueOf(map.get("pass"));
		String name = String.valueOf(map.get("name"));
		String ssn = String.valueOf(map.get("ssn"));
		String phone = String.valueOf(map.get("phone"));
		String profile = "";
		String email = String.valueOf(map.get("email"));
		String addr = String.valueOf(map.get("addr"));
		InitCommand.cmd.setData(
				id+"/"+pass+"/"+name+"/"+ssn+"/"+phone+"/"
				+profile+"/"+email+"/"+addr);
	}
}
