package br.com.managersystems.entity;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Restaurant {

	private int id;

	@NotNull
	@Size(min=5)
	private String name;
	@NotNull
	private String cnpj;
	@NotNull
	private String login;
	@NotNull
	private String password;
	private Collection<Product> dishes;




	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDishes(Collection<Product> dishes) {
		this.dishes = dishes;
	}

	public Restaurant(){
	}

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
