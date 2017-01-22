package sxxt.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Company {
	private int id;
	private String name;
	private String phone;
	private String address;
	private String introduction;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date foundingDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getFoundingDate() {
		return foundingDate;
	}

	public void setFoundingDate(Date foundingDate) {
		this.foundingDate = foundingDate;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", introduction="
				+ introduction + ", foundingDate=" + foundingDate + "]";
	}

}
