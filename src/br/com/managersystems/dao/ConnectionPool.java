package br.com.managersystems.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

public class ConnectionPool {
	private DataSource dataSource;

	public ConnectionPool() {

		PGSimpleDataSource source = new PGSimpleDataSource();
		source.setServerName("localhost");
		source.setDatabaseName("RestaurantFeedback");
		source.setUser("postgres");
		source.setPassword("atila87");
		this.dataSource = source;
	}

	public Connection getConnection() {

		Connection connection = null;

		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
