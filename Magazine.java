package datastructures;
/**
 * 
 * @author ibagr
 * Class representing a Magazine item in a library, extending the Borrowable class.
 */
// Changed from Borrowable to Borrowable<Magazine>
public class Magazine extends Borrowable<Magazine> {

	private int issueOfPublication;
    /**
     * Constructor for Magazine class.
     * @param title : Title of the Magazine.
     * @param yearOfPublication : Year the Magazine was published.
     * @param ID : Unique identifier for the Magazine.
     * @param section : The section the Magazine belongs to.
     */
	public Magazine(String title, int yearOfPublication, int issueOfPublication, int ID, String section) {
		super(title, yearOfPublication, ID, section);
		this.issueOfPublication = issueOfPublication;

	}

	public int getIssueOfPublication() {
		return issueOfPublication;
	}

	@Override
	public String toString() {
		return "Magazine : issueOfPublication=" + issueOfPublication + ", Title=" + getTitle() + ", ID=" + getID();
	}

}

