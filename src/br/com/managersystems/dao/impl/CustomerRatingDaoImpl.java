package br.com.managersystems.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.managersystems.dao.CustomerRatingDao;
import br.com.managersystems.entity.Customer;
import br.com.managersystems.entity.CustomerRating;
import br.com.managersystems.entity.Rating;
import br.com.managersystems.util.Constant;

public class CustomerRatingDaoImpl implements CustomerRatingDao{

	@Override
	public void insert(Connection conn, CustomerRating customerRating) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.INSERT_CUSTOMER_RATING,
				Statement.RETURN_GENERATED_KEYS)) {
			ps.setInt(1, customerRating.getCustomer().getId());
			ps.setInt(2, customerRating.getRating().getId());
			ps.executeUpdate();
		}

	}

	@Override
	public void update(Connection conn, CustomerRating customerRating) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.UPDATE_CUSTOMER_RATING)) {
			ps.setInt(1, customerRating.getCustomer().getId());
			ps.setInt(2, customerRating.getRating().getId());
			ps.setInt(3, customerRating.getCustomer().getId());
			ps.setInt(4, customerRating.getRating().getId());
			ps.executeUpdate();
		}

	}

	@Override
	public void delete(Connection conn, CustomerRating customerRating) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.DELETE_CUSTOMER_RATING)) {
			ps.setInt(1, customerRating.getCustomer().getId());
			ps.setInt(2, customerRating.getRating().getId());
			ps.executeUpdate();
		}

	}

	@Override
	public List<CustomerRating> list(Connection conn) throws Exception {
		ArrayList<CustomerRating> customerRatingList = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(Constant.LIST_CUSTOMER_RATING)) {
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					int idCustomer = rs.getInt("id_customer");
					int idRating = rs.getInt("id_rating");
					CustomerRating customerRating = new CustomerRating(new Customer(idCustomer), new Rating(idRating));
					customerRatingList.add(customerRating);
				}
			}
		}
		return customerRatingList;
	}

	@Override
	public void delete(Connection conn, Integer id) throws Exception {
		// TODO Auto-generated method stub

	}




}
