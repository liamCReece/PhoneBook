package au.com.reece.phonebook.service;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import org.junit.Assert;

import au.com.reece.phonebook.model.AddressBook;
import au.com.reece.phonebook.model.AddressBookSystem;
import au.com.reece.phonebook.model.Contact;

public class AddressBookSystemTest {
	private AddressBookSystem system;
	private AddressBook book1, book2;
	private Contact joe, john, sarah, sarahS;
	private AddressBookManager manager;
	
	@Before
	public void setUp(){
		system = new AddressBookSystem();
		book1 = new AddressBook("book1");
		book2 = new AddressBook("book2");
		joe = new Contact("Joe Bloggs", "4231223");
		john = new Contact("John Citizen", "555672");
		sarah = new Contact("Sarah Smith", "1355623");
		sarahS = new Contact("Sarah Smith", "1556754");
		
		manager = new AddressBookManager();
		
		book1.addContact(joe);
		book1.addContact(john);
		book1.addContact(john);
		
		book2.addContact(john);
		book2.addContact(sarah);
		book2.addContact(sarah);
		book2.addContact(sarahS);
	}
	
	/**
	 * Test for managing multiple address books
	 */
	@Test
	public void addRemoveAddressBookTest(){
		system.addAddressBook(book1);
		system.addAddressBook(book2);
		
		Assert.assertTrue(system.getBooks().size() == 2);
		
		//attempt to remove non exist address book
		system.removeAddressBook("id1");
		Assert.assertTrue(system.getBooks().size() == 2);
		
		printAllEntries();
		
		//remove book1 from the system
		system.removeAddressBook(book1.getId());
		Assert.assertTrue(system.getBooks().size() == 1);
		
		printAllEntries();
	}
	
	
	@Test
	public void printAllUniqueContact(){
		system.addAddressBook(book1);
		system.addAddressBook(book2);
		
		Collection<Contact> uniqueContacts = manager.getUniqueContacts(system);
		//there are total of 4 unique contacts
		Assert.assertTrue(uniqueContacts.size() == 4);
		System.out.println("Printing all unique contacts");
		for (Contact ct : uniqueContacts){
			System.out.println(ct.toString());
		}
		
	}
	
	private void printAllEntries(){
		//print all entries of the phone book system
		System.out.println("============================");
		for (AddressBook book : system.getBooks()) {
			System.out.println("Content of " + book.getId());
			for (Contact ct : book.getContacts()) {
				System.out.println(ct.toString());
			}
		}
		System.out.println("============================");
	}

}
