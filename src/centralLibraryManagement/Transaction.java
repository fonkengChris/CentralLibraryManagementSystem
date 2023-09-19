package centralLibraryManagement;

import java.util.Random;
import java.time.LocalDate;
import java.util.Date;

/**
 * The Transaction class models the borrowing and return of books to and from the library
 * @author Group 15
 */
public class Transaction {

	//fields
	private int code;  // unique code for each transactions
	private User user;
	private Book book;
	private LocalDate borrowDate;    //the borrow date
	private LocalDate expectedReturnDate;    // the return date
	private String status;
	private String type;

	//Constructors

	/** Create an instance of a transaction, memberName , bookTittle, date.
	 * @param user, the user involved in borrowing or returning
	 * @param book, the book that is being borrowed or returned
	 * @param borrowDate, The start day the member borrowed the book and the transaction recorded
	 * @param expectedReturnDate  The end day the book is to be returned
	 * @param type, the nature of transaction (borrow or return)
	 */

	public Transaction(User user, Book book, LocalDate borrowDate, LocalDate expectedReturnDate, String type) {
		Random random = new Random();
		this.code = random.nextInt(9999 - 1000) + 1000;
		this.user = user;
		this.book = book;
		this.borrowDate = borrowDate;
		this.expectedReturnDate = expectedReturnDate;
		this.status = "active";
		this.type = type;
	}


	//default constructors
	/** Creates a new instance of Transaction, using default values
	 */
	public Transaction () {
		Random random = new Random();
		this.code = random.nextInt(9999 - 1000) + 1000;
		this.user = new User();
		this.book = new Book();
		this.borrowDate = java.time.LocalDate.now();	
		this.expectedReturnDate = java.time.LocalDate.now();
		this.status = "active";
		this.type = "";
	}

	/**
	 * 
	 * @return the Status of the member
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status set status
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	//method

	/**
	 * @return the transactionNumber
	 */
	public int getCode() {
		return code;
	}


	/**
	 * @return the member
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user, the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return the borrowDate
	 */
	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	/**
	 * @param borrowDate the borrowDate to set
	 */
	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	/**
	 * @return the expectedReturnDate
	 */
	public LocalDate getExpectedReturnDate() {
		return expectedReturnDate;
	}

	/**
	 * @param expectedReturnDate the expectedReturnDate to set
	 */
	public void setExpectedReturnDate(LocalDate expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	@Override // it override a method declared
	/**
	 * @return the textual representation of the transaction
	 */
	public String toString() {
		return "Transaction:[code=" + code + ", memberName=" + user.getName() + ", bookTittle="
				+ book.getTitle() + "\n startDate=" + borrowDate + ", endDate=" + expectedReturnDate + 
				type + "]";
	}

}
