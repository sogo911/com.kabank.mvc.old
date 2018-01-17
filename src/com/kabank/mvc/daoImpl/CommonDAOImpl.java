package com.kabank.mvc.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kabank.mvc.dao.CommonDAO;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.OracleEnum;
import com.kabank.mvc.enums.TnameEnum;

public class CommonDAOImpl implements CommonDAO{
	@Override
	public String selectTableCount() {
		String count = "";
		try {
			Class.forName(OracleEnum.values().toString());
			Connection conn = DriverManager.getConnection(
					OracleEnum.values().toString(),
					OracleEnum.values().toString(),
					OracleEnum.values().toString());
			Statement stmt = conn.createStatement();
			/*String sql = com.getCommonSQL("Member");
			System.out.println("실행할 쿼리:"+sql);*/
			ResultSet rs = stmt.executeQuery(DMLEnum.COUNT.toString()+TnameEnum.MEMBER);
			while(rs.next()) {
				count = rs.getString("count");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

}
