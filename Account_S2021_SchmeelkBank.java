/***
 * Group 4 - Spring 2021
 * @author Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine
 * This is the parent class for both Checking and Savings Account
 *
 */
public class Account_S2021_SchmeelkBank {
	/**
	 * The id and (account) name is common knowledge
	 */
	private String id;
	private String name;
	/**
	 * First constructor for the Account class
	 */
	public Account_S2021_SchmeelkBank() {
		
	}
	/**
	 * Second constructor for the Account Class
	 * @param id Set Account ID in the constructor
	 * @param name Set Account Name in the constructor
	 */
	public Account_S2021_SchmeelkBank(String id, String name) {
		this.id = id;
		this.name = name;
	}
	/**
	 * 
	 * @return the Account ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 * @param id Sets Account ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 
	 * @return Account Name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name Sets Account Name
	 */
	public void setName(String name) {
		this.name = name;
	}	
}
