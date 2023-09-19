package centralLibraryManagement;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The User class models the users of the system. 
 * It servers as the parent class for the Member and Admin Classes.
 * @author Group15
 */
public class User {
	//fields
	private int userId;
	private String name;
	private String email;
	private String password;
	private Account account;
	private Address address;

	/**
	 *  default Constructors
	 */
	public User()  { 
		Random random = new Random();

		this.userId = random.nextInt(999 - 100) + 100;
		this.name = "";
		this.email = "";
		this.password = "";
		this.address = new Address();

	}

	/**
	 * custom constructors
	 * @param name the name of the user
	 * @param email the email of the user
	 * @param password password of the user
	 * @param address address of the user
	 * the user id is generated randomly
	 */
	public User(String name, String email, String password, 
			Address address) {

		Random random = new Random();

		this.userId = random.nextInt(999 - 100) + 100; 		
		this.name = name;
		this.email = email;
		this.password = password;
		this.account = new Account(new ArrayList<Book>(), new Status(), 2022, 10, 20);
		this.address = address;
	}

	//Methods

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}


	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}


	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}


	public void requestBook() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter title of book you intend to borrow: ");
		var title = scanner.nextLine();
		var listOfBooks = DBInit.intialBookList();
		var book = BookManagement.searchBookByTitle(listOfBooks, title).get(0); //retrive book from book list
		var borrowDate = java.time.LocalDate.of(2022, 12, 20); //given this value just to test functionalities
		var returnDate = borrowDate.plusDays(10);  //set expected return date
		var booksInKeeping = this.getAccount().getBooks(); //list of books in user's possession

		for (Book book2 : booksInKeeping) {
			//Check whether the user already has the same book in possession
			if (book2.getTitle().equals(book.getTitle())) {
				System.err.println("You already have this book in possession");
			}
		}

		//Check whether the user-account has an irregular status
		if (this.getAccount().getStatus().equals("Irregular")) {
			System.err.println("Can't borrow another book, return what you have and pay your fine first.");
		}

		//Checking if there is at least 1 copy of the book available in the library
		else if (book.getcopies() <= 0) {
			System.err.println("Sorry no copy of this book is currently available.");
		}

		else {
			Librarian.issueBook(this, book, borrowDate, returnDate);
		}
	}

	public void returnBook() {

		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);

		var booksInKeeping = this.getAccount().getBooks();
		System.out.println(booksInKeeping + "\n");
		System.out.println("Enter title of book you intend to return: ");
		var title = scanner.nextLine();

		//get book from list of books in user's possession
		var book = BookManagement.searchBookByTitle(booksInKeeping, title).get(0); 


		System.out.println("Enter year: ");
		var year = scanner2.nextInt();
		System.out.println("Enter month: ");
		var month = scanner2.nextInt();
		System.out.println("Enter day: ");
		var day = scanner2.nextInt();
		var currentDate = java.time.LocalDate.of(year, month, day);
		var expectedReturnDate = this.getAccount().getBorrowDate().plusDays(10); 

		//number of days user has been keeping the book
		long duration = ChronoUnit.DAYS.between(expectedReturnDate, currentDate);


		if (currentDate.isAfter(expectedReturnDate)) {

			//For late entry, A fine of $1.25 * number of days after the deadline
			System.out.println(Color.RED_BOLD_BRIGHT);
			System.out.println("You have kept this book for " + duration + " extra days.");
			this.getAccount().setStatus(new Status("Irregular", duration * 1.25));
			System.out.println("Please do pay your fine of: $" + this.getAccount().getStatus().getFine());
			System.out.println(Color.RESET);
			Librarian.receiveBook(this, book, this.getAccount().getBorrowDate(), currentDate);
		}

		else {
			Librarian.receiveBook(this, book, this.getAccount().getBorrowDate(), currentDate);
		}
	}





	@Override
	/**
	 * @return the textual representation of the user
	 */
	public String toString() {
		return "[UserName: " + this.name + " idNumber: " + this.userId + " status: " 
				+ this.getAccount().getStatus().getStatusName() + "]\n";
		//password field omitted for security reasons
	}



	@Override
	/** 
	 * @param obj the object to compare this Member against.
	 * 
	 * @return true if the given object represents a Member equivalent to this member, false otherwise.
	 */
	public boolean equals(Object obj) {
		// test exceptional cases, i.e. obj is a Die, and not null
		if ((this.getClass() != obj.getClass()) || (obj == null))
			return false;

		User other = (User) obj; // cast to a Die object

		// compare sides and score names using the == operator as they are primitive types
		return this.name == other.name && this.password == other.password && 
				this.userId == other.userId && this.address == other.address;
	}


}
