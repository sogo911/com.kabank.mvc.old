package com.kabank.mvc.daoImpl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.constant.DBMS;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;

public class MemberDAOImpl implements MemberDAO{
	
	@Override
	public List<MemberBean> selectMembers() {
		List<MemberBean> members = new ArrayList<>();
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL,DBMS.ORACLE_USERNAME,DBMS.ORACLE_PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT id, pass FROM Member";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MemberBean m = new MemberBean();
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				m.setId(id);
				m.setPass(pass);
				members.add(m);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return members;
		
		
	}
}
	//DAO한태 멤버스 전체리스트를 달라고 한다. List<> d = dao.selectMembers();
	//컨트롤러에서 받은 ID,PW를 멤버DAO와 멤버DAO임플을 이용하여 회원목록과 비교한다.