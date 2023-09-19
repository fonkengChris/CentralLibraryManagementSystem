package centralLibraryManagement;


import java.util.Comparator;
import java.util.List;

/**
 * The DBInit class is a helper class for initialising the list of Books and Members when the program is first run
 * @author Group 15
 */
public class DBInit implements Comparator<Book>{

	//No fields nor constructor since it is a helper class.
	
	/**
	 * @return the initial book list.
	 * */	 
	public static List<Book> intialBookList() {
		
//		Database db = new Database();
		var books = Database.getBookList();
		books.add(new Book("Altimate Java", "Chris", new Category("Coding")));
		books.add(new Book("A Tale Of Two Cities", "Charles Dickens", new Category("Historical Fiction")));
		books.add(new Book("The Little Prince", "Antoine de Saint-Exupery", new Category("Adventure")));
		books.add(new Book("Harry Potter and the Philosopher's Stone", "JK Rowling", new Category("Fantasy")));
		books.add(new Book("And Then There Were None", "Agatha Christie", new Category("Mystery")));
		books.add(new Book("Dream Of The Red Chamber", "Cao Xueqin", new Category("Classics")));
		books.add(new Book("The Hobbit", "JRR Tolkien", new Category("Fantasy")));
		books.add(new Book("The Lion, The Witch and The Wardrobe", "CS Lewis", new Category("Fantasy")));
		books.add(new Book("She: A History of Adventure", "H. Rider Haggard", new Category("Adventure")));
		books.add(new Book("The Da Vinci Code", "Dan Brown", new Category("Mystery")));
		books.add(new Book("Harry Potter and the Chamber of Secrets", "JK Rowling", new Category("Fantasy")));
		books.add(new Book("The Godfather", "Mario Puzo", new Category("Crime")));
		books.add(new Book("Flowers in the Attic", "VC Andrews", new Category("Horror")));
		books.add(new Book("To Kill a Mockingbird", "Harper Lee", new Category("Literary Fiction")));
		books.add(new Book("The Fault in Our Stars", "John Green", new Category("Romance")));
		books.add(new Book("Nineteen Eighty-Four", "George Orwell", new Category("Science Fiction")));
		books.add(new Book("The Eagle Has Landed", "Jack Higgins", new Category("Thrillers")));
		books.add(new Book("The Girl on the Train", "Paula Hawkins", new Category("Thrillers")));
		books.add(new Book("Lust for Life", "Irving Stone", new Category("Biography")));
		books.add(new Book("Animal Farm", "George Orwell", new Category("Humour and satire")));
		books.add(new Book("Jaws", "Peter Benchley", new Category("Horror")));
		books.add(new Book("Dune", "Frank Herbert", new Category("Science Fiction")));
		books.add(new Book("The Diary of Anne Frank", "Anne Frank", new Category("Autobiography and Memoir")));
		books.add(new Book("The Hite Report", "Shere Hite", new Category("Essays")));
		books.add(new Book("Harry Potter and the Prisoner of Azkaban", "JK Rowling", new Category("Fantasy")));
		books.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", new Category("Science Fiction")));
		books.add(new Book("The Bridges of Madison County", "Robert James Waller", new Category("Romance")));
		books.add(new Book("War and Peace", "Leo Tolstoy", new Category("Literary Fiction")));
		books.add(new Book("Rebecca", "Daphne Du Maurier", new Category("Horror")));
		books.add(new Book("Jonathan Livingston Seagull", "Richard Bach", new Category("Fairytales")));
		
		/*
		 * sort the books, by calling the compare method in the Book class
		 * by Category, then Title, then Author name
		 * */
		
		books.sort(new Comparator<Book>() {

			@Override
			public int compare(Book book1, Book book2) {
				return book1.compareTo(book2);
			}
		});
		
		return books;
	}
	
	
	public static List<User> intialUserList() {
	
//		Database db = new Database();
		var users = Database.getUserList();

		users.add(new Admin("Chris Esen", "chris@fon.com", "Fonkeng", new Address()));
		users.add(new Member("Lydia Ade", "ade@funke.com", "Jumobi", new Address()));
		users.add(new Admin("Joshua Abi", "josh@bola.com", "Abimbola", new Address()));
		users.add(new Member("Saye Sayo", "olu@asaye.com", "Busayo", new Address()));
		users.add(new Member("Wale Asaju", "wale@asaj.com", "Oluwale", new Address()));
		users.add(new Member("Default Member", "member@default.com", "PassDefault", new Address()));
		users.add(new Admin("Default Admin", "admin@default.com", "PassDefault", new Address()));
		
		return users;
	}

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
}

