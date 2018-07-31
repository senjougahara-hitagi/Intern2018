package controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;
import utils.MySQLUtils;

public class LoginImp {
	private String sql = "SELECT * from intern.accounts WHERE username = ? AND password = ?";
	
	private ArrayList<User> userDataList = new ArrayList<>();

	public ArrayList<User> loginUser(User user) {
		
		try {			
			PreparedStatement ps = MySQLUtils.connect().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User resultUser = new User();
				resultUser.setUsername(rs.getString(1));
				resultUser.setPassword(rs.getString(2));
				
				userDataList.add(resultUser);
				
				System.out.println("User data was get!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDataList;
	}

}
