package br.com.managersystems.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.managersystems.dao.ProductDao;
import br.com.managersystems.entity.Product;
import br.com.managersystems.entity.Restaurant;
import br.com.managersystems.util.Constant;

public class ProductDaoImpl implements ProductDao{

	@Override
	public void insert(Connection conn, Product product) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.INSERT_PRODUCT)) {
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setString(3, product.isAvailable() ? "T" : "F");
			ps.setString(4, product.getPhoto());
			ps.setInt(5, product.getRestaurant().getId());

			ps.executeUpdate();
		}

	}

	@Override
	public void update(Connection conn, Product product) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.UPDATE_PRODUCT)) {
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setString(3, product.isAvailable() ? "T" : "F");
			ps.setString(4, product.getPhoto());
			ps.setInt(5, product.getRestaurant().getId());
			ps.setInt(6, product.getId());

			ps.executeUpdate();
		}

	}

	@Override
	public void delete(Connection conn, Integer id) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.DELETE_PRODUCT)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		}
	}

	@Override
	public List<Product> list(Connection conn) throws Exception {
		List<Product> productsList = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(Constant.LIST_PRODUCT)) {
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					int idProduct = rs.getInt("id_product");
					String nome = rs.getString("name");
					String description = rs.getString("description");
					boolean available = rs.getString("available").equalsIgnoreCase("T") ? true : false;
					String photo = rs.getString("photo");
					Restaurant restaurant = new Restaurant(rs.getInt("id_restaurant"));
					productsList.add(new Product(idProduct, nome, description, available, photo, restaurant));
				}
			}
		}
		return productsList;
	}

	@Override
	public Product findById(Connection conn, Integer id) throws Exception{
		Product product = null;
		try (PreparedStatement ps = conn.prepareStatement(Constant.FIND_BY_ID_PRODUCT)) {
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					int idProduct = rs.getInt("id_product");
					String nome = rs.getString("name");
					String description = rs.getString("description");
					boolean available = rs.getString("available").equalsIgnoreCase("T") ? true : false;
					String photo = rs.getString("photo");
					Restaurant restaurant = new Restaurant(rs.getInt("id_restaurant"));
					product = new Product(idProduct, nome, description, available, photo, restaurant);
				}
			}
		}
		return product;
	}

	@Override
	public List<Product> listProductsByRestaurantId(Connection conn, Integer id) throws SQLException {
		List<Product> productsList = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(Constant.LIST_PRODUCT_BY_RESTAURANT_ID)) {
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					int idProduct = rs.getInt("id_product");
					String nome = rs.getString("name");
					String description = rs.getString("description");
					boolean available = rs.getString("available").equalsIgnoreCase("T") ? true : false;
					String photo = rs.getString("photo");
					Restaurant restaurant = new Restaurant(rs.getInt("id_restaurant"));
					productsList.add(new Product(idProduct, nome, description, available, photo, restaurant));
				}
			}
		}
		return productsList;
	}

}
