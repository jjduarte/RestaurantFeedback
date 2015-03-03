drop table if exists en_customer;
drop table if exists en_restaurant;
drop table if exists en_product;
drop table if exists en_rating;
drop table if exists re_customer_rating;
drop table if exists en_rating_codes;

CREATE TABLE en_customer
(
  id_customer integer NOT NULL,
  name character varying(255) NOT NULL,
  cpf character varying(255) NOT NULL,
  date_of_birth date NOT NULL,
  login character varying(20) NOT NULL,
  password character varying(20) NOT NULL,
  CONSTRAINT en_customer_pkey PRIMARY KEY (id_customer)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE en_customer
  OWNER TO postgres;

CREATE TABLE en_restaurant
(
  id_restaurant integer NOT NULL,
  name character varying(255) NOT NULL,
  cnpj character varying(255) NOT NULL,
  login character varying(20) NOT NULL,
  password character varying(20) NOT NULL,
  CONSTRAINT en_restaurant_pkey PRIMARY KEY (id_restaurant)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE en_restaurant
  OWNER TO postgres;

CREATE TABLE en_product
(
  id_product integer NOT NULL,
  name character varying(255) NOT NULL,
  description character varying(255) NOT NULL,
  available character varying(1) NOT NULL,
  photo character varying(255) NOT NULL,
  CONSTRAINT en_product_pkey PRIMARY KEY (id_product)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE en_product
  OWNER TO postgres;


CREATE TABLE en_rating
(
  id_rating integer NOT NULL,
  id_product integer NOT NULL,
  rating integer NOT NULL,
  comment character varying(255) NOT NULL,
  date date NOT NULL,
  CONSTRAINT en_rating_pkey PRIMARY KEY (id_rating),
  CONSTRAINT en_product_id_product_fkey FOREIGN KEY (id_product)
      REFERENCES en_product (id_product) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE en_rating
  OWNER TO postgres;

CREATE TABLE re_customer_rating
(
  id_customer integer NOT NULL,
  id_rating integer NOT NULL,
  CONSTRAINT re_customer_rating_pkey PRIMARY KEY (id_customer, id_rating),
  CONSTRAINT re_customer_rating_id_customer_fkey FOREIGN KEY (id_customer)
      REFERENCES en_customer (id_customer) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT re_customer_rating_id_rating_fkey FOREIGN KEY (id_rating)
      REFERENCES en_rating (id_rating) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE re_customer_rating
  OWNER TO postgres;


CREATE TABLE en_rating_codes
(
  id_rating_codes integer NOT NULL,
  id_restaurant integer NOT NULL,
  id_product integer NOT NULL,
  secret character varying(20) NOT NULL,
  used character varying(1) NOT NULL,
  CONSTRAINT en_rating_codes_pkey PRIMARY KEY (id_rating_codes),
  CONSTRAINT en_restaurant_id_restaurant_fkey FOREIGN KEY (id_restaurant)
      REFERENCES en_restaurant (id_restaurant) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION, 
  CONSTRAINT en_product_id_product_fkey FOREIGN KEY (id_product)
      REFERENCES en_product (id_product) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION

)
WITH (
  OIDS=FALSE
);
ALTER TABLE en_rating_codes
  OWNER TO postgres;


===================SEQUENCE GENERATION =======================


CREATE SEQUENCE enCustomer_idCustomer_seq START 1;
ALTER SEQUENCE enCustomer_idCustomer_seq OWNED BY en_customer.id_customer;

CREATE SEQUENCE enProduct_idProduct_seq START 1;
ALTER SEQUENCE enProduct_idProduct_seq OWNED BY en_product.id_product;

CREATE SEQUENCE enRating_idRating_seq START 1;
ALTER SEQUENCE enRating_idRating_seq OWNED BY en_rating.id_rating;

CREATE SEQUENCE enRatingCodes_idRatingCodes_seq START 1;
ALTER SEQUENCE enRatingCodes_idRatingCodes_seq OWNED BY en_rating_codes.id_rating_codes;

CREATE SEQUENCE enRestaurant_idRestaurant_seq START 1;
ALTER SEQUENCE enRestaurant_idRestaurant_seq OWNED BY en_restaurant.id_restaurant;


