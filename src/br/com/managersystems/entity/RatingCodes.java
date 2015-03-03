package br.com.managersystems.entity;


public class RatingCodes {

	private Integer id;
	private Restaurant restaurant;
	private Product product;
	private String secret;
	private boolean used;

	public Integer getId() {
		return id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}
	public Product getProduct() {
		return product;
	}
	public String getSecret() {
		return secret;
	}
	public boolean isUsed() {
		return used;
	}




}
