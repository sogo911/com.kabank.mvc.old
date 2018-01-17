package com.kabank.mvc.daoImpl;

import java.sql.DriverManager;

import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.enums.OracleEnum;

public class AdminDAOImpl implements AdminDAO{
	@Override
	public void selectAdminTable(String sql) {
		try {
			Class.forName(OracleEnum.ORACLE_DRIVER.getValue());
			DriverManager.getConnection(
					OracleEnum.ORACLE_CONNECTION_URL.getValue(),
					OracleEnum.ORACLE_USERNAME.getValue(),
					OracleEnum.ORACLE_PASSWORD.getValue())
			.createStatement()
			.executeUpdate(sql);
			System.out.println("넘어온 sql : "+ sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
