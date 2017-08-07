package au.com.reece.phonebook.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import au.com.reece.phonebook.model.AddressBook;
import au.com.reece.phonebook.model.AddressBookSystem;
import au.com.reece.phonebook.model.Contact;

public class AddressBookManager {

	/**
	 * prints all contacts within the addressbook
	 * 
	 * @param book
	 * 
	 */
	public void printAddressBook(AddressBook book) {
		for (Contact ct : book.getContacts()) {
			System.out.println(ct.toString());
		}
	}

	
	/**
	 * gets all unique contacts of a address book system 
	 * 
	 * @param system
	 * @return collection of unique contacts in the system
	 */
	public Collection<Contact> getUniqueContacts(AddressBookSystem system) {
		Map<String, Contact> uniqueMap = new HashMap<String, Contact>();
		for (AddressBook ab : system.getBooks()) {
			for (Contact ct : ab.getContacts()) { 
				String key = ct.getName() +ct.getPhoneNumber();
				if (!uniqueMap.containsKey(key)) {
					uniqueMap.put(key, ct);
				} 
			}
		}
		return uniqueMap.values();
	}

}
