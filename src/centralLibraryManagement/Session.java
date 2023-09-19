

package centralLibraryManagement;

import java.util.List;

/**
 * The Session class is a generic class for handling user logins 
 * @author Group 15
 */
public class Session {

	//Fields
	private static List<User> userList;


	/*
	 * No constructor for this class, since it's a helper class. No instance of it will be 
	 * required, hence the methods are all declared as static such that they are available to the 
	 * entire class and not a single instance (object) of the class.
	 * */

	/**
	 * @param userList the memberList to set
	 */
	public static void setUserList(List<User> userList) {
		Session.userList = userList;
	}

	/** Login to the library
	 * 
	 * @param email,  the userName of the book member
	 * @param password,  the password of the book member
	 * 
	 * @return user, the current logged in user
	 */
	public static User login(String email, String password) {
		setUserList(DBInit.intialUserList());
		for(var user: userList) {
			/*
			 * Compare the email address and password from the input with all those in the member list
			 * Prints the login success message if the condition above is true
			 * */

			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				System.out.println(Color.GREEN_BACKGROUND);
				System.out.println(Color.WHITE_BOLD_BRIGHT);
				System.out.println("Login successful!!!");
				System.out.println(Color.RESET);
				return user;
			}
			else {
				continue;
			}


		}

		//if the username and password don't match any found, then it prints the error message
		System.err.println("Wrong email or password!!!");
		return null;
	}

}
