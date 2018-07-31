package controller;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;
import utils.MySQLUtils;

public class RegisterImp {
	private String sql = "INSERT into intern.accounts (username, password) VALUES (?, ?)";
	private int i;

	public int registerUser(User user) {
		try {			
			PreparedStatement ps = MySQLUtils.connect().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
}
