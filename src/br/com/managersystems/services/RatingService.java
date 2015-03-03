package br.com.managersystems.services;

import java.sql.Connection;

import br.com.managersystems.entity.Rating;

public interface RatingService extends Service<Rating>{

	Rating findById(Connection conn, int id);

}
