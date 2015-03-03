package br.com.managersystems.services;

import java.sql.Connection;

import br.com.managersystems.entity.Customer;

public interface CustomerService extends Service<Customer>{

	Customer findById(Connection conn, int id) throws Exception;

	Customer findByLoginAndPassword(Connection conn, String login, String password) throws Exception;

}
