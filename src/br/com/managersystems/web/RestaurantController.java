package br.com.managersystems.web;

import java.sql.Connection;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.managersystems.dao.ConnectionPool;
import br.com.managersystems.entity.Restaurant;
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

	@RequestMapping("/restaurantForm")
	public String restaurantForm(){
		return "restaurant/restaurant-form";
	}


	@RequestMapping("/insertRestaurant")
	public String insertRestaurant(@Valid Restaurant restaurant, BindingResult result, Model model){
		if(result.hasErrors()){
			return "restaurant-form";
		}

		Connection conn = new ConnectionPool().getConnection();
		RestaurantService service = new RestaurantServiceImpl();
		try {
			service.insert(conn, restaurant);
			model.addAttribute("restaurant", restaurant);
		} catch (Exception e) {
			e.printStackTrace();
		}



		return "products/product-form";
	}

}
