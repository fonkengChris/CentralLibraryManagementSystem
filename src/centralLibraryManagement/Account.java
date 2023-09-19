package centralLibraryManagement;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.io.ObjectInputFilter.Status;
/**

 * @author p2747578

 *This is an account class for each member 
 *A particular member has it own account class 
 *and this fields are what each members can have access to like;
 *The members attributes, list of books borrowed, the date the books 
 *are borrowed with the last seen of the particular member
 */
import java.util.List;//This is imported to create the list of books bought by the member


/**
 * The Account class models a user-account and keeps track of the user's activities
 * @author Group 15
 *
 */
public class Account {

	//fields
	private Status status;
	private List<Book> books;
	private LocalDate borrowDate;



	/*
	 * dafault constructor
	 */
	public Account() {
		this.books = new ArrayList<Book>();
		this.status = new Status();
		this.borrowDate = java.time.LocalDate.of(2022, 12, 20);
	}
	/**
	 * constructotrs 
	 * @param books, the list of books in a user's keeping
	 * @param status, the status of a user-account
	 * @param year, a four digit notation of the year
	 * @param month, a two digit notation for month (1 - 12)
	 * @param day, a two digit notation for day (1 - 31)
	 */

	public Account(List<Book> books, Status status, int year, int month, int day) {
		this.status = status;
		this.books = books;
		this.borrowDate = java.time.LocalDate.of(year, month, day);
	}


	/**
	 * @return the book in a list
	 */
	public List<Book> getBooks() {

		return books;
	}

	/*
	 * @param books, the list of books to be updated
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/*
	 * @param status, the status to be updated
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/** Returns the number of books in the booklist.
	 * @return Status of user-account, regular or irregular 
	 * 
	 * */
	public Status getStatus() {
		return status;
	}

	/**
	 * @return the borrowDate
	 */
	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	/**
	 * @param year four digit number in date string
	 * @param month two digit number in date string
	 * @param day two digit number in date string
	 */
	public void setBorrowDate(int year, int month, int day) {
		this.borrowDate = java.time.LocalDate.of(year, month, day);
	}

	@Override
	/**@return  textual representation of an Account
	 * 
	 */
	public String toString() {
		return "\n" + "Book-List " + "\n" + books + "\n" +"Last-Seen "
				+ borrowDate  +"\n" ;
	}

}

