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

		String adiciona = req.getParameter("adiciona");
		String service = req.getParameter("service");

		if(adiciona == null|| service == null){
			throw new IllegalArgumentException("Faltou algum parametro!");
		}

		String nomeDaClasseAdiciona = "br.com.paripassu.core.web." + adiciona;
		String nomeDaClasseService = "br.com.paripassu.core.services.impl." + service;

		try {
			PrintWriter writer = resp.getWriter();
			Class classAdiciona = Class.forName(nomeDaClasseAdiciona);
			Popup instancia = (Popup) classAdiciona.newInstance();

			Class classsService = Class.forName(nomeDaClasseService);
			Service services = (Service) classsService.newInstance();

			services.insert(conn, instancia.popup(req, resp));

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
