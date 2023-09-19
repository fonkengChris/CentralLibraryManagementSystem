package centralLibraryManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * The BookManagement class is implemented to manage operation relating to books only
 * @author Group 15
 */
public class BookManagement implements Comparator<Book>, Iterable<Book>{
	
	//fields
	private static List<Book> bookList;

	/*
	 * No constructor for this class, since it's a helper class. No instance of it will be 
	 * required, hence the methods are all declared as static such that they are available to the 
	 * entire class and not a single instance (object) of the class.
	 * */


	//methods


	/** Returns the entire bookList.
	 * 
	 * @return the bookList.
	 */
	public static List<Book> getBookList() {
		return bookList;
	}


	/** Sets the bookList to a given value.
	 * 
	 * @param bookList, the list of books
	 */
	public static void setBookList(List<Book> bookList) {
		BookManagement.bookList = bookList;
	}


	/** Add new book to existing list
	 * 
	 * @param bookList, the list of books.
	 * @param title,  the title of the book.
	 * @param authorName,  the name of the author.
	 * 
	 * @return the list of books including the newly added book.
	 */
	public static List<Book> addNew(List<Book> bookList, String title, 
			String authorName, String categoryName) {

		//Loops through the current list of books to see if the book is already present and error out if true
		for (Book book: bookList) {

			if((book.getTitle().equals(title)) && (book.getAuthorName().equals(authorName))) {
				System.err.println("Library already contains " + book.getTitle());
				setBookList(bookList);
				return bookList;
			}

		}


		//creates the book object and add to the list
		bookList.add( new Book(title, authorName, new Category(categoryName)));
		setBookList(bookList);

		//success message that references the last object added to the book list.
		System.out.println(Color.GREEN_BACKGROUND);
		System.out.println(Color.WHITE_BOLD_BRIGHT);
		System.out.println(bookList.get(bookList.size() - 1).getTitle() + " added successfully!!!");
		System.out.println(Color.RESET);


		return bookList;
	}

	/** Remove the book with the given isbn number.
	 * 
	 * @param isbn,  the isbn number of the book.
	 */
	public static void remove(int isbn) {
		// removes member with the specified isbn number;
		if (!bookList.isEmpty()) {
			for(Book book: bookList) {
				if (book.getIsbn() == isbn) {
					bookList.remove(book);

					setBookList(bookList);
					System.out.println(Color.MAGENTA_BOLD);
					System.out.println(book.getTitle() + " deleted successfully");
					System.out.println(Color.RESET);
					return;
				}
			}

			System.err.println("Book not found in library!!!");
		}

		else {
			System.err.println("Erorr... Can not delete from an empty library");
		}
	}

	public static List<Book> searchBookByTitle(List<Book> bookList, String title) {
		//create a temporal list for books
		List<Book> tempList = new ArrayList<Book>();
		for (Book book : bookList) {
			if (book.getTitle().contains(title)) {
				tempList.add(book);
			}
		}


		return tempList;
	}

	public static List<Book> searchBooksByAuthor(List<Book> bookList, String authorName) {
		//create a temporal list for books
		List<Book> tempList = new ArrayList<Book>();
		for(var book: bookList) {
			if (book.getAuthorName().contains(authorName)) {
				tempList.add(book);
			}
		}

		return tempList;
	}

	public static List<Book> searchBookByCategory(List<Book> bookList, String categoryName) {
		//create a temporal list for books
		List<Book> tempList = new ArrayList<Book>();
		for(var book: bookList) {
			if (book.getCategory().getCategoryName().contains(categoryName)) {
				tempList.add(book);
			}
		}

		return tempList;
	}

	public static void generalSearch(List<Book> books) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose from the options below for your book search: ");
		System.out.println("1. By title");
		System.out.println("2. By author");
		System.out.println("3. By cartegory");

		int choice = scanner.nextInt();	
		Scanner sc = new Scanner(System.in);


		switch (choice) {
		case 1: 
			System.out.println("Enter title of book: ");
			var title =  sc.nextLine();
			System.out.println(searchBookByTitle(books, title));
			break;
		case 2: 

			System.out.println("Enter name of author: ");
			var author =  sc.nextLine();
			System.out.println("author");
			System.out.println(searchBooksByAuthor(books, author));
			break;
		case 3: 
			System.out.println("Enter category of book: ");
			var category =  sc.nextLine();
			System.out.println(searchBookByCategory(books, category));
			break;
		default:
			System.err.println("Invalid option!!!");
		}

	}



	@Override
	/**
	 * @return an integer depending on the value of o1 and o2
	 */
	public int compare(Book o1, Book o2) {
		return compare(o1, o2);
	}


	@Override
	public Iterator<Book> iterator() {
		return bookList.iterator();
	}

}
