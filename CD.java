package datastructures;
/**
 * 
 * @author ibagr
 * Class representing a CD item in a library, extending the Borrowable class.
 */
//Changed from Borrowable to Borrowable<CD>
public class CD extends Borrowable<CD> {

	private String author;
	 /**
	 * Constructor for Book class.
	 * @param author : The author of the CD.
	 * @param title : Title of the CD.
	 * @param yearOfPublication : Year the CD was published.
	 * @param ID : Unique identifier for the CD.
	 * @param section : The section the CD belongs to.
	 */
	public CD(String author, String title, int yearOfPublication, int ID, String section) {
		super(title, yearOfPublication, ID, section);
		this.author = author;
	}
    /**
    * setter method to set the author of the CD
    * @param author : author of the CD
    */
	public void setAuthor(String author) {
		this.author = author;
	}
    /**
    * getter method to get the author of the CD
    * @return : author of the CD
    */
	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "CD : author=" + author + ", Title=" + getTitle() + ", Year=" + getYear() + ", ID=" + getID();
	}

}
