package br.com.managersystems.dao;

import java.sql.Connection;

import br.com.managersystems.entity.Customer;



public interface CustomerDao extends Dao<Customer>{
	Customer findById(Connection conn, Integer idCustomer) throws Exception;

	Customer findByLoginAndPassword(Connection conn, String login, String password) throws Exception;
}
