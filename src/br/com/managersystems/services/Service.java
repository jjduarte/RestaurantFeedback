package br.com.managersystems.services;

import java.sql.Connection;
import java.util.List;

public interface Service <T>{
	void insert(Connection conn, T object) throws Exception;

	void update(Connection conn,  T object) throws Exception;

	void delete(Connection conn, Integer id) throws Exception;

	List<T> list(Connection conn) throws Exception;

}
