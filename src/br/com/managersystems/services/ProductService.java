package br.com.managersystems.services;

import java.sql.Connection;
import java.util.List;

import br.com.managersystems.entity.Product;

public interface ProductService extends Service<Product>{

	Product findById(Connection conn, Integer id);

	List<Product> listProductsByRestaurantId(Connection conn, Integer id);

}
