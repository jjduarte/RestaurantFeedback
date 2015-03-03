package br.com.managersystems.entity;


public class Product {

	private Integer id;
	private String name;
	private String description;
	private boolean available;
	private String photo;
	private Restaurant restaurant;

	public Product(){
	}

	public Product(int id) {
		this.id = id;
	}

	public Product(int idProduct, String name, String description, boolean available, String photo, Restaurant restaurant) {
		this.id = idProduct;
		this.name = name;
		this.description = description;
		this.available = available;
		this.photo = photo;
		this.restaurant = restaurant;
	}

	public Integer getId() {
		return id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isAvailable() {
		return available;
	}

	public String getPhoto() {
		return photo;
	}


}
