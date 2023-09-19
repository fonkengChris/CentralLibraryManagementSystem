package centralLibraryManagement;


import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

/**
 * The Member class models the users with limited permissions and restricted access to system functionalities
 * @author Group 15
 */

public class Member extends User{

	//Fields 


	//Constructors

	public Member()  { 
		super();
	}

	/**
	 * custom constructors
	 * @param name name of the member
	 * @param email email of the member
	 * @param password password of the member
	 * @param address address of the member
	 */
	public Member(String name, String email, String password, 
			Address address) {
		super(name, email, password, address);
	}



	@Override
	/**
	 * @return a textual representation of the member
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


