package br.com.managersystems.entity;
import java.util.Calendar;

public class Rating {

	private Integer id;
	private Product product;
	private Integer rating;
	private String comment;
	private Calendar date;

	public Rating(int idRating) {
		this.id = idRating;
	}

	public Rating(int id, Product product, int rat, String comment, Calendar date) {
		this.id = id;
		this.product = product;
		this.rating = rat;
		this.comment = comment;
		this.date = date;

	}

	public int getId(){
		return id;
	}

	public Product getProduct() {
		return product;
	}
	public Integer getRating() {
		return rating;
	}
	public String getComment() {
		return comment;
	}
	public Calendar getDate() {
		return date;
	}





}
