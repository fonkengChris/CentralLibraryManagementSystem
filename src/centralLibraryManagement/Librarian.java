
package centralLibraryManagement;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * The Librarian class models the issuing and receiving of books.
 * @author Group 15
 */
public class Librarian {

	//fields
	//collection of all transactions, aggregation relationship between Librarian and Transaction
	private static List<Transaction> transactions = new ArrayList<Transaction>();
	
	//The system requires only one librarian, hence there is no constructor for making separate instances.
	

	/**
	 * @return the transactions
	 */
	public static List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public static void setTransactions(List<Transaction> transactions) {
		Librarian.transactions = transactions;
	}

	
	/**
	 * @param user, the user requesting to borrow book
	 * @param book, the book being borrowed
	 * @param borrowDate, date of borrow transaction
	 * @param returnDate, expected date of return
	 */
	public static void issueBook(User user, Book book, LocalDate borrowDate, LocalDate returnDate) {
		//create a new borrow transaction
		Transaction transaction = new Transaction(user, book, borrowDate, returnDate, "\t Borrow");
		
		var recordList = RecordManagement.addRecord(Librarian.getTransactions(), transaction);
		user.getAccount().getBooks().add(book); //include new book to user's list of borrowed books
		book.setcopies(book.getcopies() - 1); // reduce number of copies of book by 1
		Database.setRecordList(recordList); // update new list of books in possession.
		
		System.out.println(Color.GREEN_BACKGROUND);
		System.out.println(Color.WHITE_BOLD_BRIGHT);
		System.out.println(transaction.getBook().getTitle() + " borrowed successfully by " 
				+ transaction.getUser().getName());
		System.out.println("Number of copies left: " + transaction.getBook().getcopies());
		System.out.println(Color.RESET);
	}
	
	/**
	 * @param user, the user requesting to return book
	 * @param book, the book being returned
	 * @param borrowDate, date of borrow transaction
	 * @param returnDate, actual date of return
	 */
	public static void receiveBook(User user, Book book, LocalDate borrowDate, LocalDate returnDate) {
		//create a new return transaction
		Transaction transaction = new Transaction(user, book, borrowDate, returnDate, "\t Return");
		
		var recordList = RecordManagement.addRecord(Librarian.getTransactions(), transaction);
		user.getAccount().getBooks().remove(book);  //remove book from list of borrowed books
		book.setcopies(book.getcopies() + 1);      //increase the number of available copies in the library
		Database.setRecordList(recordList);      //update record list to include new transaction 
		
		System.out.println(Color.GREEN_BACKGROUND);
		System.out.println(Color.WHITE_BOLD_BRIGHT);
		System.out.println(transaction.getBook().getTitle() + " returned successfully");
		System.out.println("Number of copies available: " + transaction.getBook().getcopies());
		System.out.println(Color.RESET);
	}
	
}
