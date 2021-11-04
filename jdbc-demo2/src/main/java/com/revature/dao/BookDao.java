package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dto.AddOrUpdateBooksDTO;
import com.revature.model.Book;
import com.revature.util.JDBCUtil;

public class BookDao {

	public Book addBooks() {
		return null;
	}
	
	public List<Book> getAllBooks()  throws SQLException {
		List<Book> listOfBooks = new ArrayList<>();
		
		try (Connection con = JDBCUtil.getConnection()){
			
			String sql = "SELECT * FROM books";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); 
			
			while (rs.next()) {

				// 5. Grab all of the information from the current row that we are on, and
				// create a Student object
				// based on that information

				int id = rs.getInt("book_id");
				String isbn = rs.getString("isbn");
				String bookName = rs.getString("book_name");
				String author = rs.getString("author");

				//6. Take that information and create a Student object from that information
				Book s = new Book(id, isbn, bookName, author);

				// 7. Add the student object to the list
				listOfBooks.add(s);

			}
			
		}
		return listOfBooks;
	}
	
	public Book getBookById(int id) throws SQLException {
		
		try(Connection con = JDBCUtil.getConnection()){
			String sql = "SELECT * FROM books WHERE book_id = ?"; 
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			
			if (rs.next()) {
				return new Book(rs.getInt("book_id"), rs.getString("isbn"),
						rs.getString("book_name"), rs.getString("author"));
			} else {
				return null;
			}
		}
	}
	
	public Book updateBook(int bookId, AddOrUpdateBooksDTO book) throws SQLException {
		try (Connection con = JDBCUtil.getConnection()) {
			String sql = "UPDATE books " 
					+ "SET isbn = ?,"
					+ "book_name  = ?,"
					+ "book_author = ?"
					+ "WHERE "
					+ "book_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getBookAuthor());
			pstmt.setInt(4, bookId);
		
			
			int numberOfRecordUpdated = pstmt.executeUpdate();
			
			if(numberOfRecordUpdated != 1) {
				throw new SQLException("Unable to update book record w/ id of " + bookId);
			}
			
		}
		return new Book(bookId, book.getIsbn(), book.getBookName(), book.getBookAuthor());

	}
}
