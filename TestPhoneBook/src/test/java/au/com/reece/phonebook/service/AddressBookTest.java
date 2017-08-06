package au.com.reece.phonebook.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.reece.phonebook.model.AddressBook;
import au.com.reece.phonebook.model.Contact;

public class AddressBookTest {
	private AddressBook book;
	private Contact joe, john, sarah;
	private AddressBookManager manager;
	
	@Before
	public void setUp(){
		book = new AddressBook("book1");
		joe = new Contact("Joe Bloggs", "4231223");
		john = new Contact("John Citizen", "555672");
		sarah = new Contact("Sarah Smith", "1355623");
		manager = new AddressBookManager();
	}
	
	/**
	 * test add contact to address book
	 * print out all of them
	 */
	@Test
	public void addContactToAddressBookTest() {
		book.addContact(joe);
		book.addContact(john);
		book.addContact(sarah);
		
		Assert.assertTrue(book.getContacts().size() == 3);
		System.out.println("===================================");
		System.out.println("Testing add contact to phone book");
		manager.printAddressBook(book);
		System.out.println("===================================");
		
	}
	
	/**
	 * test remove contact by name
	 */
	@Test
	public void removeContactByNameTest() {
		book.addContact(joe);
		book.addContact(john);
		book.addContact(sarah);
		
		Assert.assertTrue(book.getContacts().size() == 3);
		
		book.removeContactByName("Joe Bloggs");
		book.removeContactByName("Sarah Smith");
		
		Assert.assertTrue(book.getContacts().size() == 1);
		
		System.out.println("===================================");
		System.out.println("Testing remove contact by name");
		manager.printAddressBook(book);
		System.out.println("===================================");
	}
	
	/**
	 * test remove contact by number
	 */
	@Test
	public void removeContactByNumberTest() {
		book.addContact(joe);
		book.addContact(john);
		book.addContact(sarah);
		
		Assert.assertTrue(book.getContacts().size() == 3);
		
		book.removeContactByPhoneNumber("1355623");
		//try to remove one does not exist
		book.removeContactByPhoneNumber("000");
		
		Assert.assertTrue(book.getContacts().size() == 2);
		
		System.out.println("===================================");
		System.out.println("Testing remove contact by number");
		manager.printAddressBook(book);
		System.out.println("===================================");
		
	}
}
