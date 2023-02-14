package datastructures;
/**
 * 
 * @author ibagr
 * 
 * Main method to run the program
 * 
 * 1. Add publications
 * 2. Add regular and VIP clients
 * 3. Displaying clients
 * 4. Displaying publications
 * 5. Adding and displaying sections
 * 6. Finding Shortest path between a publication and source.
 * 7. Checking variable types of added clients and publications
 * 8. Borrowing and returning a book
 * 
 */
public class Main {

	public static void main(String[] args) {

		LibraryManagementSystem library = new LibraryManagementSystem();
		System.out.println("==========================================");
		System.out.println("Adding Publications : ");
		System.out.println("==========================================");
		library.addBook("Hemingway", "Old man and the sea", 1932, "A");
		library.addBook("Hemingway", "Farewell to arms", 1950, "B");
		library.addBook("Folklore", "Fables", 1850, "C");
		library.addBook("Herman Melville", "Moby-Dick", 1851, "D");
		library.addBlueRay("Avatar", 2009, "A");
		library.addBlueRay("Bullet Train", 2022, "B");
		library.addBlueRay("Titanic", 1999, "C");
		library.addBlueRay("Gray Man", 2022, "D");
		library.addBlueRay("Ratatouille", 2007, "B");
		library.addCD("Madonna", "SMTH", 1989, "A");
		library.addCD("Michael Jackson", "Bad", 2001, "B");
		library.addCD("Jamiroquai", "Space Cowboy", 1996, "C");
		library.addCD("Adele", "Hello", 2017, "D");
		library.addMagazine("Rolling Stones", 2022, 1000, "A");
		library.addMagazine("Vogue", 2022, 1010, "B");
		library.addMagazine("Top Gear", 2022, 900, "C");
		library.addMagazine("PlayBoy", 2022, 1001, "D");
		System.out.println();
		System.out.println("==========================================");
		System.out.println("Adding Clients:");
		System.out.println("==========================================");
		System.out.println();
		library.addClient("John", "N/A");
		library.addClient("Bob", "N/A");
		library.addVIPClient("Mary", "N/A");
		library.addVIPClient("Suzan", "N/A");
		System.out.println("==========================================");
		System.out.println();
		System.out.println("Displaying Clients:");
		System.out.println();
		library.printAllClients();
		System.out.println();
		System.out.println("==========================================");
		System.out.println("Displaying All publications:");
		System.out.println();
		library.printAllPublications();
		System.out.println("==========================================");
		library.addSection("A");
		library.addSection("B");
		library.addSection("C");
		library.addSection("D");
		library.addSection("E");
		library.connectSections("A", "B");
		library.connectSections("A", "C");
		library.connectSections("B", "C");
		library.connectSections("C", "D");
		library.connectSections("D", "E");
		System.out.println("Displaying Sections:");
		System.out.println();
		// Finding shortest path between item with ID=0 and section E
		library.findShortestPath(0, "E");
		System.out.println("Adding shortcut and testing BFS again!");
		library.connectSections("B", "E");
		library.findShortestPath(0, "E");
		System.out.println("=======================================================================\n");
		System.out.println("Checking variable type of first publication added to library (Should be a book):");
		System.out.println(library.publications.getFirst().getClass().getSimpleName());
		System.out.println("=======================================================================");
		System.out.println("Checking variable type of first user added to library (should say RegularClients):");
		System.out.println();
		System.out.println(library.users.getFirst().getClass().getSimpleName());
		System.out.println("=======================================================================");
		System.out.println("Checking variable type of last user added to library (should say VIP):");
		System.out.println();
		System.out.println(library.users.getLast().getClass().getSimpleName());
                
               
		library.borrowBook(17, "Hemingway", "Farewell to arms");
		library.borrowBook(18, "Hemingway", "Farewell to arms");
		library.borrowBook(19, "Hemingway", "Farewell to arms");
		library.borrowBook(20, "Hemingway", "Farewell to arms");
                library.returnItem(1);
	}

}
