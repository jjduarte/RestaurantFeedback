package br.com.managersystems.web;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.managersystems.dao.ConnectionPool;
import br.com.managersystems.entity.Customer;
import br.com.managersystems.services.CustomerService;
import br.com.managersystems.services.impl.CustomerServiceImpl;

@Controller
public class LoginController {

	@RequestMapping("/loginForm")
	public String formLogin() {
		return "user/login";
	}

	@RequestMapping("/login")
	public String efetuaLogin(Customer customer, HttpSession session) {
		Connection conn = new ConnectionPool().getConnection();
		CustomerService service = new CustomerServiceImpl();
		Customer c = null;

		try {
			c = service.findByLoginAndPassword(conn, customer.getLogin(), customer.getPassword());
			if (c != null) {
				session.setAttribute("usuarioLogado", c);
				return "menu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:loginForm";
	}

	@RequestMapping("/efetuaLogout")
	public String efetuaLogout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}

}
