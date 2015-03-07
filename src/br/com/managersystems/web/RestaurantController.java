package br.com.managersystems.web;

import java.sql.Connection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.managersystems.dao.ConnectionPool;
import br.com.managersystems.services.RestaurantService;
import br.com.managersystems.services.impl.RestaurantServiceImpl;

@Controller
public class RestaurantController {

	@RequestMapping("/restaurantList")
	public String listAllRestaurants(Model model){
		Connection conn = new ConnectionPool().getConnection();
		RestaurantService service = new RestaurantServiceImpl();

		try {
			model.addAttribute("list", service.list(conn));
		} catch (Exception e) {
			e.printStackTrace();
		}


		return "restaurant/restaurant-list";
	}
}
