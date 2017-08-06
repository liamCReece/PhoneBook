package au.com.reece.phonebook.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddressBookSystem {
	private List<AddressBook> books = new ArrayList<AddressBook>();
	
	public AddressBookSystem() {
		
	}

	public void addAddressBook(AddressBook book) {
		books.add(book);
	}
	
	public void removeAddressBook(String id) {
		List<AddressBook> removed = new ArrayList<AddressBook>();
		for (AddressBook book : books){
			if (Objects.equals(id, book.getId())) {
				removed.add(book);
			}
		}
		books.removeAll(removed);
	}
	
	public List<AddressBook> getBooks() {
		return books;
	}

	public void setBooks(List<AddressBook> books) {
		this.books = books;
	}

}
