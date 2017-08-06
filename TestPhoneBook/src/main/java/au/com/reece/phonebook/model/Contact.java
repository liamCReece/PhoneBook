package au.com.reece.phonebook.model;

import java.util.Objects;

public class Contact {
	private String name;
	private String phoneNumber;
	
	public Contact() {
		
	}
	
	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if (obj instanceof Contact != true){
			return false;
		}
		Contact con = (Contact)obj;
		if (Objects.equals(name, con.getName())
			&& Objects.equals(phoneNumber, con.getPhoneNumber())) {
			return true;
		}
		return false;
	}
	
	
}
