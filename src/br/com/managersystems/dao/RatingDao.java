package br.com.managersystems.dao;

import java.sql.Connection;

import br.com.managersystems.entity.Rating;

public interface RatingDao extends Dao<Rating>{
	Rating findById(Connection conn, Integer idRating) throws Exception;
}
