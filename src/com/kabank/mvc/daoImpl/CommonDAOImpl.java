package com.kabank.mvc.daoImpl;

import com.kabank.mvc.constant.CommonSql;
import com.kabank.mvc.constant.DBMS;
import com.kabank.mvc.dao.CommonDAO;
import java.sql.*;

public class CommonDAOImpl implements CommonDAO{
	@Override
	public String selectTableCount() {
		String count = "";
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(
					DBMS.ORACLE_CONNECTION_URL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD);
			Statement stmt = conn.createStatement();
			/*String sql = com.getCommonSQL("Member");
			System.out.println("실행할 쿼리:"+sql);*/
			ResultSet rs = stmt.executeQuery(CommonSql.getCommonSQL("Member"));
			while(rs.next()) {
				count = rs.getString("count");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

}
