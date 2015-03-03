package br.com.managersystems.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.managersystems.entity.Product;

public interface ProductDao extends Dao<Product>{

	Product findById(Connection conn, Integer id) throws Exception;

	List<Product> listProductsByRestaurantId(Connection conn, Integer id) throws SQLException;

}
