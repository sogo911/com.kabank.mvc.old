package com.kabank.mvc.domain;

import java.io.Serializable;

import lombok.Data;
@Data

public class BurgerkingBean implements Serializable{
	private String menu, price, count;

	@Override
	public String toString() {
		return "BurgerkinBean [상품명: " + menu + ", 가격: " + price + " 원, 수량: " + count + "]";
	}
	
}
