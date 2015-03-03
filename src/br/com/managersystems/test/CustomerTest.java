package br.com.managersystems.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.managersystems.dao.ConnectionPool;
import br.com.managersystems.entity.Customer;
import br.com.managersystems.services.CustomerService;
import br.com.managersystems.services.impl.CustomerServiceImpl;


public class CustomerTest {

	@Test
	public void insertCustomerTest() {
		boolean executou = false;
		Connection conn = new ConnectionPool().getConnection();


		Customer c1 = new Customer();
		c1.setName("teste1");
		c1.setCpf("000.000.000-00");
		c1.setDateOfBirth(Calendar.getInstance());
		c1.setLogin("testejoao");
		c1.setPassword("123");

		CustomerService customerService = new CustomerServiceImpl();
		try {
			customerService.insert(conn, c1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				executou = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		Assert.assertTrue(executou);

	}


	@Test
	public void listCustomerTest() {
		boolean executou = false;
		Connection conn = new ConnectionPool().getConnection();

		CustomerService customerService = new CustomerServiceImpl();
		try {
			List<Customer> list = customerService.list(conn);
			list.forEach(s -> System.out.println(s.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				executou = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		Assert.assertTrue(executou);

	}
}
