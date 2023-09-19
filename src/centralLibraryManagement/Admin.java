package centralLibraryManagement;

import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * The Admin class models the users with full permissions and unrestricted access to system functionalities
 * @author Group 15
 */
public class Admin extends User{
	/**
	 *This does not have a fields because it will inherit the fields from the User class
	 */

	//Constructors
	/**
	 * default constructors
	 */
	public Admin()  { 
		super();
	}

	/**
	 * custom constructors
	 * @param name name of the admin
	 * @param email email of the admin
	 * @param password password of the admin
	 * @param address address of the admin
	 */
	public Admin(String name, String email, String password, 
			Address address) {
		super(name, email, password, address);
	}



	@Override
	/**
	 * @return this return a textual representation of an Admin
	 */
	public String toString() {
		return super.toString();
		//password field omitted for security reasons
	}


	/** 
	 * @param obj the object to compare this Member against.
	 * 
	 * @return true if the given object represents a Member equivalent to this member, false otherwise.
	 */

	@Override
	public boolean equals(Object obj) {
		// test exceptional cases, i.e. obj is a Die, and not null
		if ((this.getClass() != obj.getClass()) || (obj == null))
			return false;

		User other = (User) obj; // cast to a Die object

		// compare sides and score names using the == operator as they are primitive types
		return super.equals(obj);
	}

}
