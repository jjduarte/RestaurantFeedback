package br.com.managersystems.entity;

import java.util.Calendar;

public class Customer {

	private Integer id;
	private String name;
	private String cpf;
	private Calendar dateOfBirth;
	private String login;
	private String password;

	public Customer(){
	}

	public Customer(int idCustomer) {
		this.id = idCustomer;
	}

	public Customer(Integer id, String name, String cpf, Calendar dateOfBirth, String login, String password) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.dateOfBirth = dateOfBirth;
		this.login = login;
		this.password = password;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}



}
