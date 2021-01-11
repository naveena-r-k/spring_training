package com.zensar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utility.DBUtil;

public class DemoRepository {

	public boolean validateLogin(String userName,String password) {
		
		boolean result=false;
		String user;
		String pwd = null;
		Connection con= DBUtil.getMysqlDbConnection();
		String sql="select * from login where user_id=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet resultSet=pst.executeQuery();
			while (resultSet.next()) {
				user=resultSet.getString("user_id");
				pwd=resultSet.getString("password");
			}
			if (password.equals(pwd)) {
				result=true;
			} else {
				result=false;
			}
		} catch (Exception e) {
			result=false;
			System.out.println("Exception occured:"+e);
		}
		
		return result;
	}
}
