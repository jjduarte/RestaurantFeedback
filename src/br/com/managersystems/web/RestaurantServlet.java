package br.com.managersystems.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.managersystems.entity.Restaurant;

public class RestaurantServlet implements Popup<Restaurant>{

	public static final String RESTAURANT_LIST = "restaurantList.jsp";

	@Override
	public Restaurant popup(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void list(List<Restaurant> list, HttpServletRequest req, HttpServletResponse resp) {

		req.setAttribute("lista", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/" + RESTAURANT_LIST);
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
