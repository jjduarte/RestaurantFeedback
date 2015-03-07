package br.com.managersystems.web;

import java.sql.Connection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.managersystems.dao.ConnectionPool;
import br.com.managersystems.services.ProductService;
import br.com.managersystems.services.impl.ProductServiceImpl;

@Controller
public class ProductController {

	@RequestMapping("/listProducts")
	public String listProducs(Model model){

		Connection conn = new ConnectionPool().getConnection();
		ProductService service = new ProductServiceImpl();

		try {
			model.addAttribute("productList", service.list(conn));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "products/list-products";
	}
}
