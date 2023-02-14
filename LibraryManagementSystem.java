package datastructures;

/**
 * @author ibagr
Class LibraryManagementSystem implements ILibraryManagement interface. It's responsible for managing the library's resources,
such as books, magazines, CDs, and Blurays. It also keeps track of the regular and VIP clients.
The class includes methods for adding and printing different types of publications and clients. It also contains an ID variable
that is used to assign unique IDs to each added publication or client.
The class also includes Vector objects for storing publications and clients, as well as a Graph object for managing the library's sections.
*/

public class LibraryManagementSystem implements ILibraryManagement {

    private int ID = 0; //variable to keep track of unique IDs for publications and clients
    private String pubID = "PUB"; // prefix for publication IDs
    private String userID = "U"; // prefix for user IDs
    Vector publications = new Vector(20); // Vector to store publications
    Vector users = new Vector(20); // Vector to store clients
    private Graph graph = new Graph(); // Graph object to manage library sections
    private Queue queue = new Queue(); //Queue object to manage borrow/return requests

    @Override
    /**
     *Method that adds a new book to the library.
     *@param author : The author of the book
     *@param title : The title of the book
     *@param yearOfPublication : The year the book was published
     *@param section : The section of the library the book belongs to
     *@return ID : Returns the unique ID assigned to the book
    */
    public int addBook(String author, String title, int yearOfPublication, String section) {
    	// Create new book object and adds it to the publications vector
        publications.addLast(new Book(author, title, yearOfPublication, ID, section));
        setPubID(getPubID() + ID); // Update the publication ID
        ID++; // Increment ID 
        System.out.println("The book is added.");
        return ID; // return new ID

    }

    @Override
    /**
     *Method that adds a new magazine to the library.
     *@param title : The title of the magazine
     *@param yearOfPublication : The year the magazine was published
     *@param section : The section of the library the magazine belongs to
     *@return ID : Returns the unique ID assigned to the magazine
    */
    public int addMagazine(String title, int yearOfPublication, int issue, String section) {
    	// Create new magazine object and adds it to the publications vector
        publications.addLast(new Magazine(title, yearOfPublication, issue, ID, section));
        setPubID(getPubID() + ID); // update the publication ID
        ID++; // Increment ID
        System.out.println("The Magazine is added.");
        return ID; // return new ID
    }

    @Override
    // same as addMagazine method
    /**
     *This method adds a new Bluray object to the publications.
     *@param title : the title of the Bluray
     *@param yearOfPublication : the year of publication of the Bluray
     *@param section : the section the Bluray belongs to
     *@return ID : the ID of the newly added Bluray
     */
    public int addBlueRay(String title, int yearOfPublication, String section) {
    	// Create new Bluray object and adds it to the publications vector
        publications.addLast(new Bluray(title, yearOfPublication, ID, section));
        setPubID(getPubID() + ID); // update the publication ID
        ID++; // Increment ID
        System.out.println("The Bluray is added.");
        return ID; // return new ID
    }

    @Override
    /**
     *This method adds a new CD object to the publications.
     *@param title : the title of the CD
     *@param yearOfPublication : the year of publication of the CD
     *@param section : the section the CD belongs to
     *@return ID : the ID of the newly added CD
     *
     * Same implementation as addBook method.
     */
    public int addCD(String author, String title, int yearOfPublication, String section) {
        publications.addLast(new CD(author, title, yearOfPublication, ID, section));
        setPubID(getPubID() + ID);
        ID++;
        System.out.println("The CD is added.");
        return ID;
    }

    @Override
    /**
     *This method adds a new regular Client object to the users.
     *@param name : name of the client
     *@param email : email of the client
     *@return ID : the ID of the newly added client
     *
     */
    public int addClient(String name, String email) {
    	// create a new RegularClients object with the provided name, email, and a unique ID
        users.addLast(new RegularClients(name, email, ID));
        setUserID(getUserID() + ID); // add the unique ID to the userID prefix
        ID++; // increment the ID
        System.out.println("The Client is added.");
        return ID;
    }

    @Override
    /**
     *This method adds a new VIP Client object to the users.
     *@param name : name of the client
     *@param email : email of the client
     *@return ID : the ID of the newly added VIP client
     *
     */
    public int addVIPClient(String name, String email) {
    	// create a new VIP user object with provided name, email, and a unique ID
        users.addLast(new VIP(name, email, ID));
        setUserID(getUserID() + ID); // add the unique ID to the userID prefix
        ID++; // increment the ID
        System.out.println("The VIP Client is added.");
        return ID;
    }

    @Override
    /**
     * This method prints information of all publications in the library
     */
    public void printAllPublications() {
    //loop through the publications Vector and print each publication's information
        for (int i = 0; i < publications.size(); i++) {
            System.out.println(publications.get(i).toString());
        }
    }

