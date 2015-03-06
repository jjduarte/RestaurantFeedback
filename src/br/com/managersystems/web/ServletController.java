package br.com.managersystems.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.managersystems.dao.ConnectionPool;
import br.com.managersystems.services.Service;

@WebServlet(urlPatterns="/controller")
public class ServletController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Connection conn = new ConnectionPool().getConnection();

		String servlet = req.getParameter("servlet");
		String agent = req.getParameter("agent");
		String action = req.getParameter("action");

		if(servlet == null|| agent == null){
			throw new IllegalArgumentException("Faltou algum parametro!");
		}

		String servletName = "br.com.managersystems.web." + servlet;
		String agentName = "br.com.managersystems.services.impl." + agent;

		try {
			PrintWriter writer = resp.getWriter();
			Class servletClass = Class.forName(servletName);
			Popup instance = (Popup) servletClass.newInstance();

			Class agentClass = Class.forName(agentName);
			Service services = (Service) agentClass.newInstance();

			if(action.equals("insert")){
				services.insert(conn, instance.popup(req, resp));
			} else if (action.equals("list")){
				instance.list(services.list(conn), req, resp);
			}

			writer.print("<html><body>Foi inserido com sucesso!</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
