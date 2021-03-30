package com.java.dao;

public class AddressVo {
	
	private String name;
	private String phone;
	private String tel;
	private Long id;
	
	public AddressVo() {
		
	}
	
	public AddressVo(String name, String phone, String tel) {
		this.name = name;
		this.phone = phone;
		this.tel = tel;
	}
	
	public AddressVo(Long id, String name, String phone, String tel) {
		this(name, phone, tel);
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String Phone) {
		this.phone = phone;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
