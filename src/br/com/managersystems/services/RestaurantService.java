package br.com.managersystems.services;

import java.sql.Connection;

import br.com.managersystems.entity.Restaurant;

public interface RestaurantService extends Service<Restaurant>{

	Restaurant findById(Connection conn, int id);

}
