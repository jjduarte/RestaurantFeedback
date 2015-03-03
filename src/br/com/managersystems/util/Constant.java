package br.com.managersystems.util;

public interface Constant {

	//customer
	String INSERT_CUSTOMER     = "insert into en_customer values (nextval('enCustomer_idCustomer_seq'), ?, ?, ?, ?, ? )";
	String UPDATE_CUSTOMER     = "update en_customer set nome=? , cpf=? , date_of_birth=? , login=? , password=? where id_customer=? ";
	String DELETE_CUSTOMER     = "delete from en_customer where id_customer=?";
	String LIST_CUSTOMER   	   = "select * from en_customer";
	String FIND_BY_ID_CUSTOMER = "select * from en_customer where id_customer = ?";
	String FIND_CUSTOMER_BY_LOGIN_PASSWORD = "select * from en_customer where login=? and password=?";

	//customer_rating
	String INSERT_CUSTOMER_RATING = "insert into re_customer_rating values ( ? ,? )";
	String UPDATE_CUSTOMER_RATING = "update re_customer_rating set id_customer = ? , id_rating=? where id_customer = ? and id_rating = ? ";
	String DELETE_CUSTOMER_RATING = "delete from re_customer_rating where id_customer=? and id_rating=?";
	String LIST_CUSTOMER_RATING   = "select * from re_customer_rating";
	String FIND_BY_ID_RATING 	  = "select * from en_rating where id_rating = ?";

	//en_product
	String FIND_BY_ID_PRODUCT 			 = "select * from en_product where id_product= ?";
	String LIST_PRODUCT_BY_RESTAURANT_ID = "select * from en_product where id_restaurant=?";
	String INSERT_PRODUCT 				 = "insert into en_product values  (nextval('enProduct_idProduct_seq'), ?, ?, ?, ?, ? )";
	String UPDATE_PRODUCT 				 = "update en_product set nome=? , description=? , available=? , photo=? , id_restaurant=? where id_product=?";
	String DELETE_PRODUCT 				 = "delete from en_product where id_product";
	String LIST_PRODUCT 				 = "select * from en_product";

	//en_restaurant
	String FIND_RESTAURANT_BY_ID = "select * from en_restaurant where id_restaurant=?";
	String INSERT_RESTAURANT 	 = "insert into en_restaurant values (nextval('enRestaurant_idRestaurant_seq'), ?, ?, ?, ?)";
	String UPDATE_RESTAURANT 	 = "update en_restaurant set name=? , cnpj=? , login=? , password=? where id_restaurant=?";
	String DELETE_RESTAURANT 	 = "delete from en_restaurant where id_restaurant=?";
	String LIST_RESTAURANT 		 = "select * from en_restaurant";

	//en_rating
	String INSERT_RATING = "insert into en_rating values (nextval('enRating_idRating_seq'), ?, ?, ?, ?)";
	String UPDATE_RATING = "update en_rating set product_id=? , rating=? , comment=? , date=? where id_rating=?";
	String DELETE_RATING = "delete from en_rating where id_rating=?";

	//en_rating_codes
	String INSERT_RATING_CODES = "insert into en_rating_codes values (nextval('enRatingCodes_idRatingCodes_seq'), ?, ?, ?, ?)";
	String UPDATE_RATING_CODES = "update en_rating_codes set id_restaurant=? , id_product=? , secret=? , used=? where id_rating_codes=? ";
	String DELETE_RATING_CODES = "delete from en_rating_codes where id_rating_codes=? ";






}
