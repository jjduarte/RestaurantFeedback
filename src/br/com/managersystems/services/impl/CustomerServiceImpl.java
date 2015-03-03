package br.com.managersystems.services.impl;

import java.sql.Connection;
import java.util.List;

import br.com.managersystems.dao.CustomerDao;
import br.com.managersystems.dao.impl.CustomerDaoImpl;
import br.com.managersystems.entity.Customer;
import br.com.managersystems.exceptions.CustomerRatingException;
import br.com.managersystems.services.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void insert(Connection conn, Customer customer) throws Exception {
		conn.setAutoCommit(false);
		if (customer != null) {
			try {
				CustomerDao customerDaoImpl = new CustomerDaoImpl();
				customerDaoImpl.insert(conn, customer);
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} 
			conn.commit();
		} else {
			throw new CustomerRatingException("Insert customer fails");
		}

	}

	@Override
	public void update(Connection conn, Customer customer) throws Exception {
		conn.setAutoCommit(false);
		if (customer != null) {
			try {
				CustomerDao customerDaoImpl = new CustomerDaoImpl();
				customerDaoImpl.update(conn, customer);
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} 
			conn.commit();
		} else {
			throw new CustomerRatingException("Update customer fails");
		}

	}

	@Override
	public void delete(Connection conn, Integer id) throws Exception {
		try {
			CustomerDao customerDaoImpl = new CustomerDaoImpl();
			customerDaoImpl.delete(conn, id);
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} 

	}

	@Override
	public List<Customer> list(Connection conn) throws Exception {
		CustomerDao customerDaoImpl = new CustomerDaoImpl();
		return customerDaoImpl.list(conn);
	}

	@Override
	public Customer findById(Connection conn, int id) throws Exception {
		Customer customer = null;
		try {
			CustomerDao customerDaoImpl = new CustomerDaoImpl();
			customer = customerDaoImpl.findById(conn, id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return customer;

	}

	@Override
	public Customer findByLoginAndPassword(Connection conn, String login, String password) throws Exception {
		Customer customer = null;
		try {
			CustomerDao customerDaoImpl = new CustomerDaoImpl();
			customer = customerDaoImpl.findByLoginAndPassword(conn, login, password);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return customer;
	}

}
