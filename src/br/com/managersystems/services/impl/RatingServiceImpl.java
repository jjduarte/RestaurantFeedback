package br.com.managersystems.services.impl;

import java.sql.Connection;
import java.util.List;

import br.com.managersystems.dao.RatingDao;
import br.com.managersystems.dao.impl.RatingDaoImpl;
import br.com.managersystems.entity.Rating;
import br.com.managersystems.services.ProductService;
import br.com.managersystems.services.RatingService;

public class RatingServiceImpl implements RatingService{

	@Override
	public void insert(Connection conn, Rating object) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Connection conn, Rating object) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection conn, Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Rating> list(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating findById(Connection conn, int id) {
		Rating rating = null;
		try {
			RatingDao ratingDaoImpl = new RatingDaoImpl();
			rating = ratingDaoImpl.findById(conn, id);
			ProductService productServiceImpl = new ProductServiceImpl();
			productServiceImpl.findById(conn, rating.getProduct().getId());


		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rating;
	}

}
