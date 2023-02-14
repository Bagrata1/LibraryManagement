package datastructures;
/**
 * 
 * @author ibagr
 * Class representing a Bluray item in a library, extending the Borrowable class.
 *
 */

//Changed from Borrowable to Borrowable<Bluray>
public class Bluray extends Borrowable<Bluray> {
    /**
     * Constructor for Bluray class.
     * @param title : Title of the Bluray.
     * @param yearOfPublication : Year the Bluray was published.
     * @param ID : Unique identifier for the Bluray.
     * @param section : The section the Bluray belongs to.
     */
	public Bluray(String title, int yearOfPublication, int ID, String section) {
		super(title, yearOfPublication, ID, section);
	}

	@Override
	public String toString() {
		return "Bluray : title=" + getTitle() + ", yearOfPublication=" + getYear() + ", ID=" + getID();
	}

}
