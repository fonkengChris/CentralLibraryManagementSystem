package centralLibraryManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Database class models the system database, where information for books, transactions and users are stored.
 * @author Group 15
 */
public class Database {

	//fields
	private static List<Book> bookList = new ArrayList<Book>();
	private static List<User> userList = new ArrayList<User>();
	private static List<Transaction> recordList = new ArrayList<Transaction>();



	//methods

	/**
	 * @return the recordsList
	 */
	public static List<Transaction> getRecordList() {
		return recordList;
	}


	/**
	 * @param recordsList the recordsList to set
	 */
	public static void setRecordList(List<Transaction> recordsList) {
		Database.recordList = recordsList;
	}


	/** Returns the booklist.
	 * 
	 * @return the booklist.
	 */
	public static List<Book> getBookList() {
		return bookList;
	}

	/** Returns the list of members.
	 * 
	 * @return the list of members.
	 */
	public static List<User> getUserList() {
		return userList;
	}

	/** Set the memberList to a given value
	 * 
	 * @param userList, the list of the all registered members.
	 */
	public static void setUserList(List<User> userList) {
		Database.userList = userList;
	}
	
	/** Sets the bookList to a given value.
	 * 
	 * @param bookList, the list of books
	 */
	public static void setBookList(List<Book> bookList) {
		Database.bookList = bookList;
	}

	/** Add book to existing list
	 * 
	 * @param books, the list of books.
	 * 
	 * @return the list of books including the newly added book.
	 */
	public static List<Book> addBook(List<Book> books) {

		System.out.println("Enter details to add new book \n");
		var bookList = books;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter book title: ");
		var title = scanner.nextLine();

		System.out.println("Enter author name: ");
		var authorName = scanner.nextLine();

		System.out.println("Enter cathegory: ");
		var cathegoryName = scanner.nextLine();

		BookManagement.addNew(bookList, title, authorName, cathegoryName);
		return bookList;
	}

	
	/** Register the new member and add to existing list
	 * 
	 * @param users, the list of registered members.
	 * 
	 * @return list of members including newly added members.
	 */
	public static List<User> addUser(List<User> users) {
		if(users.isEmpty()) {
			//printed only when adding the first member
			System.out.println("Welcome to the Register Page \n Fill the information to register member");

			var userList = users;
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter User name: ");
			var name = scanner.nextLine();

			System.out.println("Enter email address: ");
			var email = scanner.next();

			System.out.println("Enter password: ");
			var password = scanner.next();

			System.out.println("Enter street name: ");
			var street = scanner.nextLine();

			System.out.println("Enter city: ");
			var city = scanner.next();
			
			System.out.println("Enter state: ");
			var state = scanner.next();

			System.out.println("Enter country: ");
			var country = scanner.next();

			var address = new Address(street, city, state, country);
			MemberManagement.addNew(userList, name, email, password, address);
			
			return userList;
		}

		else {
			//printed after we already have the at least ne registered member
			System.out.println("\n Register next member");

			var userList = users;
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter User name: ");
			var name = scanner.nextLine();

			System.out.println("Enter email address: ");
			var email = scanner.next();

			System.out.println("Enter password: ");
			var password = scanner.next();

			System.out.println("Enter street name: ");
			var street = scanner.nextLine();

			System.out.println("Enter city: ");
			var city = scanner.next();
			
			System.out.println("Enter state: ");
			var state = scanner.next();

			System.out.println("Enter country: ");
			var country = scanner.next();

			var address = new Address(street, city, state, country);
			MemberManagement.addNew(userList, name, email, password, address);
			
			return userList;		
		}
	}

	/**
	 * this removes a book from the book list
	 */
	public static void removeBook() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter isbn for the book you want to delete: ");
		int isbn = scanner.nextInt();


		BookManagement.remove(isbn);
	}

	public static void removeMember() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter id number for the member you want to delete: ");
		int idNumber = scanner.nextInt();

		MemberManagement.remove(idNumber);
	}

	public static User login() {

		System.out.println("Welcome to the Login Page: \n Enter Username and Password");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter email: ");
		var email = scanner.next();

		System.out.println("Enter password: ");
		var password1 = scanner.next();

		return Session.login(email, password1);
	}
	
}
