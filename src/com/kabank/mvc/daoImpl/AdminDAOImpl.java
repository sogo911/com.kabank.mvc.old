package com.kabank.mvc.daoImpl;

import com.kabank.mvc.constant.DBMS;
import com.kabank.mvc.dao.AdminDAO;
import java.sql.*;

public class AdminDAOImpl implements AdminDAO{
	@Override
	public void selectAdminTable(String sql) {
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(
					DBMS.ORACLE_CONNECTION_URL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("넘어온 sql : "+ sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
