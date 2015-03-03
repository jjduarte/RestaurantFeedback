package br.com.managersystems.dao;

import java.sql.Connection;

import br.com.managersystems.entity.Restaurant;

public interface RestaurantDao extends Dao<Restaurant>{

	Restaurant findById(Connection conn, Integer id) throws Exception;

}
