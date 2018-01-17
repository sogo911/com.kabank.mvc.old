package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dacorate.IQuery;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.MemberProps;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.PropertiesFactory;
import com.kabank.mvc.util.Enums.Table;

public class LoginQuery implements IQuery{
	PreparedStatement pstmt;
	public LoginQuery() {
		try {
			pstmt = DatabaseFactory.create(Vendor.ORALCE)
					.getConnection()
					.prepareStatement(
							DML.SELECT
							+" "
							+PropertiesFactory.create(MemberProps.values())
							+" "
							+DML.FROM
							+" "
							+Table.MEMBER
							+" "
							+DML.WHERE
							+" id LIKE ? AND pass LIKE ?");
			String[] arr = InitCommand.cmd.getData().split("/");
			for(int i = 0;i<arr.length; i++) {
				pstmt.setString((i+1), arr[i]);
				System.out.println("인덱스 값"+(i+1));
				System.out.println("입력 값"+arr[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Object execute() {
		MemberBean member = null;
		try {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString(MemberEnum.ID.toString()));
				member.setPass(rs.getString(MemberEnum.PASS.toString()));
				member.setName(rs.getString(MemberEnum.NAME.toString()));
				member.setSsn(rs.getString(MemberEnum.SSN.toString()));
				member.setPhone(rs.getString(MemberEnum.PHONE.toString()));
				member.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
				member.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
				member.setAddr(rs.getString(MemberEnum.ADDR.toString()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
