package br.com.managersystems.dao;

import java.sql.Connection;

import br.com.managersystems.entity.CustomerRating;

public interface CustomerRatingDao extends Dao<CustomerRating>{

	void delete(Connection conn, CustomerRating customer) throws Exception;
}
