package br.com.managersystems.services.impl;

import java.sql.Connection;
import java.util.List;

import br.com.managersystems.dao.CustomerRatingDao;
import br.com.managersystems.dao.impl.CustomerRatingDaoImpl;
import br.com.managersystems.entity.CustomerRating;
import br.com.managersystems.services.CustomerRatingService;
import br.com.managersystems.services.CustomerService;
import br.com.managersystems.services.RatingService;

public class CustomerRatingServiceImpl implements CustomerRatingService{

	@Override
	public void insert(Connection conn, CustomerRating object) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Connection conn, CustomerRating object) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection conn, Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CustomerRating> list(Connection conn) throws Exception {
		CustomerRatingDao customerRatingDaoImpl = new CustomerRatingDaoImpl();
		List<CustomerRating> customerRatingList = customerRatingDaoImpl.list(conn);
		CustomerService customerServiceImpl = new CustomerServiceImpl();
		RatingService ratingServiceImpl = new RatingServiceImpl();

		for (CustomerRating customerRating : customerRatingList) {
			customerRating.setCustomer(customerServiceImpl.findById(conn, customerRating.getCustomer().getId()));
			customerRating.setRating(ratingServiceImpl.findById(conn, customerRating.getRating().getId()));
		}

		return customerRatingList;
	}


}
