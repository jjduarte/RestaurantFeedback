package br.com.managersystems.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.managersystems.dao.RestaurantDao;
import br.com.managersystems.entity.Restaurant;
import br.com.managersystems.util.Constant;

public class RestaurantDaoImpl implements RestaurantDao{

	@Override
	public void insert(Connection conn, Restaurant restaurant) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.INSERT_RESTAURANT)) {
			ps.setString(1, restaurant.getName());
			ps.setString(2, restaurant.getCnpj());
			ps.setString(3, restaurant.getLogin());
			ps.setString(4, restaurant.getPassword());

			ps.executeUpdate();
		}
	}

	@Override
	public void update(Connection conn, Restaurant restaurant) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.UPDATE_RESTAURANT)) {
			ps.setString(1, restaurant.getName());
			ps.setString(2, restaurant.getCnpj());
			ps.setString(3, restaurant.getLogin());
			ps.setString(4, restaurant.getPassword());
			ps.setInt(5, restaurant.getId());
			ps.executeUpdate();
		}
	}

	@Override
	public void delete(Connection conn, Integer id) throws Exception {
		try(PreparedStatement ps = conn.prepareStatement(Constant.DELETE_RESTAURANT)){
			ps.setInt(1, id);
			ps.execute();
		}
	}

	@Override
	public List<Restaurant> list(Connection conn) throws Exception {
		List<Restaurant> restaurantList = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(Constant.LIST_RESTAURANT)) {
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					int idRestaurant = rs.getInt("id_restaurant");
					String name = rs.getString("name");
					String cnpj = rs.getString("cnpj");
					String login = rs.getString("login");
					String password = rs.getString("password");
					restaurantList.add( new Restaurant(idRestaurant, name, cnpj, login, password, null) );
				}
			}
		}
		return restaurantList;
	}

	@Override
	public Restaurant findById(Connection conn, Integer id) throws Exception {
		Restaurant restaurant = null;
		try (PreparedStatement ps = conn.prepareStatement(Constant.FIND_RESTAURANT_BY_ID)) {
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					int idRestaurant = rs.getInt("id_restaurant");
					String name = rs.getString("name");
					String cnpj = rs.getString("cnpj");
					String login = rs.getString("login");
					String password = rs.getString("password");
					restaurant = new Restaurant(idRestaurant, name, cnpj, login, password, null);
				}
			}
		}
		return restaurant;

	}





}
