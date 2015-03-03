package br.com.managersystems.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.managersystems.dao.ConnectionPool;
import br.com.managersystems.entity.Customer;
import br.com.managersystems.services.impl.CustomerServiceImpl;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet{

	final static Map<String, String> LOGGED_USERS = new HashMap<>();
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(Connection conn= new ConnectionPool().getConnection()){
			String login = req.getParameter("login");
			String password = req.getParameter("password");

			try {
				Customer customer = new CustomerServiceImpl().findByLoginAndPassword(conn, login, password);
				PrintWriter writer = resp.getWriter();
				if(customer == null){
					writer.println("<html><body>Invalid User</body></html>");
				} else {
					HttpSession session = req.getSession();
					session.setAttribute("usuer", customer);
					writer.println("<html><body>User logged: "+ login +"</body></html>");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		} 

	}


}