    @Override
    /**
     * This method prints information about all the clients registered in the library.
     */
    public void printAllClients() {
    //loop through the users Vector and print each client's information
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }
    }
    /**
     *The method for borrowing a publication.
     *@param item : The publication to be borrowed.
     *@param c : The client who is borrowing the publication.
     */
    public void borowPublication(Borrowable item, Clients c) {
        int client = c.getUserID(); // Get the user ID of the client
        if (!item.isBorowed()) { // Check if the item is already borrowed
            item.borrowitem(client); // If not, borrow the item for the client
        } else {
        	// If the item is already borrowed, add the item and client to the queue.
            Vector v = new Vector(2);
            v.addFirst(item);
            v.addLast(c);
            queue.push(v);
         // Print the current queue
            queue.printQueue();
            System.out.println("----------");
        }
    }

    @Override
    /**
     *Method for a client to borrow a book.
     *@param client : The ID of the client who is borrowing the book.
     *@param author : The author of the book.
     *@param title : The title of the book.
     *@return ID : The ID of the book. Or -1 if the client does not exist. Or the book is not found.
     */
    
    public int borrowBook(int client, String author, String title) {
    	// Get the client by ID
        Clients c = getClientByID(client);
        // Loop through the list of clients to check if the client exists
        for (int j = 0; j < users.size(); j++) {
            Clients u = (Clients) users.get(j);
            if (u.getUserID() == client) {
                c = u;
                break;
            }
        }
        // If the client does not exist, print a message and return -1
        if (c == null) {
            System.out.println("No such client!");
            return -1;
        }
        // Iterate through the list of publications to find the book
        for (int i = 0; i < publications.size(); i++) {
            Object item = publications.get(i);
            if (item instanceof Book) {

                Book book = (Book)item;
                // Check if the book matches the provided author and title
                if ((book.getAuthor().equals(author)) && (book.getTitle().equals(title))) {
                //If the book is found, call the borrowPublication method to borrow
                //the book for the client
                    borowPublication(book, c);
                }
            }
        }
        return ID;
    }

    @Override
    /**
     *Method for a client to look at a magazine.
     *@param client : The ID of the client who is looking at the magazine.
     *@param title : The title of the magazine.
     *@param yearOfPublication : The year of publication of the magazine.
     *@param issue : The issue number of the magazine.
     *@return ID : The ID of the magazine, or -1 if the magazine is not found.
     */
    public int lookAtMagazine(int client, String title, int yearOfPublication, int issue) {
    	// Get the client by ID
        Clients c = getClientByID(client);
       // Iterate through the list of publications to find the magazine
        for (int i = 0; i < publications.size(); i++) {
            Object mag = publications.get(i);
            // Checking if the mag is the Magazine object
            if (mag instanceof Magazine) {
                Magazine magazine = (Magazine) mag;
                // Check if the magazine matches the title and year of publication 
                if ((magazine.getTitle() == title && magazine.getYear() == yearOfPublication)) {
                	// If the magazine is found, call the borrowPublication 
                	// method to borrow the magazine for the client (to look at it.
                    borowPublication(magazine, c);
                }
            }
        }
        return ID;
    }

    @Override  
    /**
     *Method for a client to borrow a Bluray.
     *@param client : The ID of the client who is borrowing the Bluray.
     *@param title : The title of the Bluray.
     *@param yearOfPublication : The year of publication of the Bluray.
     *@return ID : The ID of the Bluray, or -1 if the client is not found.
     */
    public int borrowBlueRay(int client, String title, int yearOfPublication) {
    	// Get the client by ID
        Clients c = getClientByID(client);
        // Iterate through the list of clients to find if the client exists.
        for (int j = 0; j < users.size(); j++) {
            Clients u = (Clients) users.get(j);
            if (u.getUserID() == client) {
                c = u;
                break;
            }
        }
        // If the client does not exist, print a message and return -1
        if (c == null) {
            System.out.println("No such client!");
            return -1;
        }
        // Iterate through the list of publications to find the bluray
        for (int i = 0; i < publications.size(); i++) {
            Object item = publications.get(i);
            if (item instanceof Bluray) {
                Bluray bluray = (Bluray) item;
                // Check if the bluray matches the provided title and year of publication
                if ((bluray.getTitle().equals(title)) && (bluray.getYear()==(yearOfPublication))) {
                    //If the bluray is found, call the borrowPublication method to borrow
                    //the bluray for the client
                    borowPublication(bluray, c);
                }
            }
        }
        return ID;
    }

    @Override
    /**
     *Method for a client to borrow a CD.
     *@param client : The ID of the client who is borrowing the CD.
     *@param title : The title of the CD.
     *@return ID : The ID of the CD, or -1 if the client is not found.
     */
    public int borrowCD(int client, String author, String title) {
    	// Get the client by ID
        Clients c = getClientByID(client);
        // Iterate through the list of clients to find if the client exists.
        for (int j = 0; j < users.size(); j++) {
            Clients u = (Clients) users.get(j);
            if (u.getUserID() == client) {
                c = u;
                break;
            }
        }
        // If the client does not exist, print a message and return -1
        if (c == null) {
            System.out.println("No such client!");
            return -1;
        }
     // Iterate through the list of publications to find the CD
        for (int i = 0; i < publications.size(); i++) {
            Object item = publications.get(i);
            if (item instanceof CD) {
                CD cd = (CD) item;
             // Check if the CD matches the provided title and author
                if ((cd.getTitle() == title && cd.getAuthor() == author)) {
                    //If the CD is found, call the borrowPublication method to borrow
                    //the CD for the client
                    borowPublication(cd, c);
                }
            }
        }
        return ID;
        
        }

    @Override
    /**
     *Method for returning a borrowed publication.
     *@param publicationID : The ID of the publication to be returned.
     *@return 0 if the operation is successful, -1 if the publication is not found or is currently not borrowed by anyone.
     */
    public int returnItem(int publicationID) {
    	// Iterate through the list of publications to find the borrowed publication
    	// example for books.
        for (int i = 0; i < publications.size(); i++) {
            Object item = publications.get(i);
            if (item instanceof Book) {

                Book book = (Book) item;
                if ((book.getID() == publicationID)) {
                	// Check if the publication is currently borrowed
                    if (book.isBorowed()) {
                        book.returnitem();
                        // Print a message to confirm return
                        System.out.println("Item returned.");
                        Queue newQ = new Queue(); // Create a new queue
                        // Check the queue for the next person in line
                        while (queue.size() != 0) {
                            Vector v = (Vector) queue.pop();
                            Borrowable b = (Borrowable) v.get(0);
                            if (b.getID() == publicationID) {
                                Clients c = (Clients) v.get(1);
                                b.borrowitem(c.getUserID());
                                // Print a message to confirm the next person
                                //in line is borrowing the publication
                                System.out.println("Lending to next user in queue.");
                                break;
                            } else {
                                newQ.push(v);
                            }
                        }
                        // Rebuild the queue
                        while (queue.size() != 0) {
                            Vector v = (Vector) queue.pop();
                            newQ.push(v);
                        }
                        queue = newQ;
                        // Print the updated queue
                        queue.printQueue();
                    }
                }
            }
        }
        return 0;
    }

    @Override
    /**
     * Method for adding a section to a graph (library).
     *@param name : the name of the section to be added.
     */
    public void addSection(String name) {
    // Add the section to the graph using the addNode method
    graph.addNode(name);
    }

    @Override
    /**
     *Method for connecting two sections in a graph.
     *@param section1 : The name of the first section to be connected.
     *@param section2 : The name of the second section to be connected.
     */
    public void connectSections(String section1, String section2) {
    	// Connect the two sections in the graph using the addEdge method
        graph.addEdge(section1, section2);
    }

    @Override
    /**
     *Method for finding the shortest path in a graph from a start section to a publication.
     *@param publicationID : The ID of the publication to reach.
     *@param startSection : The name of the start section.
     */
    public void findShortestPath(int publicationID, String startSection) {
    	// Print the current graph
        graph.prGraph();
        // Get the section of the publication
        String endSection = getPublicationSection(publicationID);
        // Find the shortest path in the graph from the start section to the 
        //publication section using the findShortestPathTowardsPublication method.
        graph.findShortestPathTowardsPublication(endSection, startSection);

    }
    /**
     *Method for getting the section of a publication by it's ID
     *@param ID : the id of the publication
     *@return the section of the publication, if the publication is found, or null if not found.
     */
    public String getPublicationSection(int ID) {
    	// loop through the list of publications to find the publication with the given ID
        for (int i = 0; i < publications.size(); i++) {
            Borrowable b = (Borrowable) publications.get(i);
            // Check if the publication ID matches the given ID
            if (b.getID() == ID) {
            	// If it does, return the section of the publication
                return b.getSection();
            }
        }
        
        return null; // return null if publication not found
    }
    /**
     *Method for getting a client by it's ID
     *@param ID the id of the client
     *@return c : the client object, if the client is found, or null if not found, 
     * and print a message "No such client!"
     */
    public Clients getClientByID(int ID) {

        Clients c = null;
        // Loop through the list of clients to find the client with the given ID
        for (int j = 0; j < users.size(); j++) {
            Clients u = (Clients) users.get(j);
            // Check if the client ID matches the given ID
            if (u.getUserID() == ID) {
                c = u;
                return c;
            }
        }
        // If the client is not found, print a message and return null
        System.out.println("No such client!");
        return c;
    }
    /**
     *Getter method for getting the ID of a publication.
     *@return The ID of the publication.
     */
	public String getPubID() {
		return pubID;
	}
	/**
     *Setter method for setting the ID of a publication.
     *@return The ID of the publication.
     */
	public void setPubID(String pubID) {
		this.pubID = pubID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

}
