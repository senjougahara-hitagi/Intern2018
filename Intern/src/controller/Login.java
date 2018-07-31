package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.User;

public class Login extends HttpServlet {
	
	private String username;
    private String password;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		username = req.getParameter("username");
		password = req.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		LoginImp limp = new LoginImp();
		ArrayList<User> userData = limp.loginUser(user);
		
		for(User u : userData) {
			
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				JSONArray json = new JSONArray(userData);
				PrintWriter pw = resp.getWriter();
				
				pw.print(json.toString());
				
				System.out.println("JSONArray data " + json.toString());
			}
		}
	}
}
