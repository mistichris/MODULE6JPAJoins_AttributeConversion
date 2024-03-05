package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Mar 4, 2024
 */
@Entity	//creates a new table
@Table(name="BookWithRating")	
public class BookWithRating {
	@Id
	@GeneratedValue
	private int id;
	private BookListItems book;
	private BookRatings rating;
	
	public BookWithRating() {
		super();
	}
	
	public BookWithRating(BookListItems book) {
		super();
		this.book = book;
	}

	public BookWithRating(BookListItems book, BookRatings rating) {
		super();
		this.book = book;
		this.rating = rating;
	}

	public BookListItems getBook() {
		return book;
	}

	public void setBook(BookListItems book) {
		this.book = book;
	}

	public BookRatings getRating() {
		return rating;
	}

	public void setRating(BookRatings rating) {
		this.rating = rating;
	}
	

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "BookWithRating [id=" + id + ", book=" + book + ", rating=" + rating + "]";
	}
	
	
}
