package centralLibraryManagement;

/**
 *The Status class models the status of a user-account
 * @author Group 15
 */
public class Status {

	//fields
	private String statusName;
	private Double fine;

	// constructors

	public Status() {
		// TODO Auto-generated constructor stub
		this.statusName = "Regular";
		this.fine = 0.0;
	}

	/**
	 * @param statusName  this is the status of a member if it is (regular or irregular)
	 * @param fine this is the fine to be paid by the member
	 */
	public Status(String statusName, Double fine) {
		this.statusName = statusName;
		this.fine = fine;
	}

	/**
	 * @return the statusName if it is (regular or irregular)
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName this is the statusName of the member
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/** 
	 * @return the the fine to be paid by the member
	 */
	public Double getFine() {
		return fine;
	}

	/** 
	 * @param fine set fine to be paid by the member
	 */
	public void setFine(Double fine) {
		this.fine = fine;
	}

	@Override
	/**
	 * @return the textual representation of the status
	 */
	public String toString() {
		return "Status [statusName=" + statusName + ", fine=" + fine + "]";
	}


}
