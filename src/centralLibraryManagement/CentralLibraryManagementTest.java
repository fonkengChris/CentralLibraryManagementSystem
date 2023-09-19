/**
 * 
 */
package centralLibraryManagement;

import java.util.Scanner;

/**
 * The Test class runs the entire project from the main method.
 * The main method makes use of an infinite while loop to continuously test different functionalities.
 * The functions of the system are only accessible after a successful user login
 * @author Group 15
 */
public class CentralLibraryManagementTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Display menu of actions that can be performed on system.
		 * User expected to select any number from 1 to 7 to apply a usecase,
		 * or 8 to quit.
		 * */
		System.out.println(Color.MAGENTA_BACKGROUND);
		System.out.println(Color.WHITE_BOLD);
		System.out.println("Welcome to the Central Library");
		System.out.println("************************************************ \n");
		System.out.println(Color.RESET);

		/* Default Member Login:
		 *  email: member@default.com, password: PassDefault
		 *
		 * Default Admin Login: 
		 * email: admin@default.com, password: PassDefault
		 * 
		 * Other already created users can be found in the DBInit class, initialUserList method. 
		 * */


		System.out.println(Color.YELLOW_BOLD_BRIGHT);
		var loggedInMember = Database.login();
		System.out.println(Color.RESET);
		progRun(loggedInMember);
	}
		/**
		 * Display menu of actions that can be performed on system.
		 * User expected to select any number from 1 to 7 to apply a usecase,
		 * or 8 to quit.
		 * */
		public static void progRun(User loggedInUser) {

			Scanner scanner = new Scanner(System.in);

			var bookList = DBInit.intialBookList();
			var userList = DBInit.intialUserList();
			var recordList = Database.getRecordList();

			if (loggedInUser instanceof Admin) {
				System.out.println(Color.CYAN_BOLD);
				System.out.println("Welcome " + loggedInUser.getName() + " to the admin menu");
				System.out.println("Possible actions: \n");

				System.out.println("1. Add new book to library.");
				System.out.println("2. Remove book from library.");
				System.out.println("3. Check for available books in library.");
				System.out.println("4. Search for particular books.");
				System.out.println("5. Borrow book.");
				System.out.println("6. Return book.");
				System.out.println("7. Register a new member to library.");
				System.out.println("8. Remove a member from library.");
				System.out.println("9. Check list of library members.");
				System.out.println("10. Search for particular members.");
				System.out.println("11. Display my transactions");
				System.out.println("12. Display all transactions");
				System.out.println("13.Display particular transactions");
				System.out.println("14. Logout."); //This is different from exiting the system.
				System.out.println("15. Quit"); //This brings and end to the current running program.
				System.out.println(Color.RESET);


				/*This is an infinite while loop that keeps the test program running continuously 
				 * Until the user chooses to quit.
				 */
				while (true) {

					System.out.println(Color.BLUE_BOLD_BRIGHT);
					System.out.println(loggedInUser.getName() + " Make your choice from the menu");
					System.out.println(Color.RESET);

					int choice = scanner.nextInt();	

					//This switch statement is used to implement the menu.
					switch (choice) {
					case 1: 
						Database.addBook(bookList);
						break;

					case 2:
						System.out.println(Color.CYAN_BACKGROUND);
						System.out.println(Color.BLUE_BOLD);
						System.out.println(bookList);
						System.out.println(Color.RESET);
						Database.removeBook();
						break;

					case 3:
						System.out.println(Color.CYAN_BACKGROUND);
						System.out.println(Color.BLUE_BOLD);
						System.out.println(bookList);
						System.out.println(Color.RESET);
						break;	

					case 4:
						
						System.out.println(Color.CYAN_BACKGROUND);
						System.out.println(Color.BLUE_BOLD);
						BookManagement.generalSearch(bookList);
						System.out.println(Color.RESET);
						break;
						
					case 5:
						//borrow book
						loggedInUser.requestBook();
						break;
						
					case 6:
					//	return book
						loggedInUser.returnBook();
						break;
						
					case 7:
						Database.addUser(userList);
						break;

					case 8:
						System.out.println(Color.GREEN_BOLD);
						System.out.println(userList);
						System.out.println(Color.RESET);
						Database.removeMember();
						break;

					case 9:
						System.out.println(Color.GREEN_BOLD);
						System.out.println(userList);
						System.out.println(Color.RESET);
						break;

					case 10:
						System.out.println(Color.BLUE_BOLD);
						MemberManagement.generalSearch(userList);
						System.out.println(Color.RESET);
						break;
						
					case 11:
						System.out.println(RecordManagement.searchRecordByMember(Database.getRecordList(), 
								loggedInUser.getName()));
						break;
						
					case 12:
						System.out.println(Color.GREEN_BOLD);
						System.out.println(recordList);
						System.out.println(Color.RESET);
						break;
						
					case 13:
						System.out.println(Color.BLUE_BOLD);
						RecordManagement.generalSearch(Database.getRecordList());
						System.out.println(Color.RESET);
						break;
						
					case 14:
						// logout
						System.out.println(Color.GREEN_BACKGROUND);
						System.out.println(Color.WHITE_BOLD_BRIGHT);
						System.out.println(loggedInUser.getName() + " logged out successfully. \n");
						System.out.println(Color.RESET);
						
						//Request next login
						System.out.println(Color.YELLOW_BOLD_BRIGHT);
						var loggedInUser1 = Database.login();
						System.out.println(Color.RESET);
						
						//Run tasks for next logged in user
						System.out.println(Color.YELLOW_BOLD_BRIGHT);
						progRun(loggedInUser1);
						System.out.println(Color.RESET);
						return;
						
					case 15: 
						System.out.println(Color.YELLOW_BOLD);
						System.out.println("Thanks for using the Library \n");
						System.out.println("See you next time. Bye!!!");
						System.out.println(Color.RESET);
						return;


					default:
						throw new IllegalArgumentException("Unexpected value: " + choice);
					}


				}

			}

			else if (loggedInUser instanceof Member) {
				System.out.println(Color.MAGENTA_BOLD);
				System.out.println("Welcome " + loggedInUser.getName() + " to the member menu");
				System.out.println("Possible actions: \n");

				System.out.println("1. Check for available books in library.");
				System.out.println("2. Search for particular books.");
				System.out.println("3. Borrow book.");
				System.out.println("4. Return book.");
				System.out.println("5. See my Transactions");
				System.out.println("6. Logout");
				System.out.println("7. Quit");

				System.out.println(Color.RESET);

				/*This is an infinite while loop that keeps the test program running continuously 
				 * Until the user chooses to quit.
				 */
				while (true) {

					System.out.println(Color.BLUE_BOLD_BRIGHT);
					System.out.println(loggedInUser.getName() + " Make your choice from the menu");
					System.out.println(Color.RESET);

					int choice = scanner.nextInt();	

					//This switch statement is used to implement the menu.
					switch (choice) {

					case 1:
						System.out.println(Color.CYAN_BACKGROUND);
						System.out.println(Color.BLUE_BOLD);
						System.out.println(bookList);
						System.out.println(Color.RESET);
						break;	

					case 2:
						System.out.println(Color.BLUE_BOLD);
						BookManagement.generalSearch(bookList);
						System.out.println(Color.RESET);
						break;

					case 3:
						loggedInUser.requestBook();
						break;

					case 4:
						loggedInUser.returnBook();
						break;

					case 5:
						System.out.println(RecordManagement.searchRecordByMember(Database.getRecordList(), 
								loggedInUser.getName()));
						break;

					case 6:
						System.out.println(Color.GREEN_BACKGROUND);
						System.out.println(Color.WHITE_BOLD_BRIGHT);
						System.out.println(loggedInUser.getName() + " logged out successfully.");
						System.out.println(Color.RESET);
						
						//Request next login
						System.out.println(Color.YELLOW_BOLD_BRIGHT);
						var loggedInUser1 = Database.login();
						System.out.println(Color.RESET);
						
						//Run tasks for next logged in user
						progRun(loggedInUser1);
						return;

					case 7: 
						System.out.println(Color.YELLOW_BOLD);
						System.out.println("Thanks for using the Library \n");
						System.out.println("See you next time. Bye!!!");
						System.out.println(Color.RESET);
						return;


					default:
						throw new IllegalArgumentException("Unexpected value: " + choice);
					}


				}

			}

			else {
				System.err.println("Invalid login details");
			}


	}

}