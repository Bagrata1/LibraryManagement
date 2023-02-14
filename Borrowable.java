package datastructures;
/**
 * 
 * @author ibagr
 * Borrowable is an abstract class that represents a borrowable item.
 * Implements abstract borrowable class from which other classes (Book,Bluray,Magazine,CD) inherit 
 * 
 * 
 */
public abstract class Borrowable<T> {
	//private variables to store the title,year of publication, ID and section of the borrowable item
	private String title;
	private int yearOfPublication;
	private int ID;
	private String section;
	//private variable to store the borrowed status of the item
	private boolean borrowed = false;
	//private variable to store the client who borrowed the item
	private int borrowedBy;

 /**
 * Constructor for Borrowable class.
 * @param title : Title of the item.
 * @param yearOfPublication : Year the item was published.
 * @param ID : Unique identifier for the item.
 * @param section : The section the item belongs to.
 */
	public Borrowable(String title, int yearOfPublication, int ID, String section) {

		this.title = title;
		this.yearOfPublication = yearOfPublication;
		this.ID = ID;
		this.section = section;
	}

// Getters and setters for class properties
	
	/**
	* getter method to get the title of the item
	* @return : title of the item
	*/
	public String getTitle() {
		return title;
	}
    /**
    * setter method to set the title of the item
    * @param title : title of the item
    */
	public void setTitle(String title) {
		this.title = title;
	}
    /**
    * getter method to get the year of publication of the item
    * @return : year of publication of the item
    */
	public int getYear() {
		return yearOfPublication;
	}
    /**
    * setter method to set the year of publication of the item
    * @param year : year of publication of the item
    */
	public void setYear(int year) {
		this.yearOfPublication = year;
	}
    /**
    * getter method to get the identification number of the item
    * @return : identification number of the item
    */
	public int getID() {
		return ID;
	}
    /**
    * setter method to set the identification number of the item
    * @param uniqueID : identification number of the item
    */
	public void setID(int uniqueID) {
		this.ID = uniqueID;
	}
    /**
    * getter method to get the section in which the item is located
    * @return : section in which the item is located
    */
	public String getSection() {
		return section;
	}
    /**
    * setter method to set the section in which the item is located
    * @param section : section in which the item is located
    */
	public void setSection(String section) {
		this.section = section;
	}
    /**
    * method to check if the item is borrowed
    * @return : boolean indicating if the item is borrowed
    */
	public boolean isBorowed() {
		return borrowed;
	}
    /**
    * method to set the item as borrowed
    * @param client : ID of the client who borrowed the item
    */
	public void borrowitem(int client) {
		this.setBorrowedBy(client);
		this.borrowed = true;
	}
    /**
    * method to set the borrowed item as returned
    */
	public void returnitem() {
		this.setBorrowedBy(-1);
		this.borrowed = false;
	}
    /**
    * getter method to get the ID of the client who borrowed the item
    * @return : ID of the client who borrowed the item
    */
	public int getBorrowedBy() {
		return borrowedBy;
	}
    /**
    * setter method to set the ID of the client who borrowed the item
    * @param borrowedBy : ID of the client who borrowed the item
    */
	public void setBorrowedBy(int borrowedBy) {
		this.borrowedBy = borrowedBy;
	}
	@Override
	public String toString() {
		return "Borrowable [title=" + title + ", yearOfPublication=" + yearOfPublication + ", uniqueID=" + ID + "]";
	}
}
