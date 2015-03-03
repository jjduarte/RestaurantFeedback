package br.com.managersystems.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.managersystems.dao.RatingDao;
import br.com.managersystems.entity.Product;
import br.com.managersystems.entity.Rating;
import br.com.managersystems.util.Constant;
import br.com.managersystems.util.DateConverter;

public class RatingDaoImpl implements RatingDao{

	@Override
	public void insert(Connection conn, Rating rating) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.INSERT_RATING)) {
			ps.setInt(1, rating.getProduct().getId());
			ps.setInt(2, rating.getRating());
			ps.setString(3, rating.getComment());
			ps.setDate(4, new java.sql.Date(rating.getDate().getTimeInMillis()));

			ps.executeUpdate();
		}

	}

	@Override
	public void update(Connection conn, Rating rating) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.UPDATE_RATING)) {
			ps.setInt(1, rating.getProduct().getId());
			ps.setInt(2, rating.getRating());
			ps.setString(3, rating.getComment());
			ps.setDate(4, new java.sql.Date(rating.getDate().getTimeInMillis()));
			ps.setInt(5, rating.getId());

			ps.executeUpdate();
		}

	}

	@Override
	public void delete(Connection conn, Integer id) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.DELETE_RATING)) {
			ps.setInt(1, id);

			ps.executeUpdate();
		}

	}

	@Override
	public List<Rating> list(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating findById(Connection conn, Integer idRating) throws Exception {
		Rating rating = null;
		try (PreparedStatement ps = conn.prepareStatement(Constant.FIND_BY_ID_RATING)) {
			ps.setInt(1, idRating);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					int id = rs.getInt("id_rating");
					int product = rs.getInt("product");
					int rat = rs.getInt("rating");
					String comment = rs.getString("comment");
					Date date = rs.getDate("date_of_birth");
					rating = new Rating (id, new Product(product), rat, comment, new DateConverter().dateToCalendar(date));
				}
			}
		}
		return rating;
	}



}
