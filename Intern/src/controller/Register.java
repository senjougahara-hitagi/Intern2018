package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import model.User;

public class Register extends HttpServlet {
	
    private String username;
    private String password;
    	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		username = req.getParameter("username");
		password = req.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		RegisterImp rimp = new RegisterImp();
		int i = rimp.registerUser(user);
		
		if(i > 0) {
			System.out.println("Success");
			JSONObject json = new JSONObject();
			try {
				json.put("REGISTER", "SUCCESS");
				PrintWriter pw = resp.getWriter();
				pw.print(json.toString());
				
				System.out.println("REGISTER successful: " + json.toString());
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
}
