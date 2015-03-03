package br.com.managersystems.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.managersystems.dao.CustomerDao;
import br.com.managersystems.entity.Customer;
import br.com.managersystems.util.Constant;
import br.com.managersystems.util.DateConverter;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void insert(Connection conn, Customer customer) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.INSERT_CUSTOMER,
				Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getCpf());
			ps.setDate(3, new java.sql.Date(customer.getDateOfBirth().getTimeInMillis()));
			ps.setString(4, customer.getLogin());
			ps.setString(5, customer.getPassword());

			ps.executeUpdate();
		}

	}

	@Override
	public void update(Connection conn, Customer customer) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.UPDATE_CUSTOMER,
				Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getCpf());
			ps.setDate(3, new java.sql.Date(customer.getDateOfBirth().getTimeInMillis()));
			ps.setString(4, customer.getLogin());
			ps.setString(5, customer.getPassword());
			ps.setInt(6, customer.getId());

			ps.executeUpdate();
		}

	}

	@Override
	public void delete(Connection conn, Integer id) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.DELETE_CUSTOMER,
				Statement.RETURN_GENERATED_KEYS)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		}

	}

	@Override
	public List<Customer> list(Connection conn) throws Exception {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try (PreparedStatement ps = conn.prepareStatement(Constant.LIST_CUSTOMER)) {
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					String nome = rs.getString("name");
					String cpf = rs.getString("cpf");
					Date dateOfBirth = rs.getDate("date_of_birth");
					String login = rs.getString("login");
					String password = rs.getString("password");
					int id = rs.getInt("id_customer");
					Customer customer = new Customer (id, nome, cpf, new DateConverter().dateToCalendar(dateOfBirth), login, password);
					customerList.add(customer);
				}
			}


		}

		return customerList;
	}

	@Override
	public Customer findById(Connection conn, Integer idCustomer) throws Exception {
		Customer customer = null;
		try (PreparedStatement ps = conn.prepareStatement(Constant.FIND_BY_ID_CUSTOMER)) {
			ps.setInt(1, idCustomer);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					String nome = rs.getString("name");
					String cpf = rs.getString("cpf");
					Date dateOfBirth = rs.getDate("date_of_birth");
					String login = rs.getString("login");
					String password = rs.getString("password");
					int id = rs.getInt("id_customer");
					customer = new Customer (id, nome, cpf, new DateConverter().dateToCalendar(dateOfBirth), login, password);
				}
			}
		}
		return customer;
	}

	@Override
	public Customer findByLoginAndPassword(Connection conn, String login, String password) throws SQLException {
		Customer customer = null;
		try (PreparedStatement ps = conn.prepareStatement(Constant.FIND_CUSTOMER_BY_LOGIN_PASSWORD)) {
			ps.setString(1, login);
			ps.setString(2, password);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					String nome = rs.getString("name");
					String cpf = rs.getString("cpf");
					Date dateOfBirth = rs.getDate("date_of_birth");
					String log = rs.getString("login");
					String pass = rs.getString("password");
					int id = rs.getInt("id_customer");
					customer = new Customer (id, nome, cpf, new DateConverter().dateToCalendar(dateOfBirth), log, pass);
				}
			}
		}
		return customer;
	}


}
