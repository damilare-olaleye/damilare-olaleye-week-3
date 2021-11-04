package com.revature.dto;

import java.util.Objects;

public class AddOrUpdateBooksDTO {

	private String isbn;
	private String bookAuthor;
	private String bookName;
	
	public AddOrUpdateBooksDTO() {
		
	}

	public AddOrUpdateBooksDTO(String isbn, String bookAuthor, String bookName) {
		super();
		this.isbn = isbn;
		this.bookAuthor = bookAuthor;
		this.bookName = bookName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookAuthor, bookName, isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddOrUpdateBooksDTO other = (AddOrUpdateBooksDTO) obj;
		return Objects.equals(bookAuthor, other.bookAuthor) && Objects.equals(bookName, other.bookName)
				&& Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "AddOrUpdateBooksDTO [isbn=" + isbn + ", bookAuthor=" + bookAuthor + ", bookName=" + bookName + "]";
	}
	
	
}
