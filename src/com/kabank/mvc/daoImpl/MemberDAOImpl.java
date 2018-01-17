package com.kabank.mvc.daoImpl;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.OracleEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class MemberDAOImpl implements MemberDAO{
	public static MemberDAO getInstance() {
		return new MemberDAOImpl();
	}
	private MemberDAOImpl() {
		try {
			Class.forName(OracleEnum.ORACLE_DRIVER.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberBean> selectMembers() {
		List<MemberBean> members = new ArrayList<>();
		try {
			StringBuffer buff = new StringBuffer(DMLEnum.SELECT.toString());
			buff.insert(12,TnameEnum.MEMBER.toString());
			buff.insert(6, " "+ MemberEnum.ID.toString()+","+ MemberEnum.PASS.toString());
			ResultSet rs = DriverManager.getConnection(
					OracleEnum.ORACLE_CONNECTION_URL.getValue(),
					OracleEnum.ORACLE_USERNAME.getValue(),
					OracleEnum.ORACLE_PASSWORD.getValue())
			.createStatement()
			.executeQuery(buff.toString());
			while (rs.next()) {
				MemberBean m = new MemberBean();
				String id = rs.getString(MemberEnum.ID.toString());
				String pass = rs.getString(MemberEnum.PASS.toString());
				m.setId(id);
				m.setPass(pass);
				members.add(m);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return members;
		
		
	}

	@Override
	public MemberBean selectMemberById(MemberBean m) {
		System.out.println("====DAOImpl selectMemberById====");
		System.out.println("DAO ID : "+m.getId());
		System.out.println("DAO PW : "+m.getPass());
		MemberBean mem = null ;
		try {
			StringBuffer buff = new StringBuffer(DMLEnum.WHERE.toString());
			buff.insert(20, MemberEnum.LOGIN.toString());
			buff.insert(13, " "+TnameEnum.MEMBER.toString());
			ResultSet rs = DriverManager.getConnection(
					OracleEnum.ORACLE_CONNECTION_URL.getValue(),
					OracleEnum.ORACLE_USERNAME.getValue(),
					OracleEnum.ORACLE_PASSWORD.getValue())
			.createStatement()
			.executeQuery(
					String.format(
							buff.toString(), m.getId(), m.getPass()));
		while(rs.next()) {
			mem = new MemberBean();
			mem.setId(rs.getString(MemberEnum.ID.toString()));
			mem.setPass(rs.getString(MemberEnum.PASS.toString()));
			mem.setName(rs.getString(MemberEnum.NAME.toString()));
			mem.setSsn(rs.getString(MemberEnum.SSN.toString()));
			mem.setPhone(rs.getString(MemberEnum.PHONE.toString()));
			mem.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
			mem.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
			mem.setAddr(rs.getString(MemberEnum.ADDR.toString()));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" 스펙 : "+m.toString());
		System.out.println("====DAOImpl selectMemberById OUT====");
		return mem;
	}
	@Override
	public MemberBean login() {
		System.out.println("=========MEMBER-D: LOGIN IN===========");
		StringBuffer sql = new StringBuffer(
				MemberEnum.LOGIN.toString());
		String[] arr = InitCommand.cmd.getData().split("/");
		System.out.println("ID: "+arr[0]);
		System.out.println("PASS: "+arr[1]);
		sql.replace(sql.indexOf("$"),sql.indexOf("$")+1, arr[0]);
		sql.replace(sql.indexOf("@"),sql.indexOf("@")+1, arr[1]);
		System.out.println("::::SQL::::" +sql.toString());
		MemberBean member = null;
		try {
			ResultSet rs = DatabaseFactory.create(Vendor.ORALCE)
					.getConnection()
					.createStatement()
					.executeQuery(sql.toString());
			while (rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString(MemberEnum.ID.toString()));
				member.setPass(rs.getString(MemberEnum.PASS.toString()));
				member.setName(rs.getString(MemberEnum.NAME.toString()));
				member.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
				member.setAddr(rs.getString(MemberEnum.ADDR.toString()));
				member.setPhone(rs.getString(MemberEnum.PHONE.toString()));
				member.setSsn(rs.getString(MemberEnum.SSN.toString()));
				member.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=========MEMBER-D: LOGIN OUT===========");
		return member;
/*		return (MemberBean) new ExecuteQuery(
					new LoginQuery())
				.execute();*/
	}

	@Override
	public void updatePass(MemberBean member) {
		System.out.println("=========MEMBER-D: updatePass IN===========");
		StringBuffer sql = new StringBuffer(DMLEnum.CHANGE_PASS.toString());
		try {
			DatabaseFactory.create(Vendor.ORALCE)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(sql.toString(), member.getPass(),member.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=========MEMBER-D: updatePass OUT===========");
	}
	@Override
	public void deleteMember(MemberBean member) {
		System.out.println("=========MEMBER-D: DeleteMember IN===========");
		StringBuffer sql = new StringBuffer(DMLEnum.DELETE_MEMBER.toString());
		try {
			DatabaseFactory.create(Vendor.ORALCE)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(sql.toString(), member.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=========MEMBER-D: DeleteMember OUT===========");
	}
	@Override
	public void makeMember() {
		System.out.println("=========MEMBER-D: makeMember IN===========");
		String[] arr = InitCommand.cmd.getData().split("/");
		StringBuffer sql = new StringBuffer(DMLEnum.INSERT_MEMBER.toString());
		try {
			DatabaseFactory.create(Vendor.ORALCE)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(sql.toString(),arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=========MEMBER-D: makeMember OUT===========");
	}
}
	//DAO한태 멤버스 전체리스트를 달라고 한다. List<> d = dao.selectMembers();
	//컨트롤러에서 받은 ID,PW를 멤버DAO와 멤버DAO임플을 이용하여 회원목록과 비교한다.