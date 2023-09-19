package centralLibraryManagement;

/**
 * The category class models the different categories of books
 * @author Group 15
 */
public class Category {
	//fields
	private String categoryName;

	//constructors

	public Category () {
		this("");
	}

	// this is a custom constructor
	/**
	 * custom constructor
	 * @param categoryName 
	 */
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}


	//methods
	/**
	 * 
	 * @return the identification name of the type or genre of the particular book.s
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * 
	 * @param categoryName set the categoryName of the type or genre of the particular book.s
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	/**
	 * @return the textual representation of a category
	 */
	public String toString() {
		return  categoryName;
	}


}
