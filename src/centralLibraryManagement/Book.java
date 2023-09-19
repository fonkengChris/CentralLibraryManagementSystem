
package centralLibraryManagement;

import java.util.Comparator;
import java.util.Random;

/**
 * The Book class models the books in the library
 * @author Group 15
 */
public class Book  implements Comparable<Book>, Comparator<Book>{

	//fields
	private String title;
	private String authorName;
	private Category category;
	private int isbn;
	private int copies;


	//constructors
	/**
	 * custom constructors
	 * @param title this will show the title of the book 
	 * @param authorName this will show the authorName of the book
	 * @param category this will show the category of the book
	 * the isbn is to be generated automatically by default
	 */
	public Book(String title, String authorName, Category category) {
		Random random = new Random();

		this.title = title;
		this.authorName = authorName;
		this.category = category;
		this.isbn = random.nextInt(99999 - 10000) + 10000;
		this.copies = 5;
	}

	/**
	 * Default constructor
	 * */
	public Book() {
		Random random = new Random();
		this.title = "";
		this.authorName = "";
		this.category = new Category();
		this.isbn = random.nextInt(99999 - 10000) + 10000;
		this.copies = 5;
	}
	/**
	 * 
	 * @return category 
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * 
	 * @param category set category of the book
	 */
	public void setCategory(Category category) {
		this.category = category;
	}


	//methods
	/** Returns the title of the book.
	 * 
	 * @return the title of the book.
	 */
	public String getTitle() {
		return this.title;
	}

	/** Returns the name of the author of the book.
	 * 
	 * @return the authorName of the book.
	 */
	public String getAuthorName() {
		return this.authorName;
	}

	/** Returns the isbn-number of the book.
	 * 
	 * @return the isbn number of the book.
	 */ 
	public int getIsbn() {
		return isbn;
	}

	/** Returns the number of copies available for the book.
	 * 
	 * @return the number of copies available for the book.
	 */
	public int getcopies() {
		return copies;
	}

	/** Set the number of copies to a given value
	 * 
	 * @param copies, the number of available copies
	 */
	public void setcopies(int copies) {
		this.copies = copies;
	}


	/** Set the title to a given value
	 * 
	 * @param title, the title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/** Set the authorName to a given value
	 * 
	 * @param authorName, the name of the author
	 */	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	/**
	 * No setter is created for the isbn, since its value is generated automatically
	 * hence requires no modification.
	 * /

	/** Returns a textual representation of the book.
	 * 
	 * @return a textual representation of the book.
	 */
	@Override
	public String toString() {
		return this.category + ": " + this.title + " by " + this.authorName + 
				";  ISBN: " + this.isbn + "\n"; 
	}

	@Override
	/**
	 * @param o1 the first book
	 * @param o2 the second book to be compared with the first
	 * 
	 * @return an integer depending on the values of o1 and o2
	 */
	public int compare(Book o1, Book o2) {
		return compare(o1, o2);
	}

	@Override
	public int compareTo(Book other) {
		int result = this.category.getCategoryName().compareTo(other.category.getCategoryName());
		if (result == 0) {
			result = this.title.compareTo(other.title); 
			if (result == 0) {
				result = this.authorName.compareTo(other.authorName);
			}
		}
		return result;
	}

}