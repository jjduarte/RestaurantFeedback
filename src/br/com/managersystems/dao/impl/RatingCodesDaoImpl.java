package br.com.managersystems.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.managersystems.dao.RatingCodesDao;
import br.com.managersystems.entity.RatingCodes;
import br.com.managersystems.util.Constant;

public class RatingCodesDaoImpl implements RatingCodesDao{

	@Override
	public void insert(Connection conn, RatingCodes ratingCodes) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.INSERT_RATING_CODES)) {
			ps.setInt(1, ratingCodes.getRestaurant().getId());
			ps.setInt(2, ratingCodes.getProduct().getId());
			ps.setString(3, ratingCodes.getSecret());
			ps.setString(4, ratingCodes.isUsed() ? "T" : "F");

			ps.executeUpdate();
		}

	}

	@Override
	public void update(Connection conn, RatingCodes ratingCodes) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.UPDATE_RATING_CODES)) {
			ps.setInt(1, ratingCodes.getRestaurant().getId());
			ps.setInt(2, ratingCodes.getProduct().getId());
			ps.setString(4, ratingCodes.getSecret());
			ps.setString(5, ratingCodes.isUsed() ? "T" : "F");
			ps.setInt(6, ratingCodes.getId());

			ps.executeUpdate();
		}

	}

	@Override
	public void delete(Connection conn, Integer id) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(Constant.DELETE_RATING_CODES)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		}

	}

	@Override
	public List<RatingCodes> list(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
