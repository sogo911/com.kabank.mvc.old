package com.kabank.mvc.util;

import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.MemberEnum;

public class MainTest {
	public static void main(String[] args) {
		for(Enums.MemberColumn c: Enums.MemberColumn.values()) { // 상수풀처럼 사용되는 형식이지만 힙영역에 저장되고있다.
			System.out.println("컬럼맵 :"+c);
		}
		StringBuffer buff = new StringBuffer(DMLEnum.SELECT.toString());
		System.out.println("기본 버프 :" +buff);
		buff.insert(6, " "+MemberEnum.PROPERTIES.toString());
		System.out.println("추가된 버프 :" + buff);
	}
}
