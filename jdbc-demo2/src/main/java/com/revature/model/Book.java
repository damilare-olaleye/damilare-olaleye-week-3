package com.revature.model;

import java.util.Objects;

public class Book {
	private int book_id;
	private String isbn;
	private String book_name;
	private String author;

	public Book() {
		
	}

	public Book(int book_id, String isbn, String book_name, String author) {
		super();
		this.book_id = book_id;
		this.isbn = isbn;
		this.book_name = book_name;
		this.author = author;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", isbn=" + isbn + ", book_name=" + book_name + ", author=" + author + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, book_id, book_name, isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && book_id == other.book_id
				&& Objects.equals(book_name, other.book_name) && Objects.equals(isbn, other.isbn);
	}
	
	
}
