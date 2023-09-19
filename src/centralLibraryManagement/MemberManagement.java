
package centralLibraryManagement;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The member management class is implemented to handle functionalities relating to users only
 * @author Group 15
 */
public class MemberManagement implements Comparable<User>{
	//Fields
	private static List<User> userList;


	/**
	 * No constructor for this class, since it's a helper class. No instance of it will be 
	 * required, hence the methods are all declared as static such that they are available to the 
	 * entire class and not a single instance (object) of the class.
	 * */


	//Methods

	/** Set the memberList to a given value
	 * 
	 * @param userList, the list of the all registered members.
	 */
	public static void setUserList(List<User> userList) {
		MemberManagement.userList = userList;
	}

	/** Returns the number of members in the list.
	 * 
	 * @return the number of registered members.
	 */
	public int getNumberOfMembers() {
		return userList.size();
	}


	/** Register the new member and add to existing list
	 * 
	 * @param userList, the list of registered members.
	 * @param name,  the username of the book member
	 * @param password,  the password of the book member
	 * @param address,  the address of the book member
	 * 
	 * @return list of members, including the newly added
	 */
	public static List<User> addNew(List<User> userList, String name, 
			String email, String password, Address address) {

		if(!userList.isEmpty()) {

			//Check if the user already exists before adding
			for (var user: userList) {
				if((user.getName().equals(name)) && (user.getPassword().equals(password)) 
						) {
					System.err.println("Library already contains this member!!!");
					setUserList(userList);
					return userList;
				}

			}
		}

		userList.add( new User(name, email, password, address));
		System.out.println(Color.GREEN_BACKGROUND);
		System.out.println(Color.WHITE_BOLD_BRIGHT);
		System.out.println("Registration successful!!!");
		System.out.println(Color.RESET);

		//Welcome message for the last member on the list (newly added)
		System.out.println(userList.get(userList.size() - 1).getName() + " you are welcome!!!");

		setUserList(userList);
		return userList;
	}


	/** Remove the member with the given id.
	 * 
	 * @param idNumber,  the idNumber of the book member
	 */

	public static void remove(int idNumber) {

		//Member can only be removed from a non empty list, else print error message.
		if (!userList.isEmpty()) {
			// removes member with the specified id;
			for(var user: userList) {
				if (user.getUserId() == idNumber) {
					userList.remove(user);
					System.out.println(Color.MAGENTA_BOLD);
					System.out.println(user.getName() + " removed successfully");
					System.out.println(Color.RESET);
				}
			}

			setUserList(userList);
		}

		else {
			System.err.println("Error... Empty list!!!");
		}

	}

	/** Login to the library
	 * 
	 * @param email,  the userName of the book member
	 * @param password,  the password of the book member
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

	public static List<User> searchUserByName(List<User> userList, String name) {
		List<User> tempList = new ArrayList<User>();
		for (var user : userList) {
			if (user.getName().contains(name)) {
				tempList.add(user);
			}
		}

		return tempList;
	}

	/**
	 *  
	 * @param userList list of users 
	 * @param roleName  roles of the users
	 * @return
	 */
	public static List<User> searchUserByRole(List<User> userList, String roleName) {
		List<User> tempList = new ArrayList<User>();

		if (roleName.equalsIgnoreCase("admin")) {
			System.out.println("List of Admin users: \n");
			for(var user: userList) {
				if (user instanceof Admin) {
					tempList.add(user);
				}
			}
		}

		else if (roleName.equalsIgnoreCase("member")) {
			System.out.println("List of Member users: \n");
			for(var user: userList) {
				if (user instanceof Member) {
					tempList.add(user);
				}
			}
		}

		else {
			System.out.println("Invalid Role");
		}

		return tempList;
	}

	public static List<User> searchUserByStatus(List<User> userList, String statusName) {
		//			System.out.println("in the private method" + categoryName);
		List<User> tempList = new ArrayList<User>();
		for(var user: userList) {
			if (user.getAccount().getStatus().getStatusName().equalsIgnoreCase(statusName)) {
				tempList.add(user);
			}
		}

		return tempList;
	}

	/**
	 * @param users list of users
	 */
	public static void generalSearch(List<User> users) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose from the options below for your book search: ");
		System.out.println("1. By name");
		System.out.println("2. By role");
		System.out.println("3. By status");

		int choice = scanner.nextInt();	
		Scanner sc = new Scanner(System.in);


		switch (choice) {

		case 1: 
			System.out.println("Enter name of member: ");
			var name =  sc.nextLine();
			System.out.println(searchUserByName(users, name));
			break;

		case 2: 
			System.out.println("Enter role of member: ");
			var role =  sc.nextLine();
			System.out.println(searchUserByRole(users, role));
			break;

		case 3: 
			System.out.println("Enter status of user: ");
			var status =  sc.nextLine();
			System.out.println(searchUserByStatus(users, status));
			break;

		default:
			System.err.println("Invalid option!!!");
		}
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
