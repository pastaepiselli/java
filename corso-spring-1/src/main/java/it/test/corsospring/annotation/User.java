package it.test.corsospring.annotation;

public class User {
	Phone phone;
	public User(Phone phone) {
		this.phone = phone;
	}
	public String getUserInfo() {
		return "Lorenzo rossi, telefono: " + phone.getPhone();
	}
	
}
