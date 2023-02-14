package datastructures;
/**
 * 
 * @author ibagr
 * Clients is an abstract class that represents a client.
 * Implements abstract class from clients from which regular and VIP client classes will inherit.
 * 
 */
public abstract class Clients {
	//private variables to store the userID, name, and email of the client
	private int userID;
	private String name;
	private String email;
	
    /**
    * constructor to initialize the properties of the client
    * @param name : name of the client
    * @param email : email of the client
    * @param userID : id number of the client
    */
	public Clients(String name, String email, int userID) {
		this.userID = userID;
		this.name = name;
		this.email = email;

	}

    /**
    * getter method to get the name of the client
    * @return : name of the client
    */
	public String getUsername() {
		return name;
	}
    /**
    * setter method to set the name of the client
    * @param name : name of the client
    */
	public void setUsername(String name) {
		this.name = name;
	}
    /**
    * getter method to get the email of the client
    * @return : email of the client
    */
	public String getEmail() {
		return email;
	}
    /**
    * setter method to set the email of the client
    * @param email : email of the client
    */
	public void setEmail(String email) {
		this.email = email;
	}
    /**
    * getter method to get the userID of the client
    * @return : userID of the client
    */
	public int getUserID() {
		return userID;
	}
    /**
    * setter method to set the userID of the client
    * @param userID : ID of the client
    */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "Clients [userID=" + userID + ", name=" + name + ", email=" + email + "]";
	}

}
