package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		System.out.println("액션팩토리 x :"+x);
		Action action = null;
		
		if(x==null || x.equals("") == true) {x="move";}
		System.out.println("ACTION FACTORY move 입력 x :" +x);
		switch(x) {
		case "move":action=Action.MOVE;
			break;
		case "login":action=Action.LOGIN;
			break;
		case "change_pass":action=Action.CHANGE_PASS;
			break;
		case "delete_member":action=Action.DELETE_MEMBER;
			break;
		case "join":action=Action.JOIN;
			break;
		case "make_kakao":action=Action.MAKE_KAKAO;
			break;
		default:
			action=Action.MOVE;
			break;
		}
		return action;
	}
}
