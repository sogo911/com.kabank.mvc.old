package com.kabank.mvc.command;

import java.util.Random;

public class MakeKakaoCommand implements IOrder{
	Random r;
	int customNum;
	int accountNum;
	public MakeKakaoCommand() {}
	
	@Override
	public void execute() {
		Random r = new Random();
		boolean flag = true;
		boolean flag1 = true;
		while(flag) {
			int temp = r.nextInt(10000);	//한번쓰고 말 변수들은 이렇게 바로 이닛을 해라
				if(temp>=1000) {
					customNum = temp;
					flag = false;
				}else {
					flag = true;
				}
		}
		InitCommand.cmd.setData(String.valueOf(customNum));
		// Q. 100000~999999 6자리가 만들어지면 빠져나와라
		while(flag1) {
			int temp = r.nextInt(1000000);	//한번쓰고 말 변수들은 이렇게 바로 이닛을 해라
				if(temp>=100000) {
					accountNum = temp;
					flag1 = false;
				}else {
					flag1 = true;
				}
		}
		InitCommand.cmd.setColumn(String.valueOf(accountNum));
	}
}