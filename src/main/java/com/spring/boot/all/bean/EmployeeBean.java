package com.spring.boot.all.bean;

public class EmployeeBean {

		private int id;
	
		private String name;
	
		private String email;
	
		private String address;
	
		private int telephone;

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", telephone=" + telephone + "]";
	}

}
