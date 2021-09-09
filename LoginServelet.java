package com.javaservelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns={"/LoginServelet"},
		initParams= {
				@WebInitParam(name="user", value="Ram"),
				@WebInitParam(name="password", value="Apple")
		}
)

public class LoginServelet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=req.getParameter("user");
		String pwd=req.getParameter("pwd");
		
		String userID=getServletConfig().getInitParameter("user");
		String password=getServletConfig().getInitParameter("password");
		
		if (userID.equals(user) && password.equals(pwd)) {
			req.setAttribute("user",user);
			req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
		}else {
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out=resp.getWriter();
			out.println("Incorrect Enteries...Please Try Again");
			rd.include(req, resp);
			
			
		}
	}
}
