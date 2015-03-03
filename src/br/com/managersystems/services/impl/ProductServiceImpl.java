package br.com.managersystems.services.impl;

import java.sql.Connection;
import java.util.List;

import br.com.managersystems.dao.ProductDao;
import br.com.managersystems.dao.impl.ProductDaoImpl;
import br.com.managersystems.entity.Product;
import br.com.managersystems.exceptions.ProductException;
import br.com.managersystems.services.ProductService;
import br.com.managersystems.services.RestaurantService;

public class ProductServiceImpl implements ProductService{

	@Override
	public void insert(Connection conn, Product product) throws Exception {
		conn.setAutoCommit(false);
		if (product != null) {
			try {
				ProductDao productDaoImpl = new ProductDaoImpl();
				productDaoImpl.insert(conn, product);
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} 
			conn.commit();
		} else {
			throw new ProductException("Insert product fails");
		}
	}

	@Override
	public void update(Connection conn, Product product) throws Exception {
		conn.setAutoCommit(false);
		if (product != null) {
			try {
				ProductDao productDaoImpl = new ProductDaoImpl();
				productDaoImpl.update(conn, product);
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} 
			conn.commit();
		} else {
			throw new ProductException("Update product fails");
		}

	}

	@Override
	public void delete(Connection conn, Integer id) throws Exception {
		if(id != null){
			try {
				ProductDao productDaoImpl = new ProductDaoImpl();
				productDaoImpl.delete(conn, id);
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} 			
		} else {
			throw new ProductException("Delete product fails");
		}

	}

	@Override
	public List<Product> list(Connection conn) throws Exception {
		ProductDao customerDaoImpl = new ProductDaoImpl();
		return customerDaoImpl.list(conn);
	}

	@Override
	public Product findById(Connection conn, Integer id) {
		Product product = null;
		try {
			ProductDao productDaoImpl = new ProductDaoImpl();
			product = productDaoImpl.findById(conn, id);

			RestaurantService restaurantService = new RestaurantServiceImpl();
			product.setRestaurant(restaurantService.findById(conn, product.getRestaurant().getId()));

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return product;

	}

	@Override
	public List<Product> listProductsByRestaurantId(Connection conn, Integer id) {
		List<Product> productsList = null;
		try {
			ProductDao productDaoImpl = new ProductDaoImpl();
			productsList = productDaoImpl.listProductsByRestaurantId(conn, id);

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return productsList;

	}


}
