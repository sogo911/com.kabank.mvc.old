package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.KakaoBankDAOImpl;
import com.kabank.mvc.service.KakaoBankService;

public class KakaoBankServiceImpl implements KakaoBankService{
	public static KakaoBankService getInstance() {
		return new KakaoBankServiceImpl();
	}

	@Override
	public void makeAccount() {
		KakaoBankDAOImpl.getInstance().makeAccountNum();
	}
}
