package br.com.managersystems.entity;
import java.util.Collection;
import java.util.List;


public class Restaurant {
	private int id;
	private String name;
	private String cnpj;
	private String login;
	private String password;
	private Collection<Product> dishes;

	public Restaurant(int id) {
		this.id = id;
	}

	public Restaurant(int id, String name, String cnpj, String login, String password, Collection<Product> dishes) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.login = login;
		this.password = password;
		this.dishes = dishes;	
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public Collection<Product> getDishes() {
		return dishes;
	}

	public void setProducts(List<Product> productsList) {
		this.dishes = productsList;
	}
}
