package br.com.managersystems.entity;


public class CustomerRating {
	private Customer customer;
	private Rating rating;

	public CustomerRating(Customer customer, Rating rating) {
		this.customer = customer;
		this.rating = rating;
	}


	public Customer getCustomer() {
		return customer;
	}
	public Rating getRating() {
		return rating;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public void setRating(Rating rating) {
		this.rating = rating;
	}





}
