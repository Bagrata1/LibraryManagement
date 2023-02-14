package datastructures;
/**
 * 
 * @author ibagr
 * Class representing a Book item in a library, extending the Borrowable class.
 * 
 */
// Changed from Borrowable to Borrowable<Book>
public class Book extends Borrowable<Book> {
	private String author;
 /**
 * Constructor for Book class.
 * @param author : The author of the book.
 * @param title : Title of the book.
 * @param yearOfPublication : Year the book was published.
 * @param ID : Unique identifier for the book.
 * @param section : The section the book belongs to.
 */
	public Book(String author, String title, int yearOfPublication, int ID, String section) {
		super(title, yearOfPublication, ID, section);
		this.author = author;
	}
/**
 * Get the author of the book.
 * @return author of the book.
 */
	public String getAuthor() {
		return author;
	}
 /**
 * Set the author of the book.
 * @param author new author of the book.
 */
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book : author=" + author + ", Title=" + getTitle() + ", Year=" + getYear() + ", ID=" + getID();
	}

}
