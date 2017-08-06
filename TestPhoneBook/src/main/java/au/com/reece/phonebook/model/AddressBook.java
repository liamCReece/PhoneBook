package au.com.reece.phonebook.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddressBook {
	private String id;
	private List<Contact> contacts = new ArrayList<Contact>();
	
	public AddressBook() {
		
	}
	
	public AddressBook(String id){
		this.id = id;
	}
	
	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	public List<Contact> findContactByName(String name){
		List<Contact> result = new ArrayList<Contact>();
		for (Contact c : contacts){
			if (Objects.equals(name, c.getName())) {
				result.add(c);
			}
		}
		
		return result;
	}
	
	public void removeContactByName(String name) {
		List<Contact> removed = new ArrayList<Contact>();
		for (Contact c : contacts){
			if (Objects.equals(name, c.getName())) {
				removed.add(c);
			}
		}
		contacts.removeAll(removed);
	}
	
	public void removeContactByPhoneNumber(String phoneNumber) {
		List<Contact> removed = new ArrayList<Contact>();
		for (Contact c : contacts){
			if (Objects.equals(phoneNumber, c.getPhoneNumber())) {
				removed.add(c);
			}
		}
		contacts.removeAll(removed);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}
