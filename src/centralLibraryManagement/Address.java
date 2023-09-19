package centralLibraryManagement;

/**
 * The Address class models the user's address (street, city, state, country)
 * @author Group 15
 */
public class Address {
	//fields
	private String street;
	private String city;
	private String state;
	private String country;

	//constructors
	
	/**
	 * @param street name of the address.
	 * @param city name of the address
	 * @param city in which the address of the member is located.
	 * @param country in which the address of the member is located
	 * 
	 */
	public Address(String street, String city, String state, String country) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	/**
	 * default constructor
	 */
	public Address() {
		this("", "" , "" , "" ); 
	}

	/**return the member address of the street 
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**set the street of the member
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**return the member city
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**set member city 
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**return the member state in the address
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**set the member state in the address
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**return the member country in the address
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**set the member country in the address
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	/**
	 * @return the textual representation of an Address
	 */
	public String toString() {
		return "Address [street=" + street + ", city=" + city + "]";
	}

}
