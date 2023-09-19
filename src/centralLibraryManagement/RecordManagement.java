
package centralLibraryManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The record management class is implemented to handle functionalities relating to transaction records
 * @author Group 15
 */
public class RecordManagement {
	//field
	private static List<Transaction> recordList;


	/**
	 * @return the recordList
	 */
	public static List<Transaction> getRecordList() {
		return recordList;
	}

	/**
	 * @param recordList the recordList to set
	 */
	public static void setRecordList(List<Transaction> recordList) {
		RecordManagement.recordList = recordList;
	}

	/**
	 * @param records  this is the list of transaction
	 * @param record a particular transaction made
	 * 
	 * @return this return the updated list
	 */
	public static List<Transaction> addRecord(List<Transaction> records, Transaction record) {	
		var recordList = records;
		Librarian.setTransactions(recordList);
		recordList.add(record);
		setRecordList(recordList);
		return recordList;
	}

	/**
	 * @param records this is the list of transaction made
	 * @param record this is a particular transaction made
	 */
	public static void removeRecord(List<Transaction> records, Transaction record) {
		var recordList = records;
		recordList.remove(record);
		setRecordList(recordList);
	}

	/**
	 * @param recordList  list of all transaction made
	 * @param memberName this is the name of the user or member 
	 * 
	 * @return the list of all transaction made by the member
	 */
	public static List<Transaction> searchRecordByMember(List<Transaction> recordList, String memberName) {
		List<Transaction> tempList = new ArrayList<Transaction>();
		for (Transaction record : recordList) {
			if (record.getUser().getName().contains(memberName)) {
				tempList.add(record);
			}
		}

		return tempList;
	}

	/**
	 * 
	 * @param recordList recordList  list of all transaction made
	 * @param bookTitle this  is the title of the book searched for
	 * 
	 * @return the list of all transaction made by the bookTitle
	 */
	public static List<Transaction> searchRecordByBookTitle(List<Transaction> recordList, String bookTitle) {
		List<Transaction> tempList = new ArrayList<Transaction>();
		for(var record: recordList) {
			if (record.getBook().getTitle().contains(bookTitle)) {
				tempList.add(record);
			}
		}

		return tempList;
	}

	/**
	 * @param recordList recordList  list of all transaction made
	 * @param statusName this  is the status of the transaction (active or archived)
	 * 
	 * @return the list of all transactions with a given status
	 */
	public static List<Transaction> searchRecordByStatus(List<Transaction> recordList, String statusName) {

		List<Transaction> tempList = new ArrayList<Transaction>();
		for(var record: recordList) {
			if (record.getStatus().equalsIgnoreCase(statusName)) {
				tempList.add(record);
			}
		}

		return tempList;
	}

	/**
	 * @param records, the list of transactions
	 * */
	public static void generalSearch(List<Transaction> records) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose from the options below for your transaction search: ");
		System.out.println("1. By Member");
		System.out.println("2. By Book");
		System.out.println("3. By status");

		int choice = scanner.nextInt();	
		Scanner sc = new Scanner(System.in);


		switch (choice) {
		case 1: 
			System.out.println("Enter Name of member: ");
			var name =  sc.nextLine();
			System.out.println(searchRecordByMember(records, name));
			break;

		case 2: 
			System.out.println("Enter title of book: ");
			var title =  sc.nextLine();
			System.out.println(searchRecordByBookTitle(records, title));
			break;

		case 3: 
			System.out.println("Enter status (regular or irregular): ");
			var status =  sc.nextLine();
			System.out.println(searchRecordByStatus(records, status));
			break;

		default:
			System.err.println("Invalid option!!!");
		}

	}

}
