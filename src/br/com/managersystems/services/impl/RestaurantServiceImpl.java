package br.com.managersystems.services.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.managersystems.dao.RestaurantDao;
import br.com.managersystems.dao.impl.RestaurantDaoImpl;
import br.com.managersystems.entity.Restaurant;
import br.com.managersystems.exceptions.RestaurantException;
import br.com.managersystems.services.ProductService;
import br.com.managersystems.services.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService{

	@Override
	public void insert(Connection conn, Restaurant restaurant) throws Exception {
		conn.setAutoCommit(false);
		if (restaurant != null) {
			try {
				RestaurantDao restaurantDaoImpl = new RestaurantDaoImpl();
				restaurantDaoImpl.insert(conn, restaurant);
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} 
			conn.commit();
		} else {
			throw new RestaurantException("Insert restaurant fails");
		}

	}

	@Override
	public void update(Connection conn, Restaurant restaurant) throws Exception {
		conn.setAutoCommit(false);
		if (restaurant != null) {
			try {
				RestaurantDao restaurantDaoImpl = new RestaurantDaoImpl();
				restaurantDaoImpl.insert(conn, restaurant);
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} 
			conn.commit();
		} else {
			throw new RestaurantException("Update restaurant fails");
		}

	}

	@Override
	public void delete(Connection conn, Integer id) throws Exception {
		conn.setAutoCommit(false);
		if (id != null) {
			try {
				RestaurantDao restaurantDaoImpl = new RestaurantDaoImpl();
				restaurantDaoImpl.delete(conn, id);
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} 
			conn.commit();
		} else {
			throw new RestaurantException("Delete restaurant fails");
		}

	}

	@Override
	public List<Restaurant> list(Connection conn) throws Exception {
		List<Restaurant> restaurantList = new ArrayList<>();
		try {
			RestaurantDao restaurantDaoImpl = new RestaurantDaoImpl();
			restaurantList = restaurantDaoImpl.list(conn);

			ProductService productService = new ProductServiceImpl();
			for (Restaurant restaurant : restaurantList) {
				restaurant.setProducts(productService.listProductsByRestaurantId(conn, restaurant.getId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return restaurantList;
	}

	@Override
	public Restaurant findById(Connection conn, int id) {
		Restaurant restaurant = null;
		try {
			RestaurantDao restaurantDaoImpl = new RestaurantDaoImpl();
			restaurant = restaurantDaoImpl.findById(conn, id);

			ProductService productService = new ProductServiceImpl();
			restaurant.setProducts(productService.listProductsByRestaurantId(conn, restaurant.getId()));

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return restaurant;
	}




}
