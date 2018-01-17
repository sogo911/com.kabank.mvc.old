package com.kabank.mvc.daoImpl;


import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.KakaoBankDAO;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class KakaoBankDAOImpl implements KakaoBankDAO{
	public static KakaoBankDAO getInstance() {   // 싱글톤 패턴
		return new KakaoBankDAOImpl();
	}

	@Override
	public void makeAccountNum() {
		System.out.println("=========KAKAO-D: makeAccountNum IN===========");
		System.out.println("받은 커스텀번호 :"+InitCommand.cmd.getData());
		System.out.println("받은 계좌번호 :"+InitCommand.cmd.getColumn());
		StringBuffer sql = new StringBuffer(DMLEnum.INSERT_ACCOUNTNUM.toString());
		try {
			DatabaseFactory.create(Vendor.ORALCE)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(sql.toString(), InitCommand.cmd.getData(), InitCommand.cmd.getColumn()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=========KAKAO-D: makeAccountNum OUT===========");
	}
}
